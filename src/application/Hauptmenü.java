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
	
	private MainMenueController ctrlmain;
	private BehandlungsfallSuchenController ctrlbhfsuche;
	private BehandlungsfallPflegenController ctrlbhfpflege;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.mainStage = primaryStage;
		
		try {
			FXMLLoader loader;
			
			/*  Internet-Version in einer Zeile (Zugriff auf AnchorPane aus SceneBuilder) 
			 *  Link: https://stackoverflow.com/questions/22914895/fxml-load-exception 
			 *  Zugriff am: 29.12.2018
			*/ 

			loader = new FXMLLoader(getClass().getResource("/application/MainMenue.fxml"));			
			Parent menü_pane = (Parent) loader.load();
			this.mainmenü = new Scene(menü_pane,600,600);
			this.mainmenü.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			
			loader = new FXMLLoader(getClass().getResource("/application/BehandlungsfallPflegen.fxml"));
			Parent bhfpflegen_pane = (Parent)loader.load();
			this.bhfsuche = new Scene(bhfpflegen_pane,700,500);
			this.bhfsuche.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ctrlbhfpflege = loader.getController();
			ctrlbhfpflege.setScreenController(this);
			
			loader = new FXMLLoader(getClass().getResource("/application/BehandlungsfallSuchen.fxml"));
			Parent bhfsuche_pane = (Parent)loader.load();
			this.bhfsuche = new Scene(bhfsuche_pane,700,500);
			this.bhfsuche.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ctrlbhfsuche = loader.getController();
			ctrlbhfsuche.setScreenController(this);
			
			
			anzeigen(Hauptmenü.MAINMENUE, null);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void anzeigen (String screen, Boolean auswahl) {
		
		switch (screen) {
		//Klären ----------------------------------------------------------------------------------------------!!
		//warum muss es Hauptmenü.MAINMENUE heißen?
		//reicht nicht einfach nur MAINMENUE? => es wird ja nur ein String überprüft
		//warum also die Punktnotation mit Einbezug der Klasse Hauptmenü?
			case Hauptmenü.MAINMENUE: mainStage.setScene(mainmenü);
				break;
			case Hauptmenü.BHFSUCHE: mainStage.setScene(bhfsuche);
				break;
			case Hauptmenü.BHFPFLEGE: 
				if (auswahl == true  )
				ctrlbhfpflege.setBehandlung(ctrlbhfsuche.getBehandlung());
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
