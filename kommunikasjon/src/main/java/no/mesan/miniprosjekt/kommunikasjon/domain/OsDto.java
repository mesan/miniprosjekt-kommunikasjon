package no.mesan.miniprosjekt.kommunikasjon.domain;

import java.util.List;

import org.msgpack.annotation.Message;

@Message
public class OsDto {

	private List<Os> oss;

	public List<Os> getOss() {
		return oss;
	}

	public void setOss(List<Os> oss) {
		this.oss = oss;
	}
	
	
}
