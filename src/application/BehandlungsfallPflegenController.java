package application;

import java.util.Collection;


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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import awk.entity.*;
import awk.usecase.impl.*;


public class BehandlungsfallPflegenController implements Initializable{

		@FXML
		private Button abortButton;
	
		@FXML
		private AnchorPane bfallPflegenPane;

		@FXML
	    private Label t_behandlungsID;
	    @FXML
	    private Label t_datum;   
	    @FXML
	    private Label t_LANR;
	    @FXML
	    private Label t_arzt;   
	    @FXML
	    private Label t_patientID;
	    @FXML
	    private Label t_patientName;   
	    @FXML
	    private Button b_abbrechen;
	    
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
		

    
    // ----- Tabellen Inhalt ----------------------------------------------------
    
    //Klären-----------------------------------------------------------------------------------------------!!
    //Sinn?
    //Anzeige der Stammdaten des Patienten sind unnötig an dieser Stelle.
    //Hier müssen die Leistungen in der Tabelle abgebildet werden (LeistungsID, Leistungsname, Erklärung,  etc.)
    @FXML
    private TableView<Behandlungsuche_Behandlungsdaten> tb_Namen;
    @FXML
    private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_nachname;
    @FXML
    private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_vorname;
    @FXML
    private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_str;
    @FXML
    private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_nr;
    @FXML
    private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_plz;
    @FXML
    private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_ort;
    @FXML
    private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_geschlecht;
    @FXML
    private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_ustid;
    //Leistung hat: Name / beschreibung
    
    
    
    private Behandlungsuche_Behandlungsdaten behandlung;
    
    private Hauptmenü screencontroller;
    
    public void setScreenController (Hauptmenü screencontroller) {
    	this.screencontroller = screencontroller;
    }
    
    public void initialize()  {
    	
    	t_behandlungsID.setText(behandlung.getNr());
    	
    	// erstellt Tabelle 
    	tabc_nachname.setCellValueFactory(cellData -> cellData.getValue().nachnameProperty());
    	tabc_vorname.setCellValueFactory(cellData -> cellData.getValue().vornameProperty()); 
    	tabc_str.setCellValueFactory(cellData -> cellData.getValue().strProperty());
    	tabc_nr.setCellValueFactory(cellData -> cellData.getValue().nrProperty());
    	tabc_plz.setCellValueFactory(cellData -> cellData.getValue().plzProperty());
    	tabc_ort.setCellValueFactory(cellData -> cellData.getValue().ortProperty());
    	tabc_geschlecht.setCellValueFactory(cellData -> cellData.getValue().geschlechtProperty());
    	tabc_ustid.setCellValueFactory(cellData -> cellData.getValue().ustidProperty());
    	
    	tb_Namen.setItems(show());
    }

    public ObservableList<Behandlungsuche_Behandlungsdaten> show() {
    	
    	// hier Übertragen der Leistungen
    	return behandlung.leistungen();
    }
    
    
    
    public void setBehandlung(Behandlungsuche_Behandlungsdaten behandlung) {
    	this.behandlung = behandlung; 
    }
    
    public void abbrechen() {
    	screencontroller.anzeigen(Hauptmenü.MAINMENUE, false);	    	
    }
	
}

