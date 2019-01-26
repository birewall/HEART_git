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

public class CInsertPicture extends AbsInsertController implements Initializable {

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
    private Button btnInsertSection;

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
    private Label txtResult;
    
    @FXML
    private Label lblSection;
    
    @FXML
    private Label lblMaxSection;

    public String getTextLblSection() {
		return lblSection.getText();
	}

	public void setTextLblSection(String Label) {
		this.lblSection.setText(Label);
	}

	public String getTextLblMaxSection() {
		return lblMaxSection.getText();
	}

	public void setTextLblMaxSection(String max_label) {
		this.lblMaxSection.setText(max_label);
	}

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
    	String section = lblSection.getText() + " / " + lblMaxSection.getText();
    	
    	/* DB Instance initialization */
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

        //db_location.printContents();
        int id_location = db_location.getIdLocationFromDB();
        if(id_location == 0) {
            if(!db_location.insert()){
                ((MSharedData)this.shared_model).getLogger().error("[CInsertPicture] Location Insert Failed.");
                return;
            }
            id_location = db_location.getIdLocationFromDB();
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
    	changeWindow(this.btnInsertPictureExit.getScene().getWindow(), "VImageView");
    }

    @FXML
    void quanInsertPicture(ActionEvent event) {

    }

    @FXML
    void remarkInsertPicture(ActionEvent event) {
    	
    }

    @FXML
    void searchLocInsertSection(ActionEvent event) throws IOException {
        /* Make Passing Data */
    	/*
        MPassingData parent_info = new MPassingData(1);
        parent_info.setData("CInsertPicture",0);
        ((MSharedData)(this.shared_model)).add(parent_info, "parent_name");

        spawnChildWindow(this.btnInsertPictureExit.getScene().getWindow(), "VSectionManagement");
        */
    }
    
    @FXML
    void searchLocInsertPicture(ActionEvent event) throws IOException {
        spawnChildWindow(this.btnInsertPictureExit.getScene().getWindow(), "VAddressBook");
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
		this.comboInsertPictureSex.getItems().addAll("암", "수", "불분명");
		this.comboInsertPictureQuan.getItems().addAll("1", "2", "3", "4마리 이상");
		this.comboInsertPictureLtype.getItems().addAll("핸드폰", "망원", "광각", "기타");
		this.comboInsertPictureBmove.getItems().addAll("비행", "착지", "식사", "기타");
		this.comboInsertPictureAng.getItems().addAll("정면도", "측면도", "사시도", "기타");
		this.comboInsertPictureWing.getItems().addAll("폄", "접음", "기타");		
		this.comboInsertPictureIscorrected.getItems().addAll("유", "무");
		this.comboInsertPictureBground.getItems().addAll("꽃", "암석", "나무", "기타");
		this.comboInsertPictureSize.getItems().addAll("대", "중", "소", "기타");
		this.comboInsertPictureFtype.getItems().addAll("jpg", "png", "bmp", "기타");

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

    @Override
    public void passing_address(String location, String locationDetail, String section, String alias) {
        String[] sectionSplit = section.split(" ");
        this.txtInsertPictureLoc.setText(location);
        this.txtInsertPictureDo.setText(locationDetail);
        if(sectionSplit.length == 1) {
            this.txtInsertPictureSi.setText(section);
            this.txtInsertPictureDong.setText(null);
        }else{
            this.txtInsertPictureSi.setText(sectionSplit[0]);
            this.txtInsertPictureDong.setText(sectionSplit[1]);
        }
        this.txtInsertPictureLocname.setText(alias);
    }

    @Override
    public void passing_collection_info(String date, String country, String loc_alias, String butter_name, String butter_family, String person_name) {
        /* View Updating */
        this.dateInsertPictureDate.getEditor().setText(date);
        this.txtInsertPictureNation.setText(country);
        this.txtInsertPictureLocname.setText(loc_alias);
        this.txtInsertPictureBname.setText(butter_name);
        this.txtInsertPictureFamily.setText(butter_family);
        this.comboInsertPictureWho.getSelectionModel().select(person_name);
    }

}
