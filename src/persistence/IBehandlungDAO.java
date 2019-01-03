package persistence;

import java.util.Collection;
import awk.entity.BehandlungTO;

public interface IBehandlungDAO {
	public void updateBehandlung (BehandlungTO eintragTO);
	public Collection<BehandlungTO> getBehandlungen(String datum);

}
