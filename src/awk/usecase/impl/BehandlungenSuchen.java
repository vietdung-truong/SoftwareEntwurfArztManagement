package awk.usecase.impl;
import java.util.*;
import awk.entity.*;


public class BehandlungenSuchen implements IBehandlungenSuchen {

	
	public Set<BehandlungTO> sucheBehandlungenPerDatum (String datum) {
		BehandlungManager behandlungManager = new BehandlungManager();
		Set<BehandlungTO> behandlungen  = behandlungManager.nachBehandlungenSuchen(datum);
		return behandlungen;
	}
}
