package application;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BehandlungsfallPflegenController implements Initializable{

		@FXML
		private Button abortButton;
	
		@FXML
		private AnchorPane bfallPflegenPane;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}

		@FXML
		private void loadBFallSuchen (ActionEvent event) throws IOException {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("BehandlungsfallSuchen.fxml"));
			bfallPflegenPane.getChildren().setAll(pane);
		}
		
		@FXML
		private void loadPrevWindow (ActionEvent event) throws IOException {
			Parent root;
		    Stage stage;
		    if (event.getSource() == abortButton) {
		        stage = (Stage) bfallPflegenPane.getScene().getWindow();
		        root = FXMLLoader.load(getClass().getResource("MainMenue.fxml"));
		        Scene scene = new Scene(root, 800, 700);
		        stage.setScene(scene);
		        stage.show();
		    }
			
		}
		
}

