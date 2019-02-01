package Controller;

import Model.MDBLocation;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CAddressBook extends AbsMetaController implements Initializable {

    MDBLocation db_location;

    @FXML
    private TextField txtAddress;

    @FXML
    private ListView<String> lstAddress;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtDetailAddress;

    @FXML
    private ListView<String> lstDetailAddress;

    @FXML
    private Button btnSelect;

    @FXML
    private TextField txtAlias;

    @FXML
    private ListView<String> lstAlias;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtSection;

    @FXML
    private ListView<String> lstSection;

    @FXML
    private ListView<String> lstCountry;

    @FXML
    private TextField txtCountry;

    @FXML
    void OnCountry(ActionEvent event) {
        this.lstAddress.getItems().clear();
        this.txtAddress.setText(null);
        this.lstDetailAddress.getItems().clear();
        this.txtDetailAddress.setText(null);
        this.lstSection.getItems().clear();
        this.txtSection.setText(null);
        String selected = lstCountry.getSelectionModel().getSelectedItem();
        if(selected != null) {
            fillAddress(selected);
            txtCountry.setText(selected);
        }
    }

    @FXML
    void OnSection(ActionEvent event) {
        String selected = this.lstSection.getSelectionModel().getSelectedItem();
        if(selected != null) {
            txtSection.setText(selected);
        }
    }

    @FXML
    void OnAddress(ActionEvent event) {
        this.lstDetailAddress.getItems().clear();
        this.txtDetailAddress.setText(null);
        this.lstSection.getItems().clear();
        this.txtSection.setText(null);
        String selected = lstAddress.getSelectionModel().getSelectedItem();
        if(selected != null) {
            fillDetailAddress(selected);
            txtAddress.setText(selected);
        }
    }

    @FXML
    void OnAlias(ActionEvent event) {
        String selected = lstAlias.getSelectionModel().getSelectedItem();
        if(selected != null) {
            txtAlias.setText(selected);

            /* Set Address Automatically */
            ResultSet result_query = this.db_location.selectQuery("select location, locationDetail, section, sectionDetail from Location where alias = '" + selected + "'");

            try {
                result_query.next();
                txtAddress.setText(result_query.getString(1));
                txtDetailAddress.setText(result_query.getString(2));
                if(result_query.getString(4) == null || result_query.getString(4).equals("")) {
                    txtSection.setText(result_query.getString(3));
                }else{
                    txtSection.setText(result_query.getString(3) + " " + result_query.getString(4));
                }
            } catch (SQLException e) {
                ((MSharedData)this.shared_model).getLogger().debug("No item for '" + txtAlias.getText() + "'");
            }
        }
    }

    @FXML
    void OnCancel(ActionEvent event) {
        ((Stage)this.btnCancel.getScene().getWindow()).close();
    }

    @FXML
    void OnDelete(ActionEvent event) {
        this.fillAlias();

        /* Not Yet */
    }

    @FXML
    void OnDetailAddress(ActionEvent event) {
        this.lstSection.getItems().clear();
        this.txtSection.setText(null);
        String selected = lstDetailAddress.getSelectionModel().getSelectedItem();
        if(selected != null) {
            fillSection(selected);
            txtDetailAddress.setText(selected);
        }
    }

    @FXML
    void OnSelect(ActionEvent event) throws SQLException {
        /* Add to Previous */
        if(this.txtAlias.getText().length() == 0) {
            String query = null;
            if(this.txtSection.getText().length() != 0 && this.txtSection.getText().split(" ").length == 1) {
                query = "select alias from Location where country = '" + this.txtCountry.getText() + "'"
                                                + " and location = '" + this.txtAddress.getText() + "'"
                                                + " and locationDetail = '" + this.txtDetailAddress.getText() + "'"
                                                + " and section = '" + this.txtSection.getText() + "';";
            }else if(this.txtSection.getText().length() != 0){
                query = "select alias from Location where country = '" + this.txtCountry.getText() + "'"
                        + " and location = '" + this.txtAddress.getText() + "'"
                        + " and locationDetail = '" + this.txtDetailAddress.getText() + "'"
                        + " and section = '" + this.txtSection.getText().split(" ")[0] + "'"
                        + " and section = '" + this.txtSection.getText().split(" ")[1] + "'";
            }else if(this.txtDetailAddress.getText().length() != 0){
                query = "select alias from Location where country = '" + this.txtCountry.getText() + "'"
                        + " and location = '" + this.txtAddress.getText() + "'"
                        + " and locationDetail = '" + this.txtDetailAddress.getText() + "'";
            }else{
                query = "select alias from Location where country = '" + this.txtCountry.getText() + "'"
                        + " and location = '" + this.txtAddress.getText() + "'";
            }
            ResultSet rs = this.db_location.selectQuery(query);
            if(rs.next()) {
                this.txtAlias.setText(rs.getString(1));
            }
        }
        ((AbsInsertController)this.parent_controller).passing_address(this.txtCountry.getText(),
                                                                        this.txtAddress.getText(),
                                                                        this.txtDetailAddress.getText(),
                                                                        this.txtSection.getText(),
                                                                        this.txtAlias.getText());
        ((Stage)this.txtSection.getScene().getWindow()).close();
    }

    @FXML
    void OnInsert(ActionEvent event) {
        /* Insert */
        String country = "대한민국";
        String location = txtAddress.getText();
        String locationDetail = txtDetailAddress.getText();
        String section = null;
        String sectionDetail = null;
        String[] sectionSplit = txtSection.getText().split(" ");
        if(sectionSplit.length == 1) {
            section = txtSection.getText();
        }else{
            section = sectionSplit[0];
            sectionDetail = sectionSplit[1];
        }
        String alias = txtAlias.getText();

        /* DB Insert */
        this.db_location.setCountry(country);
        this.db_location.setLocation(location);
        this.db_location.setLocationDetail(locationDetail);
        this.db_location.setSection(section);
        this.db_location.setSectionDetail(sectionDetail);
        this.db_location.setAlias(alias);

        if(this.db_location.getIdLocationFromDB() > 0) {
            /* If exist, print error */
            Alert msgBox = new Alert(Alert.AlertType.ERROR);
            msgBox.setTitle("지역 추가");
            msgBox.setHeaderText(null);
            msgBox.setContentText("이미 존재하는 지역입니다.");
            msgBox.showAndWait();
        }else{
            /* If not, insert */
            this.db_location.insert();
        }

        this.fillAlias();
    }

    private void fillCountry() {
        ResultSet result_query = this.db_location.selectQuery("select distinct country from Location;");
        this.lstCountry.getItems().clear();
        try{
            while(result_query.next()) {
                this.lstCountry.getItems().add(result_query.getString(1));
            }
        }catch (SQLException exp){
            ((MSharedData)this.shared_model).getLogger().debug("No item for country");
        }
    }

    private void fillAddress(String address) {
        ResultSet result_query = this.db_location.selectQuery("select distinct location from Location where country = '" + address + "';");
        this.lstAddress.getItems().clear();
        try{
            while(result_query.next()) {
                this.lstAddress.getItems().add(result_query.getString(1));
            }
        }catch (SQLException exp){
            ((MSharedData)this.shared_model).getLogger().debug("No item for location");
        }
    }

    private void fillDetailAddress(String address) {
        ResultSet result_query = this.db_location.selectQuery("select distinct locationDetail from Location where location = '" + address + "';");
        this.lstDetailAddress.getItems().clear();
        try{
            while(result_query.next()) {
                this.lstDetailAddress.getItems().add(result_query.getString(1));
            }
        }catch (SQLException exp){
            ((MSharedData)this.shared_model).getLogger().debug("No item for '" + address + "'");
        }
    }

    private void fillSection(String detail_address) {
        ResultSet result_query = this.db_location.selectQuery("select distinct section, sectionDetail from Location where locationDetail = '" + detail_address + "';");
        this.lstSection.getItems().clear();
        try{
            while(result_query.next()) {
                System.out.println(result_query.getString(2));
                if(result_query.getString(2) == null || result_query.getString(2).equals("")) {
                    this.lstSection.getItems().add(result_query.getString(1));
                }else{
                    this.lstSection.getItems().add(result_query.getString(1) + " " + result_query.getString(2));
                }
            }
        }catch (SQLException exp){
            ((MSharedData)this.shared_model).getLogger().debug("No item for '" + detail_address + "'");
        }
    }

    private void fillAlias() {
        ResultSet result_query = this.db_location.selectQuery("select distinct alias from Location;");
        this.lstAlias.getItems().clear();
        try{
            while(result_query.next()) {
                this.lstAlias.getItems().add(result_query.getString(1));
            }
        }catch (SQLException exp){
            ((MSharedData)this.shared_model).getLogger().debug("No item for alias");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* Register Click Handler */
        this.lstCountry.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                OnCountry(null);
            }
        });
        this.lstAddress.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                OnAddress(null);
            }
        });
        this.lstDetailAddress.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                OnDetailAddress(null);
            }
        });
        this.lstSection.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                OnSection(null);
            }
        });
        this.lstAlias.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                OnAlias(null);
            }
        });
    }

    public void init_procedure() {
        /* Set DB */
        this.db_location = new MDBLocation(((MSharedData) this.shared_model).getDB().getConnection());

        /* Fill Address and Alias List */
        this.txtCountry.setText("대한민국");
        fillCountry();
        fillAddress("대한민국");
        fillAlias();
    }
}
