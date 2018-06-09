import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {

	MDatabase db;
	
    @FXML
    private MenuBar mnbMenu;
    
    @FXML
    private TreeView<String> trvExplorer;

    @FXML
    private ImageView imvImage;

    @FXML
    void OnClick(MouseEvent event) {
    	if(event.getClickCount() == 2) {
    		//DB request
    		/* Fill */
    		//DB reply
    		/* Fill */
    		//Set image
    		/* Modify */
    		File file = new File("img/" +
    					this.trvExplorer.getSelectionModel().getSelectedItem().getValue());
    		Image image = new Image(file.toURI().toString());
    		this.imvImage.setImage(image);
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// DB open
		this.db = new MDatabase();
		try {
			this.db.connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// Set Menu
		InitMenu();
		
		// Set Root & Add Children
		InitTree();
	}
	
	public void	InitMenu() {
		// General - Load
		MenuItem load_menu = this.mnbMenu.getMenus().get(0).getItems().get(0);
		load_menu.setOnAction(e -> {
		    /* Fill */
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
		    this.db.synchronize();
		});
		// File - Insert
		MenuItem insert_menu = this.mnbMenu.getMenus().get(1).getItems().get(1);
		insert_menu.setOnAction(e -> {
		    /* Fill */
		});
		// File - Delete
		MenuItem delete_menu = this.mnbMenu.getMenus().get(1).getItems().get(2);
		delete_menu.setOnAction(e -> {
			try {
				this.db.delete(this.trvExplorer.getSelectionModel().getSelectedItem().getValue().substring(0, this.trvExplorer.getSelectionModel().getSelectedItem().getValue().length()-4));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		// File - Rename
		MenuItem rename_menu = this.mnbMenu.getMenus().get(1).getItems().get(3);
		rename_menu.setOnAction(e -> {
		    /* Fill */
		});
		
		// View - Next
		MenuItem next_menu = this.mnbMenu.getMenus().get(2).getItems().get(0);
		next_menu.setOnAction(e -> {
		    /* Fill */
		});
		// View - Previous
		MenuItem previous_menu = this.mnbMenu.getMenus().get(2).getItems().get(1);
		previous_menu.setOnAction(e -> {
		    /* Fill */
		});

	}
	
	public void InitTree() {
		TreeItem<String> tree_root = new TreeItem<String>("./img");
		this.trvExplorer.setRoot(tree_root);
		
		File test_file = new File("./img");
		for(File file : test_file.listFiles()) {
			TreeItem<String> tree_item = new TreeItem<String>(file.getName());
			tree_root.getChildren().add(tree_item);
		}
	}
}