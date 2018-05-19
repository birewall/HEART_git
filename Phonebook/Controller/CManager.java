package Controller;

import Model.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
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
	MBook focused_book = null;
	MUser focused_user = null;
	MBorrow focused_rent = null;
	
	Random random = new Random();
	String[] author_list = {"Ash", "Jager", "Tachanka", "Sledge", "Frost"};
	String[] phone_list = {"010-1234-2345", "010-8573-2353", "010-1235-5437", "010-9786-3790"};
	
	public CManager(){
		database = new MBookDB();
	}
	

    @FXML
    private Button btnBookDelete;

    @FXML
    private TextField txtResistUserName;

    @FXML
    private TableView<MUser> tblUser;

    @FXML
    private TableColumn<MUser, String> UserTableCol_UserID;
    
    @FXML
    private TableColumn<MUser, String> UserTableCol_UserName;
    
    @FXML
    private TableColumn<MUser, String> UserTableCol_UserPhone;

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
    private TableView<MBorrow> tblRent;
    
    @FXML
    private TableColumn<MBorrow, String> RentTableCol_BookID;

    @FXML
    private TableColumn<MBorrow, String> RentTableCol_UserID;

    @FXML
    private TableColumn<MBorrow, String> RentTableCol_BorrowDate;

    @FXML
    private TableColumn<MBorrow, String> RentTableCol_RetrieveDate;

    @FXML
    private TextField txtResistUserID;

    @FXML
    void OnBookAdd(ActionEvent event) throws SQLException {
    	String book_id = this.txtResistBookID.getText();
    	String book_name = this.txtResistBookName.getText();
    	
    	if( book_id.length() * book_name.length() == 0 ) return;
    	
    	this.database.insert(new MBook(book_id, book_name, author_list[random.nextInt(author_list.length)]));
    	
    	this.txtResistBookID.clear();
    	this.txtResistBookName.clear();
    }

    @FXML
    void OnBookDelete(ActionEvent event) throws SQLException {
    	this.focused_book = this.tblBook.getSelectionModel().getSelectedItem();    	
    	if(this.focused_book == null) {
    		String book_id = this.txtResistBookID.getText();
        	String book_name = this.txtResistBookName.getText();
        
        	if( book_id.length() * book_name.length() == 0 ) return;
        	
        	this.database.delete(new MBook(book_id, book_name, null));
    	}else {
        	this.database.delete(this.focused_book);
    	}    	
    	this.txtResistBookID.clear();
    	this.txtResistBookName.clear();
    }

    @FXML
    void OnUserAdd(ActionEvent event) throws SQLException {
    	String user_id = this.txtResistUserID.getText();
    	String user_name = this.txtResistUserName.getText();
    	
    	if( user_id.length() * user_name.length() == 0 ) return;
    	
    	this.database.insert(new MUser(user_id, user_name, phone_list[random.nextInt(phone_list.length)]));
    	this.txtResistUserName.clear();
    	this.txtResistUserID.clear();
    }

    @FXML
    void OnUserDelete(ActionEvent event) throws SQLException {
    	this.focused_user = this.tblUser.getSelectionModel().getSelectedItem();
    	if(this.focused_user == null) {
    		String user_id = this.txtResistBookID.getText();
        	String user_name = this.txtResistBookName.getText();
        
        	if( user_id.length() * user_name.length() == 0 ) return;
        	
        	this.database.delete(new MUser(user_id, user_name, null));
    	}else {
        	this.database.delete(this.focused_user);
        	this.focused_user = null;
        	this.txtResistUserName.clear();
        	this.txtResistUserID.clear();
    	}
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
    	this.focused_book = this.tblBook.getSelectionModel().getSelectedItem();
    	this.focused_user = this.tblUser.getSelectionModel().getSelectedItem();
    	
    	if(this.focused_book == null || this.focused_user == null) return;
    	
    	this.database.rent(this.focused_book, this.focused_user);
    	
    	this.focused_book = null;
    	this.focused_user = null;
    }

    @FXML
    void OnRetrieve(ActionEvent event) throws SQLException {
    	this.focused_rent = this.tblRent.getSelectionModel().getSelectedItem();
    	
    	if(this.focused_rent == null) return;
    	
    	this.database.retreive(this.focused_rent);
    	
    	this.focused_rent = null;
    }

    @FXML
    void OnSearch(ActionEvent event) throws SQLException {
    	String book_name = this.txtSearchBookName.getText();
    	String user_name = this.txtSearchUserName.getText();
    	
    	if(book_name.length() + user_name.length() == 0) return;
    	
    	this.database.search(new MBook(null, book_name, null), new MUser(null, user_name, null), null);
    	view_refresh();
    	this.txtSearchBookName.clear();
    	this.txtSearchUserName.clear();
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
			System.exit(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		tblBook.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        this.focused_book = tblBook.getSelectionModel().getSelectedItem();
		    }});
		this.tblRent.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        this.focused_rent = tblRent.getSelectionModel().getSelectedItem();
		    }});
		this.tblUser.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        this.focused_user = tblUser.getSelectionModel().getSelectedItem();
		    }});
		
		
		BookTableCol_BookID.setCellValueFactory(new PropertyValueFactory<MBook, String>("id"));
		BookTableCol_BookName.setCellValueFactory(new PropertyValueFactory<MBook, String>("name"));
		BookTableCol_BookAuthor.setCellValueFactory(new PropertyValueFactory<MBook, String>("author"));
		
		this.RentTableCol_BookID.setCellValueFactory(new PropertyValueFactory<MBorrow, String>("book_id"));
		this.RentTableCol_UserID.setCellValueFactory(new PropertyValueFactory<MBorrow, String>("user_id"));
		this.RentTableCol_BorrowDate.setCellValueFactory(new PropertyValueFactory<MBorrow, String>("borrow_date"));
		this.RentTableCol_RetrieveDate.setCellValueFactory(new PropertyValueFactory<MBorrow, String>("retreive_date"));

		this.UserTableCol_UserID.setCellValueFactory(new PropertyValueFactory<MUser, String>("id"));
		this.UserTableCol_UserName.setCellValueFactory(new PropertyValueFactory<MUser, String>("name"));
		this.UserTableCol_UserPhone.setCellValueFactory(new PropertyValueFactory<MUser, String>("phonenumber"));
		
	}
	
	void view_refresh() {
		view_book_refresh();
		view_user_refresh();
		view_rent_refresh();
	}
	
	void view_book_refresh() {
		this.tblBook.getItems().clear();
		for(MBook book : this.database.getBook_result()) {
			this.tblBook.getItems().add(book);
		}
	}
	
	void view_user_refresh() {
		this.tblUser.getItems().clear();
		for(MUser user : this.database.getUser_result()) {
			this.tblUser.getItems().add(user);
		}
	}
	
	void view_rent_refresh() {
		this.tblRent.getItems().clear();
		for(MBorrow rent : this.database.getRent_result()) {
			this.tblRent.getItems().add(rent);
		}
	}
}
