package Common;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.apache.log4j.*;
import org.apache.log4j.spi.LoggerFactory;

import Controller.AbsMetaController;
import Controller.CInitial;
import Controller.CMain;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	    try {
	        FXMLLoader loader = new FXMLLoader();
	    	Parent root = loader.load(getClass().getResource("/View/VMain.fxml").openStream());
	    	CMain controller = (CMain)loader.getController();
	        //controller.setForDebug();
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