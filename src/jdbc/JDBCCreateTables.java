package jdbc;

import java.sql.*;
import java.util.*;

public class JDBCCreateTables {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String Database = null;
	static String DB_URL = null;
	static final String Username = "David";
	static final String Password = "pass";
	
	//Testing water

	public static void main(String[] args) {
		// TODO Auto-generated method stub lskdfjlksjdvhlk j
		

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);

			// Connecting here
			Scanner reader = new Scanner(System.in); // Reading from System.in
			System.out.println("Tables are going to be created...");
			System.out.println("Please enter the name of the Database you want to add the tables into: ");
			Database = reader.nextLine(); // Scans the next token of the input as an String.
			// once finished reading the input
			reader.close();
			DB_URL = String.format("jdbc:mysql://localhost:3306/%s", Database);
			System.out.println("Getting connection...");
			conn = DriverManager.getConnection(DB_URL, Username, Password);
			System.out.println("Connection established");

			// Creating Statement and Database Here:
			System.out.println("Establishing Statement...");
			stmt = conn.createStatement();
			System.out.println("Statement established");
			System.out.println("Creating a Table...");
			String sql = "CREATE TABLE PATIENTEN (ID INTEGER not NULL, Vorname VARCHAR(20), "
							+ "Nachname VARCHAR(20), Anschrift VARCHAR(255), Telefon INTEGER not NULL, "
							+ "Email VARCHAR(255), Versicherungsnummer VARCHAR(30), PRIMARY KEY (ID))";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE ARZT (ID INTEGER Not NULL, Vorname VARCHAR(20), Nachname VARCHAR(20), "
							+ "Anschrift VARCHAR(255), IBAN VARCHAR(20), Telefon INTEGER not NULL, "
							+ "LANR VARCHAR(9), PRIMARY KEY(ID))";
			stmt.executeUpdate(sql);
			System.out.println("Table Patienten and Arzt has been created");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} finally {
			if (conn != null) { // sobald alle Befehle abgeschlossen sind/ eine connection geöffnet wurde und
								// bearbeitet wurde, schließt sich die Verbindung
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Goodbye");
	}
}
