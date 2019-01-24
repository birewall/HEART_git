package Controller;

import Model.MDBLocation;
import Model.MDatabase;
import Model.MSharedData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CAnalysisMain extends AbsMetaController implements Initializable {
    MDatabase db = null;

    @FXML
    private ComboBox<String> cmbCountry;

    @FXML
    private ComboBox<String> cmbInquiryYear;

    @FXML
    private ComboBox<String> cmbInquiryMonth;

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
    private CategoryAxis grpTotalXAxis;

    @FXML
    private NumberAxis grpTotalYAxis;

    @FXML
    private CategoryAxis grpRegionalXAxis;

    @FXML
    private NumberAxis grpRegionalYAxis;

    @FXML
    private CategoryAxis grpFamilyXAxis;

    @FXML
    private NumberAxis grpFamilyYAxis;

    @FXML
    private CategoryAxis grpNameXAxis;

    @FXML
    private NumberAxis grpNameYAxis;

    @FXML
    void OnInquiry(ActionEvent event) throws SQLException {
        /*
         * 조회 조건: 국가 연도
         *
         * 조회 내용: 나비 수집 수, 지역별, 나비명별, 나비과별
         * 테이블 명세: 관찰 테이블 (id수집정보, 관찰날짜)
         * 연계테이블 명세: 수집정보 테이블 (id장소, id도감, id사람)
         * 연계테이블 명세: 도감 테이블 (나비명, 나비과)
         * 연계테이블 명세: 장소 테이블 (지역명)
         * */
        drawTotalChart();
        drawRegionalChart();
        drawFamilyGhart();
        drawNameChart();
    }

    @FXML
    void OnAccumulation(ActionEvent event) {

    }

    @FXML
    void OnCountry(ActionEvent event) {

    }

    @FXML
    void OnInquiryYear(ActionEvent event) {

    }

    @FXML
    void OnInquiryMonth(ActionEvent event) {

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
    }

    @Override
    public void init_procedure() {
        this.db = ((MSharedData)this.shared_model).getDB();
        fillComboBox();

        /* Initialize View Selection */
        this.cmbCountry.getSelectionModel().select("대한민국");
        this.cmbInquiryYear.getSelectionModel().select("전체");
        this.cmbInquiryMonth.getSelectionModel().select("전체");
    }

    void fillComboBox() {
        ResultSet result_query = null;

        /* cmbCountry */
        this.cmbCountry.getItems().clear();
        result_query = db.selectQuery("select distinct country from Location");
        try {
            while (result_query.next()) {
                this.cmbCountry.getItems().add(result_query.getString(1));
            }
        }catch(Exception exp){
            System.out.println("Location is empty");
        }

        /* cmbYear */
        this.cmbInquiryYear.getItems().clear();
        result_query = db.selectQuery("select distinct left(date, 4) from Observation");
        try {
            while (result_query.next()) {
                this.cmbInquiryYear.getItems().add(result_query.getString(1));
            }
        }catch(Exception exp){
            System.out.println("Year is empty");
        }

        /* cmbMonth */
        this.cmbInquiryMonth.getItems().clear();
        this.cmbInquiryMonth.getItems().addAll("전체");

        String query = "select count(*) from Observation, CollectionInfo, ButterflyGuide, Location";
    }

    private void drawTotalChart() throws SQLException {
        boolean where_not_used = true;

        /* Initialized Chart */
        this.grpTotalCollection.getData().clear();
        XYChart.Series<String, Number> chart_series = new XYChart.Series<>();

        for(int i = 1 ; i < 13 ; i++) { // 12 months
            String query = "select count(*) from CollectionInfo " +
                    "inner join Location on CollectionInfo.idLocation = Location.idLocation ";
            where_not_used = true;

            if (!this.cmbCountry.getSelectionModel().getSelectedItem().equals("전체")) {
                if (where_not_used) {
                    query += " where";
                    where_not_used = false;
                } else {
                    query += " and";
                }
                query += " country = '" + this.cmbCountry.getSelectionModel().getSelectedItem() + "'";
            }

            if (!this.cmbInquiryYear.getSelectionModel().getSelectedItem().equals("전체")) {
                if (where_not_used) {
                    query += " where";
                    where_not_used = false;
                } else {
                    query += " and";
                }
                query += " left(date, 4) = " + this.cmbInquiryYear.getSelectionModel().getSelectedItem();
            }

//            if (!this.cmbInquiryMonth.getSelectionModel().getSelectedItem().equals("전체")) {
//                if (where_not_used) {
//                    query += " where";
//                    where_not_used = false;
//                } else {
//                    query += " and";
//                }
//                query += " substr(date, 5, 2) = " + this.cmbInquiryMonth.getSelectionModel().getSelectedItem();
//            }
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " substr(date, 5, 2) = '";
            if(i < 10) query += "0";
            query += i + "'";

            /* Make Charts */
            ResultSet result_query = this.db.selectQuery(query);
            int cnt = 0;
            if(result_query.next()) {
                cnt = Integer.parseInt(result_query.getString(1));
            }
            //chart_series.getData().add(new XYChart.Data<>(i + "월", cnt));
            chart_series.getData().add(new XYChart.Data<>(String.valueOf(i), cnt));
        }
        this.grpTotalCollection.getData().add(chart_series);

    }

    private void drawRegionalChart() {

    }

    private void drawFamilyGhart() {

    }

    private void drawNameChart() {

    }
}
