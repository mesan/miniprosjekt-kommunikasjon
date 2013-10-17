package no.mesan.miniprosjekt.kommunikasjon.data;

import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;

public class Tester {
	public static void main(String[] argv) {
		AviationDataDao aviationDataDao = new AviationDataDao();
		List<AviationData> aviationData = aviationDataDao.getAviationData();

		System.out.println("Aviation data size: " + aviationData.size());

		AircraftDao aircraftDao = new AircraftDao();
		List<Aircraft> aircrafts = aircraftDao.getAircrafts();

		System.out.println("Aircrafts size: " + aircrafts.size());
		System.out.println("Aircraft 0 drawing size: "
				+ aircrafts.get(0).getDrawing().length);

		OsDao osDao = new OsDao();
		List<Os> oss = osDao.getOss();

		System.out.println("OS size: " + oss.size());
		System.out
				.println("OS 0 system size: " + oss.get(0).getSystem().length);
		


//		OutputStream targetFile;
//		try {
//			targetFile = new FileOutputStream("linux.tar.xz");
//			targetFile.write(oss.get(0).getSystem());
//			targetFile.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
