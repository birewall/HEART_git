import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MDatabase {
	String table_name;
	Connection connection;
	Statement statement;
	
	public MDatabase() {
		super();
		this.connection = null;
		this.statement = null;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void setTablename(String table_name) {
		this.table_name = table_name;
	}
	public boolean connect(String db_name) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(
				"jdbc:mysql://35.201.230.135/" + db_name + "?useSSL=false", 
				"javateam", "boradori1");
		
		if(this.connection == null) return false;
		else return true;
	}
	public void disconnect() throws SQLException {
		if(this.connection != null) this.connection.close();
	}
	public boolean insert(String image_name, String image_path) throws SQLException {
		Statement st = this.connection.createStatement();
		boolean error = st.execute("insert into " + this.table_name + " values ('"
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
		boolean error = st.execute("delete from " + this.table_name + " where image_name = '" + name + "'");
		if(error) {
	         System.out.println("Delete failed.");
	         return false;
		}else {
			return false;
		}
	}

	public void synchronize() throws SQLException {
		this.statement = this.connection.createStatement();
		
		/* Delete All */
		this.statement.execute("delete from " + this.table_name);
		
		/* Insert All */
		this.statement.execute("insert into " + this.table_name + " values ()");
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
