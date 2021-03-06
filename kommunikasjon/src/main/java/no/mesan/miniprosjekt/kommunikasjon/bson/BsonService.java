package no.mesan.miniprosjekt.kommunikasjon.bson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.undercouch.bson4jackson.BsonFactory;
import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.data.AviationDataDao;
import no.mesan.miniprosjekt.kommunikasjon.data.OsDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;

@Path("bson")
public class BsonService{

	@GET
	@Path("aircraft")
	@Produces({"application/json"})
	public Response readAllAircrafts() throws JsonGenerationException, JsonMappingException, IOException{

		AircraftDao ariAircraftDao = new AircraftDao();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper(new BsonFactory());
		
		List<Aircraft> list = ariAircraftDao.getAircrafts();
		mapper.writeValue(baos, list);
		
		return Response.ok(baos).build();
	}

	@GET
	@Path("aviation")
	@Produces({"application/json"})
	public Response readAllAviationData() throws JsonGenerationException, JsonMappingException, IOException{

		AviationDataDao aviationDataDao = new AviationDataDao();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper(new BsonFactory());
		
		List<AviationData> list = aviationDataDao.getAviationData();
		mapper.writeValue(baos, list);
		
		return Response.ok(baos).build();
	}

	@GET
	@Path("os")
	@Produces({"application/json"})
	public Response readAllOs() throws JsonGenerationException, JsonMappingException, IOException{

		OsDao osDao = new OsDao();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper(new BsonFactory());
		
		List<Os> list = osDao.getOss();
		mapper.writeValue(baos, list);
		
		return Response.ok(baos).build();
	}
}
