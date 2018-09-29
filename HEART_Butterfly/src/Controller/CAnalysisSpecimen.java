package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MDBSpecimen;
import Model.MDBSpecimenize;
import Model.MSharedData;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CAnalysisSpecimen extends AbsMetaController {

    @FXML
    private CheckBox CheckBSpecStatus;

    @FXML
    private TableView<ObservableList<String>> tblSpecStatus;

    @FXML
    private ToggleGroup ButterflyStatus;

    @FXML
    private TextField txtBNameSpecStatus;

    @FXML
    private Button btnSpecStatusExport;

    @FXML
    private RadioButton radioGoodBStatus;

    @FXML
    private ToggleGroup PreservativeChange;

    @FXML
    private Button btnSpecStatusCorrect;

    @FXML
    private RadioButton radioFairBStatus;

    @FXML
    private RadioButton radioGoodPreservativeStatus;

    @FXML
    private RadioButton radioPoorBStatus;

    @FXML
    private CheckBox CheckBNameSearch;

    @FXML
    private Button btnSpecStatusExit;

    @FXML
    private Button btnSpecStatusSearch;

    @FXML
    private CheckBox CheckPreservativeStatus;

    @FXML
    private RadioButton radioFairPreservativeStatus;

    @FXML
    private RadioButton radioPoorPreservativeStatus;

    Double array[][];
    
    @FXML
    void exitSpecStatus(ActionEvent event) throws IOException {
    	changeWindow(this.btnSpecStatusExit.getScene().getWindow(), "VMain");
    }

    @FXML
    void correctSpecStatus(ActionEvent event) {

    }

    @FXML
    void checkGoodPreservativeStatus(ActionEvent event) {

    }

    @FXML
    void searchSpecStatus(ActionEvent event) throws SQLException {
        MDBSpecimen db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimenize db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());

        ResultSet rs = db_specimen.selectQuery("SELECT * FROM Specimen, Specimenize");
    	tblSpecStatus.getColumns().clear();
    	tblSpecStatus.getItems().clear();
    	
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int numberOfColumns=rsmd.getColumnCount();
        rs.last();

        int numberOFLines = rs.getRow();
        rs.beforeFirst();
        rs.next();
        System.out.println(numberOfColumns);
    	System.out.println("Row: " + numberOFLines);
    	
    	array = new Double[numberOFLines][numberOfColumns];
		ArrayList<String> columnItem = new ArrayList<String>();

        for(int i=1;i<=numberOfColumns;i++){
        	//System.out.println(rsmd.getColumnName(i));
        	if(rsmd.getColumnName(i).equals("storageRoom") ||
        			rsmd.getColumnName(i).equals("storageCabinet") ||
        				rsmd.getColumnName(i).equals("storageChest") ||
        					rsmd.getColumnName(i).equals("anticepticName") ||
        						rsmd.getColumnName(i).equals("embalmingDate")){
            	System.out.println(rsmd.getColumnName(i));
        		final int finalIdx = i-1;
        		TableColumn<ObservableList<String>, String> column = new TableColumn<>(
        				rsmd.getColumnName(i));
        		column.setCellValueFactory(param ->
        				new ReadOnlyObjectWrapper<>(param.getValue().get(finalIdx)));
        		    tblSpecStatus.getColumns().add(column);
        	}
    	}
        
		for(int LineCount = 0 ; LineCount < numberOFLines ; LineCount ++) {
			for ( int ColCount = 0 ; ColCount < numberOfColumns ; ColCount ++) {
    			array[LineCount][ColCount] = rs.getDouble(ColCount +1);
    			columnItem.add(Double.toString(array[LineCount][ColCount]));
			}
    		tblSpecStatus.getItems().add(FXCollections.observableArrayList(columnItem));
			rs.next();
		}
			System.out.print(columnItem);

    }

    @FXML
    void exportSpecStatusDataAnalysis(ActionEvent event) {

    }

    @FXML
    void SearchPreservativeStatus(ActionEvent event) {
    	if(this.CheckPreservativeStatus.isSelected()) {
    		this.radioGoodPreservativeStatus.setDisable(false);
    		this.radioFairPreservativeStatus.setDisable(false);
    		this.radioPoorPreservativeStatus.setDisable(false);
    	}
    	else {
    		this.radioGoodPreservativeStatus.setSelected(false);
    		this.radioFairPreservativeStatus.setSelected(false);
    		this.radioPoorPreservativeStatus.setSelected(false);
        	this.radioGoodPreservativeStatus.setDisable(true);
        	this.radioFairPreservativeStatus.setDisable(true);
        	this.radioPoorPreservativeStatus.setDisable(true);
    	}
    }

    @FXML
    void checkFairPreservativeStatus(ActionEvent event) {

    }

    @FXML
    void checkPoorPreservativeStatus(ActionEvent event) {

    }

    @FXML
    void checkPoorButterflyStatus(ActionEvent event) {

    }

    @FXML
    void checkFairButterflyStatus(ActionEvent event) {

    }

    @FXML
    void SearchButterflyStatus(ActionEvent event) {
    	if(this.CheckBSpecStatus.isSelected()) {
    		this.radioGoodBStatus.setDisable(false);
    		this.radioFairBStatus.setDisable(false);
    		this.radioPoorBStatus.setDisable(false);
    	}
    	else {
    		this.radioGoodBStatus.setSelected(false);
    		this.radioFairBStatus.setSelected(false);
    		this.radioPoorBStatus.setSelected(false);
    		this.radioGoodBStatus.setDisable(true);
    		this.radioFairBStatus.setDisable(true);
    		this.radioPoorBStatus.setDisable(true);
    	}
    }

    @FXML
    void checkGoodButterflyStatus(ActionEvent event) {
    	if(this.CheckBNameSearch.isSelected()) {
    		this.txtBNameSpecStatus.setDisable(false);
    	}
    	else {
    	//	this.txtBNameSpecStatus;
    	}
    }

    @FXML
    void SearchButterflyName(ActionEvent event) {
    	if(this.CheckBNameSearch.isSelected()) {
    		this.txtBNameSpecStatus.setDisable(false);
    	} else {
    		this.txtBNameSpecStatus.setDisable(true);
    	}
    }
    
    public void init_procedure() {
		this.txtBNameSpecStatus.setDisable(true);
    	this.radioGoodPreservativeStatus.setDisable(true);
    	this.radioFairPreservativeStatus.setDisable(true);
    	this.radioPoorPreservativeStatus.setDisable(true);
		this.radioGoodBStatus.setDisable(true);
		this.radioFairBStatus.setDisable(true);
		this.radioPoorBStatus.setDisable(true);
    }
}
