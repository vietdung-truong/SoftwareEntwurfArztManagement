package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*  Die auskommentierten Zeilen sind aus dem Skript - 
			 *  eine kürzere Version aus dem Internet funktioniert genauso.
			 */
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("BehandlungsfallPflegen.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenue.fxml"));
			Parent root = (Parent)loader.load();
			
			/*  Internet-Version in einer Zeile (Zugriff auf AnchorPane aus SceneBuilder) 
			 *  Link: https://stackoverflow.com/questions/22914895/fxml-load-exception 
			 *  Zugriff am: 29.12.2018
			*/ 
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BehandlungsfallSuchen.fxml"));
//			AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("/application/Hauptmenü.fxml"));
			
			/* Rest wie aus Skript */
			Scene scene = new Scene(root,800,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hauptmenü");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
