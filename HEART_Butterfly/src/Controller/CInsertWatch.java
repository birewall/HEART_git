package Controller;

import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.stage.WindowEvent;

import javax.swing.*;

public class CInsertWatch extends AbsInsertController implements Initializable {
	
	MDBPerson PersonDB;
		
	 	@FXML
	    private TextField txtInsertWatchDo;

	    @FXML
	    private Label lblSection_watch;

	    @FXML
	    private Button btnInsertWatchExit;

	    @FXML
	    private TextField txtInsertWatchBname;

	    @FXML
	    private TextField txtInsertWatchRemark;

	    @FXML
	    private ComboBox<String> comboInsertWatchSex;

	    @FXML
	    private TextField txtInsertWatchNation;

	    @FXML
	    private TextField txtInsertWatchSi;

	    @FXML
	    private TextField txtInsertWatchQuan;

	    @FXML
	    private TextField txtInsertWatchLong;

	    @FXML
	    private ComboBox<String> comboInsertWatchTime;

	    @FXML
	    private Button btnInsertWatchPersonManagement;

	    @FXML
	    private TextField txtInsertWatchDong;

	    @FXML
	    private Label lblMaxSection_watch;

	    @FXML
	    private TextField txtInsertWatchLat;

	    @FXML
	    private Button btnInsertWatchCorrect;

	    @FXML
	    private ComboBox<String> comboInsertWatchWho;

	    @FXML
	    private Button btnInsertSection_watch;

	    @FXML
	    private ComboBox<String> comboInsertWatchStatus;

	    @FXML
	    private Button btnInsertWatchSearchLoc;

	    @FXML
	    private Button btnInsertWatchAdd;

	    @FXML
	    private DatePicker dateInsertWatchDate;

	    @FXML
	    private TextField txtInsertWatchZoological;

	    @FXML
	    private TextField txtInsertWatchFamily;

	    @FXML
	    private TextField txtInsertWatchLoc;

	    @FXML
	    private TextField txtInsertWatchLocname;

	    @FXML
	    private Button btnInsertWatchImportCollectionInfo;

    public String getTextLblSection() {
		return lblSection_watch.getText();
	}

	public void setTextLblSection(String Label) {
		this.lblSection_watch.setText(Label);
	}

	public String getTextLblMaxSection() {
		return lblMaxSection_watch.getText();
	}

	public void setTextLblMaxSection(String max_label) {
		this.lblMaxSection_watch.setText(max_label);
	}

	
    
    @FXML
    void searchLocInsertSection_watch(ActionEvent event) throws IOException {
    	spawnChildWindow(this.btnInsertSection_watch.getScene().getWindow(), "VSectionManagement");
    	
    }
    
    @FXML
    void NationInsertWatch(ActionEvent event) {
    	
    }

    @FXML
    void addInsertWatch(ActionEvent event) {
    	
    	/* Data Acquisition */
    	String date = MDateConvertor.convert2DBFormat(dateInsertWatchDate.getEditor().getText());
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
    	String section = lblSection_watch.getText() + " / " + lblMaxSection_watch.getText();
    	
    	
    	//String section_detail = txtInsertWatchSecremark.getText();
    	String person_name = comboInsertWatchWho.getSelectionModel().getSelectedItem(); // 조윤호 교수님은 반드시 DB에 있어야 함
    	String butterfly_name = txtInsertWatchBname.getText();
    	String butterfly_family = txtInsertWatchFamily.getText();
    	String scientific_name = txtInsertWatchZoological.getText();
    	String sex = comboInsertWatchSex.getSelectionModel().getSelectedItem();
    	String status = comboInsertWatchStatus.getSelectionModel().getSelectedItem();
    	String quantity = txtInsertWatchQuan.getText();
    	if(quantity.length() == 0) quantity = "0";
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
        //db_location.setSectionDetail(section_detail);*/
        db_location.printContents();
        int id_location = db_location.getIdLocationFromDB();
        if(id_location == 0) {
            if(!db_location.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] Location Insert Failed.");
                return;
            }
            id_location = db_location.getIdLocationFromDB();
        }

        db_person.setName("조윤호");
        int id_person = db_person.getIdPersonFromDB();
        if(id_person == 0) {
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
        db_collection_info.setMethod("watch");  // 출집해서 직접 채집
        // db_collection_info.setMethod(method);
        // db_collection_info.printContents();

        int id_collection_info = db_collection_info.getIdCollectionInfoFromDB();
        if(id_collection_info == 0) {
            if(!db_collection_info.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] CollectionInfo Insert Failed.");
                return;
            }
            id_collection_info = db_collection_info.getIdCollectionInfoFromDB();
        }

        db_observation.setDate(date);
        db_observation.setIdCollectionInfo(id_collection_info);
        db_observation.setNumber(Integer.parseInt(quantity));
        db_observation.setSex((sex.equals("남"))?"m":"f");
        db_observation.setStatus(status);
        db_observation.setTime(time);
        int id_observation = db_observation.getIdObservationFromDB();
        if(id_observation == 0) {
            if (!db_observation.insert()) {
                ((MSharedData) this.shared_model).getLogger().error("[CInsertWatch] Observation Insert Failed.");
                return;
            }
            id_observation = db_observation.getIdObservationFromDB();
        }
    }

    @FXML
    void bnameInsertWatch(ActionEvent event) {

    }

    @FXML
    void OnImportCollectionInfo(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertWatchExit.getScene().getWindow(), "VCollectionInfoSelector");
    }

    @FXML
    void OnPersonManagement(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertWatchExit.getScene().getWindow(), "VPersonManager");
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
    void searchLocInsertWatch(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertSection_watch.getScene().getWindow(), "VAddressBook");
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

    public void update_collection_info() {
        /* Model name is collectionInfo_table */
        MPassingData passed_data = (MPassingData) ((MSharedData)this.shared_model).get("collectionInfo_table");

        /* View Updating */
        String date = passed_data.getData(0);
        dateInsertWatchDate.getEditor().setText(date.substring(0,4) + ". " + Integer.parseInt(date.substring(4,6)) + ". " + Integer.parseInt(date.substring(6,8)));
        txtInsertWatchNation.setText(passed_data.getData(1));
        txtInsertWatchLocname.setText(passed_data.getData(2));
        txtInsertWatchBname.setText(passed_data.getData(3));
        txtInsertWatchFamily.setText(passed_data.getData(4));
        // 5 for method
        comboInsertWatchWho.getSelectionModel().select(passed_data.getData(6));

        /* Remove date from shared model */
        ((MSharedData)this.shared_model).remove("collectInfo_table");
    }

    public void update_person() {
        /* Clear All Names from List */
        this.comboInsertWatchWho.getItems().clear();

        /* DB Querying */
        String query = "select name from Person";
        PersonDB = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        ResultSet rs = PersonDB.selectQuery(query);
        try {
            while(rs.next()) {
                /* View Updating */
                this.comboInsertWatchWho.getItems().add(rs.getString(1));   // get name
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Initializing */
        this.comboInsertWatchWho.getSelectionModel().select("조윤호"); // DB에 '조윤호'는 반드시 존재한다.
    }

    @Override
    public void view_update() {
        /* Model name is collectionInfo_table */
        if(((MSharedData)this.shared_model).isExist("collectionInfo_table")) {
            update_collection_info();
        }
        update_person();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.comboInsertWatchTime.getItems().addAll("오전", "오후", "저녁", "새벽");
		this.comboInsertWatchSex.getItems().addAll("암컷", "수컷");
		this.comboInsertWatchStatus.getItems().addAll("상", "중", "하");

		this.comboInsertWatchWho.getSelectionModel().select(0); // 조윤호 교수님은 무조건 DB에 있어야함
        this.comboInsertWatchSex.getSelectionModel().select(0);
        this.comboInsertWatchStatus.getSelectionModel().select(0);
        this.comboInsertWatchTime.getSelectionModel().select(0);
	}
	
	@Override
	public void init_procedure() {
		// Set Watcher
		String query = "select name from Person";
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

	@Override
    public void passing_address(String location, String locationDetail, String section, String alias) {
        String[] sectionSplit = section.split(" ");
        this.txtInsertWatchLoc.setText(location);
        this.txtInsertWatchDo.setText(locationDetail);
        if(sectionSplit.length == 1) {
            this.txtInsertWatchSi.setText(section);
            this.txtInsertWatchDong.setText(null);
        }else{
            this.txtInsertWatchSi.setText(sectionSplit[0]);
            this.txtInsertWatchDong.setText(sectionSplit[1]);
        }
        this.txtInsertWatchLocname.setText(alias);
    }
}
