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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.controlsfx.control.textfield.TextFields;

public class CInquiry extends AbsMetaController implements Initializable {

    MDatabase db = null;
    String ImagePath=null;

    /* Class for Table */
    public class InquiryTableItem {
        private String country;
        private String collecting_date;
        private String collector;
        private String collecting_location;
        private String butterfly_name;
        private String butterfly_family;
        private String specimen_ID;

        public InquiryTableItem(String specimen_ID, String country, String collecting_date, String collector, String collecting_location, String butterfly_name, String butterfly_family) {
            this.specimen_ID = specimen_ID;
            this.country = country;
            this.collecting_date = collecting_date;
            this.collector = collector;
            this.collecting_location = collecting_location;
            this.butterfly_name = butterfly_name;
            this.butterfly_family = butterfly_family;
        }

        public String getSpecimen_ID() {
            return specimen_ID;
        }

        public void setSpecimen_ID(String specimen_ID) {
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
    private TextField txtIDSpecimen;
    
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

        tblInquiry.getItems().clear();

        String query = null;

        String ID_Specimen = txtIDSpecimen.getText();
        String Country = cmbCountry.getSelectionModel().getSelectedItem();
        String Year = cmbCollectingYear.getSelectionModel().getSelectedItem();
        String Month = cmbCollectingMonth.getSelectionModel().getSelectedItem();
        String Collector = cmbCollector.getSelectionModel().getSelectedItem();
        String Location = txtCollectingLocation.getText();
        String ButterflyName = txtButterflyName.getText();
        String ButterflyFName = txtButterflyFamily.getText();
        String Method = cmbCollectingMethod.getSelectionModel().getSelectedItem();

        query = "select e.idSpecimen, b.country, a.date, c.name, b.alias, d.name, d.family \n" +
                "from Butterfly.CollectionInfo as a \n" +
                "inner join Butterfly.Location as b on a.idLocation = b.idLocation \n" +
                "inner join Butterfly.Person as c on a.idPerson = c.idPerson \n" +
                "inner join Butterfly.ButterflyGuide as d on a.idButterflyGuide = d.idButterflyGuide \n" +
                "inner join Butterfly.Specimen as e on a.idCollectionInfo = e.idCollectionInfo \n";

        boolean where_not_used = true;

        if(ID_Specimen == "전체") {
        	ID_Specimen = null;
        }
        
        if(Country == "전체") {
            Country = null;
        }
        if(Year == "전체") {
            Year = null;
        }
        if(Month == "전체") {
            Month = null;
        }
        if(Collector == "전체") {
            Collector = null;
        }
        if(Location == "전체") {
            Location = null;
        }
        if(ButterflyName == "전체") {
            ButterflyName = null;
        }
        if(ButterflyFName == "전체") {
            ButterflyFName = null;
        }
        if(Method == "전체") {
            Method = null;
        }

        
        if (ID_Specimen.length() != 0) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " e.idSpecimen = '" + ID_Specimen + "'";
        }
        
        if (Country != null) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " b.country = '" + Country + "'";
        }

        if (Year != null) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " left(a.date,4) = '" + Year + "'";
        }

        if (Month != null) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " substr(a.date,5,2) = '" + Month + "'";
        }

        if (Collector != null) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " c.name = '" + Collector + "'";
        }

        if (Location.length() != 0) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " b.alias = '" + Location + "'";
        }

        if (ButterflyName.length() != 0) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " d.name = '" + ButterflyName + "'";
        }

        if (ButterflyFName.length() != 0) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " d.family = '" + ButterflyFName + "'";
        }

        if (Method != null ) {
            if (where_not_used) {
                query += " where";
                where_not_used = false;
            } else {
                query += " and";
            }
            query += " a.method = '" + Method + "'";
        }

        // Complete the query

        System.out.println(query);

        /* Send Query */
        ResultSet result_query = ((MSharedData)this.shared_model).getDB().selectQuery(query);

        /* Apply to TableView */
        while(result_query.next()) {
            /* Add Itemp to TableView */
            InquiryTableItem item = new InquiryTableItem(result_query.getString(1),
                    result_query.getString(2),
                    result_query.getString(3),
                    result_query.getString(4),
                    result_query.getString(5),
                    result_query.getString(6),
                    result_query.getString(7));
            this.tblInquiry.getItems().add(item);
        }
    }

    @FXML
    void OnPrevious(ActionEvent event) throws IOException {
        changeWindow(this.btnPrevious.getScene().getWindow(), "VMain");
    }

    @FXML
    void OnPrintLabel(ActionEvent event) throws IOException {
        String strSpcimenID=null;
        String strCountry=null;
        String strButterflyName=null;
        String strCatchDate=null;
        String strCatchPlace=null;
        String strCatcher=null;
        String strButterflyFamily=null;
        
        /* Copy Table Item to Clipboard */
    	
    	if(this.tblInquiry.getSelectionModel().getSelectedItem() != null) {
    		strSpcimenID = this.tblInquiry.getSelectionModel().getSelectedItem().specimen_ID;
        	strCountry = this.tblInquiry.getSelectionModel().getSelectedItem().country;
        	strCatchDate = this.tblInquiry.getSelectionModel().getSelectedItem().collecting_date;
        	strCatcher = this.tblInquiry.getSelectionModel().getSelectedItem().collector;
        	strCatchPlace = this.tblInquiry.getSelectionModel().getSelectedItem().collecting_location;
        	strButterflyName = this.tblInquiry.getSelectionModel().getSelectedItem().butterfly_name;
        	strButterflyFamily = this.tblInquiry.getSelectionModel().getSelectedItem().butterfly_family;
        			
        	SystemClipboard.copy("표본 ID : " + strSpcimenID + "\n"
        			+ "수집 국가 : " + strCountry + "\n"
        			+ "수집 날짜 : " + strCatchDate + "\n"
        			+ "채집자 : " + strCatcher + "\n"			
        			+ "수집 장소 : " + strCatchPlace + "\n"
        			+ "나비 이름 : " + strButterflyName + "\n"
        			+ "나비 과 : " + strButterflyFamily);
        	/* Alert confirm_popup = new Alert(AlertType.CONFIRMATION);
    		confirm_popup.setTitle("Load");
    		confirm_popup.setHeaderText(null);
    		confirm_popup.setContentText("클립보드에 정보가 저장되었습니다.");
    		confirm_popup.show();
    		return; */
    	} else {
			Alert confirm_popup = new Alert(AlertType.ERROR);
			confirm_popup.setTitle("Load");
			confirm_popup.setHeaderText(null);
			confirm_popup.setContentText("나비 표본을 선택해주세요.");
			confirm_popup.show();
			return;
    	}
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

        /* Click Handler for TableView */
        //String oldValue = null;
        this.tblInquiry.setOnMouseClicked(event -> {
            if( tblInquiry.getSelectionModel().getSelectedItem() != null) {
                InquiryTableItem item = tblInquiry.getSelectionModel().getSelectedItem();

                /* DB Instance initialization */
                this.db = ((MSharedData)this.shared_model).getDB();

                ResultSet rsImage = null;
                
                String ImageLoadingPath = "SELECT distinct Image.path from Image inner join Specimen "
                		+ "on Image.idImage = Specimen.idImage where Specimen.idSpecimen = "
                		+ this.tblInquiry.getSelectionModel().getSelectedItem().specimen_ID;
                
                rsImage = db.selectQuery(ImageLoadingPath);
                
                try {
        			while(rsImage.next()) {
        			    ImagePath = rsImage.getString(1);
        			}
        		} catch (SQLException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                
        		//Set image
                System.out.println(ImagePath);
        		//Image image = new Image(file.toURI().toString());
        		//this.imvButterflyImage.setImage(image);
        		//System.out.println(ImageLoadingPath);
            }
        });
    }

    @Override
    public void init_procedure() {
        /* DB Instance initialization */
        this.db = ((MSharedData)this.shared_model).getDB();

        ResultSet rs = null;

        String InitialTblSetting = "SELECT distinct A.idSpecimen, C.country, B.date, D.name, C.alias, E.name, E.family "
                + "FROM Specimen AS A inner join CollectionInfo AS B on A.idCollectionInfo=B.idCollectionInfo "
                + "inner join Location AS C on B.idLocation=C.idLocation "
                + "inner join Person AS D on B.idPerson=D.idPerson "
                + "inner join ButterflyGuide AS E on B.idButterflyGuide=E.idButterflyGuide "
                + "ORDER BY date DESC limit 1000";

        try {
            rs = db.selectQuery(InitialTblSetting);
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
        rsCountry = db.selectQuery(InitialCountry);
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
        rsCollector = db.selectQuery(InitialCollector);
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
        rsCollectionYear = db.selectQuery(InitialCollectionYear);
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
        rsMethod = db.selectQuery(InitialMethod);
        try {
            while(rsMethod.next()) {
                this.cmbCollectingMethod.getItems().add(rsMethod.getString(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 수집 방법 채우기
        // 전체, 채집, 선물, 교환 등
        // this.cmbCollectingMethod

        /* Initialize Combobox */
        cmbCollectingMethod.getItems().add("전체");
        cmbCollectingMonth.getItems().add("전체");
        cmbCollectingYear.getItems().add("전체");
        cmbCollector.getItems().add("전체");
        cmbCountry.getItems().add("전체");
        cmbCollectingMethod.getSelectionModel().select("전체");
        cmbCollectingMonth.getSelectionModel().select("전체");
        cmbCollectingYear.getSelectionModel().select("전체");
        cmbCollector.getSelectionModel().select("전체");
        cmbCountry.getSelectionModel().select("전체");

        /* Set Auto Complete */
        try {
            setAutoComplete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setAutoComplete() throws SQLException {
        ObservableList<String> location_autocomplete_list = FXCollections.observableArrayList();
        ObservableList<String> family_autocomplete_list = FXCollections.observableArrayList();
        ObservableList<String> name_autocomplete_list = FXCollections.observableArrayList();

        ResultSet result_query = db.selectQuery("select distinct alias from Location");
        while(result_query.next()) {
            location_autocomplete_list.add(result_query.getString(1));
        }
        TextFields.bindAutoCompletion(this.txtCollectingLocation, location_autocomplete_list);

        result_query = db.selectQuery("select distinct family from ButterflyGuide");
        while(result_query.next()) {
            family_autocomplete_list.add(result_query.getString(1));
        }
        TextFields.bindAutoCompletion(this.txtButterflyFamily, family_autocomplete_list);

        result_query = db.selectQuery("select distinct name from ButterflyGuide");
        while(result_query.next()) {
            name_autocomplete_list.add(result_query.getString(1));
        }
        TextFields.bindAutoCompletion(this.txtButterflyName, name_autocomplete_list);
    }
}
