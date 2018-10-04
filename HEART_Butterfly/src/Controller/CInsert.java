package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CInsert extends AbsMetaController {

    @FXML
    private Button btnInsertWatch;

    @FXML
    private Button btnInsertPicture;

    @FXML
    private Button btnInsertSpecimen;
    
    @FXML
    private Button btnInsertAnticeptic;

    @FXML
    private Button btnInsertExit;

    @FXML
    void insertExit(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertExit.getScene().getWindow(), "VMain");
    }

    @FXML
    void insertPicture(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertExit.getScene().getWindow(), "VInsertPicture");
    }

    @FXML
    void insertSpecimen(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertExit.getScene().getWindow(), "VInsertSpecimen");
    }
    
    @FXML
    void insertAnticeptic(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertExit.getScene().getWindow(), "VInsertAnticeptic");
    }

    @FXML
    void insertWatch(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertExit.getScene().getWindow(), "VInsertWatch");
    }
}
