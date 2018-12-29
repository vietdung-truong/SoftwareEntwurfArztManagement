package persistence.internal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import awk.entity.BehandlungTO;
import persistence.IBehandlungDAO;


public class BehandlungDAO implements IBehandlungDAO {
	@Override
	public void updateBehandlung(BehandlungTO behandlungTO) {
		String begriff = behandlungTO.getBegriff();
		String definition = behandlungTO.getDefinition();

		Connection aConnection = Persistence.getConnection();

		try {
			Persistence.executeUpdateStatement(aConnection,
					"INSERT INTO definitionen VALUES ('" + begriff + "','" + definition + "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Persistence.closeConnection(aConnection);
		}
	};
	@Override
	public ArrayList<BehandlungTO> getBehandlungen(String datum) {
		Connection aConnection = Persistence.getConnection();

		ResultSet resultSet;
		ArrayList<BehandlungTO> result = new ArrayList<BehandlungTO>();
		try {
			resultSet = Persistence.executeQueryStatement(aConnection, "SELECT * FROM definitionen");
			while (resultSet.next()) {
				result.add(new behandlungTO(resultSet.getString("begriff"), resultSet.getString("definition")));
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
