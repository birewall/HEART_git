import java.sql.Connection;

public class MDatabase {
	Connection connection;
	int current_id;
	String current_name;
	int current_attendance;
	public MDatabase() {
		super();
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
	public void connect() {
		
	}
	public void disconnect() {
		
	}
}
