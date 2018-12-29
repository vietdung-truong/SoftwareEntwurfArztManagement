package awk.entity.internal;

import java.util.*;
import awk.datatypes.*;

public class Behandlung {
	int behandlungsID;
	String datum;
	String leistungen = String;
	String arzt;
	String patient;
	Behandlungsart behandlungsart;

	public Behandlung(int behandlungsID, String datum, String leistungen, String arzt,String patient, Behandlungsart behandlungsart ) {
		this.behandlungsID = behandlungsID;
		this.datum = datum;
		this.leistungen = leistungen;
		this.arzt = arzt;
		this.patient = patient;
		this.behandlungsart = behandlungsart;
	}

	public String getEckdaten() {

		return leistungen.toString();
	}

	public void setBehandlungsID(int behandlungsID) {
		this.behandlungsID = behandlungsID;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public void setLeistungen(String leistungen) {
		this.leistungen = leistungen;
	}

	public void setArzt(String arzt) {
		this.arzt = arzt;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public void setBehandlungsart(Behandlungsart behandlungsart) {
		this.behandlungsart = behandlungsart;
	}

	

}
