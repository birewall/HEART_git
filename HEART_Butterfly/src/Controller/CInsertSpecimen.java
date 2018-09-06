package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CInsertSpecimen extends AbsMetaController implements Initializable {

    @FXML
    private DatePicker dateInsertSpecimenCollectdate;

    @FXML
    private TextField txtInsertSpecimenCollectoc;

    @FXML
    private Button btnInsertSpecimenSearchcollectloc;

    @FXML
    private ComboBox<String> comboInsertSpecimenWho;

    @FXML
    private Button btnInsertSpecimenChoosewho;

    @FXML
    private Button btnInsertSpecimenClear;

    @FXML
    private TextField txtInsertSpecimenBname;

    @FXML
    private TextField txtInsertSpecimenFamily;

    @FXML
    private TextField txtInsertSpecimenZoological;

    @FXML
    private Button btnInsertSpecimenAdd;

    @FXML
    private Button btnInsertSpecimenExit;

    @FXML
    private ComboBox<String> comboInsertSpecimenStatus;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc1;

    @FXML
    private ComboBox<String> comboInsertSpecimenLoc2;

    @FXML
    private ComboBox<String> comboInsertSpecimenSex;

    @FXML
    private TextField txtInsertSpecimenRemark;

    @FXML
    private Button btnInsertSpecimenChoosecollectwho;

    @FXML
    private ComboBox<?> comboInsertSpecimenCollectwho;

    @FXML
    private TextField txtInsertSpecimenNation;

    @FXML
    private DatePicker dateInsertSpecimenDate;

    @FXML
    private ComboBox<?> comboInsertSpecimenLoc3type;

    @FXML
    private ComboBox<String> comboInsertSpecimenCollectway;

    @FXML
    private TextField txtInsertSpecimenLocname;

    @FXML
    private TextField txtInsertSpecimenLong;

    @FXML
    private TextField txtInsertSpecimenLat;

    @FXML
    private TextField txtInsertSpecimenDong;

    @FXML
    private TextField txtInsertSpecimenSi;

    @FXML
    private TextField txtInsertSpecimenDo;

    @FXML
    private Button btnInsertSpecimenLabel;

    @FXML
    private ComboBox<?> comboInsertSpecimenLoc2type;

    @FXML
    private ComboBox<?> comboInsertSpecimenLoc31;

    @FXML
    private Button btnInsertSpecimenCorrect;

    @FXML
    void addInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void bnameInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void choosecollectwhoInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void choosewhoInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void clearInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void collectdateInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void collectlocInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void collectwayInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void collectwhoInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void correctInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void dateInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void doInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void dongInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void exitInsertSpecimen(ActionEvent event) throws IOException {
    	changeWindow(this.btnInsertSpecimenExit.getScene().getWindow(), "VInsert");
    }

    @FXML
    void familyInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void labelInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void latInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc1InsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc2InsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc2typeInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc3InsertSpecimen(ActionEvent event) {

    }

    @FXML
    void loc3typeInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void locnameInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void longInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void nationInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void remarkInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void searchcollectlocInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void sexInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void siInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void statusInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void whoInsertSpecimen(ActionEvent event) {

    }

    @FXML
    void zoologicalInsertSpecimen(ActionEvent event) {

    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.comboInsertSpecimenCollectway.getItems().addAll("직접채집", "구매", "기증");
		this.comboInsertSpecimenWho.getItems().addAll("조윤호");
		this.comboInsertSpecimenStatus.getItems().addAll("상", "중", "하");
		this.comboInsertSpecimenLoc1.getItems().addAll("집", "학교", "사무실");
		this.comboInsertSpecimenSex.getItems().addAll("수", "암");

	}
	
}
