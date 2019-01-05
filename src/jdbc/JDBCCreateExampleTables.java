package jdbc;

import java.sql.*;
import java.util.*;

public class JDBCCreateExampleTables {

	static final String JDBC_DRIVER = "org.h2.Driver";
	static String Database = null;
	static String DB_URL = "jdbc:h2:~/softwareEntwurfTest";
	static final String Username = "sa";
	static final String Password = "";
	
	//Testing water

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);

			// Connecting here
			DB_URL = String.format(DB_URL, Database);
			System.out.println("Getting connection...");
			conn = DriverManager.getConnection(DB_URL, Username, Password);
			System.out.println("Connection established");

			// Creating Statement and Database Here:
			System.out.println("Establishing Statement...");
			stmt = conn.createStatement();
			System.out.println("Statement established");
			
			
			  //Hier wird die Tabelle erstellt
			  
			  System.out.println("Creating a Table..."); String sql =
			  "CREATE TABLE BEHANDLUNG (ID INTEGER not NULL AUTO_INCREMENT, DATUM DATE, " +
			  "LEISTUNGEN VARCHAR(255), ARZT VARCHAR(20), PATIENT VARCHAR (20), " +
			  "BEHANDLUNGSART VARCHAR(20),  PRIMARY KEY (ID))"; stmt.executeUpdate(sql);
			  System.out.println("Table Behandlung has been created");
			  
			  
			  //Hier werden Beispiele hinzugefuegt
			 
			System.out.println("Es werden 3 Beispiele hinzugefuegt...");
			
			sql = "insert into behandlung ( arzt , patient , datum , leistungen , behandlungsart )"
					+ "values "
					+ "( 'Margaret Neuenhofer', 'Viet Dung Truong', to_date ('2019-01-01', 'yyyy-mm-dd'), "
					+ "'<Leistungen>\r\n" + 
					"  <Leistung Leistungsname=\"Heilung 1\" Erläuterung=\"Test Heilung 1\" />\r\n" + 
					"  <Leistung Leistungsname=\"Heilung 2\" Erläuterung=\"Test Heilung 2\" />\r\n" + 
					"  <Leistung Leistungsname=\"Heilung 3\" Erläuterung=\"Test Heilung 3\" />\r\n" + 
					"</Leistungen>', 'Heilung'),"
					+ "( 'Max  Mustermann', 'Sven Zielonka',to_date ('2019-01-02', 'yyyy-mm-dd'), 'Jaehrliche Kontrolle', 'Kontrolle'),"
					+ "( 'John  Doe', 'Raphael Palombo',to_date ('2019-01-03', 'yyyy-mm-dd'), 'Erkaeltung', 'Heilung')";
			stmt.executeUpdate(sql);
			
			System.out.println("Beispiele David, Sven und Raphael hinzugefuegt.");

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
