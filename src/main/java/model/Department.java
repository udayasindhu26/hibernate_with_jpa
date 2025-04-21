package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String dept_name, String location) {
		super();
		this.id = id;
		this.dept_name = dept_name;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Id
	private int id;
	private String dept_name;
	private String location;

}
