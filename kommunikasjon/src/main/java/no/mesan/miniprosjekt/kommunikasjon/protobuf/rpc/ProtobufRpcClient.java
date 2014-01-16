package no.mesan.miniprosjekt.kommunikasjon.protobuf.rpc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProtoService;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProto;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProtoService;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProto;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProtoService;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcChannel;
import com.google.protobuf.RpcController;
import com.googlecode.protobuf.socketrpc.RpcChannels;
import com.googlecode.protobuf.socketrpc.RpcConnectionFactory;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import com.googlecode.protobuf.socketrpc.SocketRpcController;

public class ProtobufRpcClient {

	public static void main(String[] args) {
		// Create a thread pool
		ExecutorService threadPool = Executors.newFixedThreadPool(1);

		// Create channel
		String host = "127.0.0.1";
		int port = 4446;
		RpcConnectionFactory connectionFactory = SocketRpcConnectionFactories.createRpcConnectionFactory(host, port);
		RpcChannel channel = RpcChannels.newRpcChannel(connectionFactory, threadPool);

		// Call service
		getAircrafts(channel);
		getAviationDatas(channel);
		getOss(channel);
	}
	
	private static void getAircrafts(RpcChannel channel) {
		// Deserialize
		final long start = System.currentTimeMillis();
		AircraftProtoService.GetAircraftService.Stub myService = AircraftProtoService.GetAircraftService.newStub(channel);
		RpcController controller = new SocketRpcController();
		
		AircraftProto.Request.Builder b = AircraftProto.Request.newBuilder();
		b.setRequest("");
		AircraftProto.Request build = b.build();
		
		myService.getAircrafts(controller, build, new RpcCallback<AircraftProto.AircraftMessages>() {
			public void run(AircraftProto.AircraftMessages aircraftMessages) {

				System.out.println("AIRCRAFTS");
				System.out.println("Time: " + (System.currentTimeMillis() - start));
				System.out.println("size: " + aircraftMessages.getAircraftmessageCount());
			}
		});
		
		// Check success
		if (controller.failed()) {
			System.err.println(String.format("Rpc failed %s ", controller.errorText()));
		}
	}
	
	private static void getAviationDatas(RpcChannel channel) {
		// Deserialize
		final long start = System.currentTimeMillis();
		AviationDataProtoService.GetAviationDataService.Stub myService = AviationDataProtoService.GetAviationDataService.newStub(channel);
		RpcController controller = new SocketRpcController();
		
		AviationDataProto.Request.Builder b = AviationDataProto.Request.newBuilder();
		b.setRequest("");
		AviationDataProto.Request build = b.build();
		
		myService.getAviationData(controller, build, new RpcCallback<AviationDataProto.AviationDataMessages>() {
			public void run(AviationDataProto.AviationDataMessages aviationDataMessages) {

				System.out.println("AVIATIONDATA");
				System.out.println("Time: " + (System.currentTimeMillis() - start));
				System.out.println("size: " + aviationDataMessages.getAviationdatamessageCount());
			}
		});
		
		// Check success
		if (controller.failed()) {
			System.err.println(String.format("Rpc failed %s ", controller.errorText()));
		}
	}
	
	private static void getOss(RpcChannel channel) {
		// Deserialize
		final long start = System.currentTimeMillis();
		OsProtoService.GetOssService.Stub myService = OsProtoService.GetOssService.newStub(channel);
		RpcController controller = new SocketRpcController();
		
		OsProto.Request.Builder b = OsProto.Request.newBuilder();
		b.setRequest("");
		OsProto.Request build = b.build();
		
		myService.getOss(controller, build, new RpcCallback<OsProto.OsMessages>() {
			public void run(OsProto.OsMessages osMessages) {

				System.out.println("OS");
				System.out.println("Time: " + (System.currentTimeMillis() - start));
				System.out.println("size: " + osMessages.getOsmessageCount());
			}
		});
		
		// Check success
		if (controller.failed()) {
			System.err.println(String.format("Rpc failed %s ", controller.errorText()));
		}
	}

}
