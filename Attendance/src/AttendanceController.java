import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AttendanceController implements Initializable {
	MDatabase database;
	
    @FXML
    private ListView<String> lsvStudent;

    @FXML
    private Button btnDBConnect;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnShowAttendant;

    @FXML
    private Button btnModify;

    @FXML
    private Label lblResult;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnShowNonattendant;

    @FXML
    private Button btnSearch;

    @FXML
    void OnConnect(ActionEvent event) throws ClassNotFoundException, SQLException {
    	if(this.database.connect()) {
    		this.lblResult.setText("DB Connected");
    	}else {
    		this.lblResult.setText("DB is not connected");
    	}
    }

    @FXML
    void OnDelete(ActionEvent event) {
    	/* Fill */
    }

    @FXML
    void OnExit(ActionEvent event) throws SQLException {
    	this.database.disconnect();
    	System.exit(0);
    }

    @FXML
    void OnInsert(ActionEvent event) throws IOException {
    	/* Fill */
    	Stage newStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("InsertView.fxml"));
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    void OnModify(ActionEvent event) throws IOException {
    	/* Fill */
    	Stage newStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("ModifyView.fxml"));
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    void OnSearch(ActionEvent event) throws IOException {
    	/* Fill */
    	Stage newStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    void OnShowAttendant(ActionEvent event) {
    	/* Fill */
    }

    @FXML
    void OnShowNonattendant(ActionEvent event) {
    	/* Fill */
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.database = new MDatabase();
	}

}
