package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.data.AviationDataDao;
import no.mesan.miniprosjekt.kommunikasjon.data.OsDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.AircraftMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.AircraftMessages;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProto.AviationDataMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProto.AviationDatasMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProto.OsMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProto.OssMessage;

import com.google.protobuf.ByteString;

@Path("protobuf")
public class ProtobufService {

	
	@GET
	@Produces("application/x-protobuf")
	@Path("aircrafts")
	public Response getAircrafts() {
		AircraftDao aircraftDao = new AircraftDao();
		List<Aircraft> aircrafts = aircraftDao.getAircrafts();
		AircraftMessages.Builder aircraftMessages = AircraftMessages.newBuilder();
		
		for (Aircraft aircraft : aircrafts) {
			AircraftMessage.Builder aircraftMessage = AircraftMessage.newBuilder();
			aircraftMessage.setDrawing(ByteString.copyFrom(aircraft.getDrawing()));
			aircraftMessage.setName(aircraft.getName());
			aircraftMessage.build();
			aircraftMessages.addAircraftmessage(aircraftMessage);
		}
		
		return Response.ok(aircraftMessages.build()).build();
	}
	
	@GET
	@Produces("application/x-protobuf")
	@Path("aviationdata")
	public Response getAviationData() {
		AviationDataDao aviationDataDao = new AviationDataDao();
		List<AviationData> aviationDatas = aviationDataDao.getAviationData();
		AviationDatasMessage.Builder aviationDataMessages = AviationDatasMessage.newBuilder();
		
		for (AviationData aviationData : aviationDatas) {
			AviationDataMessage.Builder aviationDataMessage = AviationDataMessage.newBuilder();
			aviationDataMessage.setId(aviationData.getId());
			aviationDataMessage.setAccidentnumber(aviationData.getAccidentNumber());
			aviationDataMessage.build();
			aviationDataMessages.addAviationdatamessage(aviationDataMessage);
		}
		
		return Response.ok(aviationDataMessages.build()).build();
	}
	
	@GET
	@Produces("application/x-protobuf")
	@Path("os")
	public Response getOs() {
		OsDao osDao = new OsDao();
		List<Os> oss = osDao.getOss();
		OssMessage.Builder ossMessage = OssMessage.newBuilder();
		
		for (Os os : oss) {
			OsMessage.Builder osMessage = OsMessage.newBuilder();
			osMessage.setName(os.getName());
			osMessage.setSystem(ByteString.copyFrom(os.getSystem()));
			osMessage.build();
			ossMessage.addOsmessage(osMessage);
		}
		
		return Response.ok(ossMessage.build()).build();
	}
}
