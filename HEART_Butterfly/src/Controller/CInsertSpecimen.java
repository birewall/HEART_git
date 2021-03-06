package Controller;

import java.awt.Checkbox;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import org.controlsfx.control.textfield.TextFields;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class CInsertSpecimen extends AbsInsertController implements Initializable {

    MDatabase db=null;
    String ImagePath=null;
    List ImagePathList = new ArrayList();
    int ArraySize = 0;
    
    String PlaceName;
    String CabinetName;
    String BoxName;


    @FXML
    private CheckBox checkbox_InsertSubData_1;
    
    @FXML
    private CheckBox checkbox_InsertSubData_2;
    
    @FXML
    private Button btnPreviousImage;
    
    @FXML
    private Button btnNextImage;
    
    @FXML
    private ImageView ImgSpecimen;
    
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
    //private Button btnInsertSpecimenImportSpecimen;
    private Button btnInsertSpecimenPrintLabel;
    
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

    
    int image_index = 0;
    
    //데이터 백업 스플릿(상)
	String Collectway_sub = null;
	String Collect_date_sub = null;
	String country_sub = null;
	String location_sub = null;
	String location_detail_sub = null;
	String loc_1_sub = null;
	String loc_2_sub = null;
	String loc_3_sub = null;
    String gps_x_sub = null;
    String gps_y_sub = null;
    String gps_sub =  null;
	String alias_sub = null;
	String collectwho_sub = null;

	//데이터 백업 스플릿(하)
	String butterfly_name_sub = null;
	String butterfly_family_sub = null;
	String scientific_name_sub = null;
	String Specimen_date_sub = null;
	String status_sub = null;
	String sex_sub = null;
	String PreviousLoc1_sub = null;
	String PreviousLoc2_sub = null;
	String PreviousLoc3_sub = null;
	String NewLoc1_sub = null;
	String NewLoc2_sub = null;
	String NewLoc3_sub = null;
	String SpecimenWho_sub = null;

    @FXML
    void Oncheckbox_InsertSubData_1(ActionEvent event) {
    	if(checkbox_InsertSubData_1.isSelected()) {
            comboInsertSpecimenCollectway.getSelectionModel().select(Collectway_sub);
            dateInsertSpecimenCollectdate.getEditor().setText(Collect_date_sub);

            txtInsertSpecimenNation.setText(country_sub);
            txtInsertSpecimenCollectoc.setText(location_sub);
        	txtInsertSpecimenDo.setText(loc_1_sub);
        	txtInsertSpecimenSi.setText(loc_2_sub);
        	txtInsertSpecimenDong.setText(loc_3_sub);
        	txtInsertSpecimenLat.setText(gps_x_sub);
        	txtInsertSpecimenLong.setText(gps_y_sub);
        	txtInsertSpecimenLocname.setText(alias_sub);
        	txtWhoInsertSpecimen.setText(collectwho_sub);
    	}else {

    	    dateInsertSpecimenCollectdate.getEditor().clear();
	    	txtInsertSpecimenNation.clear();
	        txtInsertSpecimenCollectoc.clear();
	    	txtInsertSpecimenDo.clear();
	    	txtInsertSpecimenSi.clear();
	    	txtInsertSpecimenDong.clear();
	    	txtInsertSpecimenLat.clear();
	    	txtInsertSpecimenLong.clear();
	    	txtInsertSpecimenLocname.clear();
	    	txtWhoInsertSpecimen.clear();
    	}
    }
    
    @FXML
    void Oncheckbox_InsertSubData_2(ActionEvent event) {
    	if(checkbox_InsertSubData_2.isSelected()) {
    		txtInsertSpecimenBname.setText(butterfly_name_sub);
    		txtInsertSpecimenFamily.setText(butterfly_family_sub);
    		txtInsertSpecimenZoological.setText(scientific_name_sub);
    		dateInsertSpecimenDate.getEditor().setText(Specimen_date_sub);
    		comboInsertSpecimenStatus.getSelectionModel().select(status_sub);
    		comboInsertSpecimenSex.getSelectionModel().select(sex_sub); 
    		comboInsertSpecimenLoc1.getSelectionModel().select(PreviousLoc1_sub);
    		comboInsertSpecimenLoc2.getSelectionModel().select(PreviousLoc2_sub);
    		comboInsertSpecimenLoc3.getSelectionModel().select(PreviousLoc3_sub);
    		txtInsertLoc1.setText(NewLoc1_sub);
    		txtInsertLoc2.setText(NewLoc2_sub);
    		txtInsertLoc3.setText(NewLoc3_sub);
    		txtWhoWorkSpecimen.setText(SpecimenWho_sub);
    	} else {
    		txtInsertSpecimenBname.clear();
			txtInsertSpecimenFamily.clear();
			txtInsertSpecimenZoological.clear();
			dateInsertSpecimenDate.getEditor().clear();
			txtInsertLoc1.clear();
			txtInsertLoc2.clear();
			txtInsertLoc3.clear();
			txtWhoWorkSpecimen.clear();
    	}

    } 
    
    @FXML
    void OnPreviousImage(ActionEvent event) {

		//Set image
    	if(image_index <= 0) return;
    	
    	image_index--;

		File file = new File("HEART_Butterfly/img/kor/" + ImagePathList.get(image_index));
		Image image = new Image(file.toURI().toString());
		this.ImgSpecimen.setImage(image);
        System.out.println(this.ImagePathList.get(image_index));
    }
    
    @FXML
    void OnNextImage(ActionEvent event) {
		//Set image
    	if(image_index < ArraySize-1) {
			image_index++;

			File file = new File("HEART_Butterfly/img/kor/" + ImagePathList.get(image_index));
			Image image = new Image(file.toURI().toString());
			this.ImgSpecimen.setImage(image);
		    System.out.println(this.ImagePathList.get(image_index));
        }
    }
    
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
    	db = ((MSharedData)this.shared_model).getDB();
    	MDBCollectionInfo db_collection_info = new MDBCollectionInfo(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBLocation db_location = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBPerson db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
    	MDBButterflyGuide db_butterfly_guide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimenize db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimen db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
        MDBSpecimenIO db_specimenIO = new MDBSpecimenIO(((MSharedData)this.shared_model).getDB().getConnection());
        
      //스플릿 기준(상)
        String Collectway = comboInsertSpecimenCollectway.getSelectionModel().getSelectedItem();
    	String Collect_date = MDateConvertor.convert2DBFormat(dateInsertSpecimenCollectdate.getEditor().getText());
    	String country = txtInsertSpecimenNation.getText();
    	String location = txtInsertSpecimenCollectoc.getText();
    	String loc_1 = txtInsertSpecimenDo.getText();
    	String loc_2 = txtInsertSpecimenSi.getText();
    	String loc_3 = txtInsertSpecimenDong.getText();
    	String location_detail = loc_1 + " " + loc_2 + " " + loc_3;
        String gps_x = "0";
        String gps_y = "0";
        if(txtInsertSpecimenLat.getText().length() > 0) gps_x = txtInsertSpecimenLat.getText();
        if(txtInsertSpecimenLong.getText().length() > 0) gps_y = txtInsertSpecimenLong.getText();
        String gps =  gps_x + "," + gps_y;
    	String alias = txtInsertSpecimenLocname.getText();
    	String collectwho = txtWhoInsertSpecimen.getText();
    	
    	//데이터 백업 스플릿(상)
    	Collectway_sub = Collectway;
    	Collect_date_sub = Collect_date;
    	country_sub = country;
    	location_sub = location;
    	location_detail_sub = location_detail;
    	loc_1_sub = loc_1;
    	loc_2_sub = loc_2;
    	loc_3_sub = loc_3;
        gps_x_sub = gps_x;
        gps_y_sub = gps_x;
        gps_sub =  gps_x_sub + "," + gps_y_sub;
    	alias_sub = alias;
    	collectwho_sub = collectwho;
    	
    	//스플릿 기준(하)
    	
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
    	String SpecimenWho = txtWhoWorkSpecimen.getText();
    	
    	//데이터 백업 스플릿(하)
    	butterfly_name_sub = butterfly_name;
    	butterfly_family_sub = butterfly_family;
    	scientific_name_sub = scientific_name;
    	Specimen_date_sub = Specimen_date;
    	status_sub = status;
    	sex_sub = sex;
    	PreviousLoc1_sub = PreviousLoc1;
    	PreviousLoc2_sub = PreviousLoc2;
    	PreviousLoc3_sub = PreviousLoc3;
    	NewLoc1_sub = NewLoc1;
    	NewLoc2_sub = NewLoc2;
    	NewLoc3_sub = NewLoc3;
    	SpecimenWho_sub = SpecimenWho;

    	
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

        int error_code = 0;
        Alert error_popup = null;
        String idSpecimen = null;

        String collector = this.txtWhoInsertSpecimen.getText();
        String collecting_date = this.dateInsertSpecimenCollectdate.getEditor().getText();
        String location_alias = this.txtInsertSpecimenLocname.getText();
    	String LoadSpecimenID = "select distinct idSpecimen from Specimen where idSpecimen = '" + id_specimen + "'";
		ResultSet rsSpecimenID = db.selectQuery(LoadSpecimenID);
		
		try {
			while(rsSpecimenID.next()) {
				idSpecimen = rsSpecimenID.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if(collector.length() * collecting_date.length() * location_alias.length() == 0) error_code = 1;
        else if(idSpecimen == null) error_code = 2;

        switch(error_code) {
            case 0:
                SystemClipboard.copy(idSpecimen + "\n"
                        + collector + "\n"
                        + collecting_date + "\n"
                        + location_alias);
                break;
            case 1: // Empty Field Error
                error_popup = new Alert(Alert.AlertType.ERROR);
                error_popup.setTitle("레이블 복사");
                error_popup.setHeaderText(null);
                error_popup.setContentText("모든 정보를 입력해주세요.");
                error_popup.show();
                break;
            case 2:
                error_popup = new Alert(Alert.AlertType.ERROR);
                error_popup.setTitle("레이블 복사");
                error_popup.setHeaderText(null);
                error_popup.setContentText("표본ID를 특정할 수 없습니다.");
                error_popup.show();
                break;
            default:
                ((MSharedData)this.shared_model).getLogger().error("error code has a problem");
                break;
        }
        
        //초기화(init_proc_copy)

        
        dateInsertSpecimenCollectdate.getEditor().clear();
        txtInsertSpecimenNation.clear();
        txtInsertSpecimenCollectoc.clear();
        txtInsertSpecimenDo.clear();
        txtInsertSpecimenSi.clear();
        txtInsertSpecimenDong.clear();
        txtInsertSpecimenLocname.clear();
        txtWhoInsertSpecimen.clear();
        txtInsertSpecimenBname.clear();
        txtInsertSpecimenFamily.clear();
        txtInsertSpecimenZoological.clear();
        dateInsertSpecimenDate.getEditor().clear();
        txtWhoWorkSpecimen.clear();
        
        //체크박스 활성화
        if(Collectway_sub == null && Collect_date_sub == null
        		&& country_sub == null && location_sub == null 
        		&& location_detail_sub == null && PreviousLoc1_sub == null
        		&& PreviousLoc2_sub == null && PreviousLoc3_sub ==null
        		&& NewLoc1_sub == null && NewLoc2_sub == null
        		&& NewLoc3_sub == null && gps_x_sub == null
        		&& gps_y_sub == null && gps_sub == null
        		&& alias_sub == null && collectwho_sub == null) {
        	this.checkbox_InsertSubData_1.setDisable(true);
        }else {
        	this.checkbox_InsertSubData_1.setDisable(false);

        }
        if(butterfly_name_sub == null && butterfly_family_sub == null
        		&& scientific_name_sub == null && Specimen_date_sub == null 
        		&& status_sub == null && sex_sub == null
        		&& PreviousLoc2_sub == null && PreviousLoc3_sub ==null
        		&& SpecimenWho_sub == null) {
        	this.checkbox_InsertSubData_2.setDisable(true);
        }else {
        	this.checkbox_InsertSubData_2.setDisable(false);

        }
        
        }

    @FXML
    void bnameInsertSpecimen(ActionEvent event) {
        
        ResultSet result_ButterflyFamily = db.selectQuery("select distinct family from ButterflyGuide where name = " 
        + "'" + this.txtInsertSpecimenBname.getText() + "'");
        
        try {
			while(result_ButterflyFamily.next()) {
				this.txtInsertSpecimenFamily.setText(result_ButterflyFamily.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        ResultSet result_ButterflyZoological = db.selectQuery("select distinct scientific_name from ButterflyGuide where name = " 
        + "'" + this.txtInsertSpecimenBname.getText() + "'");
        
		try {
			while(result_ButterflyZoological.next()) {
				this.txtInsertSpecimenZoological.setText(result_ButterflyZoological.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        ResultSet result_ImagePath = db.selectQuery("select path "
        		+ "from Image inner join CollectionImage on Image.idImage = CollectionImage.idImage "
        		+ "inner join ButterflyGuide on CollectionImage.idButterflyGuide = ButterflyGuide.idButterflyGuide "
        		+ "where ButterflyGuide.name = '"
        		+ this.txtInsertSpecimenBname.getText() +"'");

		try{
            while(result_ImagePath.next()) {
				ImagePath = result_ImagePath.getString(1);
		        ImagePathList.add(ImagePath + ".jpg");
			}
    		//Set image
    		File file = new File("HEART_Butterfly/img/kor/" + ImagePathList.get(0));
    		Image image = new Image(file.toURI().toString());
    		this.ImgSpecimen.setImage(image);
	        System.out.println(this.ImagePathList.get(0));
	        ArraySize = ImagePathList.size();
	        System.out.println(ArraySize);

		} catch (SQLException e) {
            e.printStackTrace();
        }
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
    void OnPrintLabel(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertSpecimenPrintLabel.getScene().getWindow(), "VLabelManagement");
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
    		rsCabinet = db.selectQuery(queryCabinet);
    	}else {
            queryCabinet = "select distinct storageCabinet from Specimen where storageRoom='" + this.comboInsertSpecimenLoc1.getSelectionModel().getSelectedItem() + "'";
    		rsCabinet = db.selectQuery(queryCabinet);
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
    		rsBox = db.selectQuery(queryBox);
    	} else {
            queryBox = "select distinct storageChest from Specimen where storageCabinet='" + this.comboInsertSpecimenLoc2.getSelectionModel().getSelectedItem() + "'";
    		rsBox = db.selectQuery(queryBox);
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
        System.out.println("국가 고정값 확인: " + txtInsertSpecimenNation.getText());
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
    	db = ((MSharedData)this.shared_model).getDB();

 		this.comboInsertSpecimenLoc1.getItems().clear();
    	
    	this.comboInsertSpecimenLoc1.getItems().add("전체선택");

    	String queryRoom = "select distinct storageRoom from Specimen";
		ResultSet rsRoom = db.selectQuery(queryRoom);
		
		try {
			while(rsRoom.next()) {
				this.comboInsertSpecimenLoc1.getItems().add(rsRoom.getString(1));   // get storageRoom
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.comboInsertSpecimenCollectway.getItems().addAll("직접채집", "구입", "선물","기타");
		this.comboInsertSpecimenStatus.getItems().addAll("상", "중", "하","기타");
		this.comboInsertSpecimenSex.getItems().addAll("암", "수","기타");
        this.comboInsertSpecimenCollectway.getSelectionModel().select(0);
        this.comboInsertSpecimenStatus.getSelectionModel().select(0);
        this.comboInsertSpecimenSex.getSelectionModel().select(0);
		this.txtInsertLoc1.setDisable(true);
		this.txtInsertLoc2.setDisable(true);
		this.txtInsertLoc3.setDisable(true);
		this.comboInsertSpecimenLoc1.setDisable(true);
		this.comboInsertSpecimenLoc2.setDisable(true);
		this.comboInsertSpecimenLoc3.setDisable(true);

        /* Set Auto Complete */
        try {
            setAutoComplete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if(Collectway_sub == null && Collect_date_sub == null
        		&& country_sub == null && location_sub == null 
        		&& location_detail_sub == null && PreviousLoc1_sub == null
        		&& PreviousLoc2_sub == null && PreviousLoc3_sub ==null
        		&& NewLoc1_sub == null && NewLoc2_sub == null
        		&& NewLoc3_sub == null && gps_x_sub == null
        		&& gps_y_sub == null && gps_sub == null
        		&& alias_sub == null && collectwho_sub == null) {
        	this.checkbox_InsertSubData_1.setDisable(true);
        }else {
        	this.checkbox_InsertSubData_1.setDisable(false);

        }
        if(butterfly_name_sub == null && butterfly_family_sub == null
        		&& scientific_name_sub == null && Specimen_date_sub == null 
        		&& status_sub == null && sex_sub == null
        		&& PreviousLoc2_sub == null && PreviousLoc3_sub ==null
        		&& SpecimenWho_sub == null) {
        	this.checkbox_InsertSubData_2.setDisable(true);
        }else {
        	this.checkbox_InsertSubData_2.setDisable(false);

        }
        

        	
        
		
	  
		
		
        
    }

    @FXML
    void boxInsert(ActionEvent event) throws SQLException {
        view_update();
    }

    @Override
    public void passing_address(String country, String location, String locationDetail, String section, String alias) {
        String[] sectionSplit = section.split(" ");
        this.txtInsertSpecimenNation.setText(country);
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

    private void setAutoComplete() throws SQLException {
        ObservableList<String> name_autocomplete_list = FXCollections.observableArrayList();

        ResultSet result_ButterflyName = db.selectQuery("select distinct name from ButterflyGuide");
        while(result_ButterflyName.next()) {
            name_autocomplete_list.add(result_ButterflyName.getString(1));
        }
        TextFields.bindAutoCompletion(this.txtInsertSpecimenBname, name_autocomplete_list);
    }

    @Override
    public void passing_collection_info(String date, String country, String location, String locationDetail,
                                        String section, String sectionDetail, String loc_alias, String butter_name,
                                        String butter_family, String butter_sci, String method, String person_name) {
	    /* View Updating */
        this.comboInsertSpecimenCollectway.getSelectionModel().select(method);
        this.dateInsertSpecimenCollectdate.getEditor().setText(date);
        this.txtInsertSpecimenNation.setText(country);
        this.txtInsertSpecimenCollectoc.setText(location);
        this.txtInsertSpecimenDo.setText(locationDetail);
        this.txtInsertSpecimenSi.setText(section);
        this.txtInsertSpecimenDong.setText(sectionDetail);
        this.txtInsertSpecimenLocname.setText(loc_alias);
        this.txtInsertSpecimenBname.setText(butter_name);
        this.txtInsertSpecimenFamily.setText(butter_family);
        this.txtInsertSpecimenZoological.setText(butter_sci);
        this.txtWhoInsertSpecimen.setText(person_name);
    }

    @Override
    public void passing_specimen_info(String date, String country, String loc_alias, String butter_name, String butter_family, String person_name) {
        /* Not Implemented */
    }

    @Override
    public void passing_section_info(String nowSection, String maxSection) {
        /* Not Implemented */
    }
}