import java.sql.Connection;

public class Practice1 {
	public static class DB{
		Connection con;
		
		DB(){
			con = null;
		}
		
		void open(String id, String pw) {
			/* Fill */
		}
		
		String[] list() {
			String item[] = null;
			/* Fill */
			return item;
		}
		
		boolean find(String item) {
			/* Fill */
			return false;
		}
	}
	
	public static void main(String[] argv) {
		DB myDB = new DB();
		
		String id = null;
		String pw = null;
		String[] items = null;
		String find_item = null;
		
		myDB.open(id, pw);
		
		items = myDB.list();
		for(String item : items) {
			System.out.println(item);
		}
		
		if( myDB.find(find_item) ) {
			System.out.println("Exist");
		}else {
			System.out.println("Not Exist");
		}
	}
}
