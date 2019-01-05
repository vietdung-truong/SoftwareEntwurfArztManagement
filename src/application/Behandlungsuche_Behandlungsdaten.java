package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Behandlungsuche_Behandlungsdaten {
	private final StringProperty behandlungsID;
	private final StringProperty datum;
	private final StringProperty arzt;
	private final StringProperty patient;
	private final StringProperty behandlungsart;
	private final StringProperty leistungen;

	 public Behandlungsuche_Behandlungsdaten() {
	 this (null, null, null, null, null, null);
	 }

	public Behandlungsuche_Behandlungsdaten(int behandlungsID, String datum, String arzt, String patient,
			String behandlungsart, String leistungen) {

		String s = "" + behandlungsID;
		this.behandlungsID = new SimpleStringProperty(s);
		this.datum = new SimpleStringProperty(datum);
		this.arzt = new SimpleStringProperty(arzt);
		this.patient = new SimpleStringProperty(patient);
		this.behandlungsart = new SimpleStringProperty(behandlungsart);
		this.leistungen = new SimpleStringProperty(leistungen);
	}

	public StringProperty getBehandlungsID() {
		return behandlungsID;
	}

	public StringProperty getDatum() {
		return datum;
	}

	public StringProperty getArzt() {
		return arzt;
	}

	public StringProperty getPatient() {
		return patient;
	}

	public StringProperty getBehandlungsart() {
		return behandlungsart;
	}

	public StringProperty getLeistungen() {
		return leistungen;
	}

	public void setBehandlungsID(int behandlungsID) {
		String s = "" + behandlungsID;
		this.behandlungsID.set(s);
	}

	public void setDatum(String datum) {
		this.datum.set(datum);
	}

	public void setArzt(String arzt) {
		this.arzt.set(arzt);
	}

	public void setPatient(String patient) {
		this.patient.set(patient);
	}

	public void setBehandlungsart(String behandlungsart) {
		this.behandlungsart.set(behandlungsart);
	}

	public void setLeistungen(String leistungen) {
		this.leistungen.set(leistungen);
	}
	
	public StringProperty behandlungsIDProperty() {
		return behandlungsID;
	}

	public StringProperty datumProperty() {
		return datum;
	}

	public StringProperty arztProperty() {
		return arzt;
	}

	public StringProperty patientProperty() {
		return patient;
	}

	public StringProperty behandlungsartProperty() {
		return behandlungsart;
	}

	public StringProperty leistungenProperty() {
		return leistungen;
	}
	

	// hier auch umwandlung von leistungen in Datentypen??

}
