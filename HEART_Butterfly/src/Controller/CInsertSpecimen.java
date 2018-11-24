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
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class CInsertSpecimen extends AbsMetaController implements Initializable {
	
	MDBPerson PersonDB;

    @FXML
    private DatePicker dateInsertSpecimenCollectdate;

    @FXML
    private TextField txtInsertSpecimenCollectoc;

    @FXML
    private Button btnInsertSpecimenImportCollectionInfo;

    @FXML
    private Button btnInsertSpecimenImportSpecimen;

    @FXML
    private Button btnInsertSpecimenGiverManagement;

    @FXML
    private Button btnInsertSpecimenWorkerManagement;

    @FXML
    private ComboBox<String> comboInsertSpecimenWho;

    @FXML
    private TextField txtInsertSpecimenBname;

    @FXML
    private TextField txtInsertSpecimenFamily;

    @FXML
    private TextField txtInsertSpecimenZoological;

    @FXML
    private Button btnInsertSpecimenExit;

    @FXML
    private ComboBox<String> comboInsertSpecimenStatus;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc1;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc2;

    @FXML
    private ComboBox<String> comboInsertSpecimenSex;

    @FXML
    private TextField txtInsertSpecimenRemark;

    @FXML
    private ComboBox<String> comboInsertSpecimenCollectwho;

    @FXML
    private TextField txtInsertSpecimenNation;

    @FXML
    private DatePicker dateInsertSpecimenDate;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc3type;

    @FXML
    private ComboBox<String> comboInsertSpecimenCollectway;

    @FXML
    private TextField txtInsertSpecimenLocname;

    @FXML
    private TextField txtInsertSpecimenLong;

    @FXML
    private TextField txtInsertSpecimenLat;

    @FXML
    private TextField txtInsertSpecimenDong;

    @FXML
    private TextField txtInsertSpecimenSi;

    @FXML
    private TextField txtInsertSpecimenDo;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc2type;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc3;

    @FXML
    void addInsertSpecimen(ActionEvent event) {
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
    	String collectwho = comboInsertSpecimenCollectwho.getSelectionModel().getSelectedItem();
    	String butterfly_name = txtInsertSpecimenBname.getText();
    	String butterfly_family = txtInsertSpecimenFamily.getText();
    	String scientific_name = txtInsertSpecimenZoological.getText();
    	String Specimen_date = MDateConvertor.convert2DBFormat(dateInsertSpecimenDate.getEditor().getText());
    	String status = comboInsertSpecimenStatus.getSelectionModel().getSelectedItem();
    	String sex = comboInsertSpecimenSex.getSelectionModel().getSelectedItem();
    	String note = txtInsertSpecimenRemark.getText();
    	String Loc1 = comboInsertSpecimenLoc1.getSelectionModel().getSelectedItem();
    	String Loc2type = comboInsertSpecimenLoc2type.getSelectionModel().getSelectedItem();
    	String Loc2 = comboInsertSpecimenLoc2.getSelectionModel().getSelectedItem();
    	String Loc3type = comboInsertSpecimenLoc3type.getSelectionModel().getSelectedItem();
    	String Loc3 = comboInsertSpecimenLoc3.getSelectionModel().getSelectedItem();
    	String SpecimenWho = comboInsertSpecimenWho.getSelectionModel().getSelectedItem();

    	/* DB Instance initialization */
    	MDBCollectionInfo db_collection_info = new MDBCollectionInfo(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBLocation db_location = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBPerson db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBButterflyGuide db_butterfly_guide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimenize db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimen db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimenIO db_specimenIO = new MDBSpecimenIO(((MSharedData)this.shared_model).getDB().getConnection());

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
        db_specimen.setStorageRoom(Loc1);
        db_specimen.setStorageCabinet(Loc2 + "_" + Loc2type);
        db_specimen.setStorageChest(Loc3 + "_" + Loc3type);
        db_specimen.setComment(note);
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
        spawnChildWindow(this.btnInsertSpecimenExit.getScene().getWindow(), "VPersonManagement");
    }

    @FXML
    void OnWorkerManagement(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertSpecimenExit.getScene().getWindow(), "VPersonManagement");
    }

    @FXML
    void collectwhoInsertSpecimen(ActionEvent event) {

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
    void labelInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void latInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc1InsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc2InsertSpecimen(ActionEvent event) {

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
    void searchcollectlocInsertSpecimen(ActionEvent event) {

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
        /* Clear All Names from List */
        this.comboInsertSpecimenCollectwho.getItems().clear();
        this.comboInsertSpecimenWho.getItems().clear();

        /* DB Querying */
        String query = "select name from Person";
        PersonDB = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        ResultSet rs = PersonDB.selectQuery(query);
        try {
            while(rs.next()) {
                /* View Updating */
                this.comboInsertSpecimenWho.getItems().add(rs.getString(1));   // get name
                this.comboInsertSpecimenCollectwho.getItems().add(rs.getString(1));   // get name
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Initializing */
        if(this.comboInsertSpecimenWho.getItems().size() > 0) this.comboInsertSpecimenWho.getSelectionModel().select("조윤호"); // DB에 '조윤호'는 반드시 존재한다.
        if(this.comboInsertSpecimenCollectwho.getItems().size() > 0) this.comboInsertSpecimenCollectwho.getSelectionModel().select("조윤호");
    }

    @Override
    public void view_update() {
        update_person();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.comboInsertSpecimenCollectway.getItems().addAll("직접채집", "구매", "선물");
		this.comboInsertSpecimenWho.getItems().addAll("조윤호");
		this.comboInsertSpecimenCollectwho.getItems().addAll("조윤호");
		this.comboInsertSpecimenStatus.getItems().addAll("상", "중", "하");
		this.comboInsertSpecimenLoc1.getItems().addAll("집", "사무실", "학교");
		this.comboInsertSpecimenSex.getItems().addAll("암", "수");
		this.comboInsertSpecimenLoc2type.getItems().addAll("구형", "신형", "기타");
		this.comboInsertSpecimenLoc3type.getItems().addAll("구형", "신형", "기타");
		this.comboInsertSpecimenLoc2.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		this.comboInsertSpecimenLoc3.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        this.comboInsertSpecimenCollectway.getSelectionModel().select(0);
        this.comboInsertSpecimenWho.getSelectionModel().select(0);
        this.comboInsertSpecimenCollectwho.getSelectionModel().select(0);
        this.comboInsertSpecimenStatus.getSelectionModel().select(0);
        this.comboInsertSpecimenLoc1.getSelectionModel().select(0);
        this.comboInsertSpecimenSex.getSelectionModel().select(0);
        this.comboInsertSpecimenLoc2type.getSelectionModel().select(0);
        this.comboInsertSpecimenLoc3type.getSelectionModel().select(0);
        this.comboInsertSpecimenLoc2.getSelectionModel().select(0);
        this.comboInsertSpecimenLoc3.getSelectionModel().select(0);
	}

    @Override
    public void init_procedure() {
        view_update();
    }
}
