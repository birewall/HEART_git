package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import Model.MDBButterflyGuide;
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
import javafx.stage.FileChooser;
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
    private Button btnInquiry;

    @FXML
    private Text txtMain1;

    @FXML
    private Button btnMainSpecimenMove;

    @FXML
    private Button btnImportDB;

    @FXML
    void OnImportDB(ActionEvent event) {
        /* 채워주세요 */
        FileChooser fc = new FileChooser();
        fc.setTitle("DB 불러오기");
        //fc.setInitialDirectory(null);
        File db_file = fc.showOpenDialog(null);
    }

    @FXML
    void mainAnalysis(ActionEvent event) throws IOException {
    	changeWindow(this.btnMainExit.getScene().getWindow(), "VAnalysisMain");
    }

    @FXML
    void mainExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void mainInsert(ActionEvent event) throws IOException {
        changeWindow(this.btnMainExit.getScene().getWindow(), "VInsert");
    }

    @FXML
    void OnSpecimenMove(ActionEvent event) throws IOException {
    	changeWindow(this.btnMainExit.getScene().getWindow(), "VSpecimenMove");
    }

    @FXML
    void OnInquiry(ActionEvent event) throws IOException {
    	changeWindow(this.btnMainExit.getScene().getWindow(), "VInquiry");
    }
    
    @Override
    public void init_procedure() {
        if(this.shared_model != null) return;

        /* If not initialized */
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
    	((MSharedData)this.shared_model).getLogger().info("[CMain - init_procedure] Example");
    }
}
