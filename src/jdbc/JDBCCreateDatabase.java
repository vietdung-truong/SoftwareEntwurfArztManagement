package jdbc;

import java.sql.*;
import java.util.*;

public class JDBCCreateDatabase {

	static final String JDBC_DRIVER = "org.h2.Driver";  
	static final String DB_URL = "jdbc:h2:~/test";
	static final String Username = "sa";
	static final String Password = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//diese Klasse ist bei h2 Datenbank nicht mehr notwendig

		/*
		 * Connection conn = null; Statement stmt = null; try {
		 * Class.forName(JDBC_DRIVER);
		 * 
		 * //Here connecting System.out.println("Getting connection..."); conn =
		 * DriverManager.getConnection(DB_URL, Username, Password);
		 * System.out.println("Connection established");
		 * 
		 * //Creating Statement and Database Here:
		 * System.out.println("Establishing Statement..."); stmt =
		 * conn.createStatement(); System.out.println("Statement established");
		 * System.out.println("Creating a Database..."); Scanner reader = new
		 * Scanner(System.in); // Reading from System.in
		 * System.out.println("Please enter the name of the to be created Database: ");
		 * String s = reader.nextLine(); // Scans the next token of the input as an int.
		 * //once finished reader.close(); String sql =
		 * String.format("CREATE DATABASE %s", s); stmt.executeUpdate(sql);
		 * System.out.println("Database Has been created");
		 * 
		 * 
		 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SQLException se) { // TODO Auto-generated catch
		 * block se.printStackTrace(); }finally { if (conn != null) { //sobald alle
		 * Befehle abgeschlossen sind/ eine connection geöffnet wurde und bearbeitet
		 * wurde, schließt sich die Verbindung try { conn.close(); } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } } }
		 * System.out.println("Goodbye");
		 */
	}
}
