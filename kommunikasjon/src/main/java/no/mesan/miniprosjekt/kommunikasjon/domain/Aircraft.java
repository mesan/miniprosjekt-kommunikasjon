package no.mesan.miniprosjekt.kommunikasjon.domain;

import org.msgpack.annotation.Message;

@Message
public class Aircraft {

	private String name;
	private byte[] drawing;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getDrawing() {
		return drawing;
	}

	public void setDrawing(byte[] drawing) {
		this.drawing = drawing;
	}

}
