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

@Path("json")
public class JsonService {
	
	private final static String APPLICATION_JSON_UTF_8 = "application/json;charset=utf-8";
	@GET
	@Produces(APPLICATION_JSON_UTF_8)
	@Path("aircrafts")
	public Response getAircrafts()  {
		AircraftDao aircraftDao = new AircraftDao();
		List<Aircraft> aircrafts = aircraftDao.getAircrafts();
		
		return Response.ok(aircrafts).build();
		
	}
	
	@GET
	@Produces(APPLICATION_JSON_UTF_8)
	@Path("aviationdata")
	public Response getAviationData()  {
		AviationDataDao aviationDataDao = new AviationDataDao();
		List<AviationData> aviationData = aviationDataDao.getAviationData();
		
		return Response.ok(aviationData).build();
		
	}
	
	@GET
	@Produces(APPLICATION_JSON_UTF_8)
	@Path("os")
	public Response getOss() {
		OsDao osDao = new OsDao();
		List<Os> oss = osDao.getOss();
		
		return Response.ok(oss).build();
	}
}
