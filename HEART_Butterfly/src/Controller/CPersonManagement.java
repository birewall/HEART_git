package Controller;

import Model.MDBPerson;
import Model.MSharedData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CPersonManagement extends AbsMetaController implements Initializable {

    MDBPerson db_person = null;

    @FXML
    private ListView<String> lsvName;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnEdit;

    @FXML
    private TextField txtName;

    @FXML
    void OnDelete(ActionEvent event) {
        /* Error Handling */
        String new_name = txtName.getText();
        if(new_name.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("삭제 실패");
            alert.setHeaderText(null);
            alert.setContentText("잘못된 이름입니다.");
            alert.show();
            return;
        }

        /* DB Querying */
        if(!db_person.delete_by_name(new_name)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("삭제 실패");
            alert.setHeaderText(null);
            alert.setContentText("삭제 오류가 발생했습니다.");
            alert.show();
            return;
        }

        /* View Updating */
        this.lsvName.getItems().remove(new_name);
    }

    @FXML
    void OnDone(ActionEvent event) {
        Stage thisStage = (Stage)this.btnDone.getScene().getWindow();
        this.parent_controller.view_update();
        thisStage.close();
    }

    @FXML
    void OnEdit(ActionEvent event) {
        /* Error Handling */
        if(this.lsvName.getSelectionModel() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("변경할 이름을 선택해주세요.");
            alert.show();
            return;
        }

        String before_name = this.lsvName.getSelectionModel().getSelectedItem();
        String new_name = txtName.getText();
        if(new_name.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("잘못된 이름입니다.");
            alert.show();
            return;
        }

        db_person.setName(new_name);
        int id_person = db_person.getIdPersonFromDB();
        if(id_person > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("이미 존재하는 이름입니다.");
            alert.show();
            return;
        }

        /* DB Querying */
        if(!db_person.update(id_person)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("입력 오류가 발생했습니다.");
            alert.show();
            return;
        }

        /* View Updating */
        int item_index = this.lsvName.getSelectionModel().getSelectedIndex();
        this.lsvName.getItems().remove(before_name);
        this.lsvName.getItems().add(item_index, new_name);
    }

    @FXML
    void OnInsert(ActionEvent event) {
        /* Error Handling */
        String new_name = txtName.getText();
        if(new_name.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("잘못된 이름입니다.");
            alert.show();
            return;
        }

        db_person.setName(new_name);
        int id_person = db_person.getIdPersonFromDB();
        if(id_person > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("이미 존재하는 이름입니다.");
            alert.show();
            return;
        }

        /* DB Querying */
        db_person.setName(new_name);
        if(!db_person.insert()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("입력 실패");
            alert.setHeaderText(null);
            alert.setContentText("입력 오류가 발생했습니다.");
            alert.show();
            return;
        }

        /* View Updating */
        this.lsvName.getItems().add(new_name);
    }

    @FXML
    void OnNameTyping(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.lsvName.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                /* Error Handling */
                if(lsvName.getSelectionModel() == null) return;

                /* Set View */
                txtName.setText(newValue);
            }
        });
    }

    public void init_procedure() {
        db_person = new MDBPerson(((MSharedData)this.shared_model).getDB().getConnection());
        ResultSet person_list = db_person.selectQuery("select name from Person");

        try {
            while(person_list.next()) {
                this.lsvName.getItems().add(person_list.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
