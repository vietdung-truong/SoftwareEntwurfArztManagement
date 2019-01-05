package persistence.internal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
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


		Connection aConnection = Persistence.getConnection();

		try {
			Persistence.executeUpdateStatement(aConnection,

					"update behandlung set"
					+ "arzt = '" + arzt + "', "
					+ "patient = '" + patient + "', "
					+ "datum = TO_DATE('2019-11-01', 'YYYY-MM-DD'), " //hier müssenwir noch Datumsformat abstimmen
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
		Connection aConnection = Persistence.getConnection();

		ResultSet resultSet;
		Collection<BehandlungTO> result;
		try {

			resultSet = Persistence.executeQueryStatement(aConnection, "SELECT * FROM behandlungen");
			while (resultSet.next()) {
				result.add(new behandlungTO(resultSet.getInt("id"), resultSet.getString("datum")
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
