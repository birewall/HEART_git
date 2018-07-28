import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ModifyController {
	MDatabase database;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private RadioButton radAttend;

    @FXML
    private ToggleGroup AttendanceGroup;

    @FXML
    private RadioButton radNonattend;

    @FXML
    private Button btnCancel;

    @FXML
    void OnCancel(ActionEvent event) {
    	Stage nowStage = (Stage) this.btnCancel.getScene().getWindow();
    	nowStage.close();
    }

    @FXML
    void OnSubmit(ActionEvent event) throws NumberFormatException, SQLException {
    	if (this.txtName.getText().length() > 0) {
    		this.database.modify(this.txtName.getText(), this.radAttend.isSelected()?1:0);
    	}
    	Stage nowStage = (Stage) this.btnCancel.getScene().getWindow();
    	nowStage.close();
    }

    void setDatabase(MDatabase db) {
    	this.database = db;
    	this.txtID.setText(Integer.toString(this.database.getCurrent_id()));
    	this.txtName.setText(this.database.getCurrent_name());
    	if(this.database.getCurrent_attendance() == 1) {
    		this.radAttend.setSelected(true);
    	}else {
    		this.radNonattend.setSelected(true);
    	}
    	
    }
}
