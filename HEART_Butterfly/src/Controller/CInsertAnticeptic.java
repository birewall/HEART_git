package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.MDBButterflyGuide;
import Model.MDBPerson;
import Model.MDBSpecimen;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class CInsertAnticeptic extends AbsMetaController implements Initializable {
	
    MDBSpecimen db_specimen=null;
    String PlaceName;
    String CabinetName;
    
   @FXML
    private BorderPane AnticepticStage;
   
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
    	PlaceName = this.comboPlace.getSelectionModel().getSelectedItem();
    	
    	System.out.println("Hi");
        String queryCabinet = "select storageCabinet from Specimen where storageRoom=" + PlaceName;
		ResultSet rsCabinet = db_specimen.selectQuery(queryCabinet);

		while(rsCabinet.next()) {
			System.out.println(rsCabinet.getString(1));
			this.comboCabinet.getItems().add(rsCabinet.getString(1));   // get storageCabinet
		}

    	CabinetName = this.comboCabinet.getSelectionModel().getSelectedItem();
    }

    @FXML
    void cabinetInsert(ActionEvent event) throws SQLException {
    	
    }

    @FXML
    void boxInsert(ActionEvent event) throws SQLException {
        String queryBox = "select storageBox from Specimen where storageCabinet=" + this.comboPlace.getSelectionModel().getSelectedItem();
		ResultSet rsBox = db_specimen.selectQuery(queryBox);
		this.comboPlace.getItems().add(rsBox.getString(1));   // get storageBox
    	this.comboBox.getSelectionModel().getSelectedIndex();
    }

    @FXML
    void saveAnticepticDate(ActionEvent event) {
    	
    }

    @FXML
    void exitAnticeptic(ActionEvent event) throws IOException {
    	changeWindow(this.btnExitAnticeptic.getScene().getWindow(), "VInsert");
    }

    @FXML
    void dateInsertAnticeptic(ActionEvent event) {

    }
        
    

    public void init_procedure() {
    	this.getStage().setResizable(false);
    	
    	/* DB Instance initialization */
    	 db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());
        String queryRoom = "select storageRoom from Specimen";

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
