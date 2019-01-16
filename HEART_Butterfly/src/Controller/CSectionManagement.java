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
        /*
        if(ListSection.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("구간을 선택하세요");
            alert.show();
            return;
        }else {
            // Close and Call Close Handler
            on_close_stage();
            ((Stage) this.btnDone.getScene().getWindow()).close();
        }
        */
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
        if(ListSection.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("구간을 선택하세요");
            alert.show();
            return false;
        }

        Stage thisStage = (Stage)this.btnDone.getScene().getWindow();
        this.parent_controller.view_update();

        /* Get Parent Information and Update Parent View */
        MPassingData data = (MPassingData)((MSharedData)(this.shared_model)).get("parent_name");
        String parent_info = data.getData(0);
        ((MSharedData)(this.shared_model)).remove("parent_name");
        if(parent_info.equals("CInsertWatch")) {
            ((CInsertWatch)this.parent_controller).setTextLblMaxSection(maxSecNum);
            ((CInsertWatch)this.parent_controller).setTextLblSection(ListSection.getSelectionModel().getSelectedItem());
        }else if(parent_info.equals("CInsertPicture")) {
            ((CInsertPicture)this.parent_controller).setTextLblMaxSection(maxSecNum);
            ((CInsertPicture)this.parent_controller).setTextLblSection(ListSection.getSelectionModel().getSelectedItem());
        }else{
            System.out.println("Section Manager: Problem Occurs when closing and updating parent's view");
        }
        // thisStage.close();
        return true;
    }

}
