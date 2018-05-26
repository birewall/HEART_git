import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class InsertController {
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
    void OnSubmit(ActionEvent event) throws SQLException {
    	
    	Stage nowStage = (Stage) this.btnCancel.getScene().getWindow();
    	nowStage.close();
    }

}