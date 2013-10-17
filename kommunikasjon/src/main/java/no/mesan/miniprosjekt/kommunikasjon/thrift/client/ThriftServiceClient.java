package no.mesan.miniprosjekt.kommunikasjon.thrift.client;

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
			long start = System.currentTimeMillis();
			
			TTransport transport;

			transport = new TSocket("localhost", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			ThriftService.Client client = new ThriftService.Client(protocol);

			List<OsThrift> os = client.getOs();
			List<AircraftThrift> aircrafts = client.getAircraft();
			List<AviationDataThrift> aviationData = client.getAviationData();

			System.out.println("OS size: " + os.size());
			System.out.println("OS 0 system size: "
					+ os.get(0).getSystem().length);

			System.out.println("Aircrafts size: " + aircrafts.size());
			System.out.println("Aircraft 0 drawing size: "
					+ aircrafts.get(0).getDrawing().length);

			System.out.println("Aviation data size: " + aviationData.size());

			long end = System.currentTimeMillis();
			
			System.out.println("Time in ms: " + (end - start));
			
			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException x) {
			x.printStackTrace();
		}
	}

}
