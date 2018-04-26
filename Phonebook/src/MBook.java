
public class MBook {
	private String name;
	private String id;
	private String rent_date;
	private String retreive_date;
	
	public MBook(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		this.rent_date = null;
		this.retreive_date = null;
	}
	
	public MBook(String name, String id, String rent_date, String retreive_date) {
		super();
		this.name = name;
		this.id = id;
		this.rent_date = rent_date;
		this.retreive_date = retreive_date;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getRent_date() {
		return rent_date;
	}

	public String getRetreive_date() {
		return retreive_date;
	}
	
	public void book_retreived() {
		this.rent_date = null;
		this.retreive_date = null;
	}
	
	public void book_rented(String rent_date, String retreive_date) {
		this.rent_date = rent_date;
		this.retreive_date = retreive_date;
	}
}
