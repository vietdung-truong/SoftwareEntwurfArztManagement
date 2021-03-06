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

	// ------- Deklaration der BehandlungsfallSuchen-Dialog-Elemente ----------------------------------------------------
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


	// --------- Variablen f�r die Behandlungsdatensuche------------------------------------------------------------------------
	
	private ObservableList<Behandlungsuche_Behandlungsdaten> behandlungsdaten = FXCollections.observableArrayList();

	private Hauptmenue screencontroller;
	
	private Collection<BehandlungTO> behandlungenTO = new ArrayList<BehandlungTO>(); 

	
	public void setScreenController(Hauptmenue screencontroller) {
		this.screencontroller = screencontroller;
	}
	

	public void initialize() {

		// Wird bei Doppelklick auf eine Tabellenzeile aufgerufen: �bernimmt die Daten der angeklickten Zeile und gibt sie zur�ck
		tb_Behandlungen.setRowFactory(tv -> { 
			TableRow<Behandlungsuche_Behandlungsdaten> row = new TableRow<>();
			row.setOnMouseClicked(event -> { 
				if (!row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
					&& event.getClickCount() == 2) {
					
					Behandlungsuche_Behandlungsdaten clickedRow = row.getItem();
					System.out.println(clickedRow.behandlungsIDProperty().get() + "  " + clickedRow.behandlungsartProperty().get()+ "  " + clickedRow.leistungenProperty().get());
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

	// Geh�rt zum "Suchen"-Button: Durchsucht die Datenbank und gibt alle Eintr�ge mit dem gleichen Datum, wie eingegeben, aus.
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

	
	// Unterst�tzt die Methode "Initialize()": Durchsucht die doppelt-angeklickte Zeile spaltenweise nach der BehandlungsID. 
	// Navigiert anschlie�end zum Dialog "BehandlungsfallPflegen"
	public void auswaehlen(Behandlungsuche_Behandlungsdaten clickedRow) {
		int j = 0; 
		
		for (Behandlungsuche_Behandlungsdaten b : behandlungsdaten) {

			System.out.println(b + "test b 1");

			System.out.println(behandlungsdaten.size());
			if (clickedRow.behandlungsIDProperty().get() == b.behandlungsIDProperty().get()) {
				screencontroller.behandlungTOFuerPflegen = b;
				System.out.println(b + "test b 2");
				
				j = behandlungsdaten.size();
			}
			j++;
		}
				
    	screencontroller.anzeigen(Hauptmenue.BHFPFLEGE);	    	
    }
	
//	public Behandlungsuche_Behandlungsdaten getBehandlung() {
//    	return behandlung;    	
//    }
    
	
	public void sucheAbbrechen() {
    	screencontroller.anzeigen(Hauptmenue.BHFPFLEGE); 
    }
	
}
