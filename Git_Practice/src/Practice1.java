import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
