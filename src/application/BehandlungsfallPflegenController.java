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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class BehandlungsfallPflegenController implements Initializable{

//		@FXML
//		private Button abortButton;
//	
//		@FXML
//		private AnchorPane bfallPflegenPane;
//
//		@Override
//		public void initialize(URL arg0, ResourceBundle arg1) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@FXML
//		private void loadBFallSuchen (ActionEvent event) throws IOException {
//			AnchorPane pane = FXMLLoader.load(getClass().getResource("BehandlungsfallSuchen.fxml"));
//			bfallPflegenPane.getChildren().setAll(pane);
//		}
//		
//		@FXML
//		private void loadPrevWindow (ActionEvent event) throws IOException {
//			Parent root;
//		    Stage stage;
//		    if (event.getSource() == abortButton) {
//		        stage = (Stage) bfallPflegenPane.getScene().getWindow();
//		        root = FXMLLoader.load(getClass().getResource("MainMenue.fxml"));
//		        Scene scene = new Scene(root, 800, 700);
//		        stage.setScene(scene);
//		        stage.show();
//		    }
//			
//		}
		
	@FXML
    private TextField t_suchenachname;
    @FXML
    private TextField t_suchevorname;   
    @FXML
    private TextField t_suchestr;   
    @FXML
    private TextField t_suchenr;   
    @FXML
    private TextField t_sucheplz;   
    @FXML
    private TextField t_sucheort;
    @FXML
    private Button b_abbrechen;
    
    @FXML
    private TableView<Kundensuche_Kundendaten> tb_Namen;
    @FXML
    private TableColumn<Kundensuche_Kundendaten, String> tabc_nachname;
    @FXML
    private TableColumn<Kundensuche_Kundendaten, String> tabc_vorname;
    @FXML
    private TableColumn<Kundensuche_Kundendaten, String> tabc_str;
    @FXML
    private TableColumn<Kundensuche_Kundendaten, String> tabc_nr;
    @FXML
    private TableColumn<Kundensuche_Kundendaten, String> tabc_plz;
    @FXML
    private TableColumn<Kundensuche_Kundendaten, String> tabc_ort;
    @FXML
    private TableColumn<Kundensuche_Kundendaten, String> tabc_geschlecht;
    @FXML
    private TableColumn<Kundensuche_Kundendaten, String> tabc_ustid;
    
    
    private ObservableList<Kundensuche_Kundendaten> kundendaten = FXCollections.observableArrayList();
    
    private Hauptmenü screencontroller;
    
    public void setScreenController (Hauptmenü screencontroller) {
    	this.screencontroller = screencontroller;
    }
    
    public void initialize()  {
    	
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

    public ObservableList<Kundensuche_Kundendaten> show() {
    	return kundendaten;
    }
    
    public void suche() {
    	
    	IKundenverwaltungFactory kvFactory = new KundenverwaltungFactory();
		IKundenSuchen kundenSuchen = kvFactory.getKundenSuchen();
		
		String nachname = t_suchenachname.getText();
		String vorname 	= t_suchevorname.getText();
		String str 		= t_suchestr.getText();
		String nr 		= t_suchenr.getText();
		String plz 		= t_sucheplz.getText();
		String ort 		= t_sucheort.getText();
		
		Collection<KundeTO> kundenTO =  
				kundenSuchen.kundenSuchenPerAttribut(
							vorname, nachname,
							str, nr, plz, ort);			
		kundendaten.clear();	
		Kundensuche_Kundendaten kundedaten;
	    for (KundeTO kundeTO: kundenTO) {
		   kundedaten = new Kundensuche_Kundendaten();
		   kundedaten.setNachname(kundeTO.getNachname());
		   kundedaten.setVorname(kundeTO.getVorname());
		   kundedaten.setStr(kundeTO.getStr());
		   kundedaten.setNr(kundeTO.getNr());
		   kundedaten.setPlz(kundeTO.getPlz());
		   kundedaten.setOrt(kundeTO.getOrt());
		   if (kundeTO instanceof PrivatkundeTO )
			   kundedaten.setGeschlecht( ((PrivatkundeTO) kundeTO).getGeschlecht());
		   if (kundeTO instanceof GeschäftskundeTO )
			   kundedaten.setUstid( ((GeschäftskundeTO) kundeTO).getUstID());	   
		   
		   kundendaten.add(kundedaten);
	   }
		   
	
    	System.out.println("Anzahl Einträge in Tabelle"+kundendaten.size());
    	
    }
    
    public void abbrechen() {
    	screencontroller.anzeigen(Hauptmenü.KUNDENMENÜ);	    	
    }
	
}

