package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBRecord extends MDatabase {
	String id;
	String date;
	String time;
	String type;
	String location;
	
	public MDBRecord(Connection connection) {
		this.connection = connection;
	}

	public String getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getType() {
		return type;
	}

	public String getLocation() {
		return location;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	/* Fill the parameter */
	public boolean insert() throws SQLException {
		Statement st = this.connection.createStatement();
		/* Fill the query */
		String query = "";
		boolean error = st.execute(query);
		if(error) {
	        System.out.println("Insert failed.");
	 		return false;
		}else {
			return true;
		}
	}
	/* Fill the parameter */
	public boolean delete() throws SQLException {
		Statement st = this.connection.createStatement();
		/* Fill the query */
		String query = "";
		boolean error = st.execute(query);
		if(error) {
	         System.out.println("Delete failed.");
	         return false;
		}else {
			return false;
		}
	}
}
