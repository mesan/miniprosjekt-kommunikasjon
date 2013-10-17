package no.mesan.miniprosjekt.kommunikasjon.bson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.undercouch.bson4jackson.BsonFactory;

public class BsonClient {

	public static void main(String[] args) throws Exception {
		BsonClient http = new BsonClient();
		http.sendGet();
	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://192.168.22.24:8080/bson/aircraft/";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		ByteArrayInputStream bais = new ByteArrayInputStream(getBytesFromInputStream(con.getInputStream()));
	    ObjectMapper mapper = new ObjectMapper(new BsonFactory());
	    
	    //List<AviationData> aviationDatas = mapper.readValue(bais, new TypeReference<List<AviationData>>(){});
	    List<Aircraft> aircrafts = mapper.readValue(bais, new TypeReference<List<Aircraft>>(){});
	    System.out.println("Aircrafts: " + aircrafts.size());
	}

	public static byte[] getBytesFromInputStream(InputStream is) {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
			byte[] buffer = new byte[0xFFFF];

			for (int len; (len = is.read(buffer)) != -1;)
				os.write(buffer, 0, len);

			os.flush();

			return os.toByteArray();
		} catch (IOException e) {
			return null;
		}
	}
}
