package no.mesan.miniprosjekt.kommunikasjon.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.msgpack.annotation.Message;

@Message
@XmlRootElement
public class AircraftDto {

	private List<Aircraft> aircrafts;

	@XmlElement
	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}
	
	 
}
