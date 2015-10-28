package me.logx.mail;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.SimpleMailMessage;

public class SimpleMailDemo {
	public static void main(String[] args) throws Exception {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		// 设定 Mail Server 
		senderImpl.setHost("smtp.sina.com");
		// 建立邮件讯息
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// 设定收件人、寄件人、主题与内文
		mailMessage.setTo("logx0576@163.com");
		mailMessage.setFrom("logx0576x@sina.com");
		mailMessage.setSubject("Test");
		mailMessage.setText("This is a test!!!");
		// 传送邮件
		senderImpl.send(mailMessage);
		
		System.out.println("邮件传送 OK..");
	}
}