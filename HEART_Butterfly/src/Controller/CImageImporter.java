package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CImageImporter extends AbsMetaController {

    File selectedFile = null;
    String filepath = null;

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
        this.parent_controller.view_update();
        thisStage.close();
    }

    @FXML
    void OnImport(ActionEvent event) {

    }

    @FXML
    void OnRegister(ActionEvent event) {

    }

    @Override
    public void init_procedure() {

    }
}
