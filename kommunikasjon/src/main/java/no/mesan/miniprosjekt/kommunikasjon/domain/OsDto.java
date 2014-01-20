package no.mesan.miniprosjekt.kommunikasjon.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.msgpack.annotation.Message;

@Message
@XmlRootElement
public class OsDto {

	private List<Os> oss;

	@XmlElement
	public List<Os> getOss() {
		return oss;
	}

	public void setOss(List<Os> oss) {
		this.oss = oss;
	}
	
	
}
