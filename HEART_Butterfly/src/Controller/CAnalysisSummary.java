package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import Model.MDBButterflyGuide;
import Model.MDBLocation;
import Model.MDBPerson;
import Model.MDBSpecimen;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CAnalysisSummary extends AbsMetaController {

    @FXML
    private DatePicker PeriodStart;

    @FXML
    private ComboBox<String> comboNation;

    @FXML
    private ComboBox<String> CombFamily;

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
    void OnCheckFamily(ActionEvent event) throws SQLException {
    	if(this.checkFamaily.isSelected()) {
    		
    		MDBButterflyGuide db_butterfly_guide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
            ResultSet rs = db_butterfly_guide.selectQuery("SELECT distinct family FROM ButterflyGuide");
            ResultSetMetaData rsmd = rs.getMetaData();
            
    		
    		try {
    			while(rs.next()) {
    				this.CombFamily.getItems().add(rs.getString(1));   // get name
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		
    		
    		this.CombFamily.setDisable(false);
    		
    	}
    	else {
    		
    		this.CombFamily.setDisable(true);
    	}

    }

    @FXML
    void OnCheckNation(ActionEvent event) throws SQLException {
    	
    	if(this.checkNation.isSelected()) {
    		
    		MDBLocation db_nation = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
            ResultSet rs = db_nation.selectQuery("SELECT distinct country FROM Location");
            ResultSetMetaData rsmd = rs.getMetaData();
            
    		
    		try {
    			while(rs.next()) {
    				this.comboNation.getItems().add(rs.getString(1));   // get name
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		
    		
    		this.comboNation.setDisable(false);
    		
    	}
    	else {
    		
    		this.comboNation.setDisable(true);
    	}

    }

    @FXML
    void OnClear(ActionEvent event) {
    	

    }

    @FXML
    void OnCombFamily(ActionEvent event) {
    	if(this.CheckBPeriod.isSelected()) {
    		this.PeriodStart.setDisable(false);
    		this.PeriodEnd.setDisable(false);
    	}
    	else {    		
    		this.PeriodStart.setDisable(true);
    		this.PeriodEnd.setDisable(true);
    	}

    }

    @FXML
    void OnCombNation(ActionEvent event) {

    }

    @FXML
    void OnExit(ActionEvent event) throws IOException {
    	changeWindow(this.btnExit.getScene().getWindow(), "VMain");
    }

    

    @FXML
    void OnPeriod(ActionEvent event) {
    	if(this.CheckBPeriod.isSelected()) {
    		this.PeriodStart.setDisable(false);
    		this.PeriodEnd.setDisable(false);
    	}
    	else {    		
    		this.PeriodStart.setDisable(true);
    		this.PeriodEnd.setDisable(true);
    	}


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
    	
		this.PeriodStart.setDisable(true);
    	this.PeriodEnd.setDisable(true);
    	this.comboNation.setDisable(true);
    	this.CombFamily.setDisable(true);
		
    }

}
