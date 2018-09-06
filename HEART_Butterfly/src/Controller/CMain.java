package Controller;

import java.io.IOException;
import java.sql.SQLException;

import Model.MDBCameraInfo;
import Model.MSharedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CMain extends AbsMetaController{

    @FXML
    private Pane paneMain;

    @FXML
    private Button btnMainInsert;

    @FXML
    private Button btnMainAnalysis;

    @FXML
    private Button btnMainExit;

    @FXML
    private Text txtMain;

    @FXML
    private Button btnMainPicture;

    @FXML
    private Text txtMain1;

    @FXML
    private Button btnMainSpecimenMove;

    @FXML
    void mainAnalysis(ActionEvent event) throws IOException {
    	changeWindow(this.btnMainExit.getScene().getWindow(), "VAnalysisAll");
    	//changeWindow(this.btnMainExit.getScene().getWindow(), "VAnalysisDataPlot");
    }

    @FXML
    void mainExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void mainInsert(ActionEvent event) throws IOException {
        MDBCameraInfo cam = new MDBCameraInfo(((MSharedData)this.shared_model).getDB().getConnection());
        cam.printContents();
    	changeWindow(this.btnMainExit.getScene().getWindow(), "VInsert");
    }

    @FXML
    void mainPicture(ActionEvent event) throws IOException {
    	changeWindow(this.btnMainExit.getScene().getWindow(), "VCreatePictureFolder");
    }

    @FXML
    void specimenmoveMainSpecimen(ActionEvent event) throws IOException {
    	changeWindow(this.btnMainExit.getScene().getWindow(), "VSpecimenMove");
    }
    
    @Override
    public void init_procedure() {
    	MSharedData data = new MSharedData();
    	try {
			if(data.getDB().connect("Butterfly")) {
				data.getLogger().info("[CMain - init_procedure] DB is connected");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.shared_model = data;
    	data.getLogger().info("[CMain - init_procedure] Initialized");
    }
}
