package no.mesan.miniprosjekt.kommunikasjon.soap;

import javax.jws.WebService;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.data.AviationDataDao;
import no.mesan.miniprosjekt.kommunikasjon.data.OsDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.AircraftDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationDataDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.OsDto;

@WebService(endpointInterface = "no.mesan.miniprosjekt.kommunikasjon.soap.SoapService")
public class SoapServiceImpl implements SoapService{

	@Override
	public AviationDataDto getAviationData() {
		AviationDataDao dao = new AviationDataDao();
		AviationDataDto dto = new AviationDataDto();
		dto.setAviationData(dao.getAviationData());
		return dto;
	}

	@Override
	public AircraftDto getAircrafts() {
		AircraftDto dto = new AircraftDto();
		AircraftDao dao = new AircraftDao();
		
		dto.setAircrafts(dao.getAircrafts());
		return dto;
	}

	@Override
	public OsDto getOss() {
		OsDto dto = new OsDto();
		OsDao dao = new OsDao();
		
		dto.setOss(dao.getOss());
		return dto;
	}

}
