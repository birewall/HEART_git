package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;

public class CInsertWatch extends AbsMetaController implements Initializable {
	
	MDBPerson PersonDB;
	
    @FXML
    private DatePicker dateInsertWatchDate;

    @FXML
    private ComboBox<String> comboInsertWatchTime;

    @FXML
    private TextField txtInsertWatchLoc;

    @FXML
    private Button btnInsertWatchSearchLoc;

    @FXML
    private TextField txtInsertWatchDo;

    @FXML
    private TextField txtInsertWatchSi;

    @FXML
    private TextField txtInsertWatchDong;

    @FXML
    private ComboBox<String> comboInsertWatchWho;

    @FXML
    private Button btnInsertWatchChoosewho;

    @FXML
    private Button btnInsertWatchClear;

    @FXML
    private TextField txtInsertWatchBname;

    @FXML
    private TextField txtInsertWatchFamily;

    @FXML
    private TextField txtInsertWatchZoological;

    @FXML
    private ComboBox<String> comboInsertWatchStatus;

    @FXML
    private ComboBox<String> comboInsertWatchSex;

    @FXML
    private Button btnInsertWatchAdd;

    @FXML
    private Button btnInsertWatchExit;

    @FXML
    private TextField txtInsertWatchNation;

    @FXML
    private TextField txtInsertWatchRemark;

    @FXML
    private TextField txtInsertWatchLat;

    @FXML
    private TextField txtInsertWatchLong;

    @FXML
    private TextField txtInsertWatchLocname;

    @FXML
    private RadioButton radioInsertWatchsec1;

    @FXML
    private ToggleGroup sectionToggle;

    @FXML
    private RadioButton radioInsertWatchsec2;

    @FXML
    private RadioButton radioInsertWatchsec3;

    @FXML
    private RadioButton radioInsertWatchsec4;

    @FXML
    private RadioButton radioInsertWatchsec5;

    @FXML
    private RadioButton radioInsertWatchsec10;

    @FXML
    private RadioButton radioInsertWatchsec9;

    @FXML
    private RadioButton radioInsertWatchsec8;

    @FXML
    private RadioButton radioInsertWatchsec7;

    @FXML
    private RadioButton radioInsertWatchsec6;

    @FXML
    private TextField txtInsertWatchSecremark;

    @FXML
    private TextField txtInsertWatchQuan;

    @FXML
    private Button btnInsertWatchCorrect;

    @FXML
    void NationInsertWatch(ActionEvent event) {
    	
    }

    @FXML
    void addInsertWatch(ActionEvent event) {
        /* Data Acquisition */
    	String date = dateInsertWatchDate.getEditor().getText();
    	String time = comboInsertWatchTime.getSelectionModel().getSelectedItem();
    	String country = txtInsertWatchNation.getText();
    	String location = txtInsertWatchLoc.getText();
    	String location_detail = txtInsertWatchDo.getText() + " " + txtInsertWatchSi.getText() + " " + txtInsertWatchDong.getText();
    	String gps = txtInsertWatchLat.getText() + "," + txtInsertWatchLong.getText();
    	String alias = txtInsertWatchLocname.getText();
    	String section = sectionToggle.getSelectedToggle().toString();
    	String section_detail = txtInsertWatchSecremark.getText();
    	String person_name = comboInsertWatchWho.getSelectionModel().getSelectedItem();
    	String butterfly_name = txtInsertWatchBname.getText();
    	String butterfly_family = txtInsertWatchFamily.getText();
    	String scientific_name = txtInsertWatchZoological.getText();
    	String sex = (String)comboInsertWatchSex.getSelectionModel().getSelectedItem();
    	String status = comboInsertWatchStatus.getSelectionModel().getSelectedItem();
    	String quantity = txtInsertWatchQuan.getText();
    	String note = txtInsertWatchRemark.getText();

    	/* DB Instance initialization */
        MDBButterflyGuide db_butterfly_guide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
        MDBPerson db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        MDBCollectionInfo db_collection_info = new MDBCollectionInfo(((MSharedData)this.shared_model).getDB().getConnection());
        MDBLocation db_location = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
        MDBObservation db_observation = new MDBObservation(((MSharedData)this.shared_model).getDB().getConnection());

        /* Value Mapping */
        db_location.setCountry(country);
        db_location.setLocation(location);
        db_location.setLocationDetail(location_detail);
        db_location.setGps(gps);
        db_location.setAlias(alias);
        db_location.setSection(section);
        db_location.setSectionDetail(section_detail);
        if(!db_location.insert()){
            ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] Location Insert Failed.");
            return;
        }


        /* Query */

    }

    @FXML
    void bnameInsertWatch(ActionEvent event) {

    }

    @FXML
    void choosewhoInsertWatch(ActionEvent event) {	
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("관찰자를 등록하세요");
		dialog.setHeaderText(null);
		dialog.setContentText(null);
		dialog.showAndWait();
		String new_name = dialog.getEditor().getText();

		PersonDB.setName(new_name);
		PersonDB.setSort("관찰자");
		if(!PersonDB.insert()) System.out.println("Failed.");
		
		this.comboInsertWatchWho.getItems().add(new_name);
    }

    @FXML
    void clearInsertWatch(ActionEvent event) {
        MDBPerson person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        person.delete_by_type("관찰자");
        this.comboInsertWatchWho.getItems().clear();
    }

    @FXML
    void correctInsertWatch(ActionEvent event) {

    }

    @FXML
    void dateInsertWatch(ActionEvent event) {

    }

    @FXML
    void doInsertWatch(ActionEvent event) {

    }

    @FXML
    void dongInsertWatch(ActionEvent event) {

    }

    @FXML
    void exitInsertWatch(ActionEvent event) throws IOException {
        changeWindow(this.btnInsertWatchExit.getScene().getWindow(), "VInsert");
    }

    @FXML
    void familyInsertWatch(ActionEvent event) {

    }

    @FXML
    void latInsertWatch(ActionEvent event) {
    	
    }

    @FXML
    void locInsertWatch(ActionEvent event) {
    	
    }

    @FXML
    void locnameInsertWatch(ActionEvent event) {
    	
    }

    @FXML
    void longInsertWatch(ActionEvent event) {
    	
    }

    @FXML
    void quanInsertWatch(ActionEvent event) {

    }

    @FXML
    void remarkInsertWatch(ActionEvent event) {

    }

    @FXML
    void searchLocInsertWatch(ActionEvent event) {

    }

    @FXML
    void sec10InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec1InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec2InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec3InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec4InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec5InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec6InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec7InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec8InsertWatch(ActionEvent event) {

    }

    @FXML
    void sec9InsertWatch(ActionEvent event) {

    }

    @FXML
    void secremarkInsertWatch(ActionEvent event) {

    }

    @FXML
    void sexInsertWatch(ActionEvent event) {

    }

    @FXML
    void siInsertWatch(ActionEvent event) {

    }

    @FXML
    void statusInsertWatch(ActionEvent event) {

    }

    @FXML
    void timeInsertWatch(ActionEvent event) {

    }

    @FXML
    void whoInsertWatch(ActionEvent event) {

    }

    @FXML
    void zoologicalInsertWatch(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.comboInsertWatchTime.getItems().addAll("오전", "오후", "저녁", "새벽");
		this.comboInsertWatchSex.getItems().addAll("암컷", "수컷");
		this.comboInsertWatchStatus.getItems().addAll("상", "중", "하");
	}
	
	@Override
	public void init_procedure() {
		// Set Watcher
		String query = "select name from Person where sort = '관찰자'";
		System.out.println(this.shared_model);
		PersonDB = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
		ResultSet rs = PersonDB.selectQuery(query);
		try {
			while(rs.next()) {
				this.comboInsertWatchWho.getItems().add(rs.getString(1));   // get name
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
