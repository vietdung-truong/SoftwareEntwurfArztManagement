package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Leistung {
	private StringProperty Leistungsname;
	private StringProperty Erlauterung;
	
	
	
	
	public Leistung(String leistungsname, String erlauterung) {
		super();
		Leistungsname = new SimpleStringProperty(leistungsname);
		Erlauterung = new SimpleStringProperty(erlauterung);
	}




	public StringProperty getLeistungsname() {
		return Leistungsname;
	}




	public StringProperty getErlauterung() {
		return Erlauterung;
	}




	public void setLeistungsname(String leistungsname) {
		Leistungsname = new SimpleStringProperty(leistungsname);
	}



	public void setErlauterung(String erlauterung) {
		Erlauterung = new SimpleStringProperty(erlauterung);
	}
	
	
	
	
	
	

}
