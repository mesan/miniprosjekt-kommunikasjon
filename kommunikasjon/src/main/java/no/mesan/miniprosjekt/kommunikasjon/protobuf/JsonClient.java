package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
 
public class JsonClient {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		JsonClient jsoClient = new JsonClient();
 
		System.out.println("Testing 1 - Send Http GET request");
		long t1 = System.currentTimeMillis();
		jsoClient.sendGet();
		long t2 = System.currentTimeMillis();
		long time = t2-t1;
		System.out.println("Tid = " + time + " ms");
 
//		System.out.println("\nTesting 2 - Send Http POST request");
//		jsoClient.sendPost();
 
	}
 
	// HTTP GET request
	private void sendGet() throws Exception {
 
		String url = "http://127.0.0.1:8080/json/aircrafts";
 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
 
		// add request header
		request.addHeader("User-Agent", USER_AGENT);
 
		
		HttpResponse response = client.execute(request);

		
 
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());
 
		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));
 
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
 
		//System.out.println(result.toString());
 
	}
 
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