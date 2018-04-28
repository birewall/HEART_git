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
    private TableView<MBook> tblBook;

    @FXML
    private TableColumn<MBook, String> col_ID;

    @FXML
    private TableColumn<MBook, String> col_Name;
    
    @FXML
    private TableColumn<MBook, String> col_Rent;
  
    @FXML
    private TableColumn<MBook, String> col_Return;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtRent;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtReturn;
    
    @FXML
    void OnAdd(ActionEvent event) {
    	String id_text = this.txtID.getText();
    	String name_text = this.txtName.getText();
    	MBook item = new MBook(id_text, name_text);

    	if (id_text.length() == 0) {return;}
    	else {database.insert(item);}
    	}
    	

    @FXML
    void OnDelete(ActionEvent event) {
     	String id_text = this.txtID.getText();
    	String name_text = this.txtName.getText();
    	MBook item = new MBook(id_text, name_text);

    	if (id_text.length() == 0) {return;}
    	else {database.delete(item);}
    	}
    
    @FXML
    void OnReturn(ActionEvent event) {
     	String id_text = this.txtID.getText();
    	String name_text = this.txtName.getText();
    	MBook item = new MBook(id_text, name_text);

    	if (id_text.length() == 0 ) {return;}
    	else {database.retreive(item);}
    	}

    @FXML
    void OnRent(ActionEvent event) {
    	String id_text = this.txtID.getText();
    	String name_text = this.txtName.getText();
    	String rent_text = this.txtRent.getText();
    	String retreive_text = this.txtReturn.getText();
    	MBook item = new MBook(id_text, name_text, rent_text, retreive_text);
    	
    	if (id_text.length() == 0) {return;}
    	else {database.rent(item);}
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
    	
    	ArrayList<MBook> items = database.search(item);
    	
    	for(MBook now_item : items){
    		tblBook.getItems().add(now_item);
    	}
    	

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
		        MBook selectedItem = tblBook.getSelectionModel().getSelectedItem();
		        this.txtID.setText(selectedItem.getId());
		        this.txtName.setText(selectedItem.getName());
		        this.txtRent.setText(selectedItem.getRent_date());
		        this.txtReturn.setText(selectedItem.getRetreive_date());
		        
		    }});
		
		col_ID.setCellValueFactory(new PropertyValueFactory<MBook, String>("id"));
		col_Name.setCellValueFactory(new PropertyValueFactory<MBook, String>("name"));
		col_Rent.setCellValueFactory(new PropertyValueFactory<MBook, String>("rent_date"));
		col_Return.setCellValueFactory(new PropertyValueFactory<MBook, String>("retreive_date"));
	}
}
