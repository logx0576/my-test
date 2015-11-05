package me.logx.proxy.test;

import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		ProxyBean proxyBean = new ProxyBean();
		
		BookBean bookBean = proxyBean.newInstance(BookBeanImp.class);
		bookBean.getBookInfo();
		System.out.println("-----");
		
		StudentBean studentBean = proxyBean.newInstance(StudentBeanImp.class);
		studentBean.getStudentInfo();
		System.out.println("-----");
		
		bookBean.getBookInfo();
	}

}
