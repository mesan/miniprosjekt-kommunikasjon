package no.mesan.miniprosjekt.kommunikasjon.domain;

import java.util.List;

import org.msgpack.annotation.Message;

@Message
public class AviationDataDto {

	private List<AviationData> aviationData;

	public List<AviationData> getAviationData() {
		return aviationData;
	}

	public void setAviationData(List<AviationData> aviationData) {
		this.aviationData = aviationData;
	}

}
