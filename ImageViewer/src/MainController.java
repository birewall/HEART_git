import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
    		System.out.println(this.trvExplorer.getSelectionModel().getSelectedItem());
    		this.imvImage.setImage(this.trvExplorer.getSelectionModel().getSelectedItem());
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
		MenuItem exit_menu = this.mnbMenu.getMenus().get(0).getItems().get(0);
		exit_menu.setOnAction(e -> {
		    try {
				this.db.disconnect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    System.exit(0);
		});
		MenuItem sync_menu = this.mnbMenu.getMenus().get(1).getItems().get(0);
		sync_menu.setOnAction(e -> {
		    this.db.synchronize();
		});
		MenuItem delete_menu = this.mnbMenu.getMenus().get(1).getItems().get(1);
		delete_menu.setOnAction(e -> {
			try {
				this.db.delete(this.trvExplorer.getSelectionModel().getSelectedItem().getValue().substring(0, this.trvExplorer.getSelectionModel().getSelectedItem().getValue().length()-4));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		// Set Root
		TreeItem<String> tree_root = new TreeItem<String>("./img");
		this.trvExplorer.setRoot(tree_root);
		
		File test_file = new File("./img");
		for(File file : test_file.listFiles()) {
			System.out.println(file.getName());
			TreeItem<String> tree_item = new TreeItem<String>(file.getName());
    		tree_root.getChildren().add(tree_item);
		}
		
	}
}