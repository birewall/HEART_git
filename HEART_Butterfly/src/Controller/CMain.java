package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CMain extends AbsMetaController{

    @FXML
    private Pane paneMain;

    @FXML
    private Button btnMainInsert;

    @FXML
    private Button btnMainAnalysis;

    @FXML
    private Button btnMainExit;

    @FXML
    private Text txtMain;

    @FXML
    private Button btnMainPicture;

    @FXML
    private Text txtMain1;

    @FXML
    private Button btnMainSpecimenMove;

    @FXML
    void mainAnalysis(ActionEvent event) {

    }

    @FXML
    void mainExit(ActionEvent event) {

    }

    @FXML
    void mainInsert(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	Parent root = loader.load(getClass().getResource("/View/VInsert.fxml").openStream());
        CInsert controller = (CInsert)loader.getController();
        controller.setParentController(this);
    	controller.setSharedModel(null);
    	Scene scene = new Scene(root);
    	Stage thisStage = (Stage)(this.btnMainExit.getScene().getWindow());
    	thisStage.setScene(scene);
    	thisStage.show();
    }

    @FXML
    void mainPicture(ActionEvent event) {

    }

    @FXML
    void specimenmoveMainSpecimen(ActionEvent event) {

    }

}
