package Common;
import Controller.CAnalysisMain;
import Controller.CLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import Controller.CMain;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	    try {
	        FXMLLoader loader = new FXMLLoader();
	    	Parent root = loader.load(getClass().getResource("/View/VAnalysisMain.fxml").openStream());
	    	CAnalysisMain controller = (CAnalysisMain)loader.getController();
	    	Scene scene = new Scene(root);
	    	primaryStage.setScene(scene);
	        primaryStage.setTitle("HEARTLab LH Freezing Factor Manager v0.0");
	        primaryStage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	 
	public static void main(String[] args) {
	    launch(args);
	}
}