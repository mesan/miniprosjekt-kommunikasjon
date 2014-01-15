package no.mesan.miniprosjekt.kommunikasjon.avro;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import no.mesan.miniprosjekt.kommunikasjon.domain.AvroAircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AvroProtocol;

import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

public class ClientApp {

	public static void main(String[] args) throws IOException,
			InterruptedException {

		NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(
				65111));

		AvroProtocol proxy = (AvroProtocol) SpecificRequestor.getClient(
				AvroProtocol.class, client);


		AvroAircraft avroAircraft = proxy.send();
		ByteBuffer drawing = (ByteBuffer) avroAircraft.getDrawing();
		
		byte[] bytes = new byte[drawing.capacity()];
		drawing.get(bytes, 0, bytes.length);
		
		System.out.println("length drawings: " + bytes.length);
		
		
		OutputStream targetFile;
		try {
			targetFile = new FileOutputStream("linux.tar.xz");
			targetFile.write(bytes);
			targetFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// cleanup
		client.close();
	}
}
