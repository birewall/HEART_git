package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBInfoButterfly extends MDatabase {
	int id;
	String sort;
	String name;
	String showing_region;
	String showing_period;
	
	public MDBInfoButterfly(Connection connection) {
		super();
		this.connection = connection;
	}

	public int getId() {
		return id;
	}

	public String getSort() {
		return sort;
	}

	public String getName() {
		return name;
	}

	public String getShowing_region() {
		return showing_region;
	}

	public String getShowing_period() {
		return showing_period;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShowing_region(String showing_region) {
		this.showing_region = showing_region;
	}

	public void setShowing_period(String showing_period) {
		this.showing_period = showing_period;
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
