package Controller;

import Model.MDBButterflyGuide;
import Model.MDBCollectionInfo;
import Model.MDBLocation;
import Model.MDBPerson;
import Model.MDBSpecimen;
import Model.MDBSpecimenize;
import Model.MDatabase;
import Model.MSharedData;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CInquiry extends AbsMetaController implements Initializable {
	
    MDBSpecimen db_specimen=null;
    MDBSpecimenize db_specimenize=null;
    MDBLocation db_location=null;
    MDBCollectionInfo db_collectionInfo=null;
    MDBPerson db_person=null;
    MDBButterflyGuide db_butterflyGuide=null;

    /* Class for Table */
    public class InquiryTableItem {
        String country;
        String collecting_date;
        String collector;
        String collecting_location;
        String butterfly_name;
        String butterfly_family;

        public InquiryTableItem(String country, String collecting_date, String collector, String collecting_location, String butterfly_name, String butterfly_family) {
            this.country = country;
            this.collecting_date = collecting_date;
            this.collector = collector;
            this.collecting_location = collecting_location;
            this.butterfly_name = butterfly_name;
            this.butterfly_family = butterfly_family;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCollecting_date() {
            return collecting_date;
        }

        public void setCollecting_date(String collecting_date) {
            this.collecting_date = collecting_date;
        }

        public String getCollector() {
            return collector;
        }

        public void setCollector(String collector) {
            this.collector = collector;
        }

        public String getCollecting_location() {
            return collecting_location;
        }

        public void setCollecting_location(String collecting_location) {
            this.collecting_location = collecting_location;
        }

        public String getButterfly_name() {
            return butterfly_name;
        }

        public void setButterfly_name(String butterfly_name) {
            this.butterfly_name = butterfly_name;
        }

        public String getButterfly_family() {
            return butterfly_family;
        }

        public void setButterfly_family(String butterfly_family) {
            this.butterfly_family = butterfly_family;
        }
    }

    @FXML
    private TableView<InquiryTableItem> tblInquiry;

    @FXML
    private TableColumn<InquiryTableItem, String> tclCountry;

    @FXML
    private TableColumn<InquiryTableItem, String> tclCollectingDate;

    @FXML
    private TableColumn<InquiryTableItem, String> tclCollector;

    @FXML
    private TableColumn<InquiryTableItem, String> tclCollectingLocate;

    @FXML
    private TableColumn<InquiryTableItem, String> tclButterflyName;

    @FXML
    private TableColumn<InquiryTableItem, String> tclButterflyFamily;

    @FXML
    private ImageView imvButterflyImage;

    @FXML
    private ComboBox<String> cmbCountry;

    @FXML
    private ComboBox<String> cmbCollectingDate;

    @FXML
    private ComboBox<String> cmbCollector;

    @FXML
    private ComboBox<String> cmbCollectingMethod;

    @FXML
    private TextField txtCollectingLocation;

    @FXML
    private TextField txtButterflyName;

    @FXML
    private TextField txtButterflyFamily;

    @FXML
    private Button btnPrintLabel;

    @FXML
    private Button btnInquiry;

    @FXML
    private Button btnDetailView;

    @FXML
    private Button btnPrevious;

    @FXML
    void OnButterflyFamily(ActionEvent event) {

    }

    @FXML
    void OnButterflyName(ActionEvent event) {

    }

    @FXML
    void OnCollectingLocation(ActionEvent event) {

    }

    @FXML
    void OnDetailView(ActionEvent event) {
        Alert msgBox = new Alert(Alert.AlertType.WARNING);
        msgBox.setTitle("상세보기");
        msgBox.setHeaderText(null);
        msgBox.setContentText("미구현");

        /* 추후 구현 필요 */
    }

    @FXML
    void OnInquiry(ActionEvent event) throws SQLException {
        /* DB Inquiry */
        String query = null;

        // Complete the query

        /* Send Query */
        ResultSet result_query = ((MSharedData)this.shared_model).getDB().selectQuery(query);

        /* Apply to TableView */
        while(result_query.next()) {
            /* Add Itemp to TableView */

        }
    }

    @FXML
    void OnPrevious(ActionEvent event) throws IOException {
        changeWindow(this.btnDetailView.getScene().getWindow(), "VMain");
    }

    @FXML
    void OnPrintLabel(ActionEvent event) {
        /* Copy Table Item to Clipboard */
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
   	 tclCountry.setCellValueFactory(new PropertyValueFactory<>("country")); 
   	 tclCollectingDate.setCellValueFactory(new PropertyValueFactory<>("collecting_date"));
   	 tclCollector.setCellValueFactory(new PropertyValueFactory<>("collector"));
   	 tclCollectingLocate.setCellValueFactory(new PropertyValueFactory<>("collecting_location"));
   	 tclButterflyName.setCellValueFactory(new PropertyValueFactory<>("butterfly_name"));
   	 tclButterflyFamily.setCellValueFactory(new PropertyValueFactory<>("butterfly_family"));
	    	 
        /* Initialize Combo Bos */
        // 국가 채우기
        // 전체, 한국, 곰국 등
        // this.cmbCountry

        // 수집자 채우기
        // 전체, 문문문, 조까치, 최소쌍녀 등
        // this.cmbCollector

        // 수집 날짜 채우기
        // 전체, 2000년 이전, 2000~2010, 2010~현재 등
        // this.cmbCollectingDate

        // 수집 방법 채우기
        // 전체, 채집, 선물, 교환 등
        // this.cmbCollectingMethod

    }
    
    @Override
    public void init_procedure() {

    	/* DB Instance initialization */
    	 db_location = new MDBLocation(((MSharedData)this.shared_model).getDB().getConnection());
    	 db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
    	 db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());
    	 db_butterflyGuide = new MDBButterflyGuide(((MSharedData)this.shared_model).getDB().getConnection());
    	 db_collectionInfo = new MDBCollectionInfo(((MSharedData)this.shared_model).getDB().getConnection());
    	 db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
    	 
	     ResultSet rs = null;
	        
    	 String InitialTblSetting = "SELECT distinct A.country, B.date, C.name, A.alias, D.name, D.family "
    	 		+ "FROM Location AS A, CollectionInfo AS B, Person AS C, ButterflyGuide AS D ORDER BY date DESC limit 1000";

			try {
				rs = db_location.selectQuery(InitialTblSetting);
				while(rs.next()) {
					InquiryTableItem item = new InquiryTableItem(rs.getString(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getString(4),
							rs.getString(5),
							rs.getString(6));
					
					this.tblInquiry.getItems().add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
    }
}
