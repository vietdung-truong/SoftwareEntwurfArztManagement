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

public class BehandlungsfallSuchenController implements Initializable{

		@FXML
		private Button abortSucheButton;
	
		@FXML
		private AnchorPane bfallSuchenPane;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}

				
		@FXML
		private void loadPrevWindow (ActionEvent event) throws IOException {
			Parent root;
		    Stage stage;
		    if (event.getSource() == abortSucheButton) {
		        stage = (Stage) bfallSuchenPane.getScene().getWindow();
		        root = FXMLLoader.load(getClass().getResource("BehandlungsfallPflegen.fxml"));
		        Scene scene = new Scene(root, 800, 700);
		        stage.setScene(scene);
		        stage.show();
		    }
			
		}
		
}

