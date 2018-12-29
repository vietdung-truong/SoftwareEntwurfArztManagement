package persistence;

import java.util.ArrayList;

import awk.entity.BehandlungTO;

public interface IBehandlungDAO {
	public void updateBehandlung (BehandlungTO eintragTO);
	public ArrayList<BehandlungTO> getBehandlungen(String datum);

}
