package no.mesan.miniprosjekt.kommunikasjon.thrift.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Server {

    public void start() {
        try {
            TServerSocket serverTransport = new TServerSocket(9090);

            ThriftService.Processor processor = new ThriftService.Processor(new ThriftServiceImpl());
            
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).
                    processor(processor));
                        
            System.out.println("Starting server on port 9090 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server srv = new Server();
        srv.start();
    }

}
