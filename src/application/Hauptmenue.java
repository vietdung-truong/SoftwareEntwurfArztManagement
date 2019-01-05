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

public class Hauptmenue extends Application {
	
	private Scene mainmen�;
	private Scene bhfsuche;
	private Scene bhfpflege;
	
	public static final String MAINMENUE = "mainmen�";
	public static final String BHFPFLEGE = "bhfpflege";
	public static final String BHFSUCHE = "bhfsuche";
	
	private Stage mainStage;
	
	public Hauptmenue screenscontroller;
	
//	public MainMenueController ctrlmain;
//	public BehandlungsfallPflegenController ctrlpflegen;
//	public BehandlungsfallSuchenController ctrlsuchen;	
	
	@Override
	public void start(Stage primaryStage) {
		
		this.mainStage = primaryStage;
		
		try {
			FXMLLoader loader;
			
			loader = new FXMLLoader(getClass().getResource("/application/MainMenue.fxml"));			
			Parent men�_pane = (Parent) loader.load();
			this.mainmen� = new Scene(men�_pane,600,600);
			this.mainmen�.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			MainMenueController ctrlmain = loader.getController();
			ctrlmain.setScreenController(this);
			
			loader = new FXMLLoader(getClass().getResource("/application/BehandlungsfallPflegen.fxml"));
			Parent bhfpflegen_pane = (Parent)loader.load();
			this.bhfpflege = new Scene(bhfpflegen_pane,900,800);
			this.bhfpflege.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			BehandlungsfallPflegenController ctrlbhfpflege = loader.getController();
			ctrlbhfpflege.setScreenController(this);
			
			loader = new FXMLLoader(getClass().getResource("/application/BehandlungsfallSuchen.fxml"));
			Parent bhfsuche_pane = (Parent)loader.load();
			this.bhfsuche = new Scene(bhfsuche_pane,700,500);
			this.bhfsuche.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			BehandlungsfallSuchenController ctrlbhfsuche = loader.getController();
			ctrlbhfsuche.setScreenController(this);
			
			anzeigen(Hauptmenue.MAINMENUE);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void anzeigen (String screen)
	{
		
		switch (screen) {
			case Hauptmenue.MAINMENUE: mainStage.setScene(mainmen�);
				break;
			case Hauptmenue.BHFSUCHE: mainStage.setScene(bhfsuche);
				break;
			case Hauptmenue.BHFPFLEGE: mainStage.setScene(bhfpflege); 
				//ctrlbhfpflege.setBehandlung(ctrlbhfsuche.getBehandlung());
				
				break;
		}
		
		mainStage.sizeToScene();
		mainStage.show();
	}
	
	public static void Start_Dialog() {
		launch();
	}
}