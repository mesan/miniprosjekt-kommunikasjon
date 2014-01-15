package no.mesan.miniprosjekt.kommunikasjon.avro;

import java.io.IOException;
import java.net.InetSocketAddress;

import no.mesan.miniprosjekt.kommunikasjon.domain.AvroOss;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroProtocol;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

public class AvroClientApp {

	public static void main(String[] args) throws IOException,
			InterruptedException {

		NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(
				65111));

		AvroProtocol proxy = (AvroProtocol) SpecificRequestor.getClient(
				AvroProtocol.class, client);

		getOss(proxy);
		
		// cleanup
		client.close();
	}
	
	private static void getOss(AvroProtocol proxy) {
		try {
			// Deserialize
			System.out.println("OS");
			long start = System.currentTimeMillis();
			AvroOss oss = proxy.getOss();
			System.out.println("Time: " + (System.currentTimeMillis() - start));
			System.out.println("size: " + oss.getOss().size());
		} catch (AvroRemoteException e) {
			e.printStackTrace();
		}
		
		
	}
}
