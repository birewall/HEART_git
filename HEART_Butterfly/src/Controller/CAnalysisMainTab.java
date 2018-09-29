package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CAnalysisMainTab extends AbsMetaController implements Initializable {

    @FXML
    private TabPane tabPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Tab tabSummary = new Tab();
        Tab tabGraph = new Tab();
        Tab tabSpecimenIO = new Tab();
        Tab tabSpecimenStatus = new Tab();
        try {
            tabSummary.setContent((Node) FXMLLoader.load(this.getClass().getResource("/View/VAnalysisSummary.fxml")));
            tabGraph.setContent((Node) FXMLLoader.load(this.getClass().getResource("/View/VAnalysisDataplot.fxml")));
            tabSpecimenIO.setContent((Node) FXMLLoader.load(this.getClass().getResource("/View/VAnalysisSpecimenMove.fxml")));
            tabSpecimenStatus.setContent((Node) FXMLLoader.load(this.getClass().getResource("/View/VSpecimenMove.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.tabPane.getTabs().addAll(tabSummary, tabGraph, tabSpecimenIO, tabSpecimenStatus);
    }
}
