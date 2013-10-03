package no.mesan.miniprosjekt.kommunikasjon.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.domain.Aircraft;

public class AircraftDao {

	public List<Aircraft> getAircrafts() {
		List<Aircraft> aircrafts = new ArrayList<Aircraft>();
		

		DbTilkobling dbTilkobling = new DbTilkobling();
		Connection connection = dbTilkobling.getConnection();
		Statement stmt;
		
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM blob_store");
			Aircraft aircraft;
			while (rs.next()) {
				aircraft = new Aircraft();
				aircraft.setName(rs.getNString(2));
				aircraft.setDrawing(rs.getBytes(3));
				aircrafts.add(aircraft);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return aircrafts;
	}
}
