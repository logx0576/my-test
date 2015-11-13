package me.logx.squartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleSpringQuartz {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("squartz.xml");
	}
}