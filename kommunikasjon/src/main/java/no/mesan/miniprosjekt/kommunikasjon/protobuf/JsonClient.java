package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
 

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
 
public class JsonClient {
 
	private final String USER_AGENT = "Mozilla/5.0";
	
	private final static double NUMBER_OF_ITERATIONS = 50.0;
	public static void main(String[] args) throws Exception {
 
		JsonClient jsonClient = new JsonClient();
 
		long total_start = System.currentTimeMillis();
		long aircrafts_sum = 0;
		long aviationdata_sum = 0;
		long os_sum = 0;
		for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {	
			long os_start = System.currentTimeMillis();
			jsonClient.getOss();
			long os_end = System.currentTimeMillis();
			long os_time = os_end - os_start;
			os_sum += os_time;
			//System.out.println("Tid os = " + os_time + " ms");
			
			long aircrafts_start = System.currentTimeMillis();
			jsonClient.getAircrafts();
			long aircrafts_end = System.currentTimeMillis();
			long aircrafts_time = aircrafts_end-aircrafts_start;
			aircrafts_sum += aircrafts_time;
			//System.out.println("Tid aircrafts = " + aircrafts_time + " ms");
			
			long aviationdata_start = System.currentTimeMillis();
			jsonClient.getAviationData();
			long aviationdata_end = System.currentTimeMillis();
			long aviationdata_time = aviationdata_end-aviationdata_start;
			aviationdata_sum += aviationdata_time;
			//System.out.println("Tid aviation data = " + aviationdata_time + " ms");
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

 
//		System.out.println("\nTesting 2 - Send Http POST request");
//		jsoClient.sendPost();
 
	}
 
	// HTTP GET request
	private void getAircrafts() throws Exception {
 
		String url = "http://192.168.0.188:8080/json/aircrafts";
 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
 
		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Content-Type", "application/json;charset=utf-8");
 
		
		HttpResponse response = client.execute(request);
	}
	
	private void getAviationData() throws Exception {
		 
		String url = "http://192.168.0.188:8080/json/aviationdata";
 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
 
		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Content-Type", "application/json;charset=utf-8");
 
		
		HttpResponse response = client.execute(request);

	}
	
	private void getOss() throws Exception {
		String url = "http://192.168.0.188:8080/json/os";
		 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
 
		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Content-Type", "application/json;charset=utf-8");
 
		
		HttpResponse response = client.execute(request);
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		
		response.getEntity().getContent().read(b.toByteArray());
//		System.out.println("Size os json = " + b.size());
		
	}
		
 
//		System.out.println("\nSending 'GET' request to URL : " + url);
//		System.out.println("Response Code : " + 
//                       response.getStatusLine().getStatusCode());
 
//		BufferedReader rd = new BufferedReader(
//                       new InputStreamReader(response.getEntity().getContent()));
 
//		StringBuffer result = new StringBuffer();
//		String line = "";
//		while ((line = rd.readLine()) != null) {
//			result.append(line);
//		}
 
		//System.out.println(result.toString());
 
 
	// HTTP POST request
//	private void sendPost() throws Exception {
// 
//		String url = "https://selfsolve.apple.com/wcResults.do";
// 
//		HttpClient client = new DefaultHttpClient();
//		HttpPost post = new HttpPost(url);
// 
//		// add header
//		post.setHeader("User-Agent", USER_AGENT);
// 
//		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
//		urlParameters.add(new BasicNameValuePair("cn", ""));
//		urlParameters.add(new BasicNameValuePair("locale", ""));
//		urlParameters.add(new BasicNameValuePair("caller", ""));
//		urlParameters.add(new BasicNameValuePair("num", "12345"));
// 
//		post.setEntity(new UrlEncodedFormEntity(urlParameters));
// 
//		HttpResponse response = client.execute(post);
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		System.out.println("Post parameters : " + post.getEntity());
//		System.out.println("Response Code : " + 
//                                    response.getStatusLine().getStatusCode());
// 
//		BufferedReader rd = new BufferedReader(
//                        new InputStreamReader(response.getEntity().getContent()));
// 
//		StringBuffer result = new StringBuffer();
//		String line = "";
//		while ((line = rd.readLine()) != null) {
//			result.append(line);
//		}
// 
//		System.out.println(result.toString());
// 
//	}
 
}