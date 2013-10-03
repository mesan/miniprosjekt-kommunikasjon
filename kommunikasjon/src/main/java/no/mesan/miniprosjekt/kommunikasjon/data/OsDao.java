package no.mesan.miniprosjekt.kommunikasjon.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import no.mesan.miniprosjekt.kommunikasjon.domain.Os;

public class OsDao {
	public List<Os> getOss() {
		List<Os> aircrafts = new ArrayList<Os>();

		DbTilkobling dbTilkobling = new DbTilkobling();
		Connection connection = dbTilkobling.getConnection();
		Statement stmt;

		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM big_blob_store");
			Os os;

			while (rs.next()) {
				os = new Os();
				os.setName(rs.getNString(2));
				os.setSystem(rs.getBytes(3));
				aircrafts.add(os);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aircrafts;
	}
}
