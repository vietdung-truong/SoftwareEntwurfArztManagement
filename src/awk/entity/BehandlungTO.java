package awk.entity;

import java.util.HashSet;
import java.util.Set;


public class BehandlungTO {
	int behandlungsID;
	String datum;
	Set<String> leistungen = new HashSet<String>();
	String arzt;
	String patient;
	String behandlungsart;

	public BehandlungTO(int behandlungsID, String datum, Set<String> leistungen, String arzt,String patient, String behandlungsart ) {
		this.behandlungsID = behandlungsID;
		this.datum = datum;
		this.leistungen = leistungen;
		this.arzt = arzt;
		this.patient = patient;
		this.behandlungsart = behandlungsart;
	}

	

	public int getBehandlungsID() {
		return behandlungsID;
	}



	public String getDatum() {
		return datum;
	}



	public Set<String> getLeistungen() {
		return leistungen;
	}



	public String getArzt() {
		return arzt;
	}



	public String getPatient() {
		return patient;
	}



	public String getBehandlungsart() {
		return behandlungsart;
	}



	public void setBehandlungsart(String behandlungsart) {
		this.behandlungsart = behandlungsart;
	}



	public void setBehandlungsID(int behandlungsID) {
		this.behandlungsID = behandlungsID;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public void setLeistungen(Set<String> leistungen) {
		this.leistungen = leistungen;
	}

	public void setArzt(String arzt) {
		this.arzt = arzt;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public void setBehandlungsart(Behandlungsart behandlungsart) {
	}
}
