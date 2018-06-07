import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {

	MDatabase db;
	
    @FXML
    private TreeView<String> trvExplorer;

    @FXML
    private ImageView imvImage;

    @FXML
    void OnClick(MouseEvent event) {
    	if(event.getClickCount() == 2) {
    		System.out.println(this.trvExplorer.getSelectionModel().getSelectedItem());
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
		
		// Set Root
		TreeItem<String> tree_root = new TreeItem<String>("./img");
		this.trvExplorer.setRoot(tree_root);
		
		// Example
		TreeItem<String> tree_item = new TreeItem<String>("±âÀû.jpg");
		tree_root.getChildren().add(tree_item);
	}

}