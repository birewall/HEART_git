import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class Practice1 {
	public static class DB{
		Connection con;
		DB(){
			con = null;
		}
		void open() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://35.201.230.135/hooni?useSSL=false", "javateam", "boradori1");
		}

		String[] list() throws SQLException {
			String item[] = null;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from survey_table");
			rs.last();
			int num_item = rs.getRow();
			rs.beforeFirst();
			item = new String[num_item];
			
			int index = 0;
			while(rs.next()) {
				item[index] = rs.getString(1);
				index++;
			}
			
			return item;
		}

		boolean find(String item) throws SQLException {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from survey_table where name="+item);
			rs.last();
			int num_item = rs.getRow();
			rs.beforeFirst();
			
			if( num_item > 0 ) return true;
			else return false;
		}
	}
	
	public static class DB1{
		Connection con;
		DB1(){
			con = null;
		}

		void open() throws SQLException, IOException {
			con = DriverManager.getConnection
					("jdbc:mysql://35.201.230.135/hhs?useSSL=false", "javateam", "boradori1");

		}
		
		String[] list() throws SQLException {
			String item[] = null;

			Statement  st = con.createStatement();
	        ResultSet rs;

			String sql = "SELECT * FROM hhs.GitPractice";

	        rs = st.executeQuery(sql);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        
	        // 행 갯수 세기
	        rs.last();
	        int NumRow = rs.getRow();
	        System.out.println("Number of Rows : " +NumRow);
	        
	        item = new String [NumRow];
	        
	        // 열 갯수 세기
	        int numberOfColumns=rsmd.getColumnCount();
	        System.out.println("Number of Columns : " + numberOfColumns);
	        
	        //행 처음으로 돌아가기
	        rs.beforeFirst();
	        for (int i = 0 ; rs.next() ; i ++) {
	        	item[i] = rs.getString(1);
	        	for (int j = 2 ; j <= numberOfColumns ; j ++) {
			        item[i] = item[i] + "\t" + rs.getString(j);
	        	}
	        }
			return item;
		}

		boolean find(String item) throws SQLException {
			Statement  st = con.createStatement();
	        ResultSet rs;

			String sql = "SELECT * FROM hhs.GitPractice where LabName = \"" + item+ "\"";
	        rs = st.executeQuery(sql);
	        
	        rs.last();
	        int NumRow = rs.getRow();
	        
	        if (NumRow > 0) {
	        	return true;
	        } else {
	        	return false;
	        }
		}
	}
	
	public static class DB2{
		Connection con;
		
		DB2(){
			con = null;
		}
		
		void open() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://35.201.230.135/jch?useSSL=false", "javateam", "boradori1");
		}
		
		String[] list() throws SQLException {
			String item[] = null;

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from test");
			
			rs.last();
			int num_row = rs.getRow();
			rs.beforeFirst();
			item = new String[num_row];
			
			int i = 0;
			while(rs.next()){
				item[i] = rs.getString(2) + " ,\t" + rs.getString(3);
				i++;
			}
			
			return item;
		}
		
		boolean find(String item) throws SQLException {

			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from test where Name =\"" + item + "\"");

			rs.last();
			int num_row = rs.getRow();
			
			if(num_row >= 1){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public static void main(String[] argv) throws ClassNotFoundException, SQLException {
		DB myDB = new DB();
		
		String[] items = null;
		String find_item = "1234";
		
		myDB.open();
		
		items = myDB.list();
		for(String item : items) {
			System.out.println(item);
		}
		
		if( myDB.find(find_item) ) {
			System.out.println("Exist");
		}else {
			System.out.println("Not Exist");
		}
	}
}