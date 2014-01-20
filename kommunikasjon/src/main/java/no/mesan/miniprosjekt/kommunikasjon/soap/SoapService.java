package no.mesan.miniprosjekt.kommunikasjon.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import no.mesan.miniprosjekt.kommunikasjon.domain.AircraftDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationDataDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.OsDto;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface SoapService {
	@WebMethod AviationDataDto getAviationData();
	@WebMethod AircraftDto getAircrafts();
	@WebMethod OsDto getOss();
}
