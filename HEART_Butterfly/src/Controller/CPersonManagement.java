package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CPersonManagement extends AbsMetaController {

    @FXML
    private ListView<String> lsvName;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnEdit;

    @FXML
    private TextField txtName;

    @FXML
    void OnDelete(ActionEvent event) {

    }

    @FXML
    void OnDone(ActionEvent event) {
        Stage thisStage = (Stage)this.btnDone.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    void OnEdit(ActionEvent event) {

    }

    @FXML
    void OnInsert(ActionEvent event) {

    }

    @FXML
    void OnNameTyping(ActionEvent event) {

    }

    public void init_procedure() {

    }
}
