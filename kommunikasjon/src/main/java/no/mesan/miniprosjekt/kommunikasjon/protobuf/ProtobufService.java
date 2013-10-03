package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/protocolbuffer")
public class ProtobufService {

	@GET
	@Produces("application/x-protobuf")
	public Response getProtocolBuffers() {
		return Response.ok().build();
	}
}
