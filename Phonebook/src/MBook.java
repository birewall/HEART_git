
public class MBook {
	private String name;
	private String id;
	private String author;
	
	public MBook(String id, String name, String author) {
		super();
		this.name = name;
		this.id = id;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIssn(String author) {
		this.author = author;
	}

}
