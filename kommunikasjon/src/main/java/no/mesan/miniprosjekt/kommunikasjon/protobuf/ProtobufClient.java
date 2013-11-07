package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.AircraftMessages;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProto.AviationDatasMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProto.OssMessage;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ProtobufClient {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		ProtobufClient protobufClient = new ProtobufClient();
		for (int i = 0; i < 100; i++) {		
			long start_aircrafts = System.currentTimeMillis();
			protobufClient.getAircrafts();
			long end_aircrafts = System.currentTimeMillis();
			long time_aircrafts = end_aircrafts - start_aircrafts;
			System.out.println("Tid aircrafts = " + time_aircrafts + " ms");
			
			long start_aviationdata = System.currentTimeMillis();
			protobufClient.getAviationData();
			long end_aviationdata = System.currentTimeMillis();
			long time_aviationdata = end_aviationdata - start_aviationdata;
			System.out.println("Tid aviation data = " + time_aviationdata + " ms");
			
			long start_os = System.currentTimeMillis();
			protobufClient.getOss();
			long end_os = System.currentTimeMillis();
			long time_os = end_os - start_os;
			System.out.println("Tid os = " + time_os + " ms");
		}

		// System.out.println("\nTesting 2 - Send Http POST request");
		// jsoClient.sendPost();

	}

	private void getAviationData() throws Exception {

		String url = "http://127.0.0.1:8080/protobuf/aviationdata";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Content-Type", "application/x-protobuf");

		HttpResponse response = client.execute(request);

//		 System.out.println("\nSending 'GET' request to URL : " + url);
//		 System.out.println("Response Code : "
//		 + response.getStatusLine().getStatusCode());

		// BufferedReader rd = new BufferedReader(new InputStreamReader(response
		// .getEntity().getContent()));

		AviationDatasMessage aviationDatasMessage = AviationDatasMessage
				.newBuilder().mergeFrom(response.getEntity().getContent())
				.build();
		// StringBuffer result = new StringBuffer();
		// String line = "";
		// while ((line = rd.readLine()) != null) {
		// result.append(line);
		// }

		// System.out.println(result.toString());

	}

	// HTTP GET request
	private void getAircrafts() throws Exception {

		String url = "http://127.0.0.1:8080/protobuf/aircrafts";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Content-Type", "application/x-protobuf");

		HttpResponse response = client.execute(request);

		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("Response Code : "
		// + response.getStatusLine().getStatusCode());

		// BufferedReader rd = new BufferedReader(new InputStreamReader(response
		// .getEntity().getContent()));

		AircraftMessages aircraftMessages = AircraftMessages.newBuilder()
				.mergeFrom(response.getEntity().getContent()).build();
		// StringBuffer result = new StringBuffer();
		// String line = "";
		// while ((line = rd.readLine()) != null) {
		// result.append(line);
		// }

		// System.out.println(result.toString());

	}
	
	private void getOss() throws Exception {

		String url = "http://127.0.0.1:8080/protobuf/os";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Content-Type", "application/x-protobuf");

		HttpResponse response = client.execute(request);

		OssMessage ossMessages = OssMessage.newBuilder()
				.mergeFrom(response.getEntity().getContent()).build();
//		System.out.println("Size os protobuf = " + ossMessages.getSerializedSize());
	}

}
