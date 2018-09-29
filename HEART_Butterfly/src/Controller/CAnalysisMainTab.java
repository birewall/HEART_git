package Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CAnalysisMainTab extends AbsMetaController implements Initializable {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabSummary;

    @FXML
    private Tab tabGraph;

    @FXML
    private Tab tabSpecimenIO;

    @FXML
    private Tab tabSpecimenStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AbsMetaController this_controller = this;
        this.tabSummary.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (tabSummary.isSelected()) {
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = null;
                    try {
                        root = loader.load(getClass().getResource("/View/VAnalysisSummary.fxml").openStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    AbsMetaController controller = (AbsMetaController)loader.getController();
                    controller.setParentController(this_controller);
                    controller.setSharedModel(shared_model);
                    controller.init_procedure();
                    tabSummary.setContent(root);
                }
            }
        });

        this.tabGraph.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (tabGraph.isSelected()) {
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = null;
                    try {
                        root = loader.load(getClass().getResource("/View/VAnalysisDataplot.fxml").openStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    AbsMetaController controller = (AbsMetaController)loader.getController();
                    controller.setParentController(this_controller);
                    controller.setSharedModel(shared_model);
                    controller.init_procedure();
                    tabGraph.setContent(root);
                }
            }
        });

        this.tabSpecimenIO.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (tabSpecimenIO.isSelected()) {
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = null;
                    try {
                        root = loader.load(getClass().getResource("/View/VAnalysisSpecimenMove.fxml").openStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    AbsMetaController controller = (AbsMetaController)loader.getController();
                    controller.setParentController(this_controller);
                    controller.setSharedModel(shared_model);
                    controller.init_procedure();
                    tabSpecimenIO.setContent(root);
                }
            }
        });

        this.tabSpecimenStatus.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (tabSpecimenStatus.isSelected()) {
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = null;
                    try {
                        root = loader.load(getClass().getResource("/View/VAnalysisSpecimen.fxml").openStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    AbsMetaController controller = (AbsMetaController)loader.getController();
                    controller.setParentController(this_controller);
                    controller.setSharedModel(shared_model);
                    controller.init_procedure();
                    tabSpecimenStatus.setContent(root);
                }
            }
        });

        // For Initial Display
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {
            root = loader.load(getClass().getResource("/View/VAnalysisSummary.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AbsMetaController controller = (AbsMetaController)loader.getController();
        controller.setParentController(this_controller);
        controller.setSharedModel(shared_model);
        controller.init_procedure();
        tabSummary.setContent(root);
        this.tabPane.getSelectionModel().select(tabSummary);
    }
}
