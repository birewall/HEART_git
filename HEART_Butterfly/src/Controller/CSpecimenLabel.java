package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CSpecimenLabel extends AbsMetaController {

    @FXML
    private Label lblCatchDate;

    @FXML
    private Label lblSpecimenID;

    @FXML
    private Label lblCatchPlace;

    @FXML
    private Label lblCatcher;
    
    @FXML
    private Label lblButterflyName;
    
    @FXML
    private TextField txtSpecimenID;

    @FXML
    private TextField txtButterflyName;

    @FXML
    private TextField txtCatchPlace;

    @FXML
    private TextField txtCatcher;

    @FXML
    private TextField txtCatchDate;

    @FXML
    private Button btnDataLoad;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnLabelCopy;

    String strSpcimenID;
    String strButterflyName;
    String strCatchDate;
    String strCatchPlace;
    String strCatcher;
    
    @FXML
    void OnDataLoad(ActionEvent event) {
    	
    }
    
    @FXML
    void OnLabelCopy(ActionEvent event) {
    	strSpcimenID = this.txtSpecimenID.getText();
    	strButterflyName = this.txtButterflyName.getText();
    	strCatchDate = this.txtCatchDate.getText();
    	strCatchPlace = this.txtCatchPlace.getText();
    	strCatcher = this.txtCatcher.getText();
    	
    	SystemClipboard.copy("표본 ID : " + strSpcimenID + "\n"
    			+ "나비 이름 : " + strButterflyName + "\n"
    			+ "수집 날짜 : " + strCatchDate + "\n"
    			+ "수집 장소 : " + strCatchPlace + "\n"
    			+ "채집자 : " + strCatcher);			
    }

    @FXML
    void OnExit(ActionEvent event) throws IOException {
    	changeWindow(this.btnExit.getScene().getWindow(), "VInsertSpecimen");

    }

}
