package no.mesan.miniprosjekt.kommunikasjon.thrift.client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftServiceClient {

	public static void main(String[] args) {

		try {
			long startAll = System.currentTimeMillis();
			
			TTransport transport;

			transport = new TSocket("192.168.22.30", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			ThriftService.Client client = new ThriftService.Client(protocol);

			long start = System.currentTimeMillis();
			List<OsThrift> os = client.getOs();
			System.out.println("OS: " + (System.currentTimeMillis() - start) + "ms");
			
			start = System.currentTimeMillis();
			List<AircraftThrift> aircrafts = client.getAircraft();
			System.out.println("Aircrafts: " + (System.currentTimeMillis() - start) + "ms");
			
			start = System.currentTimeMillis();
			List<AviationDataThrift> aviationData = client.getAviationData();
			System.out.println("AviationData: " + (System.currentTimeMillis() - start) + "ms");
			transport.close();
			
			long endAll = System.currentTimeMillis();
			System.out.println("\nTotal: " + (endAll - startAll) + "ms");
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException x) {
			x.printStackTrace();
		}
	}

}
