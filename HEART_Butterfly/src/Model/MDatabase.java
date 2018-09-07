package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import Common.Main;

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

	public boolean modifyingQuery(String query) throws SQLException {
		Statement st = this.connection.createStatement();
		logger.info(query);
		System.out.println(query);
		boolean error = st.execute(query);
		if(error) {
			logger.error("Query failed.");
			return false;
		}else {
			return true;
		}
	}
}
