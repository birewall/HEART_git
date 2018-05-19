package Controller;

import Model.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private Button btnBookDelete;

    @FXML
    private TextField txtResistUserName;

    @FXML
    private TableView<?> tblUser;

    @FXML
    private TableColumn<?, ?> UserTableCol_UserID;
    
    @FXML
    private TableColumn<?, ?> UserTableCol_UserName;
    
    @FXML
    private TableColumn<?, ?> UserTableCol_UserPhone;

    @FXML
    private TextField txtResistBookName;

    @FXML
    private TextField txtResistBookID;

    @FXML
    private Button btnUserAdd;

    @FXML
    private Button btnBookAdd;

    @FXML
    private TableView<MBook> tblBook;
    
    @FXML
    private TableColumn<MBook, String> BookTableCol_BookID;
    
    @FXML
    private TableColumn<MBook, String> BookTableCol_BookName;
    
    @FXML
    private TableColumn<MBook, String> BookTableCol_BookAuthor;

    @FXML
    private Button btnExit;

    @FXML
    private TextField txtSearchBookName;

    @FXML
    private TextField txtSearchUserName;

    @FXML
    private Button btnRetrieve;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUserDelete;

    @FXML
    private Button btnBorrow;

    @FXML
    private TableView<?> tblRent;
    
    @FXML
    private TableColumn<?, ?> RentTableCol_BookID;

    @FXML
    private TableColumn<?, ?> RentTableCol_UserID;

    @FXML
    private TableColumn<?, ?> RentTableCol_BorrowDate;

    @FXML
    private TableColumn<?, ?> RentTableCol_RetrieveDate;

    @FXML
    private TextField txtResistUserID;

    @FXML
    void OnBookAdd(ActionEvent event) throws SQLException {

    }

    @FXML
    void OnBookDelete(ActionEvent event) throws SQLException {
    	
    }

    @FXML
    void OnUserAdd(ActionEvent event) {

    }

    @FXML
    void OnUserDelete(ActionEvent event) {

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
    void OnBorrow(ActionEvent event)  throws SQLException {
    	
    }

    @FXML
    void OnRetrieve(ActionEvent event) throws SQLException {

    }

    @FXML
    void OnSearch(ActionEvent event) throws SQLException {

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
		tblBook.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        /*MBook selectedItem = tblBook.getSelectionModel().getSelectedItem();
		        this.txtBook.setText(selectedItem.getId());
		        this.txtName.setText(selectedItem.getName());
		        this.txtRent.setText(selectedItem.getRent_date());
		        this.txtReturn.setText(selectedItem.getRetreive_date());
		        */
		    }});
		
		BookTableCol_BookID.setCellValueFactory(new PropertyValueFactory<MBook, String>("id"));
		BookTableCol_BookName.setCellValueFactory(new PropertyValueFactory<MBook, String>("name"));
		BookTableCol_BookAuthor.setCellValueFactory(new PropertyValueFactory<MBook, String>("author"));
	}
}
