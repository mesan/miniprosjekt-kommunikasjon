package no.mesan.miniprosjekt.kommunikasjon.domain;

import java.util.List;

import org.msgpack.annotation.Message;

@Message
public class AircraftDto {

	private List<Aircraft> aircrafts;

	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}
	
	 
}
