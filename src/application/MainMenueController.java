package application;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class MainMenueController implements Initializable{

	
		@FXML
		private AnchorPane rootPane;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}

		@FXML
		private void loadBfallPflegen (ActionEvent event) throws IOException {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("BehandlungsfallPflegen.fxml"));
			rootPane.getChildren().setAll(pane);
		}
}

