package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CInsert {

    @FXML
    private Button btnInsertWatch;

    @FXML
    private Button btnInsertPicture;

    @FXML
    private Button btnInsertSpecimen;

    @FXML
    private Button btnInsertExit;

    @FXML
    void insertExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void insertPicture(ActionEvent event) {

    }

    @FXML
    void insertSpecimen(ActionEvent event) {

    }

    @FXML
    void insertWatch(ActionEvent event) {

    }

}
