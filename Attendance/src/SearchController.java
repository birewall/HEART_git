import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchController {

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
    void OnSearch(ActionEvent event) {
    	/* Fill */
    	Stage nowStage = (Stage) this.btnCancel.getScene().getWindow();
    	nowStage.close();
    }

}
