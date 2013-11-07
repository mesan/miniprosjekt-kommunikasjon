package no.mesan.miniprosjekt.kommunikasjon.msgpack;

import java.io.IOException;

import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AircraftDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationDataDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;
import no.mesan.miniprosjekt.kommunikasjon.domain.OsDto;

import org.msgpack.MessagePack;
import org.msgpack.rpc.Client;
import org.msgpack.rpc.loop.EventLoop;

public class MsgPackClient {
	private static RPCInterface iface;

	public static interface RPCInterface {
		String hello(String msg, int a, boolean test);
		byte[] getAircrafts();
		byte[] getOss();
		byte[] getAviationData();
	}

	public static void main(String[] args) throws Exception {
		EventLoop loop = EventLoop.defaultEventLoop();

		Client cli = new Client("192.168.22.45", 1985, loop);
		iface = cli.proxy(RPCInterface.class);

//		getTestMessage();
		for (int i = 0; i < 10; i++) {
			getAircrafts();
			getAviationData();
		}
//		getOss();
	}

	private static void getAviationData() throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		System.out.println("AVIATIONDATA");
		long start = System.currentTimeMillis();
		AviationDataDto aviationDataDto = msgpack.read(iface.getAviationData(), AviationDataDto.class);
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		System.out.println("size: " + aviationDataDto.getAviationData().size());		
	}

	private static void getOss() throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		System.out.println("OS");
		long start = System.currentTimeMillis();
		OsDto osDto = msgpack.read(iface.getOss(), OsDto.class);
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		System.out.println("size: " + osDto.getOss().size());
	}

	private static void getAircrafts() throws IOException {
		MessagePack msgpack = new MessagePack();

		// Deserialize
		long start = System.currentTimeMillis();
		System.out.println("AIRCRAFTS");
		AircraftDto aircraftDto = msgpack.read(iface.getAircrafts(), AircraftDto.class);
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		System.out.println("size: " + aircraftDto.getAircrafts().size());
	}

	private static void getTestMessage() {
		String hello = iface.hello("hello", 1, true);
		System.out.println("TEST");
		System.out.println(hello);
	}
}
