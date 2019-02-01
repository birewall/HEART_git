package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CCollectionInfoSelector extends AbsMetaController implements Initializable {

    int column_size = 8;
    MDBCollectionInfo db_collectionInfo = null;
    public class TableData {
        String date;
        String country;
        String location_alias;
        String butterfly_name;
        String butterfly_family;
        String collect_method;
        String collecter;

        public TableData() {
            this.date = null;
            this.country = null;
            this.location_alias = null;
            this.butterfly_name = null;
            this.butterfly_family = null;
            this.collect_method = null;
            this.collecter = null;
        }

        public TableData(String date, String country, String location_alias, String butterfly_name, String butterfly_family, String collect_method, String collecter) {
            this.date = date;
            this.country = country;
            this.location_alias = location_alias;
            this.butterfly_name = butterfly_name;
            this.butterfly_family = butterfly_family;
            this.collect_method = collect_method;
            this.collecter = collecter;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLocation_alias() {
            return location_alias;
        }

        public void setLocation_alias(String location_alias) {
            this.location_alias = location_alias;
        }

        public String getButterfly_name() {
            return butterfly_name;
        }

        public void setButterfly_name(String butterfly_name) {
            this.butterfly_name = butterfly_name;
        }

        public String getButterfly_family() {
            return butterfly_family;
        }

        public void setButterfly_family(String butterfly_family) {
            this.butterfly_family = butterfly_family;
        }

        public String getCollect_method() {
            return collect_method;
        }

        public void setCollect_method(String collect_method) {
            this.collect_method = collect_method;
        }

        public String getCollecter() {
            return collecter;
        }

        public void setCollecter(String collecter) {
            this.collecter = collecter;
        }

        public String getVariableName(int index) {
            switch(index) {
                case 0:
                    return "date";
                case 1:
                    return "country";
                case 2:
                    return "location_alias";
                case 3:
                    return "butterfly_name";
                case 4:
                    return "butterfly_family";
                case 5:
                    return "collect_method";
                case 6:
                    return "collecter";
                default:
                    return null;
            }
        }

        public String getColumnName(int index) {
            switch(index) {
                case 0:
                    return "수집일";
                case 1:
                    return "국가";
                case 2:
                    return "지역명칭";
                case 3:
                    return "나비명";
                case 4:
                    return "나비과";
                case 5:
                    return "수집방법";
                case 6:
                    return "수집자";
                default:
                    return null;
            }
        }

        public void setRecord(int index, String data) {
            switch (index) {
                case 0:
                    this.date = data;
                    break;
                case 1:
                    this.country = data;
                    break;
                case 2:
                    this.location_alias = data;
                    break;
                case 3:
                    this.butterfly_name = data;
                    break;
                case 4:
                    this.butterfly_family = data;
                    break;
                case 5:
                    this.collect_method = data;
                    break;
                case 6:
                    this.collecter = data;
                    break;
                default:
                    break;
            }
        }

        public String getRecord(int index) {
            switch(index) {
                case 0:
                    return this.date;
                case 1:
                    return this.country;
                case 2:
                    return this.location_alias;
                case 3:
                    return this.butterfly_name;
                case 4:
                    return this.butterfly_family;
                case 5:
                    return this.collect_method;
                case 6:
                    return this.collecter;
                default:
                    break;
            }
            return null;
        }

        public int getSize() {
            return 7;
        }
    }
    TableData selected_item = null;

    @FXML
    private TableView<TableData> tblCollectionInfo;

    @FXML
    private CheckBox checkDateBegin;

    @FXML
    private DatePicker dateBegin;

    @FXML
    private CheckBox checkDateEnd;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private CheckBox checkCountry;

    @FXML
    private TextField txtCountry;

    @FXML
    private CheckBox checkAlias;

    @FXML
    private TextField txtAlias;

    @FXML
    private CheckBox checkButterflyName;

    @FXML
    private TextField txtButterflyName;

    @FXML
    private CheckBox checkButterflyFamily;

    @FXML
    private TextField txtButterflyFamily;


    @FXML
    private CheckBox checkTimeMorning;

    @FXML
    private CheckBox checkTimeAfternoon;

    @FXML
    private CheckBox checkTimeEvening;

    @FXML
    private CheckBox checkTimeDawn;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSelect;

    @FXML
    void OnAlias(ActionEvent event) {

    }

    @FXML
    void OnButterflyFamily(ActionEvent event) {

    }

    @FXML
    void OnButterflyName(ActionEvent event) {

    }

    @FXML
    void OnCancel(ActionEvent event) {
        Stage thisStage = (Stage)this.btnCancel.getScene().getWindow();
        thisStage.close();
    }

    @FXML
    void OnCountry(ActionEvent event) {

    }

    @FXML
    void OnDateBegin(ActionEvent event) {

    }

    @FXML
    void OnDateEnd(ActionEvent event) {

    }

    public String getQuery() {
        String query = "select c.date, l.country, l.alias, b.name, b.family, c.method, p.name" +
                " from Location l" +
                " inner join CollectionInfo c on l.idLocation = c.idLocation" +
                " inner join ButterflyGuide b on b.idButterflyGuide = c.idButterflyGuide" +
                " inner join Person p on p.idPerson = c.idPerson where";
        if(this.checkDateBegin.isSelected()) query += " c.date >= '" + MDateConvertor.convert2DBFormat(this.dateBegin.getEditor().getText()) + "' and ";
        if(this.checkDateEnd.isSelected()) query += " c.date <= '" + MDateConvertor.convert2DBFormat(this.dateEnd.getEditor().getText()) + "' and ";
        if(this.checkCountry.isSelected()) query += " l.country = '" + this.txtCountry.getText() + "' and ";
        if(this.checkAlias.isSelected()) query += " l.alias = '" + this.txtAlias.getText() + "' and ";
        if(this.checkButterflyName.isSelected()) query += " b.name = '" + this.txtButterflyName.getText() + "' and ";
        if(this.checkButterflyFamily.isSelected()) query += " b.family = '" + this.txtButterflyFamily.getText() + "' and ";
        /* To be implemented */
//        if(this.checkTimeMorning.isSelected()) query += "";
//        if(this.checkTimeAfternoon.isSelected()) query += "";
//        if(this.checkTimeEvening.isSelected()) query += "";
//        if(this.checkTimeDawn.isSelected()) query += "";
        query = query.substring(0, query.length()-4);
        return query;
    }
    @FXML
    void OnSearch(ActionEvent event) throws SQLException {
        /* Clean View */
        this.tblCollectionInfo.getItems().clear();

        /* Preparing Query */
        String query = getQuery();

        /* Querying */
        ResultSet query_result = db_collectionInfo.selectQuery(query);
        if(query_result == null) {
            Alert error_alert = new Alert(Alert.AlertType.ERROR);
            error_alert.setTitle("관찰정보 조회");
            error_alert.setHeaderText(null);
            error_alert.setContentText("없음");
            error_alert.show();
            return;
        }

        ResultSetMetaData rsmd = query_result.getMetaData();
        int columnCount = rsmd.getColumnCount();

        /* View Updating */
        while(query_result.next()) {
            TableData data = new TableData();
            for(int i = 0 ; i < columnCount ; i++) {
                data.setRecord(i, query_result.getString(i+1));
            }
            this.tblCollectionInfo.getItems().add(data);
        }
    }

    @FXML
    void OnSelect(ActionEvent event) throws SQLException {
        /* Data Passing */
        Stage thisStage = (Stage)this.btnSelect.getScene().getWindow();
        String date = selected_item.getRecord(0);
        String parsed_date = date.substring(0,4) + ". " + Integer.parseInt(date.substring(4,6)) + ". " + Integer.parseInt(date.substring(6,8));

        ResultSet rs = this.db_collectionInfo.selectQuery("select location, locationDetail, section, sectionDetail, scientific_name" +
                " from Location l" +
                " inner join CollectionInfo c on l.idLocation = c.idLocation" +
                " inner join ButterflyGuide b on b.idButterflyGuide = c.idButterflyGuide" +
                " inner join Person p on p.idPerson = c.idPerson" +
                " where l.country = '" + selected_item.getRecord(1)+ "'" +
                " and b.name = '" + selected_item.getRecord(3) + "'");
                //" and p.name = '" + selected_item.getRecord(5) + "'");
//        public void passing_collection_info(String date, String country, String location, String locationDetail,
//                String section, String sectionDetail, String loc_alias, String butter_name,
//                String butter_family, String butter_sci, String person_name) {
        if(!rs.next()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Search");
            alert.setHeaderText(null);
            alert.setContentText("수집정보를 찾을 수 없습니다.");
            alert.showAndWait();
            return;
        }else {
            ((AbsInsertController) this.parent_controller).passing_collection_info(parsed_date,//date
                    selected_item.getRecord(1),//country
                    rs.getString(1),//location
                    rs.getString(2),//locationDetail
                    rs.getString(3),//section
                    rs.getString(4),//sectionDetail
                    selected_item.getRecord(2),//alias
                    selected_item.getRecord(3),//butter_name
                    selected_item.getRecord(4),//butter_family
                    rs.getString(5),//butter_sci
                    selected_item.getRecord(5),//method
                    selected_item.getRecord(6));//person_name
        }
        thisStage.close();
    }

    @FXML
    void OnTimeAfternoon(ActionEvent event) {

    }

    @FXML
    void OnTimeDawn(ActionEvent event) {

    }

    @FXML
    void OnTimeEvening(ActionEvent event) {

    }

    @FXML
    void OnTimeMorning(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* Column Settings */
        this.selected_item = new TableData();
        for (int i = 0 ; i < column_size ; i++) {
            TableColumn<TableData, String> column = new TableColumn<TableData, String>(selected_item.getColumnName(i));
            column.setCellValueFactory(new PropertyValueFactory<>(selected_item.getVariableName(i)));
            this.tblCollectionInfo.getColumns().add(column);
        }

        /* Click Event Handler */
        this.tblCollectionInfo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selected_item = null;
            if (oldSelection == newSelection) return;
            if (newSelection != null) {
                selected_item = this.tblCollectionInfo.getSelectionModel().getSelectedItem();
            }
        });
    }

    @Override
    public void init_procedure() {
        db_collectionInfo = new MDBCollectionInfo(((MSharedData)this.shared_model).getDB().getConnection());
    }
}