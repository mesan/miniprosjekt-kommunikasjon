package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;

@Path("json")
public class JsonService {
	
	@GET
	@Produces("application/json;charset=utf-8")
	@Path("aircrafts")
	public Response getJson()  {
		AircraftDao aircraftDao = new AircraftDao();
		List<Aircraft> aircrafts = aircraftDao.getAircrafts();
		
		return Response.ok(aircrafts).build();
		
	}
}
