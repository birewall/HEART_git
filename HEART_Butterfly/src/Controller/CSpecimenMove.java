package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CSpecimenMove extends AbsMetaController implements Initializable {

    MDBPerson PersonDB;

    @FXML
    private TextField txtSpecimenMovePrenation;

    @FXML
    private ComboBox<String> comboSpecimenMoveWorker;

    @FXML
    private Button btnPersonManager;

    @FXML
    private TextField txtSpecimenMoveBname;

    @FXML
    private TextField txtSpecimenMoveFamily;

    @FXML
    private TextField txtSpecimenMoveZoological;

    @FXML
    private Button btnSpecimenMoveAdd;

    @FXML
    private Button btnSpecimenMoveExit;

    @FXML
    private ComboBox<String> comboSpecimenMoveStatus;

    @FXML
    private ComboBox<String> comboSpecimenMoveLoc1;

    @FXML
    private ComboBox<String> comboSpecimenMoveLoc2;

    @FXML
    private TextField txtSpecimenMoveContentremark;

    @FXML
    private TextField txtSpecimenMovePrecollectdate;

    @FXML
    private DatePicker dateSpecimenMoveWorkdate;

    @FXML
    private ComboBox<String> comboSpecimenMoveLoc3type;

    @FXML
    private TextField txtSpecimenMovePreloc;

    @FXML
    private Button btnSpecimenMoveLabel;

    @FXML
    private ComboBox<String> comboSpecimenMoveLoc2type;

    @FXML
    private ComboBox<String> comboSpecimenMoveLoc3;

    @FXML
    private Button btnSpecimenMoveCorrect;

    @FXML
    private TextField txtSpecimenMovePrecollectloc;

    @FXML
    private TextField txtSpecimenMoveCollectwho;

    @FXML
    private TextField txtSpecimenMovePreworkdate;

    @FXML
    private TextField txtSpecimenMovePresex;

    @FXML
    private TextField txtSpecimenMovePrestatus;

    @FXML
    private TextField txtSpecimenMovePreloc1;

    @FXML
    private ComboBox<String> comboSpecimenMoveContent;

    @FXML
    private TextField txtSpecimenMovePreloc2;

    @FXML
    private TextField txtSpecimenMovePreloc3;

    @FXML
    private TextField txtSpecimenMovepreworker;

    @FXML
    private Button btnImportCollectionInfo;

    @FXML
    private Button btnImportSpecimen;

    @FXML
    private Button btnSpecimenLocationManager;

    @FXML
    void OnImportCollectionInfo(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnImportCollectionInfo.getScene().getWindow(), "VCollectionInfoSelector");
    }

    @FXML
    void OnImportSpecimen(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnImportSpecimen.getScene().getWindow(), "VSpecimenSelector");
    }

    @FXML
    void OnPersonManager(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnPersonManager.getScene().getWindow(), "VPersonManager");
    }

    @FXML
    void OnSpecimenLocationManager(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnPersonManager.getScene().getWindow(), "VSpecimenLocationManager");
    }

    @FXML
    void addSpecimenMove(ActionEvent event) {
//        String Collectway = comboInsertSpecimenCollectway.getSelectionModel().getSelectedItem();
//        String Collect_date = MDateConvertor.convert2DBFormat(dateInsertSpecimenCollectdate.getEditor().getText());
//        String country = txtInsertSpecimenNation.getText();
//        String location = txtInsertSpecimenCollectoc.getText();
//        String location_detail = txtInsertSpecimenDo.getText() + " " + txtInsertSpecimenSi.getText() + " " + txtInsertSpecimenDong.getText();
//
//        String gps_x = "0";
//        String gps_y = "0";
//        if(txtInsertSpecimenLat.getText().length() > 0) gps_x = txtInsertSpecimenLat.getText();
//        if(txtInsertSpecimenLong.getText().length() > 0) gps_y = txtInsertSpecimenLong.getText();
//        String gps =  gps_x + "," + gps_y;
//
//        String alias = txtInsertSpecimenLocname.getText();
//        String collectwho = comboInsertSpecimenCollectwho.getSelectionModel().getSelectedItem();
//        String butterfly_name = txtInsertSpecimenBname.getText();
//        String butterfly_family = txtInsertSpecimenFamily.getText();
//        String scientific_name = txtInsertSpecimenZoological.getText();
//        String Specimen_date = MDateConvertor.convert2DBFormat(dateInsertSpecimenDate.getEditor().getText());
//        String status = comboInsertSpecimenStatus.getSelectionModel().getSelectedItem();
//        String sex = comboInsertSpecimenSex.getSelectionModel().getSelectedItem();
//        String note = txtInsertSpecimenRemark.getText();
//        String Loc1 = comboInsertSpecimenLoc1.getSelectionModel().getSelectedItem();
//        String Loc2type = comboInsertSpecimenLoc2type.getSelectionModel().getSelectedItem();
//        String Loc2 = comboInsertSpecimenLoc2.getSelectionModel().getSelectedItem();
//        String Loc3type = comboInsertSpecimenLoc3type.getSelectionModel().getSelectedItem();
//        String Loc3 = comboInsertSpecimenLoc3.getSelectionModel().getSelectedItem();
//        String SpecimenWho = comboInsertSpecimenWho.getSelectionModel().getSelectedItem();
//
//        /* DB Instance initialization */
//        MDBCollectionInfo db_collection_info = new MDBCollectionInfo(((MSharedData)this.shared_model).getDB().getConnection());
//        MDBLocation db_location = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
//        MDBPerson db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
//        MDBButterflyGuide db_butterfly_guide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
//        MDBSpecimenize db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());
//        MDBSpecimen db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
//        MDBSpecimenIO db_specimenIO = new MDBSpecimenIO(((MSharedData)this.shared_model).getDB().getConnection());
//
//        /* Value Mapping */
//        db_location.setCountry(country);
//        db_location.setLocation(location);
//        db_location.setLocationDetail(location_detail);
//        db_location.setGps(gps);
//        db_location.setAlias(alias);
//        db_location.setSection(null);
//        db_location.setSectionDetail(null);
//        // db_location.printContents();
//        int id_location = db_location.getIdLocationFromDB();
//        if(id_location == 0) {
//            if(!db_location.insert()){
//                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Location Insert Failed.");
//                return;
//            }
//            id_location = db_location.getIdLocationFromDB();
//        }
//
//        // db_person_제공자 & 작업자
//        db_person.setName(collectwho);
//        int id_person_col = db_person.getIdPersonFromDB();
//        if(id_person_col == 0) {
//            if(!db_person.insert()){
//                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Person Insert Failed.");
//                return;
//            }
//            id_person_col = db_person.getIdPersonFromDB();
//        }
//        db_person.setName(SpecimenWho);
//        int id_person_speci = db_person.getIdPersonFromDB();
//        if(id_person_speci == 0) {
//            if(!db_person.insert()){
//                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Person Insert Failed.");
//                return;
//            }
//            id_person_speci = db_person.getIdPersonFromDB();
//        }
//
//        // db_butterfly_guide
//        db_butterfly_guide.setName(butterfly_name);
//        db_butterfly_guide.setFamily(butterfly_family);
//        db_butterfly_guide.setScientific_name(scientific_name);
//        db_butterfly_guide.setIdImage(0);
//        int id_butterflyGuide = db_butterfly_guide.getIdButterflyGuideFromDB();
//        if(id_butterflyGuide == 0) {
//            if(!db_butterfly_guide.insert()){
//                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] ButterflyGuide Insert Failed.");
//                return;
//            }
//            id_butterflyGuide = db_butterfly_guide.getIdButterflyGuideFromDB();
//        }
//
//        //db_collection_info
//        /*
//         * 추후에 출집정보를 직접 검색해서 자동으로 입력할 수 있도록 하는게 좋음 - 성훈
//         * */
//        db_collection_info.setDate(Collect_date);
//        db_collection_info.setMethod(Collectway);
//        db_collection_info.setIdPerson(id_person_col);
//        db_collection_info.setIdButterflyGuide(id_butterflyGuide);
//        db_collection_info.setIdLocation(id_location);
//        int id_collectionInfo = db_collection_info.getIdCollectionInfoFromDB();
//        if(id_collectionInfo == 0) {
//            if(!db_collection_info.insert()){
//                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] CollectionInfo Insert Failed.");
//                return;
//            }
//            id_collectionInfo = db_collection_info.getIdCollectionInfoFromDB();
//        }
//
//        //db_specimen
//        db_specimen.setStatus(status);
//        db_specimen.setSex(sex);
//        db_specimen.setStorageRoom(Loc1);
//        db_specimen.setStorageCabinet(Loc2 + "_" + Loc2type);
//        db_specimen.setStorageChest(Loc3 + "_" + Loc3type);
//        db_specimen.setComment(note);
//        db_specimen.setIdCollectionInfo(id_collectionInfo);
//        db_specimen.setIdImage(0);   // 추후 채워야함
//        int id_specimen = db_specimen.getIdSpecimenFromDB();
//        if(id_specimen == 0) {
//            if(!db_specimen.insert()){
//                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Specimen Insert Failed.");
//                return;
//            }
//            id_specimen = db_specimen.getIdSpecimenFromDB();
//        }
//
//        //db_specimenize
//        db_specimenize.setDate(Specimen_date);
//        db_specimenize.setIdPerson(id_person_speci);
//        db_specimenize.setIdSpecimen(id_specimen);
//        db_specimenize.setAnticepticName(null); //추후 추가해야함.
//        db_specimenize.setEmbalmingDate(null); //추후 추가해야함.
//        int id_specimenize = db_specimenize.getIdSpecimenizeFromDB();
//        if(id_specimenize == 0) {
//            if(!db_specimenize.insert()){
//                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] Specimenize Insert Failed.");
//                return;
//            }
//            id_specimenize = db_specimenize.getIdSpecimenizeFromDB();
//        }
//
//        //db_specimenIO
//        db_specimenIO.setIdSpecimen(id_specimen);
//        db_specimenIO.setIdGiver(id_person_col);
//        db_specimenIO.setIdTaker(1);    //조윤호교수님으로 수정해야함
//        db_specimenIO.setCost(0);
//        db_specimenIO.setDate(null);
//        int id_specimenIO = db_specimenIO.getIdSpecimenIOFromDB();
//        if(id_specimenIO == 0) {
//            if(!db_specimenIO.insert()){
//                ((MSharedData)this.shared_model).getLogger().error("[CInsertSpecimen] SpecimenIO Insert Failed.");
//                return;
//            }
//            id_specimenIO = db_specimenIO.getIdSpecimenIOFromDB();
//        }
    }

    @FXML
    void bnameSpecimenMove(ActionEvent event) {

    }

    @FXML
    void chooseworkerSpecimenMove(ActionEvent event) {

    }

    @FXML
    void collectwhoSpecimenMove(ActionEvent event) {

    }

    @FXML
    void contentSpecimenMove(ActionEvent event) {

    }

    @FXML
    void contentremarkSpecimenMove(ActionEvent event) {

    }

    @FXML
    void correctSpecimenMove(ActionEvent event) {

    }

    @FXML
    void exitSpecimenMove(ActionEvent event) throws IOException {
        changeWindow(this.btnSpecimenMoveExit.getScene().getWindow(), "VMain");
    }

    @FXML
    void familySpecimenMove(ActionEvent event) {

    }

    @FXML
    void labelSpecimenMove(ActionEvent event) {

    }

    @FXML
    void loc1SpecimenMove(ActionEvent event) {

    }

    @FXML
    void loc2SpecimenMove(ActionEvent event) {

    }

    @FXML
    void loc2typeSpecimenMove(ActionEvent event) {

    }

    @FXML
    void loc3SpecimenMove(ActionEvent event) {

    }

    @FXML
    void precollectdateSpecimenMove(ActionEvent event) {

    }

    @FXML
    void precollectlocSpecimenMove(ActionEvent event) {

    }

    @FXML
    void preloc1SpecimenMove(ActionEvent event) {

    }

    @FXML
    void preloc2SpecimenMove(ActionEvent event) {

    }

    @FXML
    void preloc3SpecimenMove(ActionEvent event) {

    }

    @FXML
    void prelocSpecimenMove(ActionEvent event) {

    }

    @FXML
    void prenationSpecimenMove(ActionEvent event) {

    }

    @FXML
    void presexSpecimenMove(ActionEvent event) {

    }

    @FXML
    void prestatusSpecimenMove(ActionEvent event) {

    }

    @FXML
    void preworkdateSpecimenMove(ActionEvent event) {

    }

    @FXML
    void preworkerSpecimenMove(ActionEvent event) {

    }

    @FXML
    void statusSpecimenMove(ActionEvent event) {

    }

    @FXML
    void workdateSpecimenMove(ActionEvent event) {

    }

    @FXML
    void workerSpecimenMove(ActionEvent event) {

    }

    @FXML
    void zoologicalSpecimenMove(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.comboSpecimenMoveContent.getItems().addAll("이동","폐기","기증","대여");
        //this.comboSpecimenMoveLoc1.getItems().addAll();
        //this.comboSpecimenMoveLoc2.getItems().addAll();
        //this.comboSpecimenMoveLoc2type.getItems().addAll();
        //this.comboSpecimenMoveLoc3.getItems().addAll();
        //this.comboSpecimenMoveLoc3type.getItems().addAll();
        //this.comboSpecimenMoveWorker.getItems().addAll();
        this.comboSpecimenMoveStatus.getItems().addAll("상","중","하");
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
                this.comboSpecimenMoveWorker.getItems().add(rs.getString(1));   // get name
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public void update_collection_info() {
//        /* Model name is collectionInfo_table */
//        MPassingData passed_data = (MPassingData) ((MSharedData)this.shared_model).get("collectionInfo_table");
//
//        /* View Updating */
//        String date = passed_data.getData(0);
//        dateInsertWatchDate.getEditor().setText(date.substring(0,4) + ". " + Integer.parseInt(date.substring(4,6)) + ". " + Integer.parseInt(date.substring(6,8)));
//        txtInsertWatchNation.setText(passed_data.getData(1));
//        txtInsertWatchLocname.setText(passed_data.getData(2));
//        txtInsertWatchBname.setText(passed_data.getData(3));
//        txtInsertWatchFamily.setText(passed_data.getData(4));
//        // 5 for method
//        comboInsertWatchWho.getSelectionModel().select(passed_data.getData(6));
//
//        /* Remove date from shared model */
//        ((MSharedData)this.shared_model).remove("collectInfo_table");
//    }

    public void update_person() {
        /* Clear All Names from List */
        this.comboSpecimenMoveWorker.getItems().clear();

        /* DB Querying */
        String query = "select name from Person";
        PersonDB = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        ResultSet rs = PersonDB.selectQuery(query);
        try {
            while(rs.next()) {
                /* View Updating */
                this.comboSpecimenMoveWorker.getItems().add(rs.getString(1));   // get name
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Initializing */
        this.comboSpecimenMoveWorker.getSelectionModel().select("조윤호"); // DB에 '조윤호'는 반드시 존재한다.
    }

    @Override
    public void view_update() {
        /* Model name is collectionInfo_table */
        if(((MSharedData)this.shared_model).isExist("collectionInfo_table")) {
            //update_collection_info();
        }
        update_person();
    }
}
