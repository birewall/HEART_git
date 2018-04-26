import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MBookDB {
	Connection conn;
	
	MBookDB(){
		
	}
	
	public void open() throws ClassNotFoundException, SQLException {
		Connection connection = null;
        Statement st = null;
        
        Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://35.201.230.135/javateaM?useSSL=false", 
					"javateam", "boradori1");
//				st = connection.createStatement();
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
	
	public String[] list() {
		String[] items = null;
		/* Fill */
		return items;
	}
	
	public boolean isExist(String item) {
		/* Fill */
		return false;
	}
	
	public void insert(MBook item) {
		/* Fill */
	}
	
	public void delete(String item, String colume) {
		/* Fill */
	}
}
