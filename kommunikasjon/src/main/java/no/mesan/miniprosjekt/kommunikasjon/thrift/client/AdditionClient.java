package no.mesan.miniprosjekt.kommunikasjon.thrift.client;

import no.mesan.miniprosjekt.kommunikasjon.thrift.server.AdditionService;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class AdditionClient {

    private void invoke() {
        TTransport transport;
        try {
            transport = new TSocket("localhost", 7911);

            TProtocol protocol = new TBinaryProtocol(transport);

            AdditionService.Client client = new AdditionService.Client(protocol);
            transport.open();
            
            System.out.println(client.hent().getKj().toString());
            
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AdditionClient c = new AdditionClient();
        c.invoke();

    }
}