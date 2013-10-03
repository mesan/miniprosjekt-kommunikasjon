package no.mesan.miniprosjekt.kommunikasjon.thrift.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Server {

    public void start() {
        try {
            TServerSocket serverTransport = new TServerSocket(7911);
//
//            ArithmeticService.Processor processor = new ArithmeticService.Processor(new ArithmeticServiceImpl());

            AdditionService.Processor processor2 = new AdditionService.Processor(new AdditionServiceImpl());
//            
//            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).
//                    processor(processor));
            

            TServer server2 = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).
                    processor(processor2));
            
            System.out.println("Starting server on port 7911 ...");
//            server.serve();
            server2.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server srv = new Server();
        srv.start();
    }

}
