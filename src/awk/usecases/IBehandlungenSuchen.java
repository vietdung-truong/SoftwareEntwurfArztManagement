package awk.usecases;

import java.util.Collection;
import java.util.Set;
import awk.entity.BehandlungTO;


public interface IBehandlungenSuchen {

	public Collection<BehandlungTO> sucheBehandlungenPerDatum (String datum);
}
