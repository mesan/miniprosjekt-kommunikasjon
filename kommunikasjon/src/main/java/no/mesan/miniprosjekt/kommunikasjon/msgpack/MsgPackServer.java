package no.mesan.miniprosjekt.kommunikasjon.msgpack;

import java.io.IOException;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.data.AviationDataDao;
import no.mesan.miniprosjekt.kommunikasjon.data.OsDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AircraftDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationDataDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.OsDto;
import no.mesan.miniprosjekt.kommunikasjon.msgpack.MsgPackClient.RPCInterface;

import org.msgpack.MessagePack;
import org.msgpack.rpc.Server;
import org.msgpack.rpc.loop.EventLoop;
import org.msgpack.template.Template;
import org.msgpack.template.Templates;

public class MsgPackServer implements RPCInterface {
	
	public static void main(String[] args) throws Exception {
		EventLoop loop = EventLoop.defaultEventLoop();

		Server svr = new Server();
		svr.serve(new MsgPackServer());
		svr.listen(1985);
		
		loop.join();
	}
	
	public byte[] getAircrafts() throws IOException {
		AircraftDao aircraftDao = new AircraftDao();		
		AircraftDto aircraftDto = new AircraftDto();
		aircraftDto.setAircrafts(aircraftDao.getAircrafts());

		MessagePack msgpack = new MessagePack();
		return msgpack.write(aircraftDto);
	}
	
	
	public byte[] getAviationData() throws IOException {
		AviationDataDao aviationDataDao = new AviationDataDao();		
		AviationDataDto aviationDataDto = new AviationDataDto();
		
		aviationDataDto.setAviationData(aviationDataDao.getAviationData());
		MessagePack msgpack = new MessagePack();
		
		return msgpack.write(aviationDataDto);
	}
	
	public byte[] getOss() throws IOException {
		OsDao osDao = new OsDao();
		OsDto osDto = new OsDto();
		
		osDto.setOss(osDao.getOss());
		MessagePack msgpack = new MessagePack();
		
		return msgpack.write(osDto);
	}
}
