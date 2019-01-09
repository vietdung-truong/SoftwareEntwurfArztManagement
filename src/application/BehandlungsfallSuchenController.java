package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
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
	
	private Collection<BehandlungTO> behandlungenTO = new ArrayList<BehandlungTO>(); 

	public void setScreenController(Hauptmenue screencontroller) {
		this.screencontroller = screencontroller;
	}
	

	public void initialize() {
		
		tb_Behandlungen.setRowFactory(tv -> { 
			TableRow<Behandlungsuche_Behandlungsdaten> row = new TableRow<>();
			row.setOnMouseClicked(event -> { 
				if (!row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
					&& event.getClickCount() == 2) {
					
					Behandlungsuche_Behandlungsdaten clickedRow = row.getItem();
					System.out.println(clickedRow);
					auswaehlen(clickedRow);
				}
			});
			return row;
		});
		
		
		// erstellt Tabelle 
    	tabc_behandlungsID.setCellValueFactory(cellData -> cellData.getValue().behandlungsIDProperty());
    	tabc_arzt.setCellValueFactory(cellData -> cellData.getValue().arztProperty()); 
    	tabc_patient.setCellValueFactory(cellData -> cellData.getValue().patientProperty());
    	tb_Behandlungen.setItems(behandlungsdaten);
	}

	
	public void suche() {
		String datum = t_sucheDatum.getText();

		IBehandlungpflegenFactory bpfFactory = new BehandlungpflegenFactory();
		Collection<BehandlungTO> behandlungenTO = bpfFactory.getBehandlungenSuchen().sucheBehandlungenPerDatum(datum);

		behandlungsdaten.clear();
		Behandlungsuche_Behandlungsdaten behandlungdaten;
		for (BehandlungTO BehandlungTO : behandlungenTO) {
			behandlungdaten = new Behandlungsuche_Behandlungsdaten(
					BehandlungTO.getBehandlungsID(),
					BehandlungTO.getDatum(),
					BehandlungTO.getArzt(),
					BehandlungTO.getPatient(),
					BehandlungTO.getBehandlungsart(),
					BehandlungTO.getLeistungen()
			);

						behandlungsdaten.add(behandlungdaten);
		}
		
		

		System.out.println("Anzahl Eintraege in Tabelle = " + behandlungsdaten.size());


	}
	
	public void auswaehlen(Behandlungsuche_Behandlungsdaten behandlung) {
//		ArrayList al = new ArrayList<>();
//
//		TablePosition pos;
//		
//		pos = tb_Behandlungen.getSelectionModel().getSelectedCells().get(0);
//		System.out.println(pos);
//		for (int j = 0; j < behandlungsdaten.size(); j++) {
//			Behandlungsuche_Behandlungsdaten to = behandlungsdaten.iterator().next();
//			if (to.getBehandlungsID().toString() == pos.toString()) {
//				screencontroller.behandlungTOFuerPflegen = to;
//			}
//		}
//		
		
		screencontroller.behandlungTOFuerPflegen = behandlung;
		//FUNKTION ERGAENZEN: DATEN AUS TABELLE ZIEHEN------------------------------------------------------------------------!!!!!!!!!!!!!!
		System.out.println(behandlung);
    	screencontroller.anzeigen(Hauptmenue.BHFPFLEGE);	    	
    }
	
	public Behandlungsuche_Behandlungsdaten getBehandlung() {
    	return behandlung;    	
    }
    
	@FXML
	public void sucheAbbrechen() {
    	screencontroller.anzeigen(Hauptmenue.BHFPFLEGE); 
    }
	
	
	
}
