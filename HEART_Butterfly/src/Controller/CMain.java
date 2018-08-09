package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CMain implements Initializable {

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
    void mainInsert(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Stage thisStage = (Stage)(this.btnMainExit.getScene().getWindow());
		thisStage.setTitle("");
	}

}
