package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBWatch extends MDatabase {
	String collected_butterfly;
	int count;
	int collected;
	String collector;
	String record_id;
	int butterflyInfo_id;
	
	public MDBWatch(Connection connection) {	
		this.connection = connection;
	}

	public String getCollected_butterfly() {
		return collected_butterfly;
	}

	public int getCount() {
		return count;
	}

	public int getCollected() {
		return collected;
	}

	public String getCollector() {
		return collector;
	}

	public String getRecord_id() {
		return record_id;
	}

	public int getButterflyInfo_id() {
		return butterflyInfo_id;
	}

	public void setCollected_butterfly(String collected_butterfly) {
		this.collected_butterfly = collected_butterfly;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setCollected(int collected) {
		this.collected = collected;
	}

	public void setCollector(String collector) {
		this.collector = collector;
	}

	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}

	public void setButterflyInfo_id(int butterflyInfo_id) {
		this.butterflyInfo_id = butterflyInfo_id;
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