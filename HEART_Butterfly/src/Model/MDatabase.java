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
			logger.error("[MDBButterflyGuide] CreateStatement is failed");
			return false;
		}

		logger.info(query);

		boolean error = false;
		try {
			error = st.execute(query);
		} catch (SQLException e) {
			logger.error("[MDBButterflyGuide] Query execution is failed");
			return false;
		}

		if(error) {
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
			logger.error("[MDBButterflyGuide] CreateStatement is failed");
			return null;
		}

		logger.info(query);

		ResultSet result = null;
		try {
			result = st.executeQuery(query);
		} catch (SQLException e) {
			logger.error("[MDBButterflyGuide] Query execution is failed");
			return null;
		}

		return result;
	}
}
