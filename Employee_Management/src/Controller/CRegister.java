package Controller;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import Model.MEmployee;
import View.ComboBoxAutoComplete;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CRegister implements Initializable {
	MEmployee new_employee;
	CList parent_controller;
	String image_path;
	ComboBoxAutoComplete<String> autocmb;
	
    @FXML
    private Button btnRegisterImage;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnCancel;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtName;

    @FXML
    private ComboBox<String> cmbDepart;

    @FXML
    private Button btnDepartInsert;

    @FXML
    private ImageView imvFace;
    
    @FXML
    void OnCancel(ActionEvent event) {
    	Stage thisStage = (Stage)this.btnCancel.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void OnDepartInsert(ActionEvent event) {
    	/* Fill */
    }

    @FXML
    void OnDone(ActionEvent event) {
    	/* Fill */
    }

    @FXML
    void OnRegisterImage(ActionEvent event) {
    	/* Fill */
    }

    void setPerentController(CList controller) {
    	this.parent_controller = controller;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.new_employee = null;
    	this.parent_controller = null;
    	this.cmbDepart.getItems().addAll("HILab", "MECSLab", "AIBILab");
    	autocmb = new ComboBoxAutoComplete<String>(this.cmbDepart);
	}
}