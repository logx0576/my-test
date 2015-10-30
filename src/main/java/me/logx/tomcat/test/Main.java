package me.logx.tomcat.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import sun.awt.image.URLImageSource;

public class Main {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://lavasoft.blog.51cto.com/attachment/200811/200811271227767778082.jpg");
		//获得此 URL 的内容。 
		Object obj = url.getContent();
		System.out.println(obj.getClass().getName());
	}
}
