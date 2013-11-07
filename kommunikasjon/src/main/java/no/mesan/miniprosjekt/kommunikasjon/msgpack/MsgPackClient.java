package no.mesan.miniprosjekt.kommunikasjon.msgpack;

import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;

import org.msgpack.MessagePack;
import org.msgpack.rpc.Client;
import org.msgpack.rpc.loop.EventLoop;

public class MsgPackClient {
	public static interface RPCInterface {
		String hello(String msg, int a, boolean test);
		byte[] hentFly();
	}

	public static void main(String[] args) throws Exception {
		EventLoop loop = EventLoop.defaultEventLoop();

		Client cli = new Client("localhost", 1985, loop);
		RPCInterface iface = cli.proxy(RPCInterface.class);

		String hello = iface.hello("hello", 1, true);
		System.out.println(hello);
		
		MessagePack msgpack = new MessagePack();
		
        // Deserialize
		Aircraft aircraft = msgpack.read(iface.hentFly(), Aircraft.class);		
		System.out.println("navn: " + aircraft.getName() + ", str: " + aircraft.getDrawing().length);
	}
}
