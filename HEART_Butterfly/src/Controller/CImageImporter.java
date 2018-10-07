package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CImageImporter extends AbsMetaController {

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnImport;

    @FXML
    private Button btnDone;

    @FXML
    private ImageView imvPicture;

    @FXML
    void OnCancel(ActionEvent event) {
        Stage thisStage = (Stage)this.btnCancel.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    void OnDone(ActionEvent event) {
        /* Data Insert */
        Stage thisStage = (Stage)this.btnDone.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    void OnImport(ActionEvent event) {

    }

    @FXML
    void OnRegister(ActionEvent event) {

    }

    public void init_procedure() {

    }
}
