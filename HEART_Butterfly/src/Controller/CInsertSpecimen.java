package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.MDBButterflyGuide;
import Model.MDBCollectionInfo;
import Model.MDBImageObjectInfo;
import Model.MDBLocation;
import Model.MDBObservation;
import Model.MDBPerson;
import Model.MDBSpecimen;
import Model.MDBSpecimenize;
import Model.MSharedData;
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
    private Button btnInsertSpecimenSearchcollectloc;

    @FXML
    private ComboBox<String> comboInsertSpecimenWho;

    @FXML
    private Button btnInsertSpecimenChoosewho;

    @FXML
    private Button btnInsertSpecimenClear;

    @FXML
    private TextField txtInsertSpecimenBname;

    @FXML
    private TextField txtInsertSpecimenFamily;

    @FXML
    private TextField txtInsertSpecimenZoological;

    @FXML
    private Button btnInsertSpecimenAdd;

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
    private Button btnInsertSpecimenChoosecollectwho;

    @FXML
    private ComboBox<String> comboInsertSpecimenCollectwho;

    @FXML
    private TextField txtInsertSpecimenNation;

    @FXML
    private DatePicker dateInsertSpecimenDate;

    @FXML
    private ComboBox<?> comboInsertSpecimenLoc3type;

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
    private Button btnInsertSpecimenLabel;

    @FXML
    private ComboBox<?> comboInsertSpecimenLoc2type;

    @FXML
    private ComboBox<?> comboInsertSpecimenLoc3;

    @FXML
    private Button btnInsertSpecimenCorrect;

    @FXML
    void addInsertSpecimen(ActionEvent event) {
    	String Collectway = comboInsertSpecimenCollectway.getSelectionModel().getSelectedItem();
    	String Collect_date = dateInsertSpecimenCollectdate.getEditor().getText();
    	String country = txtInsertSpecimenNation.getText();
    	String location = txtInsertSpecimenCollectoc.getText();
    	String location_detail = txtInsertSpecimenDo.getText() + " " + txtInsertSpecimenSi.getText() + " " + txtInsertSpecimenDong.getText();
    	String gps = txtInsertSpecimenLat.getText() + "," + txtInsertSpecimenLong.getText();
    	String alias = txtInsertSpecimenLocname.getText();
    	String collectwho = (String) comboInsertSpecimenCollectwho.getSelectionModel().getSelectedItem();
    	String butterfly_name = txtInsertSpecimenBname.getText();
    	String butterfly_family = txtInsertSpecimenFamily.getText();
    	String scientific_name = txtInsertSpecimenZoological.getText();
    	String Specimen_date = dateInsertSpecimenDate.getEditor().getText();
    	String status = comboInsertSpecimenStatus.getSelectionModel().getSelectedItem();
    	String sex = (String)comboInsertSpecimenSex.getSelectionModel().getSelectedItem();
    	String note = txtInsertSpecimenRemark.getText();
    	String Loc1 = comboInsertSpecimenLoc1.getSelectionModel().getSelectedItem();
    	String Loc2type = (String) comboInsertSpecimenLoc2type.getSelectionModel().getSelectedItem();
    	String Loc2 = comboInsertSpecimenLoc2.getSelectionModel().getSelectedItem();
    	String Loc3type = (String) comboInsertSpecimenLoc3type.getSelectionModel().getSelectedItem();
    	String Loc3 = (String) comboInsertSpecimenLoc3.getSelectionModel().getSelectedItem();
    	String SpecimenWho = comboInsertSpecimenWho.getSelectionModel().getSelectedItem();
    	
    	/* DB Instance initialization */
    	MDBCollectionInfo db_collection_info = new MDBCollectionInfo(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBLocation db_location = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBPerson db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBButterflyGuide db_butterfly_guide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimenize db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimen db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
        MDBImageObjectInfo db_imageObjectInfo = new MDBImageObjectInfo(((MSharedData)this.shared_model).getDB().getConnection());

        /* Value Mapping */
        db_location.setCountry(country);
        db_location.setLocation(location);
        db_location.setLocationDetail(location_detail);
        db_location.setGps(gps);
        db_location.setAlias(alias);
        
        // db_location.printContents();
        int id_location = db_location.getIdLocationFromDB();
        if(id_location == 0) {
            if(!db_location.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] Location Insert Failed.");
                return;
            }
            id_location = db_location.getIdLocationFromDB();
        }
        
        // db_person_제공자 & 작업자
        db_person.setName(collectwho);
        db_person.setSort("제공자");
        int id_person_col = db_person.getIdPersonFromDB();
        if(id_person_col == 0) {
            db_person.insert();
            if(!db_person.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] Person Insert Failed.");
                return;
            }
            id_person_col = db_person.getIdPersonFromDB();
        }
        db_person.setName(SpecimenWho);
        db_person.setSort("작업자");
        int id_person_speci = db_person.getIdPersonFromDB();
        if(id_person_speci == 0) {
            db_person.insert();
            if(!db_person.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertWatch] Person Insert Failed.");
                return;
            }
            id_person_speci = db_person.getIdPersonFromDB();
        }
        
        // db_butterfly_guide
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

        //
        
        
    	

    }

    @FXML
    void bnameInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void choosecollectwhoInsertSpecimen(ActionEvent event) {
    	TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Insert New Name");
		dialog.setHeaderText(null);
		dialog.setContentText(null);
		dialog.showAndWait();
		String new_name = dialog.getEditor().getText();

//		PersonDB.setName(new_name);
//		PersonDB.setSort("제공자");
//		if(!PersonDB.insert()){
//		    System.out.println("Failed.");
//		    return;
//        }
		
		this.comboInsertSpecimenCollectwho.getItems().add(new_name);
		
    }

    @FXML
    void choosewhoInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void clearInsertSpecimen(ActionEvent event) {
    	MDBPerson person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        person.delete_by_type("제공자");
        this.comboInsertSpecimenCollectwho.getItems().clear();

        person.setName("조윤호");
        person.setSort("제공자");
        if(!person.insert()){
            System.out.println("Failed.");
            return;
        }
        this.comboInsertSpecimenCollectwho.getItems().add("조윤호");
        this.comboInsertSpecimenCollectwho.getSelectionModel().select(0);

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
    void collectwhoInsertSpecimen(ActionEvent event) {

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
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.comboInsertSpecimenCollectway.getItems().addAll("직접채집", "구매", "선물");
		this.comboInsertSpecimenWho.getItems().addAll("조윤호");
		this.comboInsertSpecimenStatus.getItems().addAll("상", "중", "하");
		this.comboInsertSpecimenLoc1.getItems().addAll("집", "사무실", "학교");
		this.comboInsertSpecimenSex.getItems().addAll("암", "수");

	}
	
}
