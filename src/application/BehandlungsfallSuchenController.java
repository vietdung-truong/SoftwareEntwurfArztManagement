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

public class BehandlungsfallSuchenController {

	@FXML
	private TextField t_sucheDatum;	
	@FXML
	private TableView<Behandlungsuche_Behandlungsdaten> tb_Behandlungen;
	@FXML
	private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_behandlungsID;
	@FXML
	private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_arzt;
	@FXML
	private TableColumn<Behandlungsuche_Behandlungsdaten, String> tabc_patient;
	

	// --------- Variablen für die Behandlungsdatensuche------------------------------------------------------------------------

	
	private ObservableList<Behandlungsuche_Behandlungsdaten> behandlungsdaten = FXCollections.observableArrayList();

	private Behandlungsuche_Behandlungsdaten behandlung; 
	
	private Hauptmenue screencontroller;

	public void setScreenController(Hauptmenue screencontroller) {
		this.screencontroller = screencontroller;
	}

//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		
//		
//		// erstellt Tabelle 
//    	tabc_behandlungsID.setCellValueFactory(cellData -> cellData.getValue().behandlungsIDProperty());
//    	tabc_arzt.setCellValueFactory(cellData -> cellData.getValue().arztProperty()); 
//    	tabc_patient.setCellValueFactory(cellData -> cellData.getValue().patientProperty());
//    	tb_Behandlungen.setItems(behandlungsdaten);
//	}

	
	public void suche() {
		String datum = t_sucheDatum.getText();

		IBehandlungpflegenFactory bpfFactory = new BehandlungpflegenFactory();
		Collection<BehandlungTO> behandlungenTO = bpfFactory.getBehandlungenSuchen().sucheBehandlungenPerDatum(datum);

		behandlungsdaten.clear();
		Behandlungsuche_Behandlungsdaten behandlungdaten;
		for (BehandlungTO BehandlungTO : behandlungenTO) {
			behandlungdaten = new Behandlungsuche_Behandlungsdaten();
			//get ID, Arzt, Patient-------------------------------------------------ändern
			behandlungdaten.setBehandlungsID(BehandlungTO.getBehandlungsID());
			behandlungdaten.setBehandlungsart(BehandlungTO.getBehandlungsart());
			behandlungdaten.setArzt(BehandlungTO.getArzt());
			behandlungdaten.setPatient(BehandlungTO.getPatient());
			behandlungdaten.setLeistungen(BehandlungTO.getLeistungen());
			behandlungdaten.setDatum(BehandlungTO.getDatum());
			
			behandlungsdaten.add(behandlungdaten);
		}
		
		

		System.out.println("Anzahl Einträge in Tabelle" + behandlungsdaten.size());

	}
	
	public void auswählen() {
    	screencontroller.anzeigen(Hauptmenue.BHFPFLEGE);	    	
    }
	
	public Behandlungsuche_Behandlungsdaten getBehandlung() {
    	return behandlung;    	
    }

	public void sucheAbbrechen() {
    	screencontroller.anzeigen(Hauptmenue.BHFPFLEGE); 
    }
	
}
