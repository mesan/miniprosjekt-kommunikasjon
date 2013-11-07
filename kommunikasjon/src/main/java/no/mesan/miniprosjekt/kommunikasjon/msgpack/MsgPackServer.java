package no.mesan.miniprosjekt.kommunikasjon.msgpack;

import java.io.IOException;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;

import org.msgpack.MessagePack;
import org.msgpack.rpc.Server;
import org.msgpack.rpc.loop.EventLoop;

public class MsgPackServer {
	public String hello(String msg, int a) {
		System.out.println("ServerMelding: " + msg);
		return msg + " " + a;
	}
	
	public byte[] hentFly() throws IOException {
		AircraftDao aircraftDao = new AircraftDao();
		List<Aircraft> aircrafts = aircraftDao.getAircrafts();
		
		Aircraft aircraft = aircrafts.get(0);
		
		MessagePack msgpack = new MessagePack();
		
		return msgpack.write(aircraft);
	}
	
	public static void main(String[] args) throws Exception {
		EventLoop loop = EventLoop.defaultEventLoop();

		Server svr = new Server();
		svr.serve(new MsgPackServer());
		svr.listen(1985);

		loop.join();
	}
}
