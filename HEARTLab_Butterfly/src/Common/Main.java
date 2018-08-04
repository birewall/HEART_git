package Common;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.apache.log4j.*;

public class Main extends Application {
	protected static Logger logger = Logger.getLogger(Main.class.getName());
	@Override
	public void start(Stage primaryStage) {
	    try {
	    	/*
	        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        */
	    	logger.info("Hi");
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	 
	public static void main(String[] args) {
	    launch(args);
	}
}