package persistence.internal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import awk.entity.BehandlungTO;
import persistence.IBehandlungDAO;

 


public class BehandlungDAO implements IBehandlungDAO {
	@Override
	public void updateBehandlung(BehandlungTO behandlungTO) {
		/*
			Werte für Eintrag ändern!
		*/
		int behandlungsID = behandlungTO.getBehandlungsID();
		String datum = behandlungTO.getDatum();
		String leistungen = behandlungTO.getLeistungen();
		String arzt = behandlungTO.getLeistungen();
		String patient = behandlungTO.getPatient();
		String behandlungsart = behandlungTO.getBehandlungsart();
		
		
		Connection aConnection = Persistence.getConnection();

		try {
			Persistence.executeUpdateStatement(aConnection,
					// Anpassen!!
					"INSERT INTO behandlungen VALUES ('" + behandlungsID + "','" + datum + "', '" + leistungen + "','" + arzt + "','" + patient + "','" + behandlungsart + "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Persistence.closeConnection(aConnection);
			
			
		}
	};
	
	@Override
	public Collection<BehandlungTO> getBehandlungen(String datum) {
		Connection aConnection = Persistence.getConnection();

		ResultSet resultSet;
		Collection<BehandlungTO> result;
		try {
			
			resultSet = Persistence.executeQueryStatement(aConnection, "SELECT * FROM behandlungen WHERE datum = " + datum);
			while (resultSet.next()) {
				result.add(new BehandlungTO(resultSet.getInt("behandlungsID"), resultSet.getString("datum"), resultSet.getString("leistungen"), resultSet.getString("arzt"), resultSet.getString("patient"), resultSet.getString("behandlungsart")));
				
				
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
