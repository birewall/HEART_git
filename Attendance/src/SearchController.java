import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchController {
	MDatabase database;
	AttendanceController controller;
	
    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnCancel;

    @FXML
    void OnCancel(ActionEvent event) {
    	Stage nowStage = (Stage) this.btnCancel.getScene().getWindow();
    	nowStage.close();
    }

    @FXML
    void OnSearch(ActionEvent event) throws SQLException, IOException {
    	if (this.txtName.getText().length() > 0) {
    		this.database.search(this.txtName.getText());
    	}    	
    	
    	this.controller.printScreen();
    	
    	Stage nowStage = (Stage) this.btnCancel.getScene().getWindow();
    	nowStage.close();
    }

    void setDatabase(MDatabase db) {
    	this.database = db;
    }
    
    void setRootController(AttendanceController controller) {
    	this.controller = controller;
    }
}
