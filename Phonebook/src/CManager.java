import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CManager implements Initializable {

	MBookDB database = null;
	
	public CManager(){
		database = new MBookDB();
	}
	
    @FXML
    private Button btnSearch;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private Button btnAdd;
    
    @FXML
    private Button btnReturn;

    @FXML
    private Button btnRent;

    @FXML
    private Button btnExit;
    
    @FXML
    private TableView<?> tblBook;

    @FXML
    private TableColumn<?, ?> col_ID;

    @FXML
    private TableColumn<?, ?> col_Rent;
    
    @FXML
    private TableColumn<?, ?> col_Name;

    @FXML
    private TableColumn<?, ?> col_Return;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtRent;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtReturn;
    
    @FXML
    void OnAdd(ActionEvent event) throws SQLException {
    	MBook item = new MBook("hungry", "spirit");
    	database.insert(item);
    }

    @FXML
    void OnDelete(ActionEvent event) throws SQLException {
    	MBook item = new MBook("hungry", "spirit");
    	database.delete(item);
    }

    @FXML
    void OnReturn(ActionEvent event) throws SQLException {
    	MBook item = new MBook("hungry", "spirit");
    	database.retreive(item);
    }

    @FXML
    void OnRent(ActionEvent event) throws SQLException {
    	MBook item = new MBook("hungry", "spirit");
    	database.rent(item);
    }

    @FXML
    void OnExit(ActionEvent event) {
    	try {
			database.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.exit(0);
    }

    @FXML
    void OnSearch(ActionEvent event) {
    	MBook item = new MBook("hungry", "spirit");
    	database.search(item);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		database = new MBookDB();
		try {
			database.open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
}
