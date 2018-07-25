package Controller;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.MComboBoxAutoComplete;
import Model.MEmployee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CRegister implements Initializable {
	MEmployee new_employee;
	CList parent_controller;
	String image_path = null;
	MComboBoxAutoComplete<String> autocmb;
	
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
    	TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Add new department");
		dialog.setHeaderText(null);
		dialog.setContentText("Type department name");
		dialog.showAndWait();
		
		/* Apply to view */
		this.cmbDepart.getItems().add(dialog.getEditor().getText());
    }
    
    
	File selectedFile = null;
    @FXML
    void OnRegisterImage(ActionEvent event) {
	    /* Choose file */
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("."));
		selectedFile = fc.showOpenDialog(null);    
		
		/*Set image*/

		Image image = new Image(selectedFile.toURI().toString());
		this.imvFace.setImage(image);	
    }
    
    @FXML
    void OnDone(ActionEvent event) {
    	/*Save Name*/
    	String new_txtName = this.txtName.toString();
    	this.new_employee.setName(new_txtName);
    	/*Save Date*/
    	String new_txtDate = this.txtDate.toString();
    	this.new_employee.setEnroll_date(new_txtDate);
    	/*Save Department*/
    	String new_txtDepartment = this.cmbDepart.toString();
    	this.new_employee.setDepartment(new_txtDepartment);
    	/*Save Image View Path*/
		image_path = selectedFile.getPath().toString();
		this.new_employee.setImage_path(image_path);
		
		parent_controller.RegisterEmployee(new_employee);
		/*Send to CList*/
		
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
    	autocmb = new MComboBoxAutoComplete<String>(this.cmbDepart);
	}
}
