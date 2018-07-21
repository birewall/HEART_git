import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class MainController implements Initializable {

	MDatabase db;

	@FXML
	private MenuBar mnbMenu;
	
	@FXML
	private TreeView<String> trvExplorer;
	
	@FXML
	private ImageView imvImage;

    @FXML
    void OnClick(MouseEvent event) throws SQLException {
    	if(event.getClickCount() == 2) {
    		if(this.trvExplorer.getSelectionModel() == null) return;
    		String filename = this.trvExplorer.getSelectionModel().getSelectedItem().getValue();
    		
    		//DB request
    		String filepath = this.db.request_path(filename.substring(0, filename.length()-4));
    		
    		//Set image
    		File file = new File(filepath);
    		Image image = new Image(file.toURI().toString());
    		this.imvImage.setImage(image);
    	}
    }
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Set db
		this.db = new MDatabase();

		// Set Menu
		InitMenu();

		// Set Root & Add Children
		InitTree();
	}

	public void InitMenu() {
		// General - Load
		MenuItem load_menu = this.mnbMenu.getMenus().get(0).getItems().get(0);
		load_menu.setOnAction(e -> {

			/* Load DB */
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Load");
			dialog.setHeaderText(null);
			dialog.setContentText("Insert DB name");
			dialog.getEditor().setText("hooni");
			
			try {
				this.db.connect(dialog.showAndWait().get());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				/* Alert */
				Alert confirm_popup = new Alert(AlertType.ERROR);
				confirm_popup.setTitle("Load");
				confirm_popup.setHeaderText(null);
				confirm_popup.setContentText("Open failed. DB is not exist.");
				confirm_popup.show();
				return;
			}

			/* Load Table */
			dialog = new TextInputDialog();
			dialog.setTitle("Load");
			dialog.setHeaderText(null);
			dialog.setContentText("Insert table name");
			dialog.getEditor().setText("image_repo");

			this.db.setTablename(dialog.showAndWait().get());

			/* Confirm */
			Alert confirm_popup = new Alert(AlertType.CONFIRMATION);
			confirm_popup.setTitle("Load");
			confirm_popup.setHeaderText(null);
			confirm_popup.setContentText("DB opened");
			confirm_popup.show();
		});

		// General - Save
		MenuItem save_menu = this.mnbMenu.getMenus().get(0).getItems().get(1);
		save_menu.setOnAction(e -> {
			/* Fill */
		});
		// General - Exit
		MenuItem exit_menu = this.mnbMenu.getMenus().get(0).getItems().get(2);
		exit_menu.setOnAction(e -> {
			try {
				this.db.disconnect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		});

		// File - Sync
		MenuItem sync_menu = this.mnbMenu.getMenus().get(1).getItems().get(0);
		sync_menu.setOnAction(e -> {
			try {
				this.db.synchronize();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});     
		// File - Insert
		MenuItem insert_menu = this.mnbMenu.getMenus().get(1).getItems().get(1);
		insert_menu.setOnAction(e -> {
		    /* Choose file */
			FileChooser fc = new FileChooser();
			fc.setInitialDirectory(new File("."));
			File selectedFile = fc.showOpenDialog(null);
			
			/* Copy to img folder */
			try {
				FileInputStream fis = new FileInputStream(selectedFile);
				FileOutputStream fos = new FileOutputStream(new File("./img/"+selectedFile.getName()));
				 
				int data = 0;
				while((data=fis.read())!=-1) {
				    fos.write(data);
				}
				
				fis.close();
				fos.close();
			} catch(IOException excep) {
				excep.printStackTrace();
				System.exit(0);
			}
			
			/* Add to View */
			this.trvExplorer.getRoot().getChildren().add(
					new TreeItem<String>(selectedFile.getName())
			);
			
			/* Add to DB */
			try {
				this.db.insert(
						selectedFile.getName().substring(0,selectedFile.getName().length()-4),
						"img/" + selectedFile.getName());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		// File - Delete
		MenuItem delete_menu = this.mnbMenu.getMenus().get(1).getItems().get(2);
		delete_menu.setOnAction(e -> {
			/* Choose file */
			String filename = this.trvExplorer.getSelectionModel().getSelectedItem().getValue();
			
			/* Delete from img folder */
			File selectedFile = new File("./img/" + filename);
			if(!selectedFile.delete()) {
				/* Alert */
				Alert confirm_popup = new Alert(AlertType.ERROR);
				confirm_popup.setTitle("Delete");
				confirm_popup.setHeaderText(null);
				confirm_popup.setContentText("Delete Failed.");
				confirm_popup.show();
				return;
			}

			/* Delete from View */
			TreeItem<String> selectedItem = this.trvExplorer.getSelectionModel().getSelectedItem();
			selectedItem.getParent().getChildren().remove(selectedItem);
			
			/* Delete from DB */
			try {
				this.db.delete(filename.substring(0, filename.length()-4));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		// File - Rename
		MenuItem rename_menu = this.mnbMenu.getMenus().get(1).getItems().get(3);
		rename_menu.setOnAction(e -> {
			/* Choose file */
			String filename = this.trvExplorer.getSelectionModel().getSelectedItem().getValue();
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Rename");
			dialog.setHeaderText(null);
			dialog.setContentText("Type new name");
			dialog.showAndWait();
			String new_name = dialog.getEditor().getText();
			
			/* Rename from img folder */
			File selectedFile = new File("./img/" + filename);
			if(!selectedFile.renameTo(new File("./img/" + new_name))) {
				Alert confirm_popup = new Alert(AlertType.ERROR);
				confirm_popup.setTitle("Rename");
				confirm_popup.setHeaderText(null);
				confirm_popup.setContentText("Rename failed.");
				confirm_popup.show();
				return;
			}
			
			/* Rename to View */
			this.trvExplorer.getSelectionModel().getSelectedItem().setValue(new_name);
			
			/* Rename to DB */
			try {
				this.db.rename(filename, new_name);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// View - Next
		MenuItem next_menu = this.mnbMenu.getMenus().get(2).getItems().get(0);
		next_menu.setOnAction(e -> {
		    /* Choose file */
			int children_size = this.trvExplorer.getRoot().getChildren().size();
			int selectedIndex = this.trvExplorer.getSelectionModel().getSelectedIndex() % children_size;
			String next_filename = this.trvExplorer.getRoot().getChildren().get(selectedIndex).getValue();

			/* Get Path */
    		String next_filepath = null;
			try {
				next_filepath = this.db.request_path(next_filename.substring(0, next_filename.length()-4));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			/* Set to View */
			this.imvImage.setImage(new Image(new File(next_filepath).toURI().toString()));
			this.trvExplorer.getSelectionModel().select(selectedIndex + 1);	// for root(./img)
		});
		// View - Previous
		MenuItem previous_menu = this.mnbMenu.getMenus().get(2).getItems().get(1);
		previous_menu.setOnAction(e -> {
			/* Choose file */
			int children_size = this.trvExplorer.getRoot().getChildren().size();
			int selectedIndex = (this.trvExplorer.getSelectionModel().getSelectedIndex() + children_size - 2) % children_size;
			String next_filename = this.trvExplorer.getRoot().getChildren().get(selectedIndex).getValue();
			
			/* Get Path */
    		String next_filepath = null;
			try {
				next_filepath = this.db.request_path(next_filename.substring(0, next_filename.length()-4));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			/* Set to View */
			this.imvImage.setImage(new Image(new File(next_filepath).toURI().toString()));
			this.trvExplorer.getSelectionModel().select(selectedIndex+1);	// for root(./img)
		});
	}

	public void InitTree() {
		TreeItem<String> tree_root = new TreeItem<String>("./img");
		this.trvExplorer.setRoot(tree_root);

		File test_file = new File("./img");
		for (File file : test_file.listFiles()) {
			TreeItem<String> tree_item = new TreeItem<String>(file.getName());
			tree_root.getChildren().add(tree_item);
		}
	}
}