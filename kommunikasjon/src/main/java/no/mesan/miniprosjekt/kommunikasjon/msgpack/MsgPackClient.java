package no.mesan.miniprosjekt.kommunikasjon.msgpack;

import java.io.IOException;

import no.mesan.miniprosjekt.kommunikasjon.domain.AircraftDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationDataDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.OsDto;

import org.msgpack.MessagePack;
import org.msgpack.rpc.Client;
import org.msgpack.rpc.loop.EventLoop;

public class MsgPackClient {

	public static interface RPCInterface {

		byte[] getAircrafts() throws IOException;

		byte[] getOss() throws IOException;

		byte[] getAviationData() throws IOException;
	}

	public static void main(String[] args) throws Exception {
		EventLoop loop = EventLoop.defaultEventLoop();

		Client cli = new Client("82.164.205.67", 1985, loop);
		RPCInterface iface = cli.proxy(RPCInterface.class);
		
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
			getAircrafts(iface);
			singleAircraftsTime = System.currentTimeMillis() - start;
			totalAircraftsTime += singleAircraftsTime;
			System.out.println("Aircrafts kjøring " + (i + 1) + ": " + singleAircraftsTime);
			
			start = System.currentTimeMillis();
			getAviationData(iface);
			singleAviationDataTime = System.currentTimeMillis() - start;
			totalAviationDataTime += singleAviationDataTime;
			System.out.println("AviationData kjøring " + (i + 1) + ": " + singleAviationDataTime);
			
			start = System.currentTimeMillis();
			getOss(iface);
			singleOsTime = System.currentTimeMillis() - start;
			totalOsTime += singleOsTime;
			System.out.println("Os kjøring " + (i + 1) + ": " + singleOsTime);
		}
		
		System.out.println("Aircrafts gjennomsnitt: " + totalAircraftsTime/antallKjoringer);
		System.out.println("AviationData gjennomsnitt: " + totalAviationDataTime/antallKjoringer);
		System.out.println("Os gjennomsnitt: " + totalOsTime/antallKjoringer);
		
		cli.close();
	}

	private static void getAviationData(RPCInterface iface) throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		System.out.println("AVIATIONDATA");
		
		AviationDataDto aviationDataDto = msgpack.read(iface.getAviationData(),
				AviationDataDto.class);
				
		//System.out.println("size: " + aviationDataDto.getAviationData().size());
	}

	private static void getOss(RPCInterface iface) throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		System.out.println("OS");
		//long start = System.currentTimeMillis();
		OsDto osDto = msgpack.read(iface.getOss(), OsDto.class);
		//System.out.println("Time: " + (System.currentTimeMillis() - start));
		//System.out.println("size: " + osDto.getOss().get(0).getSystem().length);
	}

	private static void getAircrafts(RPCInterface iface) throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		System.out.println("AIRCRAFTS");
		//long start = System.currentTimeMillis();
		byte[] arr = iface.getAircrafts();
		AircraftDto aircraftDto = msgpack.read(arr, AircraftDto.class);
		//System.out.println("Time: " + (System.currentTimeMillis() - start));
		//System.out.println("size: " + aircraftDto.getAircrafts().size());
	}
}
