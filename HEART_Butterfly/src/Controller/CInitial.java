package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CInitial extends AbsMetaController {

    @FXML
    private TextField textLoginID;

    @FXML
    private PasswordField txtLoginPW;

    @FXML
    private Button btnLoginExit;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblLoginFail;

    private String id = "developer";
    private String password = "test";
    
    @FXML
    void login(ActionEvent event) throws IOException {
    	// Exception Handling
    	if(this.textLoginID.getText().length() == 0) {
    		this.lblLoginFail.setText("?ïÑ?ù¥?îîÎ•? ?ûÖ?†•?ïò?Ñ∏?öî.");
    	}
    	
    	if(this.txtLoginPW.getText().length() == 0) {
    		this.lblLoginFail.setText("ÎπÑÎ?Î≤àÌò∏Î•? ?ûÖ?†•?ïò?Ñ∏?öî.");
    	}
    	
    	// Login Sequence
    	if(this.textLoginID.getText().equals(id) && this.txtLoginPW.getText().equals(password)) {
        	changeWindow(this.btnLogin.getScene().getWindow(), "VMain");
    	} else {
    		this.lblLoginFail.setText("?†ïÎ≥¥Í? ?ùºÏπòÌïòÏß? ?ïä?äµ?ãà?ã§.");
    	}
    }

    @FXML
    void loginExit(ActionEvent event) {
    	System.exit(0);
    }
    
    /* For Debug */
    public void setForDebug() {
    	this.textLoginID.setText(id);
    	this.txtLoginPW.setText(password);
    }
}
