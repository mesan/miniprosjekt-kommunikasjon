package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.AircraftMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.AircraftMessages;

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
}
