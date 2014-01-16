package no.mesan.miniprosjekt.kommunikasjon.avro;

import java.io.IOException;
import java.net.InetSocketAddress;

import no.mesan.miniprosjekt.kommunikasjon.domain.AvroAircrafts;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroAviationDatas;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroOss;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroProtocol;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

public class AvroClientApp {

	public static void main(String[] args) throws IOException,
			InterruptedException {

		NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(
				"127.0.0.1", 65111));

		AvroProtocol proxy = (AvroProtocol) SpecificRequestor.getClient(
				AvroProtocol.class, client);

		getAircrafts(proxy);
		getAviationData(proxy);
		getOss(proxy);
		
		// cleanup
		client.close();
	}
	
	private static void getOss(AvroProtocol proxy) {
		try {
			// Deserialize
			System.out.println("OS");
			long start = System.currentTimeMillis();
			AvroOss oss = proxy.getOss();
			System.out.println("Time: " + (System.currentTimeMillis() - start));
			System.out.println("size: " + oss.getOss().get(0).getSystem().array().length);
		} catch (AvroRemoteException e) {
			e.printStackTrace();
		}
	}
	

	
	private static void getAviationData(AvroProtocol proxy) {
		try {
			// Deserialize
			System.out.println("AviationData");
			long start = System.currentTimeMillis();
			AvroAviationDatas aviationDatas = proxy.getAviationDatas();
			System.out.println("Time: " + (System.currentTimeMillis() - start));
			System.out.println("size: " + aviationDatas.getAviationDatas().size());
		} catch (AvroRemoteException e) {
			e.printStackTrace();
		}
	}

	
	private static void getAircrafts(AvroProtocol proxy) {
		try {
			// Deserialize
			System.out.println("Aircrafts");
			long start = System.currentTimeMillis();
			AvroAircrafts aircrafts = proxy.getAircrafts();
			System.out.println("Time: " + (System.currentTimeMillis() - start));
			System.out.println("size: " + aircrafts.getAircrafts().get(0).getDrawing().array().length);
		} catch (AvroRemoteException e) {
			e.printStackTrace();
		}
	}
}
