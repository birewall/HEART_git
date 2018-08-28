package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MDBSpecimen extends MDatabase {
	String code;
	int quality;
	int gender;
	String specimen_worker;
	String detail;
	String storage;
	
	public MDBSpecimen(Connection connection) {
		this.connection = connection;
	}

	public String getCode() {
		return code;
	}

	public int getQuality() {
		return quality;
	}

	public int getGender() {
		return gender;
	}

	public String getSpecimen_worker() {
		return specimen_worker;
	}

	public String getDetail() {
		return detail;
	}

	public String getStorage() {
		return storage;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setSpecimen_worker(String specimen_worker) {
		this.specimen_worker = specimen_worker;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setStorage(String storage) {
		this.storage = storage;
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
