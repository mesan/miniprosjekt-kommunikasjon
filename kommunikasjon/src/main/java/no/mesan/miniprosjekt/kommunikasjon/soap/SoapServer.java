package no.mesan.miniprosjekt.kommunikasjon.soap;

import javax.xml.ws.Endpoint;

public class SoapServer {

	public static void main(String[] args) {
		 Endpoint.publish("http://localhost:9999/ws/heckdole", new SoapServiceImpl());
	}

}
