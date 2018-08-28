package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBInfoLocation extends MDatabase {
	String location;
	String name;
	String detail;
	
	MDBInfoLocation(Connection connection){
		this.connection = connection;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getDetail() {
		return detail;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
