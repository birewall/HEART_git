package Controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.MEmployee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CList implements Initializable {
    @FXML
    private TableView<MEmployee> tblList;

    @FXML
    private TableColumn<MEmployee, String> tclName;

    @FXML
    private TableColumn<MEmployee, String> tclDate;

    @FXML
    private TableColumn<MEmployee, String> tclDepart;

    @FXML
    private ImageView imgFace;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRegister;

    @FXML
    void OnDelete(ActionEvent event) {
    	Alert confirm_popup = new Alert(AlertType.CONFIRMATION);
		confirm_popup.setTitle("Delete");
		confirm_popup.setHeaderText(null);
		confirm_popup.setContentText("Want to remove " + this.tblList.getSelectionModel().getSelectedItem().getName() + "?");
		Optional<ButtonType> result = confirm_popup.showAndWait();
		if (result.get() == ButtonType.OK){
	    	this.tblList.getItems().remove(this.tblList.getSelectionModel().getSelectedIndex());
	    	this.imgFace.setImage(null);
		}
    }

    @FXML
    void OnExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void OnRegister(ActionEvent event) {
    	try {
	        Stage newStage = new Stage();
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent root = loader.load(getClass().getResource("/View/VRegister.fxml").openStream());
	        CRegister controller = (CRegister)loader.getController();
	        controller.setPerentController(this);
	    	Scene scene = new Scene(root);
	        newStage.setScene(scene);
	        newStage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
    }

    void RegisterEmployee(MEmployee employee) {
    	/* Fill */
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/* Initialize tableview */
		this.tblList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        imgFace.setImage(new Image(new File(
		        		tblList.getSelectionModel().getSelectedItem().getImage_path()).toURI().toString()
		        ));
		    }});
		this.tclName.setCellValueFactory(new PropertyValueFactory<MEmployee, String>("name"));
		this.tclDate.setCellValueFactory(new PropertyValueFactory<MEmployee, String>("enroll_date"));
		this.tclDepart.setCellValueFactory(new PropertyValueFactory<MEmployee, String>("department"));
		
		this.tblList.getItems().add(new MEmployee("1234","2345","3456"));
	}
}
