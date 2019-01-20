package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CAnalysisMain extends AbsMetaController implements Initializable {

    @FXML
    private ComboBox<String> cmbCountry;

    @FXML
    private ComboBox<String> cmbInquiryYear;

    @FXML
    private CheckBox ckbAccumulation;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnSpecimenAnalysis;

    @FXML
    private Button btnLocationAnalysis;

    @FXML
    private Button btnInquiry;

    @FXML
    private BarChart<String, Number> grpTotalCollection;

    @FXML
    private BarChart<String, Number> grpRegionalCollection;

    @FXML
    private BarChart<String, Number> grpFamilyCollection;

    @FXML
    private BarChart<String, Number> grpNameCollection;

    @FXML
    void OnAccumulation(ActionEvent event) {

    }

    @FXML
    void OnCountry(ActionEvent event) {

    }

    @FXML
    void OnInquiry(ActionEvent event) {

    }

    @FXML
    void OnInquiryYear(ActionEvent event) {

    }

    @FXML
    void OnLocationAnalysis(ActionEvent event) {

    }

    @FXML
    void OnPrevious(ActionEvent event) throws IOException {
        changeWindow(this.btnInquiry.getScene().getWindow(), "VMain");
    }

    @FXML
    void OnSpecimenAnalysis(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* Graph Title Initialization */
        this.grpTotalCollection.setTitle("전체 수집 통계");
        this.grpRegionalCollection.setTitle("지역별 수집 통계");
        this.grpFamilyCollection.setTitle("나비과별 수집 통계");
        this.grpNameCollection.setTitle("나비명별 수집 통계");

        /* Set Combobox */
    }
}
