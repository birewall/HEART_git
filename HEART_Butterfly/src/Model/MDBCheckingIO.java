package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBCheckingIO extends MDatabase {
	int id;
	String checking_code;
	String specimen_code;
	
	public MDBCheckingIO(Connection connection) {
		this.connection = connection;
	}
	
	public int getId() {
		return id;
	}



	public String getChecking_code() {
		return checking_code;
	}



	public String getSpecimen_code() {
		return specimen_code;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setChecking_code(String checking_code) {
		this.checking_code = checking_code;
	}



	public void setSpecimen_code(String specimen_code) {
		this.specimen_code = specimen_code;
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
