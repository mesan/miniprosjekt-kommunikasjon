package no.mesan.miniprosjekt.kommunikasjon.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.msgpack.annotation.Message;

@Message
@XmlRootElement
public class AviationDataDto {

	private List<AviationData> aviationData;

	@XmlElement
	public List<AviationData> getAviationData() {
		return aviationData;
	}

	public void setAviationData(List<AviationData> aviationData) {
		this.aviationData = aviationData;
	}

}
