package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;

public class CInsertSpecimen extends AbsInsertController implements Initializable {
	
    MDBSpecimen db_specimen=null;
    MDBSpecimenize db_specimenize=null;
    
    String PlaceName;
    String CabinetName;
    String BoxName;

    @FXML
    private TextField txtWhoWorkSpecimen;
    
    @FXML
    private TextField txtWhoInsertSpecimen;
    
    @FXML
    private ToggleGroup StorageSelection;

    @FXML
    private RadioButton rdoNewStorage;
    
    @FXML
    private RadioButton rdoPreviousStorage;

    @FXML
    private TextField txtInsertLoc1;

    @FXML
    private TextField txtInsertLoc2;

    @FXML
    private TextField txtInsertLoc3;
    
    @FXML
    private Button btnInsertSpecimenSearchcollectloc;
    
    @FXML
    private Button btnInsertSpecimenWorkerManagement;
    
    @FXML
    private TextField txtInsertSpecimenLocname;
    
    @FXML
    private DatePicker dateInsertSpecimenCollectdate;

    @FXML
    private Button btnInsertSpecimenGiverManagement;
    
    @FXML
    private ComboBox<String> comboInsertSpecimenCollectwho;

    @FXML
    private Button btnInsertSpecimenImportCollectionInfo;
    
    @FXML
    private TextField txtInsertSpecimenLat;
    
    @FXML
    private ComboBox<String> comboInsertSpecimenLoc3;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc1;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc2;

    @FXML
    private TextField txtInsertSpecimenZoological;

    @FXML
    private TextField txtInsertSpecimenCollectoc;

    @FXML
    private Button btnInsertSpecimenCorrect;

    @FXML
    private TextField txtInsertSpecimenSi;

    @FXML
    private Button btnInsertSpecimenImportSpecimen;
    
    @FXML
    private TextField txtInsertSpecimenBname;

    @FXML
    private ComboBox<String> comboInsertSpecimenStatus;
    
    @FXML
    private TextField txtInsertSpecimenDo;

    @FXML
    private TextField txtInsertSpecimenDong;

    @FXML
    private ComboBox<String> comboInsertSpecimenSex;

    @FXML
    private TextField txtInsertSpecimenNation;

    @FXML
    private Button btnInsertSpecimenAdd;

    @FXML
    private DatePicker dateInsertSpecimenDate;

    @FXML
    private Button btnInsertSpecimenExit;

    @FXML
    private TextField txtInsertSpecimenLong;
    
    @FXML
    private TextField txtInsertSpecimenFamily;
    
    @FXML
    private ComboBox<String> comboInsertSpecimenCollectway;
    

    @FXML
    void OnPreviousStorage(ActionEvent event) {
    	if(this.rdoPreviousStorage.isSelected()) {
    		this.txtInsertLoc1.setDisable(true);
    		this.txtInsertLoc2.setDisable(true);
    		this.txtInsertLoc3.setDisable(true);
    		this.comboInsertSpecimenLoc1.setDisable(false);
    		this.comboInsertSpecimenLoc2.setDisable(false);
    		this.comboInsertSpecimenLoc3.setDisable(false);

    	}
    }

    @FXML
    void OnNewStorage(ActionEvent event) {
    	if(this.rdoNewStorage.isSelected()) {
    		this.comboInsertSpecimenLoc1.setDisable(true);
    		this.comboInsertSpecimenLoc2.setDisable(true);
    		this.comboInsertSpecimenLoc3.setDisable(true);
    		this.txtInsertLoc1.setDisable(false);
    		this.txtInsertLoc2.setDisable(false);
    		this.txtInsertLoc3.setDisable(false);
    	}
    }

	@FXML
    void addInsertSpecimen(ActionEvent event) {
    	/* DB Instance initialization */
    	MDBCollectionInfo db_collection_info = new MDBCollectionInfo(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBLocation db_location = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBPerson db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBButterflyGuide db_butterfly_guide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimenize db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimen db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimenIO db_specimenIO = new MDBSpecimenIO(((MSharedData)this.shared_model).getDB().getConnection());
        
    	String Collectway = comboInsertSpecimenCollectway.getSelectionModel().getSelectedItem();
    	String Collect_date = MDateConvertor.convert2DBFormat(dateInsertSpecimenCollectdate.getEditor().getText());
    	String country = txtInsertSpecimenNation.getText();
    	String location = txtInsertSpecimenCollectoc.getText();
    	String location_detail = txtInsertSpecimenDo.getText() + " " + txtInsertSpecimenSi.getText() + " " + txtInsertSpecimenDong.getText();

        String gps_x = "0";
        String gps_y = "0";
        if(txtInsertSpecimenLat.getText().length() > 0) gps_x = txtInsertSpecimenLat.getText();
        if(txtInsertSpecimenLong.getText().length() > 0) gps_y = txtInsertSpecimenLong.getText();
        String gps =  gps_x + "," + gps_y;

    	String alias = txtInsertSpecimenLocname.getText();
    	String collectwho = txtWhoInsertSpecimen.getText();
    	String butterfly_name = txtInsertSpecimenBname.getText();
    	String butterfly_family = txtInsertSpecimenFamily.getText();
    	String scientific_name = txtInsertSpecimenZoological.getText();
    	String Specimen_date = MDateConvertor.convert2DBFormat(dateInsertSpecimenDate.getEditor().getText());
    	String status = comboInsertSpecimenStatus.getSelectionModel().getSelectedItem();
    	String sex = comboInsertSpecimenSex.getSelectionModel().getSelectedItem();
    	String PreviousLoc1 = comboInsertSpecimenLoc1.getSelectionModel().getSelectedItem();
    	String PreviousLoc2 = comboInsertSpecimenLoc2.getSelectionModel().getSelectedItem();
    	String PreviousLoc3 = comboInsertSpecimenLoc3.getSelectionModel().getSelectedItem();
    	String NewLoc1 = txtInsertLoc1.getText();
    	String NewLoc2 = txtInsertLoc2.getText();
    	String NewLoc3 = txtInsertLoc3.getText();
    	String SpecimenWho = txtWhoInsertSpecimen.getText();


        /* Value Mapping */
        db_location.setCountry(country);
        db_location.setLocation(location);
        db_location.setLocationDetail(location_detail);
        db_location.setGps(gps);
        db_location.setAlias(alias);
        db_location.setSection(null);
        db_location.setSectionDetail(null);
        // db_location.printContents();
        int id_location = db_location.getIdLocationFromDB();
        if(id_location == 0) {
            if(!db_location.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Location Insert Failed.");
                return;
            }
            id_location = db_location.getIdLocationFromDB();
        }
        
        // db_person_제공자 & 작업자
        db_person.setName(collectwho);
        int id_person_col = db_person.getIdPersonFromDB();
        if(id_person_col == 0) {
            if(!db_person.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Person Insert Failed.");
                return;
            }
            id_person_col = db_person.getIdPersonFromDB();
        }
        db_person.setName(SpecimenWho);
        int id_person_speci = db_person.getIdPersonFromDB();
        if(id_person_speci == 0) {
            if(!db_person.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Person Insert Failed.");
                return;
            }
            id_person_speci = db_person.getIdPersonFromDB();
        }
        
        // db_butterfly_guide
        db_butterfly_guide.setName(butterfly_name);
        db_butterfly_guide.setFamily(butterfly_family);
        db_butterfly_guide.setScientific_name(scientific_name);
        db_butterfly_guide.setIdImage(0);
        int id_butterflyGuide = db_butterfly_guide.getIdButterflyGuideFromDB();
        if(id_butterflyGuide == 0) {
            if(!db_butterfly_guide.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] ButterflyGuide Insert Failed.");
                return;
            }
            id_butterflyGuide = db_butterfly_guide.getIdButterflyGuideFromDB();
        }

        //db_collection_info
        /*
         * 추후에 출집정보를 직접 검색해서 자동으로 입력할 수 있도록 하는게 좋음 - 성훈
         * */
        db_collection_info.setDate(Collect_date);
        db_collection_info.setMethod(Collectway);
        db_collection_info.setIdPerson(id_person_col);
        db_collection_info.setIdButterflyGuide(id_butterflyGuide);
        db_collection_info.setIdLocation(id_location);
        int id_collectionInfo = db_collection_info.getIdCollectionInfoFromDB();
        if(id_collectionInfo == 0) {
            if(!db_collection_info.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] CollectionInfo Insert Failed.");
                return;
            }
            id_collectionInfo = db_collection_info.getIdCollectionInfoFromDB();
        }

        //db_specimen
        db_specimen.setStatus(status);
        db_specimen.setSex(sex);
        if(this.rdoPreviousStorage.isSelected()) {
            db_specimen.setStorageRoom(PreviousLoc1);
            db_specimen.setStorageCabinet(PreviousLoc2);
            db_specimen.setStorageChest(PreviousLoc3);
        } else {
        	db_specimen.setStorageRoom(NewLoc1);
        	db_specimen.setStorageCabinet(NewLoc2);
        	db_specimen.setStorageChest(NewLoc3);
        }
        db_specimen.setIdCollectionInfo(id_collectionInfo);
        db_specimen.setIdImage(0);   // 추후 채워야함
        int id_specimen = db_specimen.getIdSpecimenFromDB();
        if(id_specimen == 0) {
            if(!db_specimen.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Specimen Insert Failed.");
                return;
            }
            id_specimen = db_specimen.getIdSpecimenFromDB();
        }

        //db_specimenize
        db_specimenize.setDate(Specimen_date);
        db_specimenize.setIdPerson(id_person_speci);
        db_specimenize.setIdSpecimen(id_specimen);
        db_specimenize.setAnticepticName(null); //추후 추가해야함.
        db_specimenize.setEmbalmingDate(null); //추후 추가해야함.
        int id_specimenize = db_specimenize.getIdSpecimenizeFromDB();
        if(id_specimenize == 0) {
            if(!db_specimenize.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Specimenize Insert Failed.");
                return;
            }
            id_specimenize = db_specimenize.getIdSpecimenizeFromDB();
        }

        //db_specimenIO
        db_specimenIO.setIdSpecimen(id_specimen);
        db_specimenIO.setIdGiver(id_person_col);
        db_specimenIO.setIdTaker(1);    //조윤호교수님으로 수정해야함
        db_specimenIO.setCost(0);
        db_specimenIO.setDate(null);
        int id_specimenIO = db_specimenIO.getIdSpecimenIOFromDB();
        if(id_specimenIO == 0) {
            if(!db_specimenIO.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] SpecimenIO Insert Failed.");
                return;
            }
            id_specimenIO = db_specimenIO.getIdSpecimenIOFromDB();
        }
    }

    @FXML
    void bnameInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void OnImportCollectionInfo(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertSpecimenExit.getScene().getWindow(), "VCollectionInfoSelector");
    }

    @FXML
    void OnImportSpecimen(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertSpecimenExit.getScene().getWindow(), "VSpecimenSelector");
    }

    @FXML
    void OnGiverManagement(ActionEvent event) throws IOException {
        MPassingData data = new MPassingData(1);
        data.setData("giver", 0);
        ((MSharedData)this.shared_model).add(data, "button_name");
        spawnChildWindow(this.btnInsertSpecimenExit.getScene().getWindow(), "VPersonManager");
    }

    @FXML
    void OnWorkerManagement(ActionEvent event) throws IOException {
        MPassingData data = new MPassingData(1);
        data.setData("worker", 0);
        ((MSharedData)this.shared_model).add(data, "button_name");
        spawnChildWindow(this.btnInsertSpecimenExit.getScene().getWindow(), "VPersonManager");
    }

    @FXML
    void collectdateInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void collectlocInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void collectwayInsertSpecimen(ActionEvent event) {

    }
    
    @FXML
    void OnCreateSpecimenID(ActionEvent event) {
    	String specimenDateID = this.dateInsertSpecimenCollectdate.getEditor().getText();
        MDBSpecimen db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
    }

    @FXML
    void correctInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void dateInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void doInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void dongInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void exitInsertSpecimen(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertSpecimenExit.getScene().getWindow(), "VInsert");
    }

    @FXML
    void familyInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void latInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc1InsertSpecimen(ActionEvent event) throws SQLException {
     	String queryCabinet = null;
    	ResultSet rsCabinet = null;
    	System.out.println("Hi");
    	int PlaceTotalSelection = this.comboInsertSpecimenLoc1.getSelectionModel().getSelectedIndex();
    	if(PlaceTotalSelection==0) {
            queryCabinet = "select distinct storageCabinet from Specimen";
    		rsCabinet = db_specimen.selectQuery(queryCabinet);
    	}else {
            queryCabinet = "select distinct storageCabinet from Specimen where storageRoom='" + this.comboInsertSpecimenLoc1.getSelectionModel().getSelectedItem() + "'";
    		rsCabinet = db_specimen.selectQuery(queryCabinet);
    	}
    	
		this.comboInsertSpecimenLoc2.getItems().clear();
    	this.comboInsertSpecimenLoc2.getItems().add("전체선택");
		
			while(rsCabinet.next()) {
				System.out.println(rsCabinet.getString(1));
				this.comboInsertSpecimenLoc2.getItems().add(rsCabinet.getString(1));   // get storageCabinet
			}

    	CabinetName = this.comboInsertSpecimenLoc2.getSelectionModel().getSelectedItem();
    }

    @FXML
    void loc2InsertSpecimen(ActionEvent event) throws SQLException {
    	String queryBox = null;
    	ResultSet rsBox =null;
    	int CabinetTotalSelection = this.comboInsertSpecimenLoc2.getSelectionModel().getSelectedIndex();
    	if(CabinetTotalSelection==0) {
            queryBox = "select distinct storageChest from Specimen";
    		rsBox = db_specimen.selectQuery(queryBox);
    	} else {
            queryBox = "select distinct storageChest from Specimen where storageCabinet='" + this.comboInsertSpecimenLoc2.getSelectionModel().getSelectedItem() + "'";
    		rsBox = db_specimen.selectQuery(queryBox);
    	}
		
		this.comboInsertSpecimenLoc3.getItems().clear();
    	this.comboInsertSpecimenLoc3.getItems().add("전체선택");
		
				while(rsBox.next()) {
					System.out.println(rsBox.getString(1));
					this.comboInsertSpecimenLoc3.getItems().add(rsBox.getString(1));
				}
		
    	BoxName = this.comboInsertSpecimenLoc3.getSelectionModel().getSelectedItem();
    }

    @FXML
    void loc2typeInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc3InsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc3typeInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void locnameInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void longInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void nationInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void remarkInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void searchcollectlocInsertSpecimen(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertSpecimenAdd.getScene().getWindow(), "VAddressBook");
    }

    @FXML
    void sexInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void siInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void statusInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void whoInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void zoologicalInsertSpecimen(ActionEvent event) {

    }

    public void update_person() {
    	/* DB Instance initialization */
    	MDBPerson db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());

        /* Clear All Names from List */
        this.txtWhoInsertSpecimen.clear();

        /* DB Querying */
        String query = "select name from Person";
        ResultSet rs = db_person.selectQuery(query);
        try {
            while(rs.next()) {
                /* View Updating */
                this.txtWhoInsertSpecimen.getText();   // get name
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void view_update() {
        update_person();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

    @Override
    public void init_procedure() {

    	/* DB Instance initialization */
    	 db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
    	 db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());

 		this.comboInsertSpecimenLoc1.getItems().clear();
    	
    	this.comboInsertSpecimenLoc1.getItems().add("전체선택");

    	String queryRoom = "select distinct storageRoom from Specimen";
		ResultSet rsRoom = db_specimen.selectQuery(queryRoom);
		
		try {
			while(rsRoom.next()) {
				this.comboInsertSpecimenLoc1.getItems().add(rsRoom.getString(1));   // get storageRoom
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.comboInsertSpecimenCollectway.getItems().addAll("직접채집", "구매", "선물");
		this.comboInsertSpecimenStatus.getItems().addAll("상", "중", "하");
		this.comboInsertSpecimenSex.getItems().addAll("암", "수");
        this.comboInsertSpecimenCollectway.getSelectionModel().select(0);
        this.comboInsertSpecimenStatus.getSelectionModel().select(0);
        this.comboInsertSpecimenSex.getSelectionModel().select(0);
		this.txtInsertLoc1.setDisable(true);
		this.txtInsertLoc2.setDisable(true);
		this.txtInsertLoc3.setDisable(true);
		this.comboInsertSpecimenLoc1.setDisable(true);
		this.comboInsertSpecimenLoc2.setDisable(true);
		this.comboInsertSpecimenLoc3.setDisable(true);
    }

    @FXML
    void boxInsert(ActionEvent event) throws SQLException {
    	

        view_update();
    }

    @Override
    public void passing_address(String location, String locationDetail, String section, String alias) {
        String[] sectionSplit = section.split(" ");
        this.txtInsertSpecimenCollectoc.setText(location);
        this.txtInsertSpecimenDo.setText(locationDetail);
        if(sectionSplit.length == 1) {
            this.txtInsertSpecimenSi.setText(section);
            this.txtInsertSpecimenDong.setText(null);
        }else{
            this.txtInsertSpecimenSi.setText(sectionSplit[0]);
            this.txtInsertSpecimenDong.setText(sectionSplit[1]);
        }
        this.txtInsertSpecimenLocname.setText(alias);
    }

    @Override
    public void passing_person(String prev_button, String name) {
    	if(prev_button.equals("giver")) {
        	this.txtWhoInsertSpecimen.setText(name);
    	} else if(prev_button == "worker") {
        	this.txtWhoWorkSpecimen.setText(name);
    	}
    }
}