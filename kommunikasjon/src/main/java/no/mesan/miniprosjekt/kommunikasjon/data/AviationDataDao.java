package no.mesan.miniprosjekt.kommunikasjon.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.domain.AviationData;

public class AviationDataDao {
	
	public List<AviationData> getAviationData() {
		DbTilkobling dbTilkobling = new DbTilkobling();
		Connection connection = dbTilkobling.getConnection();
		Statement stmt;
		
		List<AviationData> data = new ArrayList<AviationData>();
		
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM aviationdata");
			AviationData aviationData;
			while (rs.next()) {
				aviationData = new AviationData();
				aviationData.setId(rs.getNString(1));
				aviationData.setAccidentNumber(rs.getNString(3));
				data.add(aviationData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}

}
