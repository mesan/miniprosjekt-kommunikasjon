package no.mesan.miniprosjekt.kommunikasjon.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DbTilkobling {

	public static final String CONNECTION_URL = "jdbc:sqlserver://192.168.0.188:1433;"
			+ "databaseName=heckdole_prod;user=miniprosjekt;password=pass;";
	
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(CONNECTION_URL);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return connection;
	}
}
