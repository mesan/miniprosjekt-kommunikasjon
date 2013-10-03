package no.mesan.miniprosjekt.kommunikasjon.data;

import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;


public class Tester {
	public static void main(String[] argv) {
		AviationDataDao aviationDataDao = new AviationDataDao();
		List<AviationData> aviationData = aviationDataDao.getAviationData();
		
		System.out.println("size: " + aviationData.size());
	}
}
