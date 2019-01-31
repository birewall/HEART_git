package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.PropertySheet.Item;

import Controller.CInquiry.InquiryTableItem;
import Model.MDatabase;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CLabelManagement extends AbsMetaController implements Initializable {
	
    MDatabase db = null;
    
    /* Class for Table */
    public class LabelTableItem {
        private String specimen_ID;
        private String collector;
        private String collecting_date;
        private String collecting_place;


        public LabelTableItem(String specimen_ID, String collector,String collecting_date, String collecting_place) {
            this.specimen_ID = specimen_ID;
            this.collector = collector;
            this.collecting_date = collecting_date;
            this.collecting_place = collecting_place;
        }


		public String getSpecimen_ID() {
			return specimen_ID;
		}


		public void setSpecimen_ID(String specimen_ID) {
			this.specimen_ID = specimen_ID;
		}


		public String getCollector() {
			return collector;
		}


		public void setCollector(String collector) {
			this.collector = collector;
		}


		public String getCollecting_date() {
			return collecting_date;
		}


		public void setCollecting_date(String collecting_date) {
			this.collecting_date = collecting_date;
		}


		public String getCollecting_place() {
			return collecting_place;
		}


		public void setCollecting_place(String collecting_place) {
			this.collecting_place = collecting_place;
		}


    }

    @FXML
    private TableView<LabelTableItem> tblLabelInfo;

    @FXML
    private TableColumn<LabelTableItem, String> tclSpecimenID;

	@FXML
    private TableColumn<LabelTableItem, String> tclCollector;

    @FXML
    private TableColumn<LabelTableItem, String> tclCollectDate;

    @FXML
    private TableColumn<LabelTableItem, String> tclCollectPlace;

    @FXML
    private Label lblSpecimenID;

    @FXML
    private Label lblCollectDate;

    @FXML
    private Label lblCollector;

    @FXML
    private Label lblCollectPlace;

    @FXML
    private Button btnSelection;

    @FXML
    private Button btnCancel;
    
    @FXML
    void OnSelection(ActionEvent event) {

    	int error_code = 0;
         Alert error_popup = null;
         String idSpecimen = this.lblSpecimenID.getText();
         String collector = this.lblCollector.getText();
         String collecting_date = this.lblCollectDate.getText();
         String location_alias = this.lblCollectPlace.getText();

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
    }

    @FXML
    void OnExit(ActionEvent event) throws IOException {
    	changeWindow(this.btnCancel.getScene().getWindow(), "VInsertSpecimen");
    }
    
    public void initialize(URL location, ResourceBundle resources) {
        tclSpecimenID.setCellValueFactory(new PropertyValueFactory<>("specimen_ID"));
        tclCollector.setCellValueFactory(new PropertyValueFactory<>("collector"));
        tclCollectDate.setCellValueFactory(new PropertyValueFactory<>("collecting_date"));
        tclCollectPlace.setCellValueFactory(new PropertyValueFactory<>("collecting_place"));
        
        /* Click Handler for TableView */
        //String oldValue = null;
        this.tblLabelInfo.setOnMouseClicked(event -> {
            if( tblLabelInfo.getSelectionModel().getSelectedItem() != null) {
                LabelTableItem item = tblLabelInfo.getSelectionModel().getSelectedItem();
                this.lblSpecimenID.setText(item.getSpecimen_ID().toString());
                this.lblCollector.setText(item.getCollector().toString());
                this.lblCollectDate.setText(item.getCollecting_date().toString());
                this.lblCollectPlace.setText(item.getCollecting_place().toString());
            }
        });

    }
    
    @Override
    public void init_procedure() {
        /* DB Instance initialization */
        this.db = ((MSharedData)this.shared_model).getDB();

        ResultSet rs = null;

        String InitialTblSetting = "SELECT distinct C.idSpecimen, B.name, D.date, E.alias "
        		+ "FROM Specimenize AS A " 
        		+ "inner join Person AS B on B.idPerson = A.idPerson " 
        		+ "inner join Specimen AS C on A.idSpecimen = C.idSpecimen " 
        		+ "inner join CollectionInfo AS D on C.idCollectionInfo = D.idCollectionInfo " 
        		+ "inner join Location AS E on E.idLocation = D.idLocation";

        rs = db.selectQuery(InitialTblSetting);
        
        try {
        	rs.last();
        	int count = rs.getRow();
        	rs.beforeFirst();
			while(rs.next()) {
			    LabelTableItem labelItem = new LabelTableItem(rs.getString(1),
			            rs.getString(2),
			            rs.getString(3),
			            rs.getString(4));
			    this.tblLabelInfo.getItems().add(labelItem);
			}
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
