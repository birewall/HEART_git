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
    	String location_detail = txtInsertWatchDo.getText() + "/" + txtInsertWatchSi.getText() + "/" + txtInsertWatchDong.getText();

    	String gps_x = "0";
        String gps_y = "0";
        if(txtInsertWatchLat.getText().length() > 0) gps_x = txtInsertWatchLat.getText();
        if(txtInsertWatchLat.getText().length() > 0) gps_y = txtInsertWatchLong.getText();
        String gps =  gps_x + "," + gps_y;

        String alias = txtInsertWatchLocname.getText();
    	String section = "";
    	if(sectionToggle.getSelectedToggle() != null) section = sectionToggle.getSelectedToggle().toString();
    	String section_detail = txtInsertWatchSecremark.getText();
    	String person_name = comboInsertWatchWho.getSelectionModel().getSelectedItem(); // 조윤호 교수님은 반드시 DB에 있어야 함
    	String butterfly_name = txtInsertWatchBname.getText();
    	String butterfly_family = txtInsertWatchFamily.getText();
    	String scientific_name = txtInsertWatchZoological.getText();
    	String sex = comboInsertWatchSex.getSelectionModel().getSelectedItem();
    	String status = comboInsertWatchStatus.getSelectionModel().getSelectedItem();
    	String quantity = txtInsertWatchQuan.getText();
    	String note = txtInsertWatchRemark.getText();

    	/* Debug */
        System.out.println(date);
        System.out.println(time);
        System.out.println(country);
        System.out.println(location);
        System.out.println(location_detail);
        System.out.println(gps);
        System.out.println(alias);
        System.out.println(section);
        System.out.println(section_detail);
        System.out.println(person_name);
        System.out.println(butterfly_name);
        System.out.println(butterfly_family);
        System.out.println(scientific_name);
        System.out.println(sex);
        System.out.println(status);
        System.out.println(quantity);
        System.out.println(note);

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
        // db_location.printContents();
        int id_location = db_location.getIdLocation();
        if(id_location == 0) {
            if(!db_location.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] Location Insert Failed.");
                return;
            }
            id_location = db_location.getIdLocationFromDB();
        }

        db_person.setName("조윤호");
        db_person.setSort("관찰자");
        int id_person = db_person.getIdPersonFromDB();
        if(id_person == 0) {
            db_person.insert();
            if(!db_person.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] Person Insert Failed.");
                return;
            }
            id_person = db_person.getIdPersonFromDB();
        }

        db_butterfly_guide.setName(butterfly_name);
        db_butterfly_guide.setFamily(butterfly_family);
        db_butterfly_guide.setScientific_name(scientific_name);
        int id_butterflyGuide = db_butterfly_guide.getIdButterflyGuideFromDB();
        if(id_butterflyGuide == 0) {
            db_butterfly_guide.insert();
            if(!db_butterfly_guide.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] ButterflyGuide Insert Failed.");
                return;
            }
            id_butterflyGuide = db_butterfly_guide.getIdButterflyGuideFromDB();
        }

        db_collection_info.setIdLocation(id_location);
        db_collection_info.setIdButterflyGuide(id_butterflyGuide);
        db_collection_info.setIdPerson(id_person);
        db_collection_info.setDate(date);
        // db_collection_info.setMethod(method);
        // db_collection_info.printContents();
        int id_collection_info = db_collection_info.getIdCollectionInfo();
        if(id_collection_info == 0) {
            db_collection_info.insert();
            if(!db_collection_info.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] CollectionInfo Insert Failed.");
                return;
            }
            id_collection_info = db_collection_info.getIdCollectionInfo();
        }

        db_observation.setDate(date);
        db_observation.setIdCollectionInfo(id_collection_info);
        db_observation.setNumber(Integer.parseInt(quantity));
        db_observation.setSex((sex.equals("남"))?'m':'f');
        db_observation.setStatus(status);
        db_observation.setTime(time);
        int id_observation = db_observation.getIdCollectionInfo();
        if(id_observation == 0) {
            db_observation.insert();
            if (!db_observation.insert()) {
                ((MSharedData) this.shared_model).getLogger().error("[CInsertWatch] Observation Insert Failed.");
                return;
            }
            id_observation = db_observation.getIdCollectionInfo();
        }
    }

    @FXML
    void bnameInsertWatch(ActionEvent event) {

    }

    @FXML
    void choosewhoInsertWatch(ActionEvent event) {	
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Insert New Name");
		dialog.setHeaderText(null);
		dialog.setContentText(null);
		dialog.showAndWait();
		String new_name = dialog.getEditor().getText();

		PersonDB.setName(new_name);
		PersonDB.setSort("관찰자");
		if(!PersonDB.insert()){
		    System.out.println("Failed.");
		    return;
        }
		
		this.comboInsertWatchWho.getItems().add(new_name);
    }

    @FXML
    void clearInsertWatch(ActionEvent event) {
        MDBPerson person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        person.delete_by_type("관찰자");
        this.comboInsertWatchWho.getItems().clear();

        person.setName("조윤호");
        person.setSort("관찰자");
        if(!person.insert()){
            System.out.println("Failed.");
            return;
        }
        this.comboInsertWatchWho.getItems().add("조윤호");
        this.comboInsertWatchWho.getSelectionModel().select(0);
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
		this.comboInsertWatchTime.getItems().addAll("새벽", "오전", "오후", "저녁");
		this.comboInsertWatchSex.getItems().addAll("암", "수");
		this.comboInsertWatchStatus.getItems().addAll("상", "중", "하");

		this.comboInsertWatchWho.getSelectionModel().select(0); // 조윤호 교수님은 무조건 DB에 있어야함
        this.comboInsertWatchSex.getSelectionModel().select(0);
        this.comboInsertWatchStatus.getSelectionModel().select(0);
        this.comboInsertWatchTime.getSelectionModel().select(0);
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
