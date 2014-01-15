package no.mesan.miniprosjekt.kommunikasjon.avro;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.data.OsDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroAircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroProtocol;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificResponder;

public class ServerApp {
	public static class AvroProtocolImpl implements AvroProtocol {

		@Override
		public AvroAircraft send() throws AvroRemoteException {
			AvroAircraft avroAircraft= new AvroAircraft();
			//AircraftDao dao = new AircraftDao();
			OsDao dao = new OsDao();
			Os os = dao.getOss().get(0);
	        //List<Aircraft> aircrafts = dao.getAircrafts();
	       // Aircraft aircraft = aircrafts.get(0);
	        
	        
	        avroAircraft.setName(os.getName());
			System.out.println("length drawing server: " + os.getSystem().length);
	        
	        //ByteBuffer byteBuffer = ByteBuffer.allocate(aircraft.getDrawing().length + 16);
	        //byteBuffer.put(aircraft.getDrawing());
	        
	        avroAircraft.setDrawing(ByteBuffer.wrap(os.getSystem()));
	        
			System.out.println("length byteBuffer: " + avroAircraft.getDrawing().array().length);
			return avroAircraft;
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
		// usually this would be another app, but for simplicity
		startServer();

		System.out.println("Server started");

		// server.close();
		// System.out.println("Stopped");
	}
}
