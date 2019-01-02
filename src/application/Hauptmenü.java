package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import application.BehandlungsfallSuchenController;
import application.BehandlungsfallPflegenController;
import application.MainMenueController;

public class Hauptmenü extends Application {
	
	private Scene mainmenü;
	private Scene bhfsuche;
	private Scene bhfpflege;
	
	public static final String MAINMENUE = "mainmenü";
	public static final String BHFSUCHE = "bhfsuche";
	public static final String BHFPFLEGE = "bhfpflege";
	
	private Stage mainStage;
	
	public Hauptmenü screenscontroller;
	
	private BehandlungsfallSuchenController ctrlbhfsuche;
	BehandlungsfallPflegenController ctrlbhfpflege;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.mainStage = primaryStage;
		
		try {
			/*  Die auskommentierten Zeilen sind aus dem Skript - 
			 *  eine kürzere Version aus dem Internet funktioniert genauso.
			 */
//			
			FXMLLoader loader;
			
			/*  Internet-Version in einer Zeile (Zugriff auf AnchorPane aus SceneBuilder) 
			 *  Link: https://stackoverflow.com/questions/22914895/fxml-load-exception 
			 *  Zugriff am: 29.12.2018
			*/ 
//			
			

			loader = new FXMLLoader(getClass().getResource("kundenverwaltung/mainmenü.fxml"));			
			Parent menü_pane = (Parent) loader.load();
			this.mainmenü = new Scene(menü_pane,200,200);
			this.mainmenü.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			MainMenueController ctrlmainmenü = loader.getController();
			ctrlmainmenü.setScreenController(this);
			
			loader = new FXMLLoader(getClass().getResource("kundenverwaltung/bhfsuche.fxml"));
			Parent bhfsuche_pane = (Parent)loader.load();
			this.bhfsuche = new Scene(bhfsuche_pane,700,500);
			this.bhfsuche.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ctrlbhfsuche = loader.getController();
			ctrlbhfsuche.setScreenController(this);
			
			loader = new FXMLLoader(getClass().getResource("kundenverwaltung/bhfpflege.fxml"));
			Parent bhfpflege_pane = (Parent) loader.load();
			this.bhfpflege = new Scene(bhfpflege_pane,600,400);
			this.bhfpflege.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ctrlbhfpflege = loader.getController();
			ctrlbhfpflege.setScreenController(this);
			
			anzeigen(Hauptmenü.MAINMENUE);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void anzeigen (String screen, Boolean auswahl) {
		
		switch (screen) {
			case Hauptmenü.MAINMENUE: mainStage.setScene(mainmenü);
				break;
			case Hauptmenü.BHFSUCHE: mainStage.setScene(bhfsuche);
				break;
			case Hauptmenü.BHFPFLEGE: 
				if (auswahl == true  )
				ctrlbhfpflege.setKundendaten(ctrlbhfsuche.getBehandlung());
				mainStage.setScene(bhfpflege);
				break;
		}
		
		mainStage.sizeToScene();
		mainStage.show();
	}
	
	public static void Start_Dialog() {
		launch();
	}
}
