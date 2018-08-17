package Common;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.apache.log4j.*;
import org.apache.log4j.spi.LoggerFactory;

public class Main extends Application {
	protected static Logger logger = Logger.getLogger(Main.class);
	@Override
	public void start(Stage primaryStage) {
		logger.info("Hi");
	    try {
	        Parent root = FXMLLoader.load(getClass().getResource("/View/VMain.fxml"));
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("HEARTLab Butterfly Manager v0.0");
	        primaryStage.show();	    	
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	 
	public static void main(String[] args) {
	    launch(args);
	}
}