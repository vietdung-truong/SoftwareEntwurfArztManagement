package awk.usecase.impl;
import java.util.*;
import awk.entity.*;
import awk.usecases.IBehandlungenSuchen;


public class BehandlungenSuchen implements IBehandlungenSuchen {

	
	public Collection<BehandlungTO> sucheBehandlungenPerDatum (String datum) {
		BehandlungManager behandlungManager = new BehandlungManager();
		Collection<BehandlungTO> behandlungen  = behandlungManager.nachBehandlungenSuchen(datum);
		return behandlungen;
	}
}
