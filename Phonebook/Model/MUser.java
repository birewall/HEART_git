package Model;

public class MUser {
	private String name;
	private String id;
	private String phonenumber;
	
	public MUser(String name, String id, String phonenumber) {
		super();
		this.name = name;
		this.id = id;
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
}
