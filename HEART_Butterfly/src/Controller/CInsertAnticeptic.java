package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class CInsertAnticeptic extends AbsMetaController{

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
    void placeInsert(ActionEvent event) {
    	
    }

    @FXML
    void cabinetInsert(ActionEvent event) {

    }

    @FXML
    void boxInsert(ActionEvent event) {

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
    }	
	    	
}
