package awk.usecases;

import java.util.Set;
import awk.entity.BehandlungTO;


public interface IBehandlungenSuchen {

	public Set<BehandlungTO> sucheBehandlungenPerDatum ();
}
