package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBCheckingIOLog extends MDatabase {
	int id;
	String time;
	String destination;
	String who;
	
	public MDBCheckingIOLog(Connection connection) {
		this.connection = connection;
	}
	
	public int getId() {
		return id;
	}



	public String getTime() {
		return time;
	}



	public String getDestination() {
		return destination;
	}



	public String getWho() {
		return who;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public void setWho(String who) {
		this.who = who;
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
