package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Behandlungsuche_Behandlungsdaten {
	private final StringProperty nachname;
	private final StringProperty vorname;
	private final StringProperty str;
	private final StringProperty nr;
	private final StringProperty plz;
	private final StringProperty ort;
	private final StringProperty geschlecht;
	private final StringProperty ustid;

	public Behandlungsuche_Behandlungsdaten() {
			this (null,null, null, null, null, null, null, null);
		}

	public Behandlungsuche_Behandlungsdaten(	String nachname, String vorname,
										String str, String nr, String plz, String ort,
										String geschlecht, String ustid) {
	        this.nachname = new SimpleStringProperty(nachname);
	        this.vorname = new SimpleStringProperty(vorname);
	        this.str = new SimpleStringProperty(str);
	        this.nr = new SimpleStringProperty(nr);
	        this.plz = new SimpleStringProperty(plz);
	        this.ort = new SimpleStringProperty(ort);
	        this.geschlecht = new SimpleStringProperty(geschlecht);
	        this.ustid = new SimpleStringProperty(ustid);
		}
	
	// hier auch umwandlung von leistungen in Datentypen?? 

	public String getnachname() {
		return nachname.get();
	}

	public void setNachname(String nachname) {
		this.nachname.set(nachname);
	}

	public StringProperty nachnameProperty() {
		return nachname;
	}

	public String getVorname() {
		return vorname.get();
	}

	public void setVorname(String vorname) {
		this.vorname.set(vorname);
	}

	public StringProperty vornameProperty() {
		return vorname;
	}

	public String getStr() {
		return str.get();
	}

	public void setStr(String str) {
		this.str.set(str);
	}

	public StringProperty strProperty() {
		return str;
	}

	public String getNr() {
		return nr.get();
	}

	public void setNr(String nr) {
		this.nr.set(nr);
	}

	public StringProperty nrProperty() {
		return nr;
	}

	public String getPlz() {
		return plz.get();
	}

	public void setPlz(String plz) {
		this.plz.set(plz);
	}

	public StringProperty plzProperty() {
		return plz;
	}

	public String getOrt() {
		return ort.get();
	}

	public void setOrt(String ort) {
		this.ort.set(ort);
	}

	public StringProperty ortProperty() {
		return ort;
	}

	public String getGeschlecht() {
		return geschlecht.get();
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht.set(geschlecht);
	}

	public StringProperty geschlechtProperty() {
		return geschlecht;
	}

	public String getUstid() {
		return ustid.get();
	}

	public void setUstid(String ustid) {
		this.ustid.set(ustid);
	}

	public StringProperty ustidProperty() {
		return ustid;
	}
}
