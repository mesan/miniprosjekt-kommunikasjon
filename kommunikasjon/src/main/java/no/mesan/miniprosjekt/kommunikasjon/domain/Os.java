package no.mesan.miniprosjekt.kommunikasjon.domain;

import org.msgpack.annotation.Message;

@Message
public class Os {

	private String name;
	private byte[] system;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getSystem() {
		return system;
	}

	public void setSystem(byte[] system) {
		this.system = system;
	}

}
