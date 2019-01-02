package awk.usecase.impl;

import awk.entity.internal.Behandlung;
import persistence.internal.BehandlungDAO;
import awk.entity.*;
import awk.entity.*;

public class BehandlungManager {

	public Behandlung nachBehandlungenSuchen (String datum) {
		
		BehandlungDAO BehandlungDAO = new BehandlungDAO();
		awk.entity.BehandlungTO BehandlungTO = BehandlungDAO.getBehandlungen(datum);
		
		if (BehandlungTO != null)
			return new Behandlung (BehandlungTO.getBehandlungsID(), BehandlungTO.getDatum(), BehandlungTO.getLeistungen(), BehandlungTO.getArzt(),BehandlungTO.getPatient(),BehandlungTO.getBehandlungsart());
		else
			return null;
	}
	
	public void BehandlungAnlegen(Behandlung Behandlung) {
		
		IBehandlungDAO BehandlungDAO = new BehandlungDAO();		
		BehandlungTO BehandlungTO = new BehandlungTO(Behandlung.getDatum(), Behandlung.);
		BehandlungDAO.speichereBehandlung(BehandlungTO);
		
		
	}
}
