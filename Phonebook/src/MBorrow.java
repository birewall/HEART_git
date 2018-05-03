
public class MBorrow {
	private String book_id;
	private String user_id;
	private String borrow_date;
	private String retrieve_date;
	
	public MBorrow(String book_id, String user_id, String borrow_date, String retrieve_date) {
		super();
		this.book_id = book_id;
		this.user_id = user_id;
		this.borrow_date = borrow_date;
		this.retrieve_date = retrieve_date;
	}

	public String getBook_id() {
		return book_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public String getRetrieve_date() {
		return retrieve_date;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public void setRetrieve_date(String retrieve_date) {
		this.retrieve_date = retrieve_date;
	}


}
