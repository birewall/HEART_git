
public class CManager {
	MBookDB database = new MBookDB();
	CManager manager = new CManager();
	
	public CManager(){
		database = new MBookDB();
		manager = new CManager();
	}
}