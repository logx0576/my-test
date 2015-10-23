package me.logx.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pet implements DisposableBean, InitializingBean {

	private int petAge;

	private String petName;

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		System.out.println("init name...");
		this.petName = petName;
	}

	public void print() {
		System.out.println(petName + " " + petAge);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy...");
	}
}
