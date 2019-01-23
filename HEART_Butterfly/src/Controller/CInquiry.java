package Controller;

import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CInquiry extends AbsMetaController implements Initializable {

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
    void OnPrintLabel(ActionEvent event) {
        /* Copy Table Item to Clipboard */
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
}
