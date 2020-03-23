package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.MDBPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class CInsertSheet extends AbsInsertController implements Initializable {
	MDBPerson PersonDB;
	
	public class InsertTableItem{
		private String SpecimenID;
		private String ButterflyName;
		private String ButterflyFamily;
		private String ButterflyZoological;
		private String CollectMethod;
		private String CollectYear;
		private String CollectDate;
		private String CollectCountry;
		private String State;
		private String City;
		private String Village;
		private String Place;
		private String Collector;
		private String SpecimenizeYear;
		private String SpecimenizeMonth;
		private String SpecimenizeDate;
		private String SpecimenSex;
		private String SpecimenStatus;
		private String SpecimenOffice;
		private String SpecimenCabinet;
		private String SpecimenBox;
		private String SpecimenizePerson;
		
		public InsertTableItem(String SpecimenID, String ButterflyName, String ButterflyFamily, String ButterflyZoological,
				String CollectMethod, String CollectYear, String CollectDate, String CollectCountry, String State, 
				String City, String Village, String Place, String Collector, String SpecimenizeYear, String SpecimenizeMonth,
				String SpecimenizeDate, String SpecimenSex, String SpecimenStatus, String SpecimenOffice, String SpecimenCabinet,
				String SpecimenBox, String SpecimenizePerson){
			this.SpecimenID = SpecimenID;
			this.ButterflyName = ButterflyName;
			this.ButterflyFamily = ButterflyFamily;
			this.ButterflyZoological = ButterflyZoological;
			this.CollectMethod = CollectMethod;
			this.CollectYear = CollectYear;
			this.CollectDate = CollectDate;
			this.CollectCountry = CollectCountry;
			this.State = State;
			this.City = City;
			this.Village = Village;
			this.Place = Place;
			this.Collector = Collector;
			this.SpecimenizeYear = SpecimenizeYear;
			this.SpecimenizeMonth = SpecimenizeMonth;
			this.SpecimenizeDate = SpecimenizeDate;
			this.SpecimenSex = SpecimenSex;
			this.SpecimenStatus = SpecimenStatus;
			this.SpecimenOffice = SpecimenOffice;
			this.SpecimenCabinet = SpecimenCabinet;
			this.SpecimenBox = SpecimenBox;
		}
		
		public String getSpecimenID() {
			return SpecimenID;
		}
		public void setSpecimenID(String specimenID) {
			SpecimenID = specimenID;
		}
		public String getButterflyName() {
			return ButterflyName;
		}
		public void setButterflyName(String butterflyName) {
			ButterflyName = butterflyName;
		}
		public String getButterflyFamily() {
			return ButterflyFamily;
		}
		public void setButterflyFamily(String butterflyFamily) {
			ButterflyFamily = butterflyFamily;
		}
		public String getButterflyZoological() {
			return ButterflyZoological;
		}
		public void setButterflyZoological(String butterflyZoological) {
			ButterflyZoological = butterflyZoological;
		}
		public String getCollectMethod() {
			return CollectMethod;
		}
		public void setCollectMethod(String collectMethod) {
			CollectMethod = collectMethod;
		}
		public String getCollectYear() {
			return CollectYear;
		}
		public void setCollectYear(String collectYear) {
			CollectYear = collectYear;
		}
		public String getCollectDate() {
			return CollectDate;
		}
		public void setCollectDate(String collectDate) {
			CollectDate = collectDate;
		}
		public String getCollectCountry() {
			return CollectCountry;
		}
		public void setCollectCountry(String collectCountry) {
			CollectCountry = collectCountry;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getVillage() {
			return Village;
		}
		public void setVillage(String village) {
			Village = village;
		}
		public String getPlace() {
			return Place;
		}
		public void setPlace(String place) {
			Place = place;
		}
		public String getCollector() {
			return Collector;
		}
		public void setCollector(String collector) {
			Collector = collector;
		}
		public String getSpecimenizeYear() {
			return SpecimenizeYear;
		}
		public void setSpecimenizeYear(String specimenizeYear) {
			SpecimenizeYear = specimenizeYear;
		}
		public String getSpecimenizeMonth() {
			return SpecimenizeMonth;
		}
		public void setSpecimenizeMonth(String specimenizeMonth) {
			SpecimenizeMonth = specimenizeMonth;
		}
		public String getSpecimenizeDate() {
			return SpecimenizeDate;
		}
		public void setSpecimenizeDate(String specimenizeDate) {
			SpecimenizeDate = specimenizeDate;
		}
		public String getSpecimenSex() {
			return SpecimenSex;
		}
		public void setSpecimenSex(String specimenSex) {
			SpecimenSex = specimenSex;
		}
		public String getSpecimenStatus() {
			return SpecimenStatus;
		}
		public void setSpecimenStatus(String specimenStatus) {
			SpecimenStatus = specimenStatus;
		}
		public String getSpecimenOffice() {
			return SpecimenOffice;
		}
		public void setSpecimenOffice(String specimenOffice) {
			SpecimenOffice = specimenOffice;
		}
		public String getSpecimenCabinet() {
			return SpecimenCabinet;
		}
		public void setSpecimenCabinet(String specimenCabinet) {
			SpecimenCabinet = specimenCabinet;
		}
		public String getSpecimenBox() {
			return SpecimenBox;
		}
		public void setSpecimenBox(String specimenBox) {
			SpecimenBox = specimenBox;
		}
		public String getSpecimenizePerson() {
			return SpecimenizePerson;
		}
		public void setSpecimenizePerson(String specimenizePerson) {
			SpecimenizePerson = specimenizePerson;
		}
		
	}
	
    @FXML
    private TableView<InsertTableItem> tblInformation;
    
    @FXML
    private Button btnPreviousImg;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectVillage;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenizeYear;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenCabinet;

    @FXML
    private Button btnInsert;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenSex;

    @FXML
    private Label lblButterflyFamily;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectCountry;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectMonth;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollector;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenCondition;

    @FXML
    private Button btnExportLableCSV;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectMethod;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectYear;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectState;

    @FXML
    private Label lblButterflyName;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectPlace;

    @FXML
    private Button btnNextImg;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenID;

    @FXML
    private TableColumn<InsertTableItem, String> tclButterflyZoological;

    @FXML
    private Label lblButterflyZoological;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenizeMonth;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectCity;

    @FXML
    private TableColumn<InsertTableItem, String> tclCollectDate;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenBox;

    @FXML
    private Button btnCancel;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenOffice;

    @FXML
    private ImageView butterflyImg;

    @FXML
    private TableColumn<InsertTableItem, String> tclButterflyFamily;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenizeDate;

    @FXML
    private TableColumn<InsertTableItem, String> tclButterflyName;

    @FXML
    private TableColumn<InsertTableItem, String> tclSpecimenPerson;

    @FXML
    void onExportLableCSV(ActionEvent event) {

    }

    @FXML
    void onInsert(ActionEvent event) {

    }

    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void OnPreviousImg(ActionEvent event) {

    }

    @FXML
    void OnNextImg(ActionEvent event) {

    }
    
    @Override
    public void init_procedure() {
    	
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    
    }
}