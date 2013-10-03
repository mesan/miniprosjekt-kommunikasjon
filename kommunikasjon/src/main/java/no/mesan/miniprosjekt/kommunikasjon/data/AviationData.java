package no.mesan.miniprosjekt.kommunikasjon.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AviationData {

	public void getAviationData() {
		DbTilkobling dbTilkobling = new DbTilkobling();
		Connection connection = dbTilkobling.getConnection();
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM aviationdata");
			while (rs.next()) {
				String lastName = rs.getNString(1);
				System.out.println(lastName + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
