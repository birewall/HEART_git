import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CManager {

	MBookDB database = new MBookDB();
	
	public CManager(){
		database = new MBookDB();
	}

    @FXML
    private TableView<?> tblBook;

    @FXML
    private Button btnBookReturn;

    @FXML
    private Button btnDelete;
    
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnBookRent;
    
    @FXML
    private TextField ReturnBookName;

    @FXML
    private TextField AddBookName;

    @FXML
    private TextField RentBookID;

    @FXML
    private TextField ReturnBookID;
    
      //initialize
    
}
