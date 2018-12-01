package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CSpecimenLocationManager extends AbsMetaController implements Initializable {

    @FXML
    private TextField txtRoom;

    @FXML
    private ListView<String> lstRoom;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField txtCabinet;

    @FXML
    private ListView<String> lstCabinet;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtChest;

    @FXML
    private ListView<String> lstChest;

    @FXML
    private Button btnCancel;

    @FXML
    void OnCancel(ActionEvent event) {
        this.nowStage = (Stage)this.btnCancel.getScene().getWindow();
        this.nowStage.close();
    }

    @FXML
    void OnDelete(ActionEvent event) {

    }

    @FXML
    void OnEditCabinet(ActionEvent event) {

    }

    @FXML
    void OnEditingChest(ActionEvent event) {

    }

    @FXML
    void OnEditingRoom(ActionEvent event) {

    }

    @FXML
    void OnInsert(ActionEvent event) {
        this.nowStage = (Stage)this.btnCancel.getScene().getWindow();
        this.nowStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
