package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import awk.entity.*;
import awk.usecase.impl.*;
import awk.usecases.*;

public class BehandlungsfallSuchenController implements Initializable {

	@FXML
	private TextField t_sucheDatum;

	@FXML
	private Button b_behandlungenSuchen;
	@FXML
	private Button b_auswahl;;
	@FXML
	private Button b_abbrechen;
	
	@FXML
	private TableView<Behandlungsuche_Behandlungsdaten> tb_Behandlungen;
	@FXML
	private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_behandlungsID;
	@FXML
	private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_arzt;
	@FXML
	private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_patient;
	

	// --------- Variablen ------------------------------------------------------------------------

	
	private ObservableList<Behandlungsuche_Behandlungsdaten> behandlungsdaten = FXCollections.observableArrayList();

	private Behandlungsuche_Behandlungsdaten behandlung; 
	
	private Hauptmen� screencontroller;

	public void setScreenController(Hauptmen� screencontroller) {
		this.screencontroller = screencontroller;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
//		// erstellt Tabelle 
//    	tabc_behandlungsID.setCellValueFactory(cellData -> cellData.getValue().nachnameProperty());
//    	tabc_arzt.setCellValueFactory(cellData -> cellData.getValue().vornameProperty()); 
//    	tabc_patient.setCellValueFactory(cellData -> cellData.getValue().strProperty());
//    	tb_Behandlungen.setItems(behandlungsdaten);
	}

	public void suche() {
		String datum = t_sucheDatum.getText();

		IBehandlungpflegenFactory bpfFactory = new BehandlungpflegenFactory();

		Collection<BehandlungTO> behandlungenTO = bpfFactory.getBehandlungenSuchen(datum);

		behandlungsdaten.clear();
		Behandlungsuche_Behandlungsdaten behandlungdaten;
		for (BehandlungTO BehandlungTO : behandlungenTO) {
			behandlungdaten = new Behandlungsuche_Behandlungsdaten();
			//get ID, Arzt, Patient-------------------------------------------------�ndern
			behandlungdaten.setNachname(BehandlungTO.getNachname());
			behandlungdaten.setVorname(BehandlungTO.getVorname());
			behandlungdaten.setStr(BehandlungTO.getStr());
			
			behandlungsdaten.add(behandlungdaten);
		}
		
		

		System.out.println("Anzahl Eintr�ge in Tabelle" + behandlungsdaten.size());

	}
	
	public void ausw�hlen() {
    	screencontroller.anzeigen(Hauptmen�.BHFPFLEGE, true);	    	
    }
	
	public Behandlungsuche_Behandlungsdaten getBehandlung() {
    	return behandlung;    	
    }

	public void abbrechen() {
		screencontroller.anzeigen(Hauptmen�.BHFPFLEGE, false);
	}
}
