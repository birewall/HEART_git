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
        String specimen_ID;

        public InquiryTableItem(String specimen_ID, String country, String collecting_date, String collector, String collecting_location, String butterfly_name, String butterfly_family) {
            this.specimen_ID = specimen_ID;
        	this.country = country;
            this.collecting_date = collecting_date;
            this.collector = collector;
            this.collecting_location = collecting_location;
            this.butterfly_name = butterfly_name;
            this.butterfly_family = butterfly_family;
        }

        public String getSpecimenID() {
            return specimen_ID;
        }

        public void setSpecimenID(String specimen_ID) {
            this.specimen_ID = specimen_ID;
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
    private TableColumn<InquiryTableItem, String> tclSpecimenID;

    @FXML
    private ImageView imvButterflyImage;

    @FXML
    private ComboBox<String> cmbCountry;

    @FXML
    private ComboBox<String> cmbCollectingYear;
    
    @FXML
    private ComboBox<String> cmbCollectingMonth;

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
        
        String Country = cmbCountry.getSelectionModel().getSelectedItem();
        //String Year = 
        String Collector = cmbCollector.getSelectionModel().getSelectedItem();
        String Location = 
        //String ButterflyName = 
        //String ButterflyFName =
        //String Method = 
        
        
        
        // Complete the query
        query = "Select";
        
        System.out.println(query);
        

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
    void OnPrintLabel(ActionEvent event) throws IOException {
        /* Copy Table Item to Clipboard */
    	changeWindow(this.btnPrevious.getScene().getWindow(), "VSpecimenLabel");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
	   	 tclSpecimenID.setCellValueFactory(new PropertyValueFactory<>("specimen_ID")); 
	   	 tclCountry.setCellValueFactory(new PropertyValueFactory<>("country")); 
	   	 tclCollectingDate.setCellValueFactory(new PropertyValueFactory<>("collecting_date"));
	   	 tclCollector.setCellValueFactory(new PropertyValueFactory<>("collector"));
	   	 tclCollectingLocate.setCellValueFactory(new PropertyValueFactory<>("collecting_location"));
	   	 tclButterflyName.setCellValueFactory(new PropertyValueFactory<>("butterfly_name"));
	   	 tclButterflyFamily.setCellValueFactory(new PropertyValueFactory<>("butterfly_family"));
	   	 
	   	 tblInquiry.setRowFactory( tv -> {
	   		 TableRow<InquiryTableItem> row = new TableRow<>();
	   		 row.setOnMouseClicked(event -> {
	   			 if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
	   				 InquiryTableItem rowData = row.getItem();
	   				 String PathCountry = rowData.getCountry();
	   				 System.out.println(PathCountry);
	   			 }
	   		 });
	   		 return row ;
	   	 });
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
	        
    	 String InitialTblSetting = "SELECT distinct A.idSpecimen, C.country, B.date, D.name, C.alias, E.name, E.family "
    	 		+ "FROM Specimen AS A inner join CollectionInfo AS B on A.idCollectionInfo=B.idCollectionInfo "
    	 		+ "inner join Location AS C on B.idLocation=C.idLocation "
    	 		+ "inner join Person AS D on B.idPerson=D.idPerson "
    	 		+ "inner join ButterflyGuide AS E on B.idButterflyGuide=E.idButterflyGuide "
    	 		+ "ORDER BY date DESC limit 1000";

			try {
				rs = db_location.selectQuery(InitialTblSetting);
				while(rs.next()) {
					InquiryTableItem item = new InquiryTableItem(rs.getString(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7));
					this.tblInquiry.getItems().add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
			
	        /* Initialize Combo Box */

			/*Country*/
	   	 	String InitialCountry = null;
		   	ResultSet rsCountry = null;
		     
			InitialCountry = "SELECT distinct country from Location";
			rsCountry = db_location.selectQuery(InitialCountry);
			try {
				while(rsCountry.next()) {
			        this.cmbCountry.getItems().add(rsCountry.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        /*Collector*/
	   	 	String InitialCollector = null;
		   	ResultSet rsCollector = null;
			InitialCollector = "SELECT distinct name from Person";
			rsCollector = db_person.selectQuery(InitialCollector);
			try {
				while(rsCollector.next()) {
			        this.cmbCollector.getItems().add(rsCollector.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        /*Collection Year*/
	   	 	String InitialCollectionYear = null;
		   	ResultSet rsCollectionYear = null;
			InitialCollectionYear = "SELECT distinct left(date, 4) from CollectionInfo";
			rsCollectionYear = db_collectionInfo.selectQuery(InitialCollectionYear);
			try {
				while(rsCollectionYear.next()) {
					String CollectingYear = rsCollectionYear.getString(1);
			        this.cmbCollectingYear.getItems().add(CollectingYear);
			        System.out.println(CollectingYear);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        /*Collection Month*/
			this.cmbCollectingMonth.getItems().addAll("01", "02", "03", "04", "05", "06,", "07", "08", "09", "10", "11", "12");

	        /*Collection Method*/
	   	 	String InitialMethod = null;
		   	ResultSet rsMethod = null;
			InitialMethod = "SELECT distinct method from CollectionInfo";
			rsMethod = db_collectionInfo.selectQuery(InitialMethod);
			try {
				while(rsMethod.next()) {
			        this.cmbCollectingMethod.getItems().add(rsMethod.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }
}
