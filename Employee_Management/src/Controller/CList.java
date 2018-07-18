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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    	/* Fill */
    	Alert confirm_dialog = new Alert(AlertType.CONFIRMATION);
    	confirm_dialog.setHeaderText(null);
    	confirm_dialog.setTitle("Delete");
    	confirm_dialog.setContentText("Are you sure to delete " + this.tblList.getSelectionModel().getSelectedItem().getName() + "?");
    	
    	Optional<ButtonType> result = confirm_dialog.showAndWait();
		if (result.get() == ButtonType.OK){
			this.tblList.getItems().remove(this.tblList.getSelectionModel().getSelectedIndex());
		}
    }

    @FXML
    void OnExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void OnRegister(ActionEvent event) throws IOException {
    	/* Fill */
    	Parent root = FXMLLoader.load(getClass().getResource("/View/VRegister.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
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
