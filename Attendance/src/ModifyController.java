import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ModifyController {

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

    }

    @FXML
    void OnSubmit(ActionEvent event) {

    }

}
