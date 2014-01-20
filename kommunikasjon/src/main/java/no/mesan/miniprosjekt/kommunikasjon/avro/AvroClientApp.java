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
				"82.164.205.67", 65111));

		AvroProtocol proxy = (AvroProtocol) SpecificRequestor.getClient(
				AvroProtocol.class, client);

		double antallKjoringer = 5.0;
		long start = 0;
		long totalAircraftsTime = 0;
		long totalAviationDataTime = 0;
		long totalOsTime = 0;
		long singleAircraftsTime = 0;		
		long singleAviationDataTime = 0;
		long singleOsTime = 0;
		
		for (int i = 0; i < antallKjoringer; i++) {
			start = System.currentTimeMillis();
			getAircrafts(proxy);
			singleAircraftsTime = System.currentTimeMillis() - start;
			totalAircraftsTime += singleAircraftsTime;
			System.out.println("Aircrafts kjøring " + (i + 1) + ": " + singleAircraftsTime);
			
			start = System.currentTimeMillis();
			getAviationData(proxy);
			singleAviationDataTime = System.currentTimeMillis() - start;
			totalAviationDataTime += singleAviationDataTime;
			System.out.println("AviationData kjøring " + (i + 1) + ": " + singleAviationDataTime);
			
			start = System.currentTimeMillis();
			getOss(proxy);
			singleOsTime = System.currentTimeMillis() - start;
			totalOsTime += singleOsTime;
			System.out.println("Os kjøring " + (i + 1) + ": " + singleOsTime);
		}
		
		System.out.println("Aircrafts gjennomsnitt: " + totalAircraftsTime/antallKjoringer);
		System.out.println("AviationData gjennomsnitt: " + totalAviationDataTime/antallKjoringer);
		System.out.println("Os gjennomsnitt: " + totalOsTime/antallKjoringer);
		
		
		// cleanup
		client.close();
	}
	
	private static void getOss(AvroProtocol proxy) {
		try {
			// Deserialize
			//System.out.println("OS");
			//long start = System.currentTimeMillis();
			AvroOss oss = proxy.getOss();
			//System.out.println("Time: " + (System.currentTimeMillis() - start));
			//System.out.println("size: " + oss.getOss().get(0).getSystem().array().length);
		} catch (AvroRemoteException e) {
			e.printStackTrace();
		}
	}
	

	
	private static void getAviationData(AvroProtocol proxy) {
		try {
			// Deserialize
			//System.out.println("AviationData");
			//long start = System.currentTimeMillis();
			AvroAviationDatas aviationDatas = proxy.getAviationDatas();
			//System.out.println("Time: " + (System.currentTimeMillis() - start));
			//System.out.println("size: " + aviationDatas.getAviationDatas().size());
		} catch (AvroRemoteException e) {
			e.printStackTrace();
		}
	}

	
	private static void getAircrafts(AvroProtocol proxy) {
		try {
			// Deserialize
			//System.out.println("Aircrafts");
			//long start = System.currentTimeMillis();
			AvroAircrafts aircrafts = proxy.getAircrafts();
			//System.out.println("Time: " + (System.currentTimeMillis() - start));
			//System.out.println("size: " + aircrafts.getAircrafts().get(0).getDrawing().array().length);
		} catch (AvroRemoteException e) {
			e.printStackTrace();
		}
	}
}
