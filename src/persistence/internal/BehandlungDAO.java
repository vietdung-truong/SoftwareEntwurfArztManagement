package persistence.internal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;


import awk.entity.BehandlungTO;
import persistence.IBehandlungDAO;



public class BehandlungDAO implements IBehandlungDAO {
	
	
	@Override
	public void updateBehandlung(BehandlungTO behandlungTO) {

		int behandlungsID = behandlungTO.getBehandlungsID();
		String datum = behandlungTO.getDatum();
		String leistungen = behandlungTO.getLeistungen();
		String arzt = behandlungTO.getArzt();
		String patient = behandlungTO.getPatient();
		String Behandlungsart = behandlungTO.getBehandlungsart();

//		//Transform the date format
//		final String OLD_FORMAT = "dd.MM.yyyy";
//		final String NEW_FORMAT = "yyyy-MM-dd";
//
//		try {
//			String oldDateString = datum;
//			String newDateString;
//
//			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//			Date d;
//			d = sdf.parse(oldDateString);
//			sdf.applyPattern(NEW_FORMAT);
//			newDateString = sdf.format(d);
//			datum = newDateString;
//
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		Connection aConnection = Persistence.getConnection();
		
		try {
			Persistence.executeUpdateStatement(aConnection,

					"update behandlung set "
					+ "arzt = '" + arzt + "', "
					+ "patient = '" + patient + "', "
					+ "datum = TO_DATE('" + datum + "', 'YYYY-MM-DD'), " //hier müssen wir noch Datumsformat abstimmen
					+ "behandlungsart = '" + Behandlungsart + "', "
					+ "leistungen = '" + leistungen + "' "
					+ "where ID = " + behandlungsID + "");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Persistence.closeConnection(aConnection);
			
			
		}
	};
	
	@Override
	public Collection<BehandlungTO> getBehandlungen(String datum) {
		
		final String OLD_FORMAT = "dd.MM.yyyy";
		final String NEW_FORMAT = "yyyy-MM-dd"; 
		try {
			String oldDateString = datum;
			String newDateString;

			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d;
			d = sdf.parse(oldDateString);
			sdf.applyPattern(NEW_FORMAT);
			newDateString = sdf.format(d);
			datum = newDateString;

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection aConnection = Persistence.getConnection();
		
		ResultSet resultSet;
		Collection<BehandlungTO> result = new ArrayList<BehandlungTO>();
		
		try {

			resultSet = Persistence.executeQueryStatement(aConnection, "SELECT * FROM behandlung WHERE Datum = '" + datum + "'");
			while (resultSet.next()) {
				result.add(new BehandlungTO(resultSet.getInt("id"), resultSet.getString("datum")
						, resultSet.getString("leistungen"), resultSet.getString("arzt")
						, resultSet.getString("patient"), resultSet.getString("behandlungsart")));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Persistence.closeConnection(aConnection);
		}
		return result;

	}
}
