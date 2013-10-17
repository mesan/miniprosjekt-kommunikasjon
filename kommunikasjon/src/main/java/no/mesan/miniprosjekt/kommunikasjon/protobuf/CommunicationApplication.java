package no.mesan.miniprosjekt.kommunikasjon.protobuf;

import java.util.*;

import javax.ws.rs.core.Application;

import no.mesan.miniprosjekt.kommunikasjon.bson.BsonMessageBodyReader;
import no.mesan.miniprosjekt.kommunikasjon.bson.BsonMessageBodyWriter;
import no.mesan.miniprosjekt.kommunikasjon.bson.BsonService;

 
public class CommunicationApplication  extends Application {
 
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>(2);
        set.add(ProtobufMessageBodyReader.class);
        set.add(ProtobufMessageBodyWriter.class);
        set.add(ProtobufService.class);
        set.add(JsonService.class);
        set.add(BsonService.class);
        return set;
    }
}
