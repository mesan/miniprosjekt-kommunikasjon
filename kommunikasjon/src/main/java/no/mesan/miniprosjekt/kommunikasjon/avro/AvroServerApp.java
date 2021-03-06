package no.mesan.miniprosjekt.kommunikasjon.avro;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.data.AviationDataDao;
import no.mesan.miniprosjekt.kommunikasjon.data.OsDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroAircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroAircrafts;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroAviationData;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroAviationDatas;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroOs;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroOss;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroProtocol;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificResponder;

public class AvroServerApp {
	public static class AvroProtocolImpl implements AvroProtocol {
		
		@Override
		public AvroAircrafts getAircrafts() throws AvroRemoteException {
			AircraftDao dao = new AircraftDao();
			List<Aircraft> aircrafts = dao.getAircrafts();
			
			List<AvroAircraft> avroAircrafts = new ArrayList<>();
			
			for(Aircraft aircraft : aircrafts) {
				avroAircrafts.add(new AvroAircraft(aircraft.getName(), ByteBuffer.wrap(aircraft.getDrawing())));
			}
			
			return new AvroAircrafts(avroAircrafts);
		}

		@Override
		public AvroAviationDatas getAviationDatas() throws AvroRemoteException {
			AviationDataDao dao = new AviationDataDao();
			List<AviationData> aviationDatas = dao.getAviationData();
			
			List<AvroAviationData> avroAviationDatas = new ArrayList<>();
			
			for(AviationData aviationData : aviationDatas) {
				avroAviationDatas.add(new AvroAviationData(aviationData.getId(), aviationData.getAccidentNumber()));
			}
			return new AvroAviationDatas(avroAviationDatas);
		}

		@Override
		public AvroOss getOss() throws AvroRemoteException {
			OsDao dao = new OsDao();
			List<Os> oss = dao.getOss();

			List<AvroOs> avroOss = new ArrayList<>();
			
			for(Os os : oss) {
				avroOss.add(new AvroOs(os.getName(), ByteBuffer.wrap(os.getSystem())));
			}
			return new AvroOss(avroOss);
		}

	}

	private static Server server;

	private static void startServer() throws IOException {
		server = new NettyServer(new SpecificResponder(AvroProtocol.class,
				new AvroProtocolImpl()), new InetSocketAddress(65111));
		server.start();
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Starting server");
		startServer();

		System.out.println("Server started");
	}
}
