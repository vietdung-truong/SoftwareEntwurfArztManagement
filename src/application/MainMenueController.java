package application;

import application.Hauptmen�;

//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.layout.AnchorPane;

public class MainMenueController {

	    private Hauptmen� screencontroller;

	    public void setScreenController (Hauptmen� screencontroller) {
	    	this.screencontroller = screencontroller;
	    }
		
		public void bFallAnzeigen() {
	    	screencontroller.anzeigen(Hauptmen�.BHFPFLEGE);
	    	
	    }

//	    //Beispiel f�r Scenenwechsel aus dem Internet: (funktioniert)
//		@FXML
//		private AnchorPane rootPane;
//		@FXML
//		private void bFallAnzeigen (ActionEvent event) throws IOException {
//			AnchorPane pane = FXMLLoader.load(getClass().getResource("BehandlungsfallPflegen.fxml"));
//			rootPane.getChildren().setAll(pane);
//		}
		
	
}

