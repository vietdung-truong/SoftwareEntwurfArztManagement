package application;

import application.Hauptmenue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class MainMenueController {

		@FXML private Label funcLabel;
		
		@FXML private Button bfallAnlegen;
		@FXML private Button arztPflegen; 
		@FXML private Button arztAnlegen;
		@FXML private Button patPflegen;
		@FXML private Button patAnlegen;
		@FXML private Button abrechnung;
		
		
		private Hauptmenue screencontroller;

	    public void setScreenController (Hauptmenue screencontroller) {
	    	this.screencontroller = screencontroller;
	    }
		
		public void bFallAnzeigen() {
	    	screencontroller.anzeigen(Hauptmenue.BHFPFLEGE);
	    	
	    }
		
		
		//Bei Buttonklick im Hauptmenü auf eine nichtimplementierte Funktion, wird ein Label am unteren Rand mit dem entsprechenden Hinweis versehen.
		public void nonImplementedFunctionMessage(ActionEvent e) {

			funcLabel.setText(((Button)e.getSource()).getText() + " ist noch nicht implementiert!");

		}
		
		
}

