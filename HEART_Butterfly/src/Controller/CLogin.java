package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    void login(ActionEvent event) {

    }

    @FXML
    void loginExit(ActionEvent event) {

    }

}
