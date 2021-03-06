package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import Model.MDBPerson;
import Model.MPassingData;
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
import javafx.stage.WindowEvent;

public class CSectionManagement extends AbsMetaController implements Initializable {
	

    @FXML
    private ListView<String> listSection;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnDone;

    @FXML
    private TextField txtMaxSection;

   	String maxSecNum = null;
    @FXML
    void OnInsert(ActionEvent event) {
        this.listSection.getItems().clear();

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
            	this.listSection.getItems().add(AllSection);
            }
    	} else {
    		return;
    	}
    	
    }

    @FXML
    void OnDone(ActionEvent event) {
        Stage this_stage = ((Stage) this.btnDone.getScene().getWindow());
        this_stage.fireEvent(new WindowEvent(this_stage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    void OnSectionTyping(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public boolean on_close_stage() {
        if(listSection.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("구간을 선택하세요");
            alert.show();
            return false;
        }

        Stage thisStage = (Stage)this.btnDone.getScene().getWindow();
        ((AbsInsertController)this.parent_controller).passing_section_info(listSection.getSelectionModel().getSelectedItem(), maxSecNum);
        //this.parent_controller.view_update();

        return true;
    }
}