package application;

public class Leistung {
	private String Leistungsname;
	private String Erlauterung;
	
	
	
	
	public Leistung(String leistungsname, String erlauterung) {
		super();
		Leistungsname = leistungsname;
		Erlauterung = erlauterung;
	}
	
	public String getLeistungsname() {
		return Leistungsname;
	}
	public String getErlauterung() {
		return Erlauterung;
	}
	public void setLeistungsname(String leistungsname) {
		Leistungsname = leistungsname;
	}
	public void setErlauterung(String erlauterung) {
		Erlauterung = erlauterung;
	}
	
	

}
