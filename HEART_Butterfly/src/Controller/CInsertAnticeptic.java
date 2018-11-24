package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.MDBButterflyGuide;
import Model.MDBPerson;
import Model.MDBSpecimen;
import Model.MDBSpecimenize;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class CInsertAnticeptic extends AbsMetaController implements Initializable {
	
    MDBSpecimen db_specimen=null;
    MDBSpecimenize db_specimenize=null;

    String PlaceName;
    String CabinetName;
    String BoxName;
    
   @FXML
    private BorderPane AnticepticStage;
   
   @FXML
   private TextField txtAnticepticName;
   
    @FXML
    private ComboBox<String> comboPlace;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnExitAnticeptic;

    @FXML
    private DatePicker datepickerInsertAnticeptic;

    @FXML
    private Label lblDateInsert;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ComboBox<String> comboCabinet;

    @FXML
    void placeInsert(ActionEvent event) throws SQLException {

    	String queryCabinet = null;
    	ResultSet rsCabinet = null;
    	System.out.println("Hi");
    	int PlaceTotalSelection = this.comboPlace.getSelectionModel().getSelectedIndex();
    	if(PlaceTotalSelection==0) {
            queryCabinet = "select distinct storageCabinet from Specimen";
    		rsCabinet = db_specimen.selectQuery(queryCabinet);
    	}else {
            queryCabinet = "select distinct storageCabinet from Specimen where storageRoom='" + this.comboPlace.getSelectionModel().getSelectedItem() + "'";
    		rsCabinet = db_specimen.selectQuery(queryCabinet);
    	}
    	
		this.comboCabinet.getItems().clear();
    	this.comboCabinet.getItems().add("전체선택");
		
		while(rsCabinet.next()) {
			System.out.println(rsCabinet.getString(1));
			this.comboCabinet.getItems().add(rsCabinet.getString(1));   // get storageCabinet
		}

    	CabinetName = this.comboCabinet.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    void cabinetInsert(ActionEvent event) throws SQLException {
    	String queryBox = null;
    	ResultSet rsBox =null;
    	int CabinetTotalSelection = this.comboPlace.getSelectionModel().getSelectedIndex();
    	if(CabinetTotalSelection==0) {
            queryBox = "select distinct storageChest from Specimen";
    		rsBox = db_specimen.selectQuery(queryBox);
    	} else {
            queryBox = "select distinct storageChest from Specimen where storageCabinet='" + this.comboCabinet.getSelectionModel().getSelectedItem() + "'";
    		rsBox = db_specimen.selectQuery(queryBox);
    	}
		
		this.comboBox.getItems().clear();
    	this.comboBox.getItems().add("전체선택");
		
			while(rsBox.next()) {
				System.out.println(rsBox.getString(1));
				this.comboBox.getItems().add(rsBox.getString(1));
			}
		
    	BoxName = this.comboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void boxInsert(ActionEvent event) throws SQLException {
    	int BoxTotalSelection = this.comboPlace.getSelectionModel().getSelectedIndex();
    	if(BoxTotalSelection==0) {
    		
    	}
    }

    @FXML
    void saveAnticepticDate(ActionEvent event) {

    	String queryDateName = "update Butterfly.Specimenize as spn, Butterfly.Specimen as sp set spn.anticepticName = '"
    			+ txtAnticepticName.getText() + "', spn.embalmingDate = '" + lblDateInsert.getText() 
    			+ "' where sp.storageRoom = '" + comboPlace.getSelectionModel().getSelectedItem()
    			+ "' and sp.storageCabinet = '" + comboCabinet.getSelectionModel().getSelectedItem() 
    			+ "' and sp.storageChest = '" + comboBox.getSelectionModel().getSelectedItem() + "' and spn.idSpecimen = sp.idSpecimen";
    	if(!this.db_specimenize.modifyingQuery(queryDateName)) {
    		return;
    	}
    }

    @FXML
    void exitAnticeptic(ActionEvent event) throws IOException {
    	changeWindow(this.btnExitAnticeptic.getScene().getWindow(), "VInsert");
    }

    @FXML
    void dateInsertAnticeptic(ActionEvent event) {
    	String confrimedDate = datepickerInsertAnticeptic.getEditor().getText().replaceAll(". ", "-");
    	lblDateInsert.setText(confrimedDate);
    }
        
    

    public void init_procedure() {
    	this.getStage().setResizable(false);

    	/* DB Instance initialization */
    	 db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
    	 db_specimenize = new MDBSpecimenize(((MSharedData)this.shared_model).getDB().getConnection());

 		this.comboPlace.getItems().clear();
    	
    	this.comboPlace.getItems().add("전체선택");

    	String queryRoom = "select distinct storageRoom from Specimen";
		ResultSet rsRoom = db_specimen.selectQuery(queryRoom);
		
		try {
			while(rsRoom.next()) {
				this.comboPlace.getItems().add(rsRoom.getString(1));   // get storageRoom
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}	
	    	
}
