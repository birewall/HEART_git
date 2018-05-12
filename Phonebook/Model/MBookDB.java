package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MBookDB {
	Connection conn;
	
	MBookDB(){
		conn = null;
	}
	
	public void open() throws ClassNotFoundException, SQLException {
		Statement st = null;
        Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://35.201.230.135/javateam?useSSL=false", 
					"javateam", "boradori1");
			st = conn.createStatement();
			
//				String sql = "insert into Library_books values("
//						+ "\"" + this.txtName_b.getText() + "\","
//						+  this.txtDate_b.getText() + ","
//						+ this.txtRental_b.getText() + ")";
//				
//				boolean error = st.execute(sql);
//				if(error){
//					System.out.println("Insertion was failed.");
//					return;
//				}
//				
//				st.close();
//				connection.close();
			}
	
	public ArrayList<MBook> search(MBook book, MUser user) throws SQLException {
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
	
	public boolean insert(MBook name) throws SQLException {
		String sql = "Insert into Library(book_name) Values (" 
					+ "'" + name.getName() + ")";
		
		System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Insertion was failed.");
		}
		

		return false;
	}
	
	public boolean insert(MUser name) throws SQLException {
		String sql = "Insert into Library(user_name) Values (" 
				+ "'" + name.getName() + ")";
	
		System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Insertion was failed.");
		}
		

		return false;
	}
	
	public boolean delete(MBook item) throws SQLException {
		String sql = "Delete From Library where id =" 
					+ "'" + item.getId() + "'";
		System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
			System.out.println("Deletion was failed.");
		}


		return false;
	}
	
	public boolean rent(MBook item) throws SQLException{
		String sql = "Update Library set book_rent =" + "'" + item.getRent_date() + "'" 
					+ ", book_return ="+ "'" + item.getRetreive_date() + "'"
					+ "where id = "+ "'" + item.getId() + "'";
		
		System.out.println(sql);
		Statement st = conn.createStatement();
		boolean error = st.execute(sql);
		if (error){
		System.out.println("Rent was failed.");
		}
		return false;
	}
	
	public boolean retreive(MBook item) throws SQLException {
		String sql = "Update Library set book_rent =" + "''"
					+ ", book_return ="+ "''";
	
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
