import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MDatabase {
	Connection connection;
	
	public MDatabase() {
		super();
		this.connection = null;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public boolean connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(
				"jdbc:mysql://35.201.230.135/javateam?useSSL=false", 
				"javateam", "boradori1");
		
		if(this.connection == null) return false;
		else return true;
	}
	public void disconnect() throws SQLException {
		if(this.connection != null) this.connection.close();
	}
	public boolean insert(String image_name, String image_path) throws SQLException {
		Statement st = this.connection.createStatement();
		boolean error = st.execute("insert into image_repo values ('"
								+ image_name + "','"
								+ image_path + "')");
		if(error) {
	        System.out.println("Insert failed.");
	 		return false;
		}else {
			return true;
		}
	}
	public boolean delete(String name) throws SQLException {
		Statement st = this.connection.createStatement();
		boolean error = st.execute("delete from image_repo where image_name = '" + name + "'");
		if(error) {
	         System.out.println("Delete failed.");
	         return false;
		}else {
			return false;
		}
	}
	public void synchronize() {
		/* Fill */
	}
	public void insert() {
		/* Fill */
	}
	public void delete() {
		/* Fill */
	}
	public void rename() {
		/* Fill */
	}
}
