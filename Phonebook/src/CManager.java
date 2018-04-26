import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import MainController.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CManager {

MBookDB database = new MBookDB();
	
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
    void OnAdd(ActionEvent event) {

    }

    @FXML
    void OnDelete(ActionEvent event) {

    }

    @FXML
    void OnReturn(ActionEvent event) {

    }

    @FXML
    void OnRent(ActionEvent event) {

    }

    @FXML
    void OnExit(ActionEvent event) {

    }

    @FXML
    void OnSearch(ActionEvent event) {

    }

    static Connection conn;
    
  	@Override
  	public void initialize(URL location, ResourceBundle resources) {

  		try { 
  			
  		conn = DriverManager.getConnection("jdbc:mysql://35.201.230.135/nsh?useSSL=false","javateam","boradori1");
  		
  		}
  		catch (SQLException SQLex) {
  			System.out.println("SQLException:"+SQLex.getMessage());
  		}	

  		int iresult = 0;
  		try {
  			Statement st = conn.createStatement();
  			ResultSet rs = st.executeQuery("");
  			
  			while(rs.next()) {
  				//String networkID = rs.getString("networkID");
  	
  				
  	//			System.out.println("networkID : "+networkID+"\n"+"branchID : "+branchID+"sectionID: "+sectionID+"\n"+"sectionPCI: "+sectionPCI);
  				iresult ++;
  			}
  		rs.close();
  		st.close();
  		
  		} catch (SQLException SQLex) {
  			System.out.println("SQLException:"+SQLex.getMessage());
  		}
  		
  		// Ä®·³ tclSafetyIndex.setCellValueFactory(new PropertyValueFactory<Item, String>("index"));
  		
  	}

    
}
