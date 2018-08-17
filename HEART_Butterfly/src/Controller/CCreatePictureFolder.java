package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CCreatePictureFolder extends AbsMetaController {

    @FXML
    private ComboBox<?> comboInsertPictureTime;

    @FXML
    private TextField txtInsertPictureNation;

    @FXML
    private Button btnInsertPictureSearchLoc;

    @FXML
    private TextField txtInsertPictureLoc;

    @FXML
    private TextField txtInsertPictureFamily;

    @FXML
    private TextField txtInsertPictureBname;

    @FXML
    private ComboBox<?> comboInsertPictureSex;

    @FXML
    private ComboBox<?> comboInsertPictureStatus;

    @FXML
    private ComboBox<?> comboInsertPictureSize;

    @FXML
    private ComboBox<?> comboInsertPictureWing;

    @FXML
    private ComboBox<?> comboInsertPictureBground;

    @FXML
    private ComboBox<?> comboInsertPictureBloc;

    @FXML
    private ComboBox<?> comboInsertPictureSloc;

    @FXML
    private ComboBox<?> comboInsertPictureFtype;

    @FXML
    private ComboBox<?> comboInsertPictureIscorrected;

    @FXML
    private ComboBox<?> comboInsertPictureLtype;

    @FXML
    private TextField txtInsertPictureLoc1;

    @FXML
    private TextField txtInsertPictureLoc11;

    @FXML
    private Button btnExit;
    
    @FXML
    void BlocInsertPicture(ActionEvent event) {

    }

    @FXML
    void NationInsertPicture(ActionEvent event) {

    }

    @FXML
    void bgroundInsertPicture(ActionEvent event) {

    }

    @FXML
    void bnameInsertPicture(ActionEvent event) {

    }

    @FXML
    void familyInsertPicture(ActionEvent event) {

    }

    @FXML
    void ftypeInsertPicture(ActionEvent event) {

    }

    @FXML
    void iscorrectedInsertPicture(ActionEvent event) {

    }

    @FXML
    void OnExit(ActionEvent event) throws IOException {
    	changeWindow(this.btnExit.getScene().getWindow(), "VMain");
    }
    
    @FXML
    void locInsertPicture(ActionEvent event) {

    }

    @FXML
    void ltypeInsertPicture(ActionEvent event) {

    }

    @FXML
    void searchLocInsertPicture(ActionEvent event) {

    }

    @FXML
    void sexInsertPicture(ActionEvent event) {

    }

    @FXML
    void sizeInsertPicture(ActionEvent event) {

    }

    @FXML
    void slocInsertPicture(ActionEvent event) {

    }

    @FXML
    void statusInsertPicture(ActionEvent event) {

    }

    @FXML
    void timeInsertPicture(ActionEvent event) {

    }

    @FXML
    void wingInsertPicture(ActionEvent event) {

    }

}
