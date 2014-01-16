package no.mesan.miniprosjekt.kommunikasjon.protobuf.rpc;

import java.io.IOException;
import java.util.concurrent.Executors;

import com.googlecode.protobuf.socketrpc.RpcServer;
import com.googlecode.protobuf.socketrpc.ServerRpcConnectionFactory;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;

public class ProtobufRpcServer {

	public static void main(String[] args) throws IOException {

		ServerRpcConnectionFactory rpcConnectionFactory = SocketRpcConnectionFactories.createServerRpcConnectionFactory(4446);
		RpcServer server = new RpcServer(rpcConnectionFactory, Executors.newFixedThreadPool(5), true);
		server.registerService(new AircraftProtoServiceImpl());
		server.registerService(new AviationDataProtoServiceImpl());
		server.registerService(new OsProtoServiceImpl());
		server.run();
	}
}
