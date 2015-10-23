package me.logx.domain;

public class Employee {
	
	private int id = 1;
	
	private String first_name;
	
	private String last_name;
	
	private int salary;

	/* Define constructors for the Employee class. */
	public Employee() {
	}

	public Employee(String fname, String lname, int salary) {
		this.first_name = fname;
		this.last_name = lname;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
