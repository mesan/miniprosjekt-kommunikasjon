package no.mesan.miniprosjekt.kommunikasjon.bson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.undercouch.bson4jackson.BsonFactory;
import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;

@Path("bson")
public class BsonService {

	@GET
	@Path("aircraft")
	public Response readAllAircrafts() throws JsonGenerationException, JsonMappingException, IOException{

		AircraftDao ariAircraftDao = new AircraftDao();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper(new BsonFactory());
		
		List<Aircraft> list = ariAircraftDao.getAircrafts();
		mapper.writeValue(baos, list);
		
		return Response.ok(mapper).build();
	}

	@GET
	@Path("/aviation")
	public void readAllAviationData(){

	}

	@GET
	@Path("/os")
	public void readAllOs(){

	}

}
