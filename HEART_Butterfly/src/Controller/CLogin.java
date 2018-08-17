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

public class CLogin extends AbsMetaController {

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

    @FXML
    void login(ActionEvent event) throws IOException {
    	changeWindow(this.btnLogin.getScene().getWindow(), "VMain");
    }

    @FXML
    void loginExit(ActionEvent event) {
    	System.exit(0);
    }

}
