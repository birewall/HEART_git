package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.AbsMetaModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public abstract class AbsMetaController {
	AbsMetaController parent_controller = null;
	AbsMetaModel shared_model = null;
	Stage nowStage;

	public void setParentController(AbsMetaController  parent_controller) {
		this.parent_controller = parent_controller;
	}
	
	public void setSharedModel(AbsMetaModel shared_model) {
		this.shared_model = shared_model;
	}
	
	public AbsMetaController getParentController() {
		return this.parent_controller;
	}
	
	public AbsMetaModel getSharedModel() {
		return this.shared_model;
	}
	
	public void changeWindow(Window nowWindow, String viewName) throws IOException {
		FXMLLoader loader = new FXMLLoader();
    	Parent root = loader.load(getClass().getResource("/View/" + viewName + ".fxml").openStream());
        AbsMetaController controller = (AbsMetaController)loader.getController();
        controller.setParentController(this);
		controller.setSharedModel(shared_model);
		nowStage = (Stage)nowWindow;
		controller.setStage(nowStage);
    	controller.init_procedure();
    	Scene scene = new Scene(root);
    	nowStage.setScene(scene);
	}
	
	public void init_procedure() {
		/* For Overridding */
	}

	public Stage getStage() {
		return nowStage;
	}

	public void setStage(Stage stage) {
		nowStage = stage;
	}
}