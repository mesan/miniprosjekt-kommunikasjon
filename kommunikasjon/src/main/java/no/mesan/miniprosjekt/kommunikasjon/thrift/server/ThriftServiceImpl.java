package no.mesan.miniprosjekt.kommunikasjon.thrift.server;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.data.AviationDataDao;
import no.mesan.miniprosjekt.kommunikasjon.data.OsDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;

import org.apache.thrift.TException;

public class ThriftServiceImpl implements ThriftService.Iface {

	@Override
	public List<OsThrift> getOs() throws TException {
		OsDao osDao = new OsDao();
		List<Os> oss = osDao.getOss();

		List<OsThrift> masseOs = new ArrayList<OsThrift>();
		
		for(Os os : oss) {
			ByteBuffer bb = ByteBuffer.wrap(os.getSystem());
			masseOs.add(new OsThrift(os.getName(), bb));
		}
		return masseOs;
	}

	@Override
	public List<AviationDataThrift> getAviationData() throws TException {
		AviationDataDao aviationDataDao = new AviationDataDao();
		List<AviationData> aviationData = aviationDataDao.getAviationData();

		List<AviationDataThrift> masseAviationData = new ArrayList<AviationDataThrift>();
		
		for(AviationData ad : aviationData) {
			masseAviationData.add(new AviationDataThrift(ad.getId(), ad.getAccidentNumber()));
		}
		return masseAviationData;
	}

	@Override
	public List<AircraftThrift> getAircraft() throws TException {
		AircraftDao aircraftDao = new AircraftDao();
		List<Aircraft> aircrafts = aircraftDao.getAircrafts();
		
		List<AircraftThrift> masseAircraft = new ArrayList<AircraftThrift>();
		
		for(Aircraft aircraft : aircrafts) {
			ByteBuffer bb = ByteBuffer.wrap(aircraft.getDrawing());
			masseAircraft.add(new AircraftThrift(aircraft.getName(), bb));
		}
		return masseAircraft;
	}

}
