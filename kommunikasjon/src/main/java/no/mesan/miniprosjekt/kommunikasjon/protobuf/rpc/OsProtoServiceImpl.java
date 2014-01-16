package no.mesan.miniprosjekt.kommunikasjon.protobuf.rpc;

import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.data.OsDao;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProto.OsMessage;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProto.OsMessages;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProto.Request;
import no.mesan.miniprosjekt.kommunikasjon.protobuf.OsProtoService.GetOssService;

import com.google.protobuf.ByteString;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;

public class OsProtoServiceImpl extends GetOssService {

	@Override
	public void getOss(RpcController controller, Request request, RpcCallback<OsMessages> done) {
		OsMessages.Builder messages = OsMessages.newBuilder();
		OsMessage.Builder message = OsMessage.newBuilder();
		
		OsDao dao = new OsDao();
		List<Os> oss = dao.getOss();
		
		for (Os os : oss) {			
			message.setName(os.getName());
			message.setSystem(ByteString.copyFrom(new byte[0]));
			//ByteString.copyFrom(os.getSystem())
			messages.addOsmessage(message.build());
			message.clear();
		}

		done.run(messages.build());

	}

}
