package me.logx.main;

import java.util.Date;

public class OneBean {
	
	private String name;

	private int age;
	
	private Date birth;
	
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public OneBean() {
		this.name = "logx";
		this.age = 3;
		this.birth = new Date();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return getName() + " : " + getAge() + getBirth();
	}
}
