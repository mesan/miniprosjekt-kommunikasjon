package no.mesan.miniprosjekt.kommunikasjon.data;

import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;
import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;
import no.mesan.miniprosjekt.kommunikasjon.domain.Os;

public class Tester {
	public static void main(String[] argv) {
		long start = System.currentTimeMillis();
		AviationDataDao aviationDataDao = new AviationDataDao();
		List<AviationData> aviationData = aviationDataDao.getAviationData();

		System.out.println("AviationData - tid (ms): " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();

		AircraftDao aircraftDao = new AircraftDao();
		List<Aircraft> aircrafts = aircraftDao.getAircrafts();


		System.out.println("Aircrafts - tid (ms): " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();

		OsDao osDao = new OsDao();
		List<Os> oss = osDao.getOss();
		
		System.out.println("OS - tid (ms): " + (System.currentTimeMillis() - start));
		


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
