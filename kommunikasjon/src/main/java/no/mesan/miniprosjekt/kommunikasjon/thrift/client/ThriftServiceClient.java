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

		int antallKjoeringer = 5;
		
		try {
			long startAll = System.currentTimeMillis();
			
			TTransport transport;

			transport = new TSocket("82.164.205.67", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			ThriftService.Client client = new ThriftService.Client(protocol);
			
			long osTime = 0;
			long aircraftTime = 0;
			long aviationDataTime = 0;
			long totalTime = 0;
			
			long osSingleRunTime = 0;
			long aircraftSingleRunTime = 0;
			long aviationDataSingleRunTime = 0;
			
			for (int i = 0; i < antallKjoeringer; i++) {
				long start = System.currentTimeMillis();

				List<OsThrift> os = client.getOs();
				osSingleRunTime = System.currentTimeMillis() - start;
				System.out.println("Tid os kjøring " + (i+1) + ": " + osSingleRunTime);
				osTime += osSingleRunTime;

				start = System.currentTimeMillis();
				
				List<AircraftThrift> aircrafts = client.getAircraft();
				aircraftSingleRunTime = System.currentTimeMillis() - start;
				System.out.println("Tid aircrafts kjøring " + (i+1) + ": " + aircraftSingleRunTime);
				aircraftTime += aircraftSingleRunTime;

				start = System.currentTimeMillis();
				List<AviationDataThrift> aviationData = client
						.getAviationData();
				aviationDataSingleRunTime = System.currentTimeMillis() - start;
				System.out.println("Tid aviation data kjøring " + (i+1) + ": " + aviationDataSingleRunTime);
				aviationDataTime += aviationDataSingleRunTime;

				long endAll = System.currentTimeMillis();
				totalTime += endAll - startAll;
				
			}
			transport.close();
			System.out.println("Gjennomsnitt OS: "
					+ osTime/antallKjoeringer + "ms");
			System.out.println("Gjennomsnitt Aircrafts: "
					+ aircraftTime/antallKjoeringer + "ms");
			System.out.println("Gjennomsnitt AviationData: "
					+ aviationDataTime/antallKjoeringer + "ms");
			System.out.println("\nTotal: " + totalTime/antallKjoeringer + "ms");
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException x) {
			x.printStackTrace();
		}
		
		
	}

}
