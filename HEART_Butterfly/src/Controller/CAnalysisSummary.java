package Controller;

import Model.MDBLocation;
import Model.MDBPerson;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CAnalysisSummary extends AbsMetaController {

    @FXML
    private DatePicker PeriodStart;

    @FXML
    private ComboBox<?> comboNation;

    @FXML
    private ComboBox<?> CombFamily;

    @FXML
    private BarChart<?, ?> BarChartSumary;

    @FXML
    private TextField txtAll;

    @FXML
    private TextField txtWatch;

    @FXML
    private TextField txtPicture;

    @FXML
    private TextField txtSpecimen;

    @FXML
    private Button btnExportResult;

    @FXML
    private Button btnExit;

    @FXML
    private CheckBox CheckBPeriod;

    @FXML
    private CheckBox checkNation;

    @FXML
    private DatePicker PeriodEnd;

    @FXML
    private CheckBox checkFamaily;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSearch;

    @FXML
    void OnCheckFamily(ActionEvent event) {

    }

    @FXML
    void OnCheckNation(ActionEvent event) {

    }

    @FXML
    void OnClear(ActionEvent event) {

    }

    @FXML
    void OnCombFamily(ActionEvent event) {

    }

    @FXML
    void OnCombNation(ActionEvent event) {

    }

    @FXML
    void OnExit(ActionEvent event) {

    }

    @FXML
    void OnPeriod(ActionEvent event) {

    }

    @FXML
    void OnSearch(ActionEvent event) {

    }

    @FXML
    void calenderPeriodEnd(ActionEvent event) {

    }

    @FXML
    void calenderPeriodStart(ActionEvent event) {

    }

    @FXML
    void exportSummaryAnalysis(ActionEvent event) {

    }

    public void init_procedure() {
        // Set Watcher
        String query = "select distinct country from Location";
        MDBLocation LocationDB = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
        ResultSet rs = LocationDB.selectQuery(query);
        try {
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}