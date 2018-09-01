package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CAnalysisMain extends AbsMetaController {

    @FXML
    private Tab tabSummaryAnalysis;

    @FXML
    private RadioButton radioSummaryAnalysisDate;

    @FXML
    private ToggleGroup SummaryAnalysis;

    @FXML
    private RadioButton radioSummaryAnalysisNation;

    @FXML
    private RadioButton radioSummaryAnalysisBname;

    @FXML
    private RadioButton radioSummaryAnalysisFamily;

    @FXML
    private Button btnSummaryAnalysisClear;

    @FXML
    private Button vtnSummaryAnalysisSearch;

    @FXML
    private TextField txtSummaryAnalysisDateselect;

    @FXML
    private DatePicker calenSummaryAnalysisCalender;

    @FXML
    private ComboBox<?> comboSummaryAnalysisNation;

    @FXML
    private ComboBox<?> comboSummaryAnalysisFamily;

    @FXML
    private ComboBox<?> comboSummaryAnalysisBname;

    @FXML
    private TextField txtSummaryAnalysisStartdate;

    @FXML
    private TextField txtSummaryAnalysisNation;

    @FXML
    private TextField txtSummaryAnalysisNationselect;

    @FXML
    private TextField txtSummaryAnalysisFamily;

    @FXML
    private TextField txtSummaryAnalysisFamilyselect;

    @FXML
    private TextField txtSummaryAnalysisBname;

    @FXML
    private TextField txtSummaryAnalysisBnameselect;

    @FXML
    private ComboBox<?> comboSummaryAnalysisYear;

    @FXML
    private ComboBox<?> comboSummaryAnalysisMonth;

    @FXML
    private TextField txtSummaryAnalysisEnddate;

    @FXML
    private RadioButton radioSummaryAnalysisYearm;

    @FXML
    private TextField txtSummaryAnalysisYear;

    @FXML
    private TextField txtSummaryAnalysisMonth;

    @FXML
    private TextField txtSummaryAnalysisYearmselect;

    @FXML
    private BarChart<?, ?> plotSummaryAnalysis;

    @FXML
    private TextField txtSummaryAnalysisAll;

    @FXML
    private TextField txtSummaryAnalysisWatch;

    @FXML
    private TextField txtSummaryAnalysisPicture;

    @FXML
    private TextField txtSummaryAnalysisSpecimen;

    @FXML
    private Button btnSummaryAnalysisExport;

    @FXML
    private Button btnSummaryAnalysisExit;

    @FXML
    private Tab tabDataAnalysis;

    @FXML
    private RadioButton radioDataAnalysisPicture;

    @FXML
    private ToggleGroup DataAnalysis;

    @FXML
    private RadioButton radioDataAnalysisSpecimen;

    @FXML
    private RadioButton radioDataAnalysisWatch;

    @FXML
    private RadioButton radioDataAnalysisAll;

    @FXML
    private TextField txtDataAnalysisFamily;

    @FXML
    private TextField txtDataAnalysisBname;

    @FXML
    private ComboBox<?> comboDataAnalysisStatus;

    @FXML
    private ComboBox<?> comboDataAnalysisSex;

    @FXML
    private ComboBox<?> comboDataAnalysisDate;

    @FXML
    private Slider scrollDataAnalysisDate;

    @FXML
    private LineChart<?, ?> graphDataAnalysis;

    @FXML
    private Button btnDataAnalysisLocname;

    @FXML
    private CheckBox checkDataAnalysisFamily;

    @FXML
    private CheckBox checkDataAnalysisBname;

    @FXML
    private CheckBox checkDataAnalysisStatus;

    @FXML
    private CheckBox checkDataAnalysisSex;

    @FXML
    private CheckBox checkDataAnalysisPicture;

    @FXML
    private TextField txtDataAnalysisSelectedloc1;

    @FXML
    private Button btnDataAnalysisLocmap;

    @FXML
    private CheckBox checkDataAnalysisLoc;

    @FXML
    private TextField txtDataAnalysisBiggest;

    @FXML
    private Button btnDataAnalysisData;

    @FXML
    private Button btnDataAnalysisExport;

    @FXML
    private Button btnDataAnalysisExit;

    @FXML
    private TextField txtDataAnalysisWatchnumber;

    @FXML
    private TextField txtDataAnalysisCollectnumber;

    @FXML
    private TextField txtDataAnalysisSelecteddate;

    @FXML
    private TextField txtDataAnalysisSelectedloc2;

    @FXML
    private TextField txtDataAnalysisSelectedfamily;

    @FXML
    private TextField txtDataAnalysisSelectedbname;

    @FXML
    private TextField txtDataAnalysisSelectedstatus;

    @FXML
    private TextField txtDataAnalysisSelectedsex;

    @FXML
    private TextField txtDataAnalysisSelectedpicture;

    @FXML
    private Tab tabSpecHistory;

    @FXML
    private ComboBox<?> comboSpecHistoryDate;

    @FXML
    private ComboBox<?> comboSpecHistoryTime;

    @FXML
    private TextField txtSpecHistoryLoc;

    @FXML
    private Button btnSpecHistoryLocname;

    @FXML
    private TextField txtSpecHistoryNation;

    @FXML
    private TextField txtSpecHistoryBname;

    @FXML
    private ComboBox<?> comboSpecHistoryStatus;

    @FXML
    private ComboBox<?> comboSpecHistorySex;

    @FXML
    private TableView<?> tblSpecHistory;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryLabelid;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryDate;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryTime;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryNation;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryLoc;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryFamily;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryBname;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryZoo;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryStatus;

    @FXML
    private TableColumn<?, ?> tblcSpecHistorySex;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryBLoc;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryLoc2;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryLoc3;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryContent;

    @FXML
    private TableColumn<?, ?> tblcSpecHistoryWorkdate;

    @FXML
    private Button btnSpecHistorySearch;

    @FXML
    private Button btnSpecHistoryExport;

    @FXML
    private TextField txtSpecHistoryFamily;

    @FXML
    private TextField txtSpecHistoryZoo;

    @FXML
    private TextField txtSpecHistoryLabelid;

    @FXML
    private ComboBox<?> comboSpecHistoryBloc1;

    @FXML
    private ComboBox<?> comboSpecHistoryLoc2type;

    @FXML
    private TextField txtSpecHistoryLoc2;

    @FXML
    private TextField txtSpecHistoryLoc3;

    @FXML
    private ComboBox<?> comboSpecHistoryLoc3type;

    @FXML
    private ComboBox<?> comboAnalysisBasicTime112;

    @FXML
    private Button btnSpecHistoryExit;

    @FXML
    private Button btnSpecHistoryCorrect;

    @FXML
    private Button btnSpecHistoryLocmap;

    @FXML
    void allDataAnalysis(ActionEvent event) {

    }

    @FXML
    void allSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void biggestDataAnalysis(ActionEvent event) {

    }

    @FXML
    void bloc1SpecHistory(ActionEvent event) {

    }

    @FXML
    void bnameDataAnalysis(ActionEvent event) {

    }

    @FXML
    void bnameSpecHistory(ActionEvent event) {

    }

    @FXML
    void bnameSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void bnamecheckDataAnalysis(ActionEvent event) {

    }

    @FXML
    void bnameradioSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void bnameselectSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void bnametxtSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void calenderSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void clearSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void collectnumberDataAnalysis(ActionEvent event) {

    }

    @FXML
    void correctSpecHistory(ActionEvent event) {

    }

    @FXML
    void dataDataAnalysis(ActionEvent event) {

    }

    @FXML
    void dateDataAnalysis(ActionEvent event) {

    }

    @FXML
    void dateSpecHistory(ActionEvent event) {

    }

    @FXML
    void dateSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void dateselectSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void enddateSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void exitDataAnalysis(ActionEvent event) {

    }

    @FXML
    void exitSpecHistory(ActionEvent event) {

    }

    @FXML
    void exitSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void exportDataAnalysis(ActionEvent event) {

    }

    @FXML
    void exportSpecHistory(ActionEvent event) {

    }

    @FXML
    void exportSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void familyDataAnalysis(ActionEvent event) {

    }

    @FXML
    void familySpecHistory(ActionEvent event) {

    }

    @FXML
    void familySummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void familycheckDataAnalysis(ActionEvent event) {

    }

    @FXML
    void familyradioSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void familyselecttSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void familytxtSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void labelidSpecHistory(ActionEvent event) {

    }

    @FXML
    void loc2SpecHistory(ActionEvent event) {

    }

    @FXML
    void loc2typeSpecHistory(ActionEvent event) {

    }

    @FXML
    void loc3SpecHistory(ActionEvent event) {

    }

    @FXML
    void loc3typeSpecHistory(ActionEvent event) {

    }

    @FXML
    void locDataAnalysis(ActionEvent event) {

    }

    @FXML
    void locSpecHistory(ActionEvent event) {

    }

    @FXML
    void locmapSpecHistory(ActionEvent event) {

    }

    @FXML
    void locmpDataAnalysis(ActionEvent event) {

    }

    @FXML
    void locnameDataAnalysis(ActionEvent event) {

    }

    @FXML
    void locnameSpecHistory(ActionEvent event) {

    }

    @FXML
    void monthSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void nationSpecHistory(ActionEvent event) {

    }

    @FXML
    void nationSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void nationradioSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void nationselectSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void pictureDataAnalysis(ActionEvent event) {

    }

    @FXML
    void pictureSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void searchSpecHistory(ActionEvent event) {

    }

    @FXML
    void searchSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void selectedbnameDataAnalysis(ActionEvent event) {

    }

    @FXML
    void selecteddateDataAnalysis(ActionEvent event) {

    }

    @FXML
    void selectedfamilyDataAnalysis(ActionEvent event) {

    }

    @FXML
    void selectedloc1DataAnalysis(ActionEvent event) {

    }

    @FXML
    void selectedloc2DataAnalysis(ActionEvent event) {

    }

    @FXML
    void selectedpictureDataAnalysis(ActionEvent event) {

    }

    @FXML
    void selectedsexDataAnalysis(ActionEvent event) {

    }

    @FXML
    void selectedstatusDataAnalysis(ActionEvent event) {

    }

    @FXML
    void sexDataAnalysis(ActionEvent event) {

    }

    @FXML
    void sexSpecHistory(ActionEvent event) {

    }

    @FXML
    void sexcheckDataAnalysis(ActionEvent event) {

    }

    @FXML
    void specimenDataAnalysis(ActionEvent event) {

    }

    @FXML
    void specimenSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void startdateSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void statusDataAnalysis(ActionEvent event) {

    }

    @FXML
    void statusSpecHistory(ActionEvent event) {

    }

    @FXML
    void statuscheckDataAnalysis(ActionEvent event) {

    }

    @FXML
    void timeAnalysisBasic(ActionEvent event) {

    }

    @FXML
    void timeSpecHistory(ActionEvent event) {

    }

    @FXML
    void txtnationSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void watchDataAnalysis(ActionEvent event) {

    }

    @FXML
    void watchSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void watchnumberDataAnalysis(ActionEvent event) {

    }

    @FXML
    void yearSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void yearmradioSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void yearmselectSummaryAnalysis(ActionEvent event) {

    }

    @FXML
    void zooSpecHistory(ActionEvent event) {

    }

}
