package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

import Model.MDBButterflyGuide;
import Model.MDBCameraInfo;
import Model.MDBCollectionInfo;
import Model.MDBImage;
import Model.MDBImageObjectInfo;
import Model.MDBLocation;
import Model.MDBObservation;
import Model.MDBPerson;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class CInsertPicture extends AbsMetaController implements Initializable {

	MDBPerson PersonDB;
	MDBImage ImageDB;

    @FXML
    private DatePicker dateInsertPictureDate;

    @FXML
    private ComboBox<String> comboInsertPictureTime;

    @FXML
    private TextField txtInsertPictureLoc;

    @FXML
    private Button btnInsertPictureSearchLoc;

    @FXML
    private ComboBox<String> comboInsertPictureWho;

    @FXML
    private Button btnInsertPictureChoosewho;

    @FXML
    private Button btnInsertPictureClear;

    @FXML
    private TextField txtInsertPictureBname;

    @FXML
    private TextField txtInsertPictureFamily;

    @FXML
    private TextField txtInsertPictureZoological;

    @FXML
    private ComboBox<String> comboInsertPictureSex;
    
    @FXML
    private ImageView ImvImage;

    @FXML
    private Button btnInsertPictureAdd;

    @FXML
    private Button btnInsertPictureExit;

    @FXML
    private ComboBox<String> comboInsertPictureLtype;

    @FXML
    private ComboBox<String> comboInsertPictureBmove;

    @FXML
    private ComboBox<String> comboInsertPictureBground;

    @FXML
    private ComboBox<String> comboInsertPictureWing;

    @FXML
    private ComboBox<String> comboInsertPictureSize;

    @FXML
    private ComboBox<String> comboInsertPictureIscorrected;

    @FXML
    private ComboBox<String> comboInsertPictureFtype;

    @FXML
    private TextField txtInsertPictureSpath;

    @FXML
    private TextField txtInsertPictureRemark;

    @FXML
    private TextField txtInsertPictureNation;

    @FXML
    private TextField txtInsertPictureDo;

    @FXML
    private TextField txtInsertPictureSi;

    @FXML
    private TextField txtInsertPictureDong;

    @FXML
    private TextField txtInsertPictureLat;

    @FXML
    private TextField txtInsertPictureLong;

    @FXML
    private TextField txtInsertPictureLocname;

    @FXML
    private Label lblLoadPictureStatus;
    
    @FXML
    private ComboBox<String> comboInsertPictureAng;

    @FXML
    private ComboBox<String> comboInsertPictureQuan;

    @FXML
    private CheckBox cboxInsertPictureMatching;

    @FXML
    private ToggleGroup matingToggle;

    @FXML
    private Button btnInsertPictureCorrect;

    @FXML
    private Button btnInsertPicturepicture;

    @FXML
    private TextField txtInsertPictureSecremark;

    @FXML
    private RadioButton radioInsertPicturesec6;

    @FXML
    private ToggleGroup sectionToggle1;

    @FXML
    private RadioButton radioInsertPicturesec7;

    @FXML
    private RadioButton radioInsertPicturesec8;

    @FXML
    private RadioButton radioInsertPicturesec9;

    @FXML
    private RadioButton radioInsertPicturesec10;

    @FXML
    private RadioButton radioInsertPicturesec5;

    @FXML
    private RadioButton radioInsertPicturesec4;

    @FXML
    private RadioButton radioInsertPicturesec3;

    @FXML
    private RadioButton radioInsertPicturesec2;

    @FXML
    private RadioButton radioInsertPicturesec1;

    @FXML
    void BlocInsertPicture(ActionEvent event) {

    }

    @FXML
    void BmoveInsertPicture(ActionEvent event) {

    }

    @FXML
    void NationInsertPicture(ActionEvent event) {

    }

    @FXML
    void addInsertPicture(ActionEvent event) {
        /* Data Acquisition */
   
    	String date = dateInsertPictureDate.getEditor().getText();
    	String time = comboInsertPictureTime.getSelectionModel().getSelectedItem();
    	String country = txtInsertPictureNation.getText();
    	String location = txtInsertPictureLoc.getText();
    	String location_detail = txtInsertPictureDo.getText() + " " + txtInsertPictureSi.getText() + " " + txtInsertPictureDong.getText();
    	String gps = txtInsertPictureLat.getText() + "," + txtInsertPictureLong.getText();
    	String alias = txtInsertPictureLocname.getText();
    	String section = matingToggle.getSelectedToggle().toString();
    	String section_detail = txtInsertPictureSecremark.getText();
    	String person_name = comboInsertPictureWho.getSelectionModel().getSelectedItem();
    	String butterfly_name = txtInsertPictureBname.getText();
    	String butterfly_family = txtInsertPictureFamily.getText();
    	String scientific_name = txtInsertPictureZoological.getText();
    	String sex = (String)comboInsertPictureSex.getSelectionModel().getSelectedItem();
    	String moving = comboInsertPictureAng.getSelectionModel().getSelectedItem();
    	String wing_status = comboInsertPictureWing.getSelectionModel().getSelectedItem();
    	String b_move = comboInsertPictureBmove.getSelectionModel().getSelectedItem();
    	String type_lens = comboInsertPictureLtype.getSelectionModel().getSelectedItem();
    	String pic_correction = comboInsertPictureIscorrected.getSelectionModel().getSelectedItem();
    	String pic_quantity = comboInsertPictureQuan.getSelectionModel().getSelectedItem();
    	String background = comboInsertPictureBground.getSelectionModel().getSelectedItem();
    	String pic_size = comboInsertPictureSize.getSelectionModel().getSelectedItem();
    	String file_type = comboInsertPictureFtype.getSelectionModel().getSelectedItem();
    	String matching = cboxInsertPictureMatching.getText();
    	String note = txtInsertPictureRemark.getText();

    	/* DB Instance initialization */
        MDBButterflyGuide db_butterfly_guide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
        MDBPerson db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        MDBLocation db_location = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
        MDBImage db_image = new MDBImage(((MSharedData)this.shared_model).getDB().getConnection());
        MDBImageObjectInfo db_image_object = new MDBImageObjectInfo(((MSharedData)this.shared_model).getDB().getConnection());
        MDBCameraInfo db_camera = new MDBCameraInfo(((MSharedData)this.shared_model).getDB().getConnection());

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
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] Location Insert Failed.");
                return;
            }
            id_location = db_location.getIdLocationFromDB();
        }

        db_person.setName(person_name);
        db_person.setSort("촬영자");
        int id_person = db_person.getIdPersonFromDB();
        if(id_person == 0) {
            db_person.insert();
            if(!db_person.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] Person Insert Failed.");
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
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] ButterflyGuide Insert Failed.");
                return;
            }
            id_butterflyGuide = db_butterfly_guide.getIdButterflyGuideFromDB();
        }

        db_camera.setLens(type_lens);
        db_camera.setFormat(file_type);
        db_camera.setCalibration(pic_correction);
        int id_camera = db_camera.getIdCameraInfoFromDB();
        if(id_camera == 0) {
            db_camera.insert();
            if(!db_camera.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] CameraInfo Insert Failed.");
                return;
            }
            id_camera = db_camera.getIdCameraInfoFromDB();
        }
        
        db_image_object.setSize(pic_size);
        db_image_object.setWing(wing_status);
        db_image_object.setBackground(background);
        db_image_object.setStatus(b_move);
        db_image_object.setSex(sex);
        db_image_object.setNumber(Integer.parseInt(pic_quantity));
        db_image_object.setMarriage(matching);
        int id_image_object = db_image_object.getIdImageObjectInfoFromDB();
        if(id_image_object == 0) {
            db_image_object.insert();
            if(!db_image_object.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] ImageObjectInfo Insert Failed.");
                return;
            }
            id_image_object = db_image_object.getIdImageObjectInfoFromDB();
        }
        
        db_image.setIdLocation(id_location);
        db_image.setIdImageObjectInfo(id_image_object);
        db_image.setIdCameraInfo(id_camera);
        db_image.setDate(date);
        db_image.setTime(time);
        db_image.setPath(filepath);
        int id_image = db_image.getIdImageFromDB();
        if(id_image == 0) {
            db_image.insert();
            if(!db_image.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] Image Insert Failed.");
                return;
            }
            id_butterflyGuide = db_butterfly_guide.getIdButterflyGuideFromDB();
        }
        
        this.txtInsertPictureSpath.setText(filepath);
    }

    @FXML
    void bgroundInsertPicture(ActionEvent event) {

    }

    @FXML
    void bnameInsertPicture(ActionEvent event) {

    }

    @FXML
    void choosewhoInsertPicture(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Insert New Name");
		dialog.setHeaderText(null);
		dialog.setContentText(null);
		dialog.showAndWait();
		String new_name = dialog.getEditor().getText();

		PersonDB.setName(new_name);
		PersonDB.setSort("촬영자");
		if(!PersonDB.insert()) System.out.println("Failed.");
		
		this.comboInsertPictureWho.getItems().add(new_name);
    }

    @FXML
    void clearInsertPicture(ActionEvent event) {
        MDBPerson person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        person.delete_by_type("촬영자");
        this.comboInsertPictureWho.getItems().clear();
    }

    @FXML
    void correctInsertPicture(ActionEvent event) {

    }

    @FXML
    void dateInsertPicture(ActionEvent event) {

    }

    @FXML
    void doInsertPicture(ActionEvent event) {

    }

    @FXML
    void dongInsertPicture(ActionEvent event) {

    }

    @FXML
    void exitInsertPicture(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertPictureExit.getScene().getWindow(), "VInsert");
    }

    @FXML
    void familyInsertPicture(ActionEvent event) {

    }

    @FXML
    void ftypeInsertPicture(ActionEvent event) {

    }

    @FXML
    void iscorrectedInsertPicture(ActionEvent event) {

    }

    @FXML
    void latInsertPicture(ActionEvent event) {

    }

    @FXML
    void locInsertPicture(ActionEvent event) {

    }

    @FXML
    void locnameInsertPicture(ActionEvent event) {

    }

    @FXML
    void longInsertPicture(ActionEvent event) {

    }

    @FXML
    void ltypeInsertPicture(ActionEvent event) {

    }

    @FXML
    void matingInsertPicture(ActionEvent event) {

    }
    
    File ImageSelectedFile;
    String filepath;
    
    @FXML
    void pictureInsertPicture(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File ("C:/Temp"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("jpg files","*.jpg"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("png files", "*.png"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("bmp files", "*.bmp"));
        ImageSelectedFile = fc.showOpenDialog(null);
        if(ImageSelectedFile == null){
            this.lblLoadPictureStatus.setText("File is not valid");
            return;
        }
        else{
        	this.lblLoadPictureStatus.setText("File is loaded");
        	
        	BufferedReader reader = new BufferedReader(
	    			new FileReader(ImageSelectedFile));
        	
    		if(ImageSelectedFile.getAbsolutePath() == null) return;
    		String filename = ImageSelectedFile.getName();
    		
    		//Determine path
    		filepath = ImageSelectedFile.getAbsolutePath();

    		
    		//Set image at view
    		File file = new File(filepath);
    		Image image = new Image(file.toURI().toString());
    		this.ImvImage.setImage(image);
        }
    }

    @FXML
    void quanInsertPicture(ActionEvent event) {

    }

    @FXML
    void remarkInsertPicture(ActionEvent event) {

    }

    @FXML
    void searchLocInsertPicture(ActionEvent event) {

    }

    @FXML
    void sec10InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec1InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec2InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec3InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec4InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec5InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec6InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec7InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec8InsertPicture(ActionEvent event) {

    }

    @FXML
    void sec9InsertPicture(ActionEvent event) {

    }

    @FXML
    void secremarkInsertWatch(ActionEvent event) {

    }

    @FXML
    void sexInsertPicture(ActionEvent event) {

    }

    @FXML
    void siInsertPicture(ActionEvent event) {

    }

    @FXML
    void sizeInsertPicture(ActionEvent event) {

    }

    @FXML
    void spathInsertPicture(ActionEvent event) {

    }

    @FXML
    void timeInsertPicture(ActionEvent event) {

    }

    @FXML
    void whoInsertPicture(ActionEvent event) {

    }

    @FXML
    void wingInsertPicture(ActionEvent event) {

    }

    @FXML
    void zoologicalInsertPicture(ActionEvent event) {

    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.comboInsertPictureTime.getItems().addAll("새벽", "오전", "오후", "저녁");
		this.comboInsertPictureSex.getItems().addAll("암", "수");
		this.comboInsertPictureQuan.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		this.comboInsertPictureLtype.getItems().addAll("핸드폰", "망원", "광각");
		this.comboInsertPictureBmove.getItems().addAll("비행", "정지");
		this.comboInsertPictureAng.getItems().addAll("정면도", "측면도", "사시도");
		this.comboInsertPictureWing.getItems().addAll("펼침", "닫힘");		
		this.comboInsertPictureIscorrected.getItems().addAll("유", "무");
		this.comboInsertPictureBground.getItems().addAll("꽃", "암석", "나무");
		this.comboInsertPictureSize.getItems().addAll("대", "중", "소");
		this.comboInsertPictureFtype.getItems().addAll("jpg", "png", "bmp");
	}

	@Override
	public void init_procedure() {
		// Set Watcher
		String query = "select name from Person where sort = '촬영자'";
		System.out.println(this.shared_model);
		PersonDB = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
		ResultSet rs = PersonDB.selectQuery(query);
		try {
			while(rs.next()) {
				this.comboInsertPictureWho.getItems().add(rs.getString(1));   // get name
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
