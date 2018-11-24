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

		//System.out.println(query);
		logger.info(query);

		boolean error = false;
		try {
			error = st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println(query);
			logger.error("[MDatabase] Query execution is failed");
			return false;
		}

		if(error) {
			//System.out.println(query);
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

		//System.out.println(query);
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

	public boolean initDB() {
		if(!cleanAllTable()) return false;

		Statement st = null;
		try {
			st = this.connection.createStatement();
		} catch (SQLException e) {
			logger.error("[MDatabase] CreateStatement is failed");
			return false;
		}

		MDBButterflyGuide db_butterflyguide = new MDBButterflyGuide(this.connection);
		MDBCameraInfo db_camerainfo = new MDBCameraInfo(this.connection);
		MDBCollectionInfo db_collectioninfo = new MDBCollectionInfo(this.connection);
		MDBImage db_image = new MDBImage(this.connection);
		MDBImageObjectInfo db_imageobjinfo = new MDBImageObjectInfo(this.connection);
		MDBLocation db_location = new MDBLocation(this.connection);
		MDBObservation db_observation = new MDBObservation(this.connection);
		MDBPerson db_person = new MDBPerson(this.connection);
		MDBSpecimen db_specimen = new MDBSpecimen(this.connection);
		MDBSpecimenIO db_specimenIO = new MDBSpecimenIO(this.connection);
		MDBSpecimenize db_specimenize = new MDBSpecimenize(this.connection);

		if(!db_butterflyguide.insert_zero_id()) return false;
		if(!db_camerainfo.insert_zero_id()) return false;
		if(!db_collectioninfo.insert_zero_id()) return false;
		if(!db_image.insert_zero_id()) return false;
		if(!db_imageobjinfo.insert_zero_id()) return false;
		if(!db_location.insert_zero_id()) return false;
		if(!db_observation.insert_zero_id()) return false;
		if(!db_person.insert_zero_id()) return false;
		if(!db_specimen.insert_zero_id()) return false;
		if(!db_specimenIO.insert_zero_id()) return false;
		if(!db_specimenize.insert_zero_id()) return false;
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

		MDBButterflyGuide db_butterflyguide = new MDBButterflyGuide(this.connection);
		MDBCameraInfo db_camerainfo = new MDBCameraInfo(this.connection);
		MDBCollectionInfo db_collectioninfo = new MDBCollectionInfo(this.connection);
		MDBImage db_image = new MDBImage(this.connection);
		MDBImageObjectInfo db_imageobjinfo = new MDBImageObjectInfo(this.connection);
		MDBLocation db_location = new MDBLocation(this.connection);
		MDBObservation db_observation = new MDBObservation(this.connection);
		MDBPerson db_person = new MDBPerson(this.connection);
		MDBSpecimen db_specimen = new MDBSpecimen(this.connection);
		MDBSpecimenIO db_specimenIO = new MDBSpecimenIO(this.connection);
		MDBSpecimenize db_specimenize = new MDBSpecimenize(this.connection);

		if(!db_butterflyguide.clear_table()) return false;
		if(!db_camerainfo.clear_table()) return false;
		if(!db_collectioninfo.clear_table()) return false;
		if(!db_image.clear_table()) return false;
		if(!db_imageobjinfo.clear_table()) return false;
		if(!db_location.clear_table()) return false;
		if(!db_observation.clear_table()) return false;
		if(!db_person.clear_table()) return false;
		if(!db_specimen.clear_table()) return false;
		if(!db_specimenIO.clear_table()) return false;
		if(!db_specimenize.clear_table()) return false;

		return true;
	}

	public boolean changeID(int id_before, int id_after) {
		String query = "update " + this.table_name + " set id" + this.table_name + "=" + id_after
				+ " where id"+ this.table_name + "="
				+ id_before;
		return modifyingQuery(query);
	}

	public boolean clear_table() {
		String query = "delete from " + this.table_name + " where not id" + this.table_name + "=0";
		return modifyingQuery(query);
	}

	public boolean insert_zero_id() {
		if(!delete(0)) return false;
		initialize();
		if(!insert()) return false;
		int zero_id = getIDFromDB();
		if(zero_id > 0) {
			return changeID(zero_id, 0);
		}
		return true;
	}

	public String db_string_formatting(String origin, String type) {
		if(origin == null)
			return null;
		else if(type.equals("string") || type.equals("String"))
			return "'" + origin + "'";
		else if(type.equals("int") || type.equals("Int"))
			return origin;
		else
			return null;
	}

	/* 	Input: 	'abcd'
	* 	Output:	column='abcd',
	* */
	public String db_update_formatting(String origin, String column_name) {
		String query;
		if(origin == null) return "";
		query = column_name + "=" + origin + ",";
		return query;
	}

	/* 	Input: 	'abcd'
	 * 	Output:	column='abcd',
	 * */
	public String db_where_formatting(String origin, String column_name) {
		String query;
		if(origin == null) return column_name + " is null";
		query = column_name + "=" + origin;
		return query;
	}

	/* For Override */
	public int getIDFromDB() {
		return 0;
	}

	/* For Override */
	public void initialize() { }

	/* For Override */
	public boolean delete(int id) {
		return false;
	}

	/* For Override */
	public boolean insert() {
		return false;
	}
}
