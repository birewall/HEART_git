package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.MDBPerson;
import Model.MDatabase;
import Model.MSharedData;
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
    	String Data = dateInsertWatchDate.getEditor().getText();
    	String Time = comboInsertWatchTime.getSelectionModel().getSelectedItem();
    	String Country = txtInsertWatchNation.getText();
    	String Location = txtInsertWatchLoc.getText();
    	String Location_Detail = txtInsertWatchDo.getText() + " " + txtInsertWatchSi.getText() + " " + txtInsertWatchDong.getText();
    	String GPS = txtInsertWatchLat.getText() + "," + txtInsertWatchLong.getText();
    	String Alias = txtInsertWatchLocname.getText();
    	String Section = sectionToggle.getSelectedToggle().toString();
    	String Section_Detail = txtInsertWatchSecremark.getText();
    	String Person_Name = comboInsertWatchWho.getSelectionModel().getSelectedItem();
    	String Butterfly_Name = txtInsertWatchBname.getText();
    	String Butterfly_Family = txtInsertWatchFamily.getText();
    	String Butterfly_Scien = txtInsertWatchZoological.getText();
    	String Sex = (String)comboInsertWatchSex.getSelectionModel().getSelectedItem();
    	String Status = comboInsertWatchStatus.getSelectionModel().getSelectedItem();
    	String Quantity = txtInsertWatchQuan.getText();
    	String Note = txtInsertWatchRemark.getText();
    	System.out.println(Data);
    	System.out.println(Time);
    	System.out.println(Country);
    	System.out.println(Location);
    	System.out.println(Location_Detail);
    	System.out.println(GPS);
    	System.out.println(Alias);
    	System.out.println(Section);
    	System.out.println(Section_Detail);
    	System.out.println(Person_Name);
    	System.out.println(Butterfly_Name);
    	System.out.println(Butterfly_Family);
    	System.out.println(Butterfly_Scien);
    	System.out.println(Sex);
    	System.out.println(Status);
    	System.out.println(Quantity);
    	System.out.println(Note);    	
    	
    }

    @FXML
    void bnameInsertWatch(ActionEvent event) {

    }

    @FXML
    void choosewhoInsertWatch(ActionEvent event) {	
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("�����ڸ� �Է��Ͻÿ�");
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
		this.comboInsertWatchTime.getItems().addAll("����", "����", "����", "����");
		this.comboInsertWatchSex.getItems().addAll("��", "��");
		this.comboInsertWatchStatus.getItems().addAll("��", "��", "��");
	}
	
	@Override
	public void init_procedure() {
		// Set Watcher
		String query = "select name from Person where sort = '관찰자'";
		System.out.println(this.shared_model);
		PersonDB = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
		ResultSet rs = PersonDB.selectQuery(query);
		System.out.println("I'm In!");
		try {
			while(rs.next()) {
				this.comboInsertWatchWho.getItems().add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
