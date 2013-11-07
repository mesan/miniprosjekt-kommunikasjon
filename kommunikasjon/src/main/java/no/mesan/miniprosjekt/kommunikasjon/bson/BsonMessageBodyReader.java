package no.mesan.miniprosjekt.kommunikasjon.bson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;


@Provider
@Consumes("application/bson")
public class BsonMessageBodyReader extends Application implements MessageBodyReader {

	@Override
	public boolean isReadable(Class arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object readFrom(Class arg0, Type arg1, Annotation[] arg2,
			MediaType arg3, MultivaluedMap arg4, InputStream arg5)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
