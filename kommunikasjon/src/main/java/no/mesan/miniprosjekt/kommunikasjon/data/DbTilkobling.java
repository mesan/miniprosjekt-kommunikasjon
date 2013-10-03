package no.mesan.miniprosjekt.kommunikasjon.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTilkobling {

	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		Connection connection = null;

		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=heckdole_prod;user=miniprosjekt;password=pass;";
			connection = DriverManager.getConnection(connectionUrl);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return connection;
	}
}
