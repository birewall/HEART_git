package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.AbsMetaModel;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public abstract class AbsMetaController {
	AbsMetaController parent_controller = null;
	AbsMetaModel shared_model = null;
	Stage nowStage;

    public Stage getStage() {
        return nowStage;
    }

    public void setStage(Stage stage) {
        nowStage = stage;
    }

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

    public void spawnChildWindow(Window nowWindow, String viewName) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/View/" + viewName + ".fxml").openStream());
        AbsMetaController controller = (AbsMetaController)loader.getController();
        controller.setParentController(this);
        controller.setSharedModel(shared_model);
        Stage newStage = new Stage();
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(nowWindow);
        controller.setStage(nowStage);
        controller.init_procedure();
        newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                boolean exit_flag = controller.on_close_stage();
                if(!exit_flag) we.consume();
            }
        });

        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    public boolean on_close_stage() {
        /* For Overriding */
        return true;
    }

    public void init_procedure() {
        /* For Overridding */
    }

    public void view_update() {
        /* For Overridding */
    }

	public void handle(WindowEvent we) {
		// TODO Auto-generated method stub
		
	}
}