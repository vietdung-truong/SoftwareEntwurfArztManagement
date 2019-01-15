package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



import application.BehandlungsfallSuchenController;
import application.BehandlungsfallPflegenController;
import application.MainMenueController;
import application.Behandlungsuche_Behandlungsdaten;

public class Hauptmenue extends Application {
	
	private Scene mainmen�;
	private Scene bhfsuche;
	private Scene bhfpflege;
	
	public static final String MAINMENUE = "mainmen�";
	public static final String BHFPFLEGE = "bhfpflege";
	public static final String BHFSUCHE = "bhfsuche";
	
	private Stage mainStage;
	
	public Hauptmenue screenscontroller;
	public Behandlungsuche_Behandlungsdaten behandlungTOFuerPflegen;
	
	private BehandlungsfallPflegenController ctrlbhfpflege ;
	private BehandlungsfallSuchenController ctrlbhfsuche;	

	
	@Override
	public void start(Stage primaryStage) {
		behandlungTOFuerPflegen = new Behandlungsuche_Behandlungsdaten(0, "", "", "", "", "");
		
		this.mainStage = primaryStage;
		
		try {
			FXMLLoader loader;
			
			//Die Dialoge Hauptmenue, BehandlungsfallPflegen und BehandlungsfallSuchen werden vorgeladen.		
			loader = new FXMLLoader(getClass().getResource("/application/MainMenue.fxml"));			
			Parent men�_pane = (Parent) loader.load();
			this.mainmen� = new Scene(men�_pane,460,460);
			this.mainmen�.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			MainMenueController ctrlmain = loader.getController();
			ctrlmain.setScreenController(this);
			
			loader = new FXMLLoader(getClass().getResource("/application/BehandlungsfallPflegen.fxml"));
			Parent bhfpflegen_pane = (Parent)loader.load();
			this.bhfpflege = new Scene(bhfpflegen_pane,770,720);
			this.bhfpflege.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ctrlbhfpflege = loader.getController();
			ctrlbhfpflege.setScreenController(this);
			
			loader = new FXMLLoader(getClass().getResource("/application/BehandlungsfallSuchen.fxml"));
			Parent bhfsuche_pane = (Parent)loader.load();
			this.bhfsuche = new Scene(bhfsuche_pane,670,500);
			this.bhfsuche.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ctrlbhfsuche = loader.getController();
			ctrlbhfsuche.setScreenController(this);
			
			anzeigen(Hauptmenue.MAINMENUE);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Erm�glicht Navigation zwischen den Dialogen
	public void anzeigen (String screen)
	{		
		switch (screen) {
			case Hauptmenue.MAINMENUE: mainStage.setScene(mainmen�);
				mainStage.setTitle("Hauptmen�");
				break;
			case Hauptmenue.BHFPFLEGE: mainStage.setScene(bhfpflege); 
				ctrlbhfpflege.setLeistungen(behandlungTOFuerPflegen);
				ctrlbhfpflege.setBehandlung(behandlungTOFuerPflegen);
				mainStage.setTitle("Behandlung pflegen");
				break;
			case Hauptmenue.BHFSUCHE: mainStage.setScene(bhfsuche);
				mainStage.setTitle("Behandlung suchen");
				break;
		}	
		mainStage.sizeToScene();
		mainStage.show();
	}
	
	
	public static void Start_Dialog() {
		launch();
	}
}
