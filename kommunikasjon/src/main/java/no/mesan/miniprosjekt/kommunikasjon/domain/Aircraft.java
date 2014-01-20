package no.mesan.miniprosjekt.kommunikasjon.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.msgpack.annotation.Message;

@Message
@XmlType
public class Aircraft {

	private String name;
	private byte[] drawing;
	
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public byte[] getDrawing() {
		return drawing;
	}

	public void setDrawing(byte[] drawing) {
		this.drawing = drawing;
	}

}
