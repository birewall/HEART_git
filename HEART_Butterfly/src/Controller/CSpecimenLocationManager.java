package Controller;

import Model.MDBSpecimen;
import Model.MSharedData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CSpecimenLocationManager extends AbsMetaController implements Initializable {

    MDBSpecimen db_specimen = null;

    @FXML
    private TextField txtRoom;

    @FXML
    private ListView<String> lstRoom;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField txtCabinet;

    @FXML
    private ListView<String> lstCabinet;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtChest;

    @FXML
    private ListView<String> lstChest;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSelect;

    @FXML
    void OnSelect(ActionEvent event) {
        /* Parameter Check : Not yet! */
        String room = this.txtRoom.getText();
        String cabinet = this.txtCabinet.getText();
        String chest = this.txtChest.getText();

        ((CSpecimenMove)this.parent_controller).setStorage(room, cabinet, chest);

        this.nowStage = (Stage)this.btnCancel.getScene().getWindow();
        this.nowStage.close();
    }

    @FXML
    void OnCancel(ActionEvent event) {
        this.nowStage = (Stage)this.btnCancel.getScene().getWindow();
        this.nowStage.close();
    }

    @FXML
    void OnDelete(ActionEvent event) {
        /* Delete if it can be */
    }

    @FXML
    void OnEditCabinet(ActionEvent event) {
        /* Update Chest */
        String roomString = this.txtRoom.getText();
        if(roomString.length() == 0) return;
        String cabinetString = this.txtCabinet.getText();
        if(cabinetString.length() == 0) return;

        updateChest(roomString, cabinetString);
    }

    @FXML
    void OnEditingChest(ActionEvent event) {

    }

    @FXML
    void OnEditingRoom(ActionEvent event) {
        /* Update Cabinet */
        String roomString = this.txtRoom.getText();
        if(roomString.length() == 0) return;

        updateCabinet(roomString);
    }

    private void updateCabinet(String roomString) {
        this.lstCabinet.getItems().clear();
        this.lstChest.getItems().clear();

        ResultSet storage_list = db_specimen.selectQuery("select storageCabinet from Specimen where storageRoom='" + roomString + "' order by storageCabinet asc");

        try {
            while(storage_list.next()) {
                this.lstCabinet.getItems().add(storage_list.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateChest(String roomString, String cabinetString) {
        this.lstChest.getItems().clear();

        ResultSet storage_list = db_specimen.selectQuery("select storageChest from Specimen where storageRoom='" + roomString + "' and storageCabinet='" + cabinetString + "' order by storageChest asc");

        try {
            while(storage_list.next()) {
                this.lstChest.getItems().add(storage_list.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnInsert(ActionEvent event) {
        /* Apply to parent */
        this.nowStage = (Stage)this.btnCancel.getScene().getWindow();
        this.nowStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.lstRoom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                /* Error Handling */
                if(lstRoom.getSelectionModel() == null) return;

                /* Set View */
                txtRoom.setText(newValue);
                updateCabinet(newValue);
            }
        });

        this.lstCabinet.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                /* Error Handling */
                if(lstCabinet.getSelectionModel() == null) return;

                /* Set View */
                txtCabinet.setText(newValue);
                if(txtRoom.getText().length() == 0) return;
                updateChest(txtRoom.getText(), newValue);
            }
        });

        this.lstChest.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                /* Error Handling */
                if(lstChest.getSelectionModel() == null) return;

                /* Set View */
                txtChest.setText(newValue);
            }
        });
    }

    public void init_procedure() {
        db_specimen = new MDBSpecimen(((MSharedData)this.shared_model).getDB().getConnection());

        /* Update Room */
        ResultSet storage_list = db_specimen.selectQuery("select storageRoom from Specimen");

        try {
            while(storage_list.next()) {
                this.lstRoom.getItems().add(storage_list.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
