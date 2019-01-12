package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import Model.MDBPerson;
import Model.MSharedData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CSectionManagement extends AbsMetaController implements Initializable {
	

    @FXML
    private ListView<String> ListSection;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnDone;

    @FXML
    private TextField txtMaxSection;

   	String maxSecNum = null;
    @FXML
    void OnInsert(ActionEvent event) {
        this.ListSection.getItems().clear();

        /* Error Handling */
    	maxSecNum = txtMaxSection.getText();

        if(maxSecNum.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("최대 구간을 입력해주세요");
            alert.show();
            return;
        }
        
        /* View Updating */
        String AllSection = null;
    	if(maxSecNum!=null) {
            int maxNumber = Integer.parseInt(maxSecNum);
            for (int i=1; i <= maxNumber; i ++) {
            	AllSection = ""+i+"";
            	this.ListSection.getItems().add(AllSection);
            }
    	} else {
    		return;
    	}
    	
    }

    @FXML
    void OnDone(ActionEvent event) {
        Stage thisStage = (Stage)this.btnDone.getScene().getWindow();
        this.parent_controller.view_update();
      	((CInsertPicture)this.parent_controller).setTextLblMaxSection(maxSecNum);
      	((CInsertPicture)this.parent_controller).setTextLblSection(ListSection.getSelectionModel().getSelectedItem());
        thisStage.close();
    }

    @FXML
    void OnSectionTyping(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
