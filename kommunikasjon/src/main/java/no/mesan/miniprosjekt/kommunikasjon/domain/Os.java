package no.mesan.miniprosjekt.kommunikasjon.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.msgpack.annotation.Message;

@Message
@XmlType
public class Os {

	private String name;
	private byte[] system;

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public byte[] getSystem() {
		return system;
	}

	public void setSystem(byte[] system) {
		this.system = system;
	}

}
