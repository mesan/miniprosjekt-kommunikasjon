package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.AircraftMessages;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProto.AviationDataMessages;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProto.OsMessages;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ProtobufClient {

	private final String USER_AGENT = "Mozilla/5.0";

	private final static double NUMBER_OF_ITERATIONS = 5.0;
	
	public static void main(String[] args) throws Exception {

		long total_start = System.currentTimeMillis();
		long aircrafts_sum = 0;
		long aviationdata_sum = 0;
		long os_sum = 0;
		ProtobufClient protobufClient = new ProtobufClient();
		for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {		
			long start_aircrafts = System.currentTimeMillis();
			protobufClient.getAircrafts();
			long end_aircrafts = System.currentTimeMillis();
			long aircrafts_time = end_aircrafts - start_aircrafts;
			System.out.println("Tid aircrafts kjøring " + (i+1) + ":" + aircrafts_time + " ms");
			aircrafts_sum += aircrafts_time;
			
			long start_aviationdata = System.currentTimeMillis();
			protobufClient.getAviationData();
			long end_aviationdata = System.currentTimeMillis();
			long aviationdata_time = end_aviationdata - start_aviationdata;
			System.out.println("Tid aviation data kjøring " + (i+1) + ":" + aviationdata_time + " ms");
			aviationdata_sum += aviationdata_time;
			
			long start_os = System.currentTimeMillis();
			protobufClient.getOss();
			long end_os = System.currentTimeMillis();
			long os_time = end_os - start_os;
			os_sum += os_time;
			System.out.println("Tid os kjøring" + (i+1) + ":" + os_time + " ms");
		}
		long total_end = System.currentTimeMillis();
		double os_average = os_sum/NUMBER_OF_ITERATIONS;
		double aircrafts_average = aircrafts_sum/NUMBER_OF_ITERATIONS;
		double aviation_data_average = aviationdata_sum/NUMBER_OF_ITERATIONS;
		long total_time = total_end - total_start;
		System.out.println("Tid totalt " + total_time + " ms");
		System.out.println("Gjennomsnitt os: " + os_average);
		System.out.println("Gjennomsnitt aviation data: " + aviation_data_average);
		System.out.println("Gjennomsnitt aircrafts: " + aircrafts_average);

		// System.out.println("\nTesting 2 - Send Http POST request");
		// jsoClient.sendPost();

	}

	private void getAviationData() throws Exception {

		String url = "http://82.164.205.67:8080/protobuf/aviationdata";

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

		AviationDataMessages aviationDatasMessage = AviationDataMessages
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

		String url = "http://82.164.205.67:8080/protobuf/aircrafts";

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

		String url = "http://82.164.205.67:8080/protobuf/os";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Content-Type", "application/x-protobuf");

		HttpResponse response = client.execute(request);

		OsMessages ossMessages = OsMessages.newBuilder()
				.mergeFrom(response.getEntity().getContent()).build();
		//System.out.println("Size os protobuf = " + ossMessages.getSerializedSize());
	}

}
