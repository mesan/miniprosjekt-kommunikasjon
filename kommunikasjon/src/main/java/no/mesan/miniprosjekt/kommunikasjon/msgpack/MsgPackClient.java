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
		String hello(String msg, int a, boolean test);

		byte[] getAircrafts();

		byte[] getOss();

		byte[] getAviationData();
	}

	public static void main(String[] args) throws Exception {
		EventLoop loop = EventLoop.defaultEventLoop();

		Client cli = new Client("localhost", 1985, loop);
		RPCInterface iface = cli.proxy(RPCInterface.class);
		
		for (int i = 0; i < 10; i++) {
			getAircrafts(iface);
			getAviationData(iface);
			getOss(iface);
		}
		
		cli.close();
	}

	private static void getAviationData(RPCInterface iface) throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		System.out.println("AVIATIONDATA");
		long start = System.currentTimeMillis();
		AviationDataDto aviationDataDto = msgpack.read(iface.getAviationData(),
				AviationDataDto.class);
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		System.out.println("size: " + aviationDataDto.getAviationData().size());
	}

	private static void getOss(RPCInterface iface) throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		System.out.println("OS");
		long start = System.currentTimeMillis();
		OsDto osDto = msgpack.read(iface.getOss(), OsDto.class);
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		System.out.println("size: " + osDto.getOss().size());
	}

	private static void getAircrafts(RPCInterface iface) throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		System.out.println("AIRCRAFTS");
		long start = System.currentTimeMillis();
		byte[] arr = iface.getAircrafts();
		AircraftDto aircraftDto = msgpack.read(arr, AircraftDto.class);
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		System.out.println("size: " + aircraftDto.getAircrafts().size());
	}
}
