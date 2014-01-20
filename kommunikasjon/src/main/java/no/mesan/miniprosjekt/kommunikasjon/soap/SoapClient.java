package no.mesan.miniprosjekt.kommunikasjon.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import no.mesan.miniprosjekt.kommunikasjon.domain.AircraftDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationDataDto;
import no.mesan.miniprosjekt.kommunikasjon.domain.OsDto;

public class SoapClient {
	private static long aviationMs = 0l;
	private static long aircraftMs = 0l;
	private static long osMs = 0l;
	private static double antall = 5.0;

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://82.164.205.67:9999/ws/heckdole?wsdl");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://soap.kommunikasjon.miniprosjekt.mesan.no/", "SoapServiceImplService");

		for (int i = 0; i < antall; i++) {
			getAviationData(url, qname);
			getAircrafts(url, qname);
			getOss(url, qname);
		}

		System.out.println("gjennomsnitt AviationData: " + (aviationMs/antall) + "ms");
		System.out.println("gjennomsnitt Aircrafts: " + (aircraftMs/antall) + "ms");
		System.out.println("gjennomsnitt Os: " + (osMs/antall) + "ms");
		
	}

	private static void getAviationData(URL url, QName qname) throws MalformedURLException {
		long start = System.currentTimeMillis();

		Service service = Service.create(url, qname);
		SoapService soapService = service.getPort(SoapService.class);

		AviationDataDto aviationData = soapService.getAviationData();

		long end = System.currentTimeMillis();		
		System.out.println("res: " + aviationData.getAviationData().get(0).getAccidentNumber());

		System.out.println("AviationData: " + (end - start) + "ms");
		aviationMs += (end - start);
	}

	private static void getAircrafts(URL url, QName qname) {
		long start = System.currentTimeMillis();

		Service service = Service.create(url, qname);
		SoapService soapService = service.getPort(SoapService.class);

		AircraftDto aircrafts = soapService.getAircrafts();

		long end = System.currentTimeMillis();
		System.out.println("res: " + aircrafts.getAircrafts().get(0).getDrawing().length);

		System.out.println("Aircrafts: " + (end - start) + "ms");
		aircraftMs += (end - start);
	}

	private static void getOss(URL url, QName qname) {
		long start = System.currentTimeMillis();

		Service service = Service.create(url, qname);
		SoapService soapService = service.getPort(SoapService.class);

		OsDto oss = soapService.getOss();

		long end = System.currentTimeMillis();
		System.out.println("res: " + oss.getOss().get(0).getSystem().length);

		System.out.println("Os: " + (end - start) + "ms");
		osMs += (end - start);
	}
}
