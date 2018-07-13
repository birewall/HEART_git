package Model;

public class MEmployee {
	private String name;
	private String enroll_date;
	private String department;
	private String image_path;
	
	public MEmployee() {
		super();
		this.name = null;
		this.enroll_date = null;
		this.department = null;
		this.image_path = null;
	}
	
	public MEmployee(String name, String enroll_date, String department) {
		super();
		this.name = name;
		this.enroll_date = enroll_date;
		this.department = department;
		this.image_path = null;
	}
	
	public MEmployee(String name, String enroll_date, String department, String image_path) {
		super();
		this.name = name;
		this.enroll_date = enroll_date;
		this.department = department;
		this.image_path = image_path;
	}

	public String getName() {
		return name;
	}

	public String getEnroll_date() {
		return enroll_date;
	}

	public String getDepartment() {
		return department;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
}
