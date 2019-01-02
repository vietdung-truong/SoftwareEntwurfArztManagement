package awk.usecase.impl;

import awk.entity.internal.Behandlung;
import persistence.internal.BehandlungDAO;

import java.util.Collection;

import awk.entity.*;
import persistence.internal.*;
import awk.entity.*;

public class BehandlungManager {

	public Collection<BehandlungTO> nachBehandlungenSuchen (String datum) {
		
		BehandlungDAO dao = new BehandlungDAO();
			return dao.getBehandlungen(datum);
			
	}
	
	public void BehandlungAnlegen(Behandlung behandlung) {
		;
		BehandlungDAO dao = new BehandlungDAO();	
		BehandlungTO to = new BehandlungTO(behandlung.getBehandlungsID(), behandlung.getDatum(), behandlung.getLeistungen(), behandlung.getArzt(), behandlung.getPatient(), behandlung.getBehandlungsart().toString());
		dao.updateBehandlung(to);
		
		
	}
}
