package no.mesan.miniprosjekt.kommunikasjon.protobuf.rpc;

import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.data.AircraftDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.AircraftMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.AircraftMessages;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProto.Request;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AircraftProtoService.GetAircraftService;

import com.google.protobuf.ByteString;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;

public class AircraftProtoServiceImpl extends GetAircraftService {

	@Override
	public void getAircrafts(RpcController controller, Request request, RpcCallback<AircraftMessages> done) {

		AircraftMessages.Builder messages = AircraftMessages.newBuilder();
		AircraftMessage.Builder message = AircraftMessage.newBuilder();
		
		AircraftDao dao = new AircraftDao();
		List<Aircraft> aircrafts = dao.getAircrafts();
		
		for(Aircraft aircraft : aircrafts) {
			message.setName(aircraft.getName());
			message.setDrawing(ByteString.copyFrom(aircraft.getDrawing()));
			messages.addAircraftmessage(message.build());
			message.clear();
		}

		done.run(messages.build());

	}
}
