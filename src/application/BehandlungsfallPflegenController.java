package application;

import java.util.Collection;


import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import application.tools.XMLParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.scene.control.cell.TextFieldTableCell;
import awk.entity.*;
import awk.usecase.impl.*;
import awk.usecases.IBehandlungpflegenFactory;
import awk.usecase.*;


public class BehandlungsfallPflegenController{

	
		// ------- Deklaration der BehandlungsfallPflegen-Dialog-Elemente ----------------------------------------------------
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
	    private Label t_behandlungsart;
	    @FXML
	    private Button b_abbrechen;
	    
	    String testLeistung = "<Leistungen> \r\n" + 
	    		"  <Leistung Leistungsname=\"Heilung 1\" Erläuterung=\"Test Heilung 1\" /> \r\n" + 
	    		"  <Leistung Leistungsname=\"Heilung 2\" Erläuterung=\"Test Heilung 2\" /> \r\n" + 
	    		"  <Leistung Leistungsname=\"Heilung 3\" Erläuterung=\"Test Heilung 3\" /> \r\n" + 
	    		"</Leistungen>";
	    

	/*
	 * @FXML private void loadBFallSuchen (ActionEvent event) throws IOException {
	 * AnchorPane pane =
	 * FXMLLoader.load(getClass().getResource("BehandlungsfallSuchen.fxml"));
	 * bfallPflegenPane.getChildren().setAll(pane); }
	 */
	    public void loadBFallSuchen() {
	    	screencontroller.anzeigen(Hauptmenue.BHFSUCHE);
	    }
		
	/* @FXML */
	/*
	 * private void loadPrevWindow (ActionEvent event) throws IOException { Parent
	 * root; Stage stage; if (event.getSource() == abortButton) { stage = (Stage)
	 * bfallPflegenPane.getScene().getWindow(); root =
	 * FXMLLoader.load(getClass().getResource("MainMenue.fxml")); Scene scene = new
	 * Scene(root, 800, 700); stage.setScene(scene); stage.show(); }
	 * 
	 * }
	 */
		

    
    // ----- Tabellen Inhalt ----------------------------------------------------
    @FXML
    private TableView<Leistung> tb_leistungen;
    @FXML
    private TableColumn<Leistung, String> tabc_leistungsname;
    @FXML
    private TableColumn<Leistung, String> tabc_erlaeuterung;
    

    
    // ------ Controller-Objekte -------------------------------------------------
    private Behandlungsuche_Behandlungsdaten behandlung;
    
    private ObservableList<Leistung> leistungsdaten = FXCollections.observableArrayList();
    
    private Hauptmenue screencontroller;
    
    public void setScreenController (Hauptmenue screencontroller) {
    	this.screencontroller = screencontroller;
    }
    
    

    public void initialize()  {  	
    	
//    	t_behandlungsID.setText(behandlung.getNr());
        //Ermöglicht Tabelleneinträge der Erläuterungsspalte zu ändern
    	tb_leistungen.setEditable(true);
    	tabc_erlaeuterung.setEditable(true);
    	tabc_erlaeuterung.setCellFactory(TextFieldTableCell.forTableColumn());
 
    	// erstellt Tabelle 
    	tabc_leistungsname.setCellValueFactory(cellData -> cellData.getValue().getLeistungsname());
    	tabc_erlaeuterung.setCellValueFactory(cellData -> cellData.getValue().getErlauterung()); 
    	
	}

    //Füllt die Labels des Dialogs "Behandlungsfall pflegen" mit Daten aus dem ausgewählten Objekt der Behandlungssuche
    public void setBehandlung(Behandlungsuche_Behandlungsdaten bh) {
    	this.behandlung = bh; 
    	t_behandlungsID.setText(behandlung.behandlungsIDProperty().get());
    	t_datum.setText(behandlung.datumProperty().get());
    	t_LANR.setText("Liegt in anderer Komponente");
    	t_arzt.setText(behandlung.arztProperty().get());
    	t_patientID.setText("Liegt in anderer komponente");
    	t_patientName.setText(behandlung.patientProperty().get());
    	t_behandlungsart.setText(behandlung.behandlungsartProperty().get());	
    }
    
    
    public void setLeistungen(Behandlungsuche_Behandlungsdaten behandlung) {
    	try {
			leistungsdaten = XMLParser.getXML(behandlung.leistungenProperty().get());
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	tb_leistungen.setItems(leistungsdaten);
    }
    
    //Gehört zum "Abbrechen"-Button: Dialogwechsel zum Hauptmenü, wenn Warnhinweis mit "JA" bestätigt wird. 
    //Änderungen in Leistungserläuterung(en) werden nur übernommen, wenn vorher der Button "Leistungsänderungen übernehmen" geklickt wurde.
    public void abbrechen() {
    	Alert alert = new Alert(AlertType.CONFIRMATION, "Bitte Eingaben überprüfen", ButtonType.YES, ButtonType.CANCEL);
    	alert.setTitle("Warnhinweis");
    	alert.setHeaderText("Nicht gespeicherte Änderungen werden verworfen!");
    	alert.showAndWait();

    	if (alert.getResult() == ButtonType.YES) {
    	   	screencontroller.anzeigen(Hauptmenue.MAINMENUE);
    	}
 	    	
    }
    
    //Gehört zum "Leistungsänderungen übernehmen"-Button: Überträgt alle geänderten Leistungserläuterungen in die Datenbank
    public void speichern() {
    	ObservableList<Leistung> updLeistungen = FXCollections.observableArrayList();
    	int i = 0;
    	while (tabc_leistungsname.getCellData(i) != null) {
    		Leistung leistung = new Leistung(tabc_leistungsname.getCellData(i), tabc_erlaeuterung.getCellData(i));
    		updLeistungen.add(leistung);
    		i++;
		}
    	try {
			String xml = XMLParser.setXML(updLeistungen);

			IBehandlungpflegenFactory factory = new BehandlungpflegenFactory();
			factory.getBehandlungPflegen().behandlungsdatenSpeichern(
					Integer.parseInt(t_behandlungsID.getText()),
					t_datum.getText(),
					xml,
					t_arzt.getText(),
					t_patientName.getText(),
					t_behandlungsart.getText()
			);

			System.out.println("Speicherung erfolgreich!");
			
			Alert alert = new Alert(AlertType.INFORMATION, "", ButtonType.OK);
	    	alert.setTitle("");
	    	alert.setHeaderText("Speicherung erfolgreich!");
	    	alert.showAndWait();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   	
    }
}

