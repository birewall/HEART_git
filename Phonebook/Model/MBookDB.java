package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MBookDB {
	Connection conn;
	ArrayList<MBook> book_result = null;
	ArrayList<MUser> user_result = null;
	ArrayList<MBorrow> rent_result = null;
	
	final static boolean FLAG_DEBUG = true;
	
	public MBookDB(){
		conn = null;
		this.book_result = new ArrayList<MBook>();
		this.user_result = new ArrayList<MUser>();
		this.rent_result = new ArrayList<MBorrow>();
	}
	
	public ArrayList<MBook> getBook_result() {
		return book_result;
	}



	public ArrayList<MUser> getUser_result() {
		return user_result;
	}



	public ArrayList<MBorrow> getRent_result() {
		return rent_result;
	}



	public void open() throws ClassNotFoundException, SQLException {
		Statement st = null;
        Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://35.201.230.135/library?useSSL=false", 
					"javateam", "boradori1");
		st = conn.createStatement();
	}
	
	/**
	 * @param book
	 * @param user
	 * @throws SQLException
	 */
	public void search(MBook book, MUser user) throws SQLException {
		this.book_result.clear();
		this.user_result.clear();
		this.rent_result.clear();
		
		String where_statement = null;
		
		ResultSet rs = null;
		Statement st = conn.createStatement();
		
		if(book.getName().length()>0) {
			if(FLAG_DEBUG) System.out.println("Select * From Book Where name = " + "'" + book.getName() + "'");
			rs = st.executeQuery("Select * From Book Where name = " + "'" + book.getName() + "'");
			while(rs.next()) {
				MBook item = new MBook(rs.getString(1), rs.getString(2), rs.getString(3));
				this.book_result.add(item);
			}
			if(where_statement == null) {
				where_statement = "where book_id = ( select id from Book where name = '" 
								+ book.getName() + "')";
			}
		}
		
		if(user.getName().length()>0) {
			if(FLAG_DEBUG) System.out.println("Select * From User Where name = " + "'" + user.getName() + "'");
			rs = st.executeQuery("Select * From User Where name = " + "'" + user.getName() + "'");
			while(rs.next()) {
				MUser item = new MUser(rs.getString(1), rs.getString(2), rs.getString(3));
				this.user_result.add(item);
			}
			if(where_statement == null) {
				where_statement = "where user_id = ( select id from User where name = '" 
								+ user.getName() + "')";
			}else {
				where_statement += " or user_id = ( select id from User where name = '" 
						+ user.getName() + "')";
			}
		}
		
		rs = st.executeQuery("Select * From Borrow " + where_statement);
		if(FLAG_DEBUG) System.out.println("Select * From Borrow " + where_statement);
		while(rs.next()) {
			MBorrow item = new MBorrow(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			this.rent_result.add(item);
		}
	}
	
	public boolean insert(MBook book) throws SQLException {
		String sql = "Insert into Book Values ('" 
					+ book.getId() + "', '"
					+ book.getName() + "', '"
					+ book.getAuthor() + "')";
		
		if(FLAG_DEBUG) System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Insertion was failed.");
		}
		
		return false;
	}
	
	public boolean insert(MUser name) throws SQLException {
		String sql = "Insert into User Values ('" 
				+ name.getId() + "', '"
				+ name.getName() + "', '"
				+ name.getPhonenumber() + "')";
	
		if(FLAG_DEBUG) System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Insertion was failed.");
		}

		return false;
	}
	
	public boolean delete(MBook item) throws SQLException {
		String sql = "Delete From Book where id =" 
					+ "'" + item.getId() + "'";

		if(FLAG_DEBUG) System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Deletion was failed.");
		}

		return false;
	}
	
	public boolean delete(MUser item) throws SQLException {
		String sql = "Delete From User where id =" 
					+ "'" + item.getId() + "'";

		if(FLAG_DEBUG) System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Deletion was failed.");
		}


		return false;
	}
	
	public boolean rent(MBook book, MUser user) throws SQLException{
		String sql = "Insert into Borrow Values ('"
					+ book.getId() + "', '"
					+ user.getId() + "', null, null)";
		

		if(FLAG_DEBUG) System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Rent was failed.");
		}
		return false;
	}
	
	public boolean retreive(MBorrow rent) throws SQLException {
		String sql = "Delete From Borrow where book_id = " 
				+ "'" + rent.getBook_id() + "' and user_id = "
				+ "'" + rent.getUser_id() + "'";
		
		if(FLAG_DEBUG) System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Return was failed.");
		}

		return false;
	}
	
	public void close() throws SQLException {
		conn.close();
	}	
}
