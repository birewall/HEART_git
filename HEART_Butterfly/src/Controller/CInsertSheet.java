package Controller;

import Model.MDBPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;

public class CInsertSheet extends AbsInsertController {
	MDBPerson PersonDB;

    @FXML
    private Button btnPreviousImg;

    @FXML
    private TableColumn<?, ?> tclCollectVillage;

    @FXML
    private TableColumn<?, ?> tclSpecimenizeYear;

    @FXML
    private TableColumn<?, ?> tclSpecimenCabinet;

    @FXML
    private Button btnInsert;

    @FXML
    private TableColumn<?, ?> tclSpecimenSex;

    @FXML
    private Label lblButterflyFamily;

    @FXML
    private TableColumn<?, ?> tclCollectCountry;

    @FXML
    private TableColumn<?, ?> tclCollectDate1;

    @FXML
    private TableColumn<?, ?> tclCollector;

    @FXML
    private TableColumn<?, ?> tclSpecimenCondition;

    @FXML
    private Button btnExportLableCSV;

    @FXML
    private TableColumn<?, ?> tclCollectMethod;

    @FXML
    private TableColumn<?, ?> tclCollectYear;

    @FXML
    private TableColumn<?, ?> tclCollectState;

    @FXML
    private Label lblButterflyName;

    @FXML
    private TableColumn<?, ?> tclCollectPlace;

    @FXML
    private Button btnNextImg;

    @FXML
    private TableColumn<?, ?> tclSpecimenID;

    @FXML
    private TableColumn<?, ?> tclButterflyZoological;

    @FXML
    private Label lblButterflyZoological;

    @FXML
    private TableColumn<?, ?> tclSpecimenizeMonth;

    @FXML
    private TableColumn<?, ?> tclCollectCity;

    @FXML
    private TableColumn<?, ?> tclCollectDate;

    @FXML
    private TableColumn<?, ?> tclSpecimenBox;

    @FXML
    private Button btnCancel;

    @FXML
    private TableColumn<?, ?> tclSpecimenOffice;

    @FXML
    private ImageView butterflyImg;

    @FXML
    private TableColumn<?, ?> tclButterflyFamily;

    @FXML
    private TableColumn<?, ?> tclSpecimenizeDate;

    @FXML
    private TableColumn<?, ?> tclButterflyName;

    @FXML
    private TableColumn<?, ?> tclSpecimenPerson;

    @FXML
    void onExportLableCSV(ActionEvent event) {

    }

    @FXML
    void onInsert(ActionEvent event) {

    }

    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void OnPreviousImg(ActionEvent event) {

    }

    @FXML
    void OnNextImg(ActionEvent event) {

    }

}
