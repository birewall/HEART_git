package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
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
        Alert msgBox = new Alert(Alert.AlertType.ERROR);
        msgBox.setTitle("지역 통계");
        msgBox.setHeaderText(null);
        msgBox.setContentText("미구현");
        msgBox.showAndWait();
    }

    @FXML
    void OnPrevious(ActionEvent event) throws IOException {
        changeWindow(this.btnInquiry.getScene().getWindow(), "VMain");
    }

    @FXML
    void OnSpecimenAnalysis(ActionEvent event) {
        Alert msgBox = new Alert(Alert.AlertType.ERROR);
        msgBox.setTitle("표본 통계");
        msgBox.setHeaderText(null);
        msgBox.setContentText("미구현");
        msgBox.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* Graph Title Initialization */
        this.grpTotalCollection.setTitle("전체 수집 통계");
        this.grpRegionalCollection.setTitle("지역별 수집 통계");
        this.grpFamilyCollection.setTitle("나비과별 수집 통계");
        this.grpNameCollection.setTitle("나비명별 수집 통계");

        /* Set Combobox */
        /*
        * 조회 조건: 국가 연도
        *
        * 조회 내용: 나비 수집 수, 지역별, 나비명별, 나비과별
        * 테이블 명세: 관찰 테이블 (id수집정보, 관찰날짜)
        * 연계테이블 명세: 수집정보 테이블 (id장소, id도감, id사람)
        * 연계테이블 명세: 도감 테이블 (나비명, 나비과)
        * 연계테이블 명세: 장소 테이블 (지역명)
        * */

        /* cmbCountry */

        /* cmbYear */

        /* cmbMeonth */

        /* cmbCollector */

        /* cmbLocation */

        //this.cmbCountry.getItems().add();
        String query = "select count(*) from Observation, CollectionInfo, ButterflyGuide, Location";
    }
}
