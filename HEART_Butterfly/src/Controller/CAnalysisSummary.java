package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Optional;

import Model.MDBButterflyGuide;
import Model.MDBImage;
import Model.MDBLocation;
import Model.MDBPerson;
import Model.MDBSpecimen;
import Model.MDBSpecimenize;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    String Nation;
    String Family;
    String Period_Start;
    String Period_End;

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
    	checkNation.setSelected(false);
    	checkFamaily.setSelected(false);
    	CheckBPeriod.setSelected(false);
    	this.PeriodStart.setDisable(true);
    	this.PeriodEnd.setDisable(true);
    	this.comboNation.setDisable(true);
    	this.CombFamily.setDisable(true);
    	
    	
    
    }

    @FXML
    void OnCombFamily(ActionEvent event) {
    	Family = CombFamily.getSelectionModel().getSelectedItem();

    }

    @FXML
    void OnCombNation(ActionEvent event) {
    	Nation = comboNation.getSelectionModel().getSelectedItem();


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
    	Alert confirm_popup = new Alert(AlertType.CONFIRMATION);
		confirm_popup.setTitle("검색조건을 확인하세요");
		confirm_popup.setHeaderText(null);
		confirm_popup.setContentText(Period_Start + " ~ " + Period_End + ", " + Nation + ", " + Family);
		
		Optional<ButtonType> result = confirm_popup.showAndWait();
		
		if(result.get() == ButtonType.CANCEL) {
			return;
		}
		
		MDBImage db_image = new MDBImage(((MSharedData)this.shared_model).getDB().getConnection());
		
        ResultSet rs = db_image.selectQuery("SELECT idImage FROM Butterfly.Image where date = '2018-10-10'");

    	
    	

    }

    @FXML
    void calenderPeriodEnd(ActionEvent event) {
    	Period_End = PeriodEnd.getEditor().getText().replaceAll(". ","-");


    }

    @FXML
    void calenderPeriodStart(ActionEvent event) {
    	Period_Start = PeriodStart.getEditor().getText().replaceAll(". ","-");



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
