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

public class Hauptmen� extends Application {
	
	private Scene mainmen�;
	private Scene bhfsuche;
	private Scene bhfpflege;
	
	public static final String MAINMENUE = "mainmen�";
	public static final String BHFSUCHE = "bhfsuche";
	public static final String BHFPFLEGE = "bhfpflege";
	
	private Stage mainStage;
	
	public Hauptmen� screenscontroller;
	
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
			Parent men�_pane = (Parent) loader.load();
			this.mainmen� = new Scene(men�_pane,600,600);
			this.mainmen�.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			
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
			
			
			anzeigen(Hauptmen�.MAINMENUE, null);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void anzeigen (String screen, Boolean auswahl) {
		
		switch (screen) {
		//Kl�ren ----------------------------------------------------------------------------------------------!!
		//warum muss es Hauptmen�.MAINMENUE hei�en?
		//reicht nicht einfach nur MAINMENUE? => es wird ja nur ein String �berpr�ft
		//warum also die Punktnotation mit Einbezug der Klasse Hauptmen�?
			case Hauptmen�.MAINMENUE: mainStage.setScene(mainmen�);
				break;
			case Hauptmen�.BHFSUCHE: mainStage.setScene(bhfsuche);
				break;
			case Hauptmen�.BHFPFLEGE: 
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
