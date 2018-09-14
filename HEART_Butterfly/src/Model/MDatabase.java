package Model;

import java.sql.*;

import org.apache.log4j.Logger;
import Common.Main;

import javax.xml.transform.Result;

public class MDatabase extends AbsMetaModel {
	protected static Logger logger;
	String table_name;
	Connection connection;
	Statement statement;

	static final String db_address = "jdbc:mysql://35.234.16.88/";
	static final String db_option = "?useSSL=false";
	static final String db_id = "shroh";
	static final String db_pw = "3124";
	
	public MDatabase() {
		super();
		this.logger = Logger.getLogger(Main.class.getName());
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
							db_address + db_name + db_option, 
							db_id, db_pw);
		if(this.connection == null) return false;
		else return true;
	}
	public void disconnect() throws SQLException {
		if (this.connection != null) this.connection.close();
	}

	public boolean modifyingQuery(String query) {
		Statement st = null;
		try {
			st = this.connection.createStatement();
		} catch (SQLException e) {
			logger.error("[MDatabase] CreateStatement is failed");
			return false;
		}

		logger.info(query);

		boolean error = false;
		try {
			error = st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(query);
			logger.error("[MDatabase] Query execution is failed");
			return false;
		}

		if(error) {
			System.out.println(query);
			logger.error("Query failed.");
			return false;
		}else {
			return true;
		}
	}

	public ResultSet selectQuery(String query) {
		Statement st = null;
		try {
			st = this.connection.createStatement();
		} catch (SQLException e) {
			logger.error("[MDatabase] CreateStatement is failed");
			return null;
		}

		logger.info(query);

		ResultSet result = null;
		try {
			result = st.executeQuery(query);
		} catch (SQLException e) {
			logger.error("[MDatabase] Query execution is failed");
			return null;
		}

		return result;
	}

	/* Not Implemented Yet */
	public boolean initDB() {
		if(!cleanAllTable()) return false;

		Statement st = null;
		try {
			st = this.connection.createStatement();
		} catch (SQLException e) {
			logger.error("[MDatabase] CreateStatement is failed");
			return false;
		}

		try {
			MDBButterflyGuide db_butterflyguide = new MDBButterflyGuide(this.connection);

			st.execute("delete from ButterflyGuide where not idButterflyGuide=0");
			st.execute("delete from CameraInfo where not idCameraInfo=0");
			st.execute("delete from CollectionInfo where not idCollectionInfo=0");
			st.execute("delete from Image where not idImage=0");
			st.execute("delete from ImageObjectInfo where not idImageObjectInfo=0");
			st.execute("delete from Location where not idLocation=0");
			st.execute("delete from Observation where not idObservation=0");
			st.execute("delete from Person where not idPerson=0");
			st.execute("delete from Specimen where not idSpecimen=0");
			st.execute("delete from SpecimenIO where not idSpecimenIO=0");
			st.execute("delete from Specimenize where not idSpecimenize=0");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("[MDatabase] Delete all items is failed");
			return false;
		}
		return true;
	}

	public boolean cleanAllTable() {
		Statement st = null;
		try {
			st = this.connection.createStatement();
		} catch (SQLException e) {
			logger.error("[MDatabase] CreateStatement is failed");
			return false;
		}

		try {
			st.execute("delete from ButterflyGuide where not idButterflyGuide=0");
			st.execute("delete from CameraInfo where not idCameraInfo=0");
			st.execute("delete from CollectionInfo where not idCollectionInfo=0");
			st.execute("delete from Image where not idImage=0");
			st.execute("delete from ImageObjectInfo where not idImageObjectInfo=0");
			st.execute("delete from Location where not idLocation=0");
			st.execute("delete from Observation where not idObservation=0");
			st.execute("delete from Person where not idPerson=0");
			st.execute("delete from Specimen where not idSpecimen=0");
			st.execute("delete from SpecimenIO where not idSpecimenIO=0");
			st.execute("delete from Specimenize where not idSpecimenize=0");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("[MDatabase] Delete all items is failed");
			return false;
		}

		return true;
	}
}
