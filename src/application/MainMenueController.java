package application;

import application.Hauptmenue;

public class MainMenueController {

	    private Hauptmenue screencontroller;

	    public void setScreenController (Hauptmenue screencontroller) {
	    	this.screencontroller = screencontroller;
	    }
		
		public void bFallAnzeigen() {
	    	screencontroller.anzeigen(Hauptmenue.BHFPFLEGE);
	    	
	    }
}

