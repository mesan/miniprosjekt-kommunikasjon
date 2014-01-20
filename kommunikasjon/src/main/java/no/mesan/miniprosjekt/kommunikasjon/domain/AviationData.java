package no.mesan.miniprosjekt.kommunikasjon.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.msgpack.annotation.Message;

@Message
@XmlType
public class AviationData {

	private String id;
	private String accidentNumber;
	
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement
	public String getAccidentNumber() {
		return accidentNumber;
	}
	public void setAccidentNumber(String accidentNumber) {
		this.accidentNumber = accidentNumber;
	}
	
	
}
