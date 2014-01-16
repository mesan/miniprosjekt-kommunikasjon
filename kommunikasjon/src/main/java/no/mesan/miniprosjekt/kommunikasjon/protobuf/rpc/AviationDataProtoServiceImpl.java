package no.mesan.miniprosjekt.kommunikasjon.protobuf.rpc;

import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.data.AviationDataDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProto.AviationDataMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProto.AviationDataMessages;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProto.Request;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.AviationDataProtoService.GetAviationDataService;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;

public class AviationDataProtoServiceImpl extends GetAviationDataService {

	@Override
	public void getAviationData(RpcController controller, Request request, RpcCallback<AviationDataMessages> done) {
		AviationDataMessages.Builder messages = AviationDataMessages.newBuilder();
		AviationDataMessage.Builder message = AviationDataMessage.newBuilder();
		
		AviationDataDao dao = new AviationDataDao();
		List<AviationData> aviationDatas = dao.getAviationData();
		
		for (AviationData aviationData : aviationDatas) {
			message.setId(aviationData.getId());
			message.setAccidentnumber(aviationData.getAccidentNumber());
			
			messages.addAviationdatamessage(message.build());
			message.clear();
		}

		done.run(messages.build());

	}

}
