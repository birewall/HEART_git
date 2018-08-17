package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CMain extends AbsMetaController implements Initializable {

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
    void mainAnalysis(ActionEvent event) {

    }

    @FXML
    void mainExit(ActionEvent event) {
    	System.exit(0);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
}
