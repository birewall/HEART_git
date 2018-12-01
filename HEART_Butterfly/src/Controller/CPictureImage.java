package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

	public class CPictureImage extends AbsMetaController implements Initializable {
		
		String filePath = null;
		List<File> selectedFile;
		File file;
		
	    @FXML
	    private ListView<String> listExplorer;

	    @FXML
	    private Button Insertfile;

	    @FXML
	    private Button InputImage;

	    @FXML
	    private ImageView imvImage;

	    @FXML
	    private Button DeleteFile;

	    @FXML
	    private Button Exit;

	    @FXML
	    void OnInsert(ActionEvent event) {
			FileChooser fc = new FileChooser();
			fc.setInitialDirectory(new File("."));
			selectedFile = fc.showOpenMultipleDialog(null);
			
			for (File file : selectedFile) {
				filePath = file.getPath();
				this.listExplorer.getItems().add(filePath);
			}
	    }
	    
	    @FXML
	    void OnClick(MouseEvent event) {

	    }

	    @FXML
	    void OnDelete(ActionEvent event) throws IOException {
			/* Delete from View */
			this.imvImage.setImage(null);
			
			/* Delete from List*/
			listExplorer.getItems().remove(listExplorer.getSelectionModel().getSelectedIndex());
	    }

	    @FXML
	    void OnDone(ActionEvent event) throws IOException {
	    	for (String path : listExplorer.getItems()) {
	    		System.out.println(path);		
	    	}
	    	changeWindow(this.Exit.getScene().getWindow(), "VInsertPicture");
	    }

	    @FXML
	    void OnExit(ActionEvent event) throws IOException {
	    	changeWindow(this.Exit.getScene().getWindow(), "VInsertPicture");
	    }
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	        this.listExplorer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	            @Override
	            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	                /* Error Handling */
	                if(listExplorer.getSelectionModel() == null) return;

	                /* Set View */
		    		File file = new File(newValue);
		    		Image image = new Image(file.toURI().toString());
		    		imvImage.setImage(image);
	            }
	        });
	    }
	    
		@Override
		public void init_procedure() {

	    }
	}