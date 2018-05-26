import java.io.IOException;
import java.net.URL;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    void OnDelete(ActionEvent event) throws SQLException {
    	if(this.lsvStudent.getSelectionModel() == null) return;
    	
    	String selected_name = this.lsvStudent.getSelectionModel().getSelectedItem();
    	if(selected_name != null) {
    		this.database.delete(selected_name);
    	}
    	this.lsvStudent.getItems().remove(this.lsvStudent.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void OnExit(ActionEvent event) throws SQLException {
    	this.database.disconnect();
    	System.exit(0);
    }

    @FXML
    void OnInsert(ActionEvent event) throws IOException {
    	Stage newStage = new Stage();
    	FXMLLoader loader = new FXMLLoader();
    	Parent root = loader.load(getClass().getResource("InsertView.fxml").openStream());
        InsertController controller = (InsertController)loader.getController();
        controller.setDatabase(this.database);
    	Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    void OnModify(ActionEvent event) throws IOException {
    	if (this.lsvStudent.getSelectionModel().getSelectedItem() != null) {
    		this.database.setCurrent_name(this.lsvStudent.getSelectionModel().getSelectedItem());
	    	Stage newStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent root = loader.load(getClass().getResource("ModifyView.fxml").openStream());
	        ModifyController controller = (ModifyController)loader.getController();
	        controller.setDatabase(this.database);
	    	Scene scene = new Scene(root);
	        newStage.setScene(scene);
	        newStage.show();
    	}
    }

    @FXML
    void OnSearch(ActionEvent event) throws IOException {
    	Stage newStage = new Stage();
    	FXMLLoader loader = new FXMLLoader();
    	Parent root = loader.load(getClass().getResource("SearchView.fxml").openStream());
        SearchController controller = (SearchController)loader.getController();
        controller.setDatabase(this.database);
        controller.setRootController(this);
    	Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    void OnShowAttendant(ActionEvent event) throws SQLException {
    	this.database.searchAttendant();
    	printScreen();
    }

    @FXML
    void OnShowNonattendant(ActionEvent event) throws SQLException {
    	this.database.searchNonattendant();
    	printScreen();
    }

    public void printScreen() {
    	this.lsvStudent.getItems().clear();
    	for( int i = 0 ; i < this.database.getResult().size() ; i++ ) {
    		this.lsvStudent.getItems().add(this.database.getResult().get(i));
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.database = new MDatabase();
	}

}
