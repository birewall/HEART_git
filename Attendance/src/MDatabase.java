import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MDatabase {
	Connection connection;
	int current_id;
	String current_name;
	int current_attendance;
	ArrayList<String> result;
	
	public MDatabase() {
		super();
		this.result = new ArrayList<String>();
		this.connection = null;
		this.current_attendance = 0;
		this.current_id = 0;
		this.current_name = null;
	}
	public Connection getConnection() {
		return connection;
	}
	public int getCurrent_id() {
		return current_id;
	}
	public String getCurrent_name() {
		return current_name;
	}
	public int getCurrent_attendance() {
		return current_attendance;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void setCurrent_id(int current_id) {
		this.current_id = current_id;
	}
	public void setCurrent_name(String current_name) {
		this.current_name = current_name;
	}
	public void setCurrent_attendance(int current_attendance) {
		this.current_attendance = current_attendance;
	}
	public ArrayList<String> getResult() {
		return this.result;
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
	public boolean insert(int id, String name, int attendance) throws SQLException {
		Statement st = this.connection.createStatement();
		boolean error = st.execute("insert into attendance values ("
								+ id + ","
								+ "'" + name + "',"
								+ attendance + ")");
		if(error) {
	        System.out.println("Insert failed.");
	 		return false;
		}else {
			return true;
		}
	}
	public boolean modify(String name, int attendance) throws SQLException {
		Statement st = this.connection.createStatement();
		boolean error = st.execute("update attendance set attendance = " + attendance
								+ " where name = '" + name + "'");
		if(error) {
	        System.out.println("Modify failed.");
	 		return false;
		}else {
			return true;
		}
	}
	public boolean delete(String name) throws SQLException {
		Statement st = this.connection.createStatement();
		boolean error = st.execute("delete from attendance where name = '" + name + "'");
		if(error) {
	         System.out.println("Delete failed.");
	         return false;
		}else {
			return false;
		}
	}
	public void search(String name) throws SQLException {
		Statement st = this.connection.createStatement();
		ResultSet search_result = st.executeQuery("select name from attendance where name = '" + name + "'");
		this.result.clear();
		while(search_result.next()) {
			this.result.add(search_result.getString(1));
		}
	}
	public void searchAttendant() throws SQLException {
		Statement st = this.connection.createStatement();
		ResultSet search_result = st.executeQuery("select name from attendance where attendance = 1");
		this.result.clear();
		while(search_result.next()) {
			this.result.add(search_result.getString(1));
		}
	}
	public void searchNonattendant() throws SQLException {
		Statement st = this.connection.createStatement();
		ResultSet search_result = st.executeQuery("select name from attendance where attendance = 0");
		this.result.clear();
		while(search_result.next()) {
			this.result.add(search_result.getString(1));
		}
	}
}
