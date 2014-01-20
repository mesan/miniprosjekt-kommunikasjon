package no.mesan.miniprosjekt.kommunikasjon.protobuf.rpc;

import java.util.ArrayList;
import java.util.List;
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

	static long antallKjoringer = 5;
	static long startAircrafts = 0;
	static long startAviationData = 0;
	static long kjoring = 1;
	static long totalAircraftsTime = 0;
	static long totalAviationDataTime = 0;
	static long singleAircraftsTime = 0;		
	static long singleAviationDataTime = 0;
	
	//static List<Long> aircraftsKjoringer = new ArrayList<>();
	//static List<Long> aviationDataKjoringer = new ArrayList<>();
	
	static RpcChannel channel = null;
	
	public static void main(String[] args) {
		// Create a thread pool
		ExecutorService threadPool = Executors.newFixedThreadPool(1);

		// Create channel
		String host = "82.164.205.67";
		int port = 4446;
		RpcConnectionFactory connectionFactory = SocketRpcConnectionFactories.createRpcConnectionFactory(host, port);
		channel = RpcChannels.newRpcChannel(connectionFactory, threadPool);
		
		double antallKjoringer = 5.0;

		
		// Call service
		
		getAircrafts(channel);
		
			
			/*start = System.currentTimeMillis();
			getOss(channel);
			singleOsTime = System.currentTimeMillis() - start;
			totalOsTime += singleOsTime;
			System.out.println("Os kjøring " + (i + 1) + ": " + singleOsTime);*/
		
		
		
		//System.out.println("Os gjennomsnitt: " + totalOsTime/antallKjoringer);
	}
	
	private static void getAircrafts(RpcChannel channel) {
		// Deserialize
		//final long start = System.currentTimeMillis();
		startAircrafts = System.currentTimeMillis();
		AircraftProtoService.GetAircraftService.Stub myService = AircraftProtoService.GetAircraftService.newStub(channel);
		RpcController controller = new SocketRpcController();
		
		AircraftProto.Request.Builder b = AircraftProto.Request.newBuilder();
		b.setRequest("");
		AircraftProto.Request build = b.build();
		
		myService.getAircrafts(controller, build, new RpcCallback<AircraftProto.AircraftMessages>() {
			public void run(AircraftProto.AircraftMessages aircraftMessages) {

				/*System.out.println("AIRCRAFTS");
				System.out.println("Time: " + (System.currentTimeMillis() - start));*/
				/*int size = 0;
				int count = aircraftMessages.getAircraftmessageCount();
				for (int i = 0; i < count; i++) {
					size += aircraftMessages.getAircraftmessage(i).getSerializedSize();
				}
				System.out.println(size);*/
				
				long singleAircraftsTime = System.currentTimeMillis() - startAircrafts;
				totalAircraftsTime += singleAircraftsTime;
				System.out.println("Aircrafts kjøring " + (kjoring) + ": " + singleAircraftsTime);
				//aircraftsKjoringer.add(singleAircraftsTime);
				
				getAviationDatas(ProtobufRpcClient.channel);
			}
		});
		
		// Check success
		if (controller.failed()) {
			System.err.println(String.format("Rpc failed %s ", controller.errorText()));
		}
	}
	
	private static void getAviationDatas(RpcChannel channel) {
		// Deserialize
		//final long start = System.currentTimeMillis();
		startAviationData = System.currentTimeMillis();
		AviationDataProtoService.GetAviationDataService.Stub myService = AviationDataProtoService.GetAviationDataService.newStub(channel);
		RpcController controller = new SocketRpcController();
		
		AviationDataProto.Request.Builder b = AviationDataProto.Request.newBuilder();
		b.setRequest("");
		AviationDataProto.Request build = b.build();
		
		myService.getAviationData(controller, build, new RpcCallback<AviationDataProto.AviationDataMessages>() {
			public void run(AviationDataProto.AviationDataMessages aviationDataMessages) {

				
				singleAviationDataTime = System.currentTimeMillis() - startAviationData;
				totalAviationDataTime += singleAviationDataTime;
				System.out.println("AviationData kjøring " + (kjoring++) + ": " + singleAviationDataTime);
				//aviationDataKjoringer.add(singleAviationDataTime);
				/*System.out.println("AVIATIONDATA");
				System.out.println("Time: " + (System.currentTimeMillis() - start));*/
				//aviationDataMessages.getAviationdatamessageCount();
				if (kjoring <= 5)
					getAircrafts(ProtobufRpcClient.channel);
				else {
					System.out.println("Aircrafts gjennomsnitt: " + totalAircraftsTime/antallKjoringer);
					System.out.println("AviationData gjennomsnitt: " + totalAviationDataTime/antallKjoringer);
				}
			}
		});
		
		// Check success
		if (controller.failed()) {
			System.err.println(String.format("Rpc failed %s ", controller.errorText()));
		}
	}
	
	private static void getOss(RpcChannel channel) {
		// Deserialize
		//final long start = System.currentTimeMillis();
		OsProtoService.GetOssService.Stub myService = OsProtoService.GetOssService.newStub(channel);
		RpcController controller = new SocketRpcController();
		
		OsProto.Request.Builder b = OsProto.Request.newBuilder();
		b.setRequest("");
		OsProto.Request build = b.build();
		
		myService.getOss(controller, build, new RpcCallback<OsProto.OsMessages>() {
			public void run(OsProto.OsMessages osMessages) {

				/*System.out.println("OS");
				System.out.println("Time: " + (System.currentTimeMillis() - start));*/
				osMessages.getOsmessageCount();
			}
		});
		
		// Check success
		if (controller.failed()) {
			System.err.println(String.format("Rpc failed %s ", controller.errorText()));
		}
	}

}
