package Controller;

import java.io.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CInsertPicture extends AbsMetaController implements Initializable {

	MDBPerson PersonDB;
	String filepath;
	File selectedFile;

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
    private Button btnInsertPicturePersonManagement;

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
    private Label txtResult;

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
        /* View Updating */
        this.txtResult.setText("사진을 저장중입니다...");

        /* File Copy */
        String dest_filename = null;
        try {
            FileInputStream fis = new FileInputStream(selectedFile.getAbsoluteFile());
            dest_filename = "HEART_Butterfly/img/" + selectedFile.getName();
            FileOutputStream fos = new FileOutputStream(dest_filename);

            int data = 0;
            while((data=fis.read())!=-1) {
                fos.write(data);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Data Acquisition */
    	String date = MDateConvertor.convert2DBFormat(dateInsertPictureDate.getEditor().getText());
    	String time = comboInsertPictureTime.getSelectionModel().getSelectedItem();
    	String country = txtInsertPictureNation.getText();
    	String location = txtInsertPictureLoc.getText();
    	String location_detail = txtInsertPictureDo.getText() + " " + txtInsertPictureSi.getText() + " " + txtInsertPictureDong.getText();

    	String gps_x = "0";
        String gps_y = "0";
        if(txtInsertPictureLat.getText().length() > 0) gps_x = txtInsertPictureLat.getText();
        if(txtInsertPictureLong.getText().length() > 0) gps_y = txtInsertPictureLong.getText();
        String gps =  gps_x + "," + gps_y;

    	String alias = txtInsertPictureLocname.getText();

        String section = null;
    	if(this.sectionToggle1.getSelectedToggle() != null) {
            section = (String)sectionToggle1.getSelectedToggle().getUserData();
        }

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
    	String matching = cboxInsertPictureMatching.isSelected()?"y":"n";
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
        //db_location.printContents();
        int id_location = db_location.getIdLocationFromDB();
        if(id_location == 0) {
            if(!db_location.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] Location Insert Failed.");
                return;
            }
            id_location = db_location.getIdLocationFromDB();
        }

        db_person.setName(person_name);
        int id_person = db_person.getIdPersonFromDB();
        if(id_person == 0) {
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
        if(pic_quantity == null) db_image_object.setNumber(0);
        else db_image_object.setNumber(Integer.parseInt(pic_quantity));
        db_image_object.setMarriage(matching);
        int id_image_object = db_image_object.getIdImageObjectInfoFromDB();
        if(id_image_object == 0) {
            if(!db_image_object.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] ImageObjectInfo Insert Failed.");
                return;
            }
            id_image_object = db_image_object.getIdImageObjectInfoFromDB();
        }
        
        db_image.setIdLocation(id_location);
        db_image.setIdImageObjectInfo(id_image_object);
        db_image.setIdCameraInfo(id_camera);
        db_image.setIdButterflyGuide(id_butterflyGuide);
        db_image.setDate(date);
        db_image.setTime(time);
        db_image.setPath(dest_filename);
        int id_image = db_image.getIdImageFromDB();
        if(id_image == 0) {
            if(!db_image.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] Image Insert Failed.");
                return;
            }
        }

        /* View Updating */
        this.txtInsertPictureSpath.setText(filepath);
        this.txtResult.setText("사진 저장이 완료되었습니다.");
    }

    @FXML
    void bgroundInsertPicture(ActionEvent event) {

    }

    @FXML
    void bnameInsertPicture(ActionEvent event) {

    }

    @FXML
    void OnPersonManagement(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertPictureExit.getScene().getWindow(), "VPersonManager");
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

    /*
     *   Load selectedFile and filepath
     *   and update imageView
     * */
    @FXML
    void pictureInsertPicture(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        //fc.setInitialDirectory(new File("./HEART_Butterfly/img"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("images","*.jpg", "*.png", ".bmp", ".tif", ".gif"));

        selectedFile = fc.showOpenDialog(null);
        /* Error Handling */
        if(selectedFile == null){
            return;
        }

        String dest_filename = "HEART_Butterfly/img/" + selectedFile.getName();
        File f1 = new File(dest_filename);

        if(f1.exists()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("불러오기 실패");
            alert.setHeaderText(null);
            alert.setContentText("이미 존재하는 사진입니다.");
            alert.show();
            return;
        }

        /* View Updating */
        File file = this.selectedFile;
        Image image = new Image(file.toURI().toString());
        this.ImvImage.setImage(image);
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

    public void update_person() {
        /* Clear All Names from List */
        this.comboInsertPictureWho.getItems().clear();

        /* DB Querying */
        String query = "select name from Person";
        PersonDB = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        ResultSet rs = PersonDB.selectQuery(query);
        try {
            while(rs.next()) {
                /* View Updating */
                this.comboInsertPictureWho.getItems().add(rs.getString(1));   // get name
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Initializing */
        if(this.comboInsertPictureWho.getItems().size() > 0) this.comboInsertPictureWho.getSelectionModel().select("조윤호"); // DB에 '조윤호'는 반드시 존재한다.
    }

    @Override
    public void view_update() {
        update_person();
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

        this.comboInsertPictureTime.getSelectionModel().select(0);
        this.comboInsertPictureSex.getSelectionModel().select(0);
        this.comboInsertPictureQuan.getSelectionModel().select(0);
        this.comboInsertPictureLtype.getSelectionModel().select(0);
        this.comboInsertPictureBmove.getSelectionModel().select(0);
        this.comboInsertPictureAng.getSelectionModel().select(0);
        this.comboInsertPictureWing.getSelectionModel().select(0);
        this.comboInsertPictureIscorrected.getSelectionModel().select(0);
        this.comboInsertPictureBground.getSelectionModel().select(0);
        this.comboInsertPictureSize.getSelectionModel().select(0);
        this.comboInsertPictureFtype.getSelectionModel().select(0);
    }

	@Override
	public void init_procedure() {
		view_update();
    }
}
