package no.mesan.miniprosjekt.kommunikasjon.bson;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;


@Provider
@Consumes("application/bson")
public class BsonMessageBodyWriter  extends Application implements MessageBodyWriter<Object> {

	@Override
	public long getSize(Object arg0, Class arg1, Type arg2, Annotation[] arg3,
			MediaType arg4) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class clazz, Type type, Annotation[] annotations,
			MediaType medaiType) {
		if("".equals(clazz.getPackage().getName())){
			
		}
		return false;
	}

	@Override
	public void writeTo(Object arg0, Class clazz, Type type, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap multivaluedMap, OutputStream outputStream)
			throws IOException, WebApplicationException {
	}

}
