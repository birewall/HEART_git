import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MBookDB {
	Connection conn;
	
	MBookDB(){
		conn = null;
	}
	
	public void open() throws ClassNotFoundException, SQLException {
		Statement st = null;
        
        Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://35.201.230.135/javateaM?useSSL=false", 
					"javateam", "boradori1");
			st = conn.createStatement();
//				
//				String sql = "insert into Library_books values("
//						+ "\"" + this.txtName_b.getText() + "\","
//						+  this.txtDate_b.getText() + ","
//						+ this.txtRental_b.getText() + ")";
//				
//				boolean error = st.execute(sql);
//				if(error){
//					System.out.println("Insertion was failed.");
//					return;
//				}
//				
//       
//				st.close();
//				connection.close();
			}
	
	public MBook[] search(MBook item) {
		MBook[] items = null;
		/* Fill */
		return items;
	}
	
	public boolean insert(MBook item) {
		
		String id, name;
		id = item.getId();
		name = item.getName();
		String sql = "Insert into Library(id, book_name) Values (" + id + " " + name + ")";
		System.out.println(sql);

		return false;
	}
	
	public boolean delete(MBook item) {

		return false;
	}
	
	public boolean rent(MBook item){

		// SQL
		String sql = "";
		
		// Check
		
		

		return false;
	}
	
	public boolean retreive(MBook item) {
		
		return false;
	}
	
	public void close() throws SQLException {
		conn.close();
	}	
}
