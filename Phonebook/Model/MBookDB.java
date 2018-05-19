package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MBookDB {
	Connection conn;
	ArrayList<MBook> book_result = null;
	ArrayList<MUser> user_result = null;
	ArrayList<MBorrow> rent_result = null;
	
	public MBookDB(){
		conn = null;
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
	
	public ArrayList<MBook> search(MBook book, MUser user) throws SQLException {
		return null;
		
		/*if(book != null){
			String bookname = book.getName();
		}
		
		ArrayList <MBook> result = new ArrayList<>();
		int count = 0;
		String sql = "selected * from Library where";
		if(item.getId() != null){
			if(count>0){
				sql += " and id = " + "'" + item.getId() + "'" ;
			}else {
				count ++;
				sql += " id = " + "'" + item.getId() + "'" ;
			}
		}
		if(item.getName() != null){
			if(count >0){
				sql += " and book_name =" + "'" + item.getName() + "'";
			}else{
				count ++;
				sql += " book_name =" + "'" + item.getName() + "'";
			}
		}
		if(item.getRent_date() != null){
			if(count > 0 ){
				sql += " and book_rent = " + "'" + item.getRent_date() + "'";
			}else {
				count ++;
				sql += " book_rent = " + "'" + item.getRent_date() + "'";
			}			
		}
		if(item.getRetreive_date() != null){
			if(count >0){
				sql += " and book_return = " + "'" + item.getRetreive_date() + "'";
			}else {
				count ++;
				sql += " book_return = " + "'" + item.getRetreive_date() + "'";
			}
		}
		
		ArrayList <MBook> rs = new ArrayList<>();
		
		//while()
		System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		
		
		if (error){
			System.out.println("Searching was failed.");
		}
		*/
		//return result;
	}
	
	public boolean insert(MBook book) throws SQLException {
		String sql = "Insert into Book Values ('" 
					+ book.getId() + "', '"
					+ book.getName() + "', '"
					+ book.getAuthor() + "')";
		
		System.out.println(sql);
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
	
		System.out.println(sql);
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
		System.out.println(sql);
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
		System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Deletion was failed.");
		}


		return false;
	}
	public boolean rent(MBook book, MUser user) throws SQLException{
		String sql = "Insert into Rent Values ('"
					+ book.getId() + "', '"
					+ user.getId() + "', "
					+ "" + ","
					+ "" + "')";
		
		System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
		System.out.println("Rent was failed.");
		}
		return false;
	}
	
	public boolean retreive(MBorrow rent) throws SQLException {
		String sql = "Delete From Rent where book_id =" 
				+ "'" + rent.getBook_id() + "' and"
				+ "'" + rent.getUser_id() + "'";
		
		System.out.println(sql);
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
