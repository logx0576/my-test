package me.logx.main;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Main {
	//	public static void main(String[] args) throws UnsupportedEncodingException {
	//
	//		byte[] bb = "汉字".getBytes("gbk");
	//		System.out.println(new String(bb, "UTF-8"));
	//	}
	public static void main(String[] args) throws UnsupportedEncodingException {
				byte[] b1 = "���".getBytes("utf-8");
				byte[] b2 = new String(b1, 0, b1.length, "UTF-8").getBytes("GBK");
				System.out.println(new String(b1, 0, b1.length));
				System.out.println(new String(b2, 0, b2.length));

//		long s1 = System.currentTimeMillis();
//		for (int i = 0; i < 100000000; i++) {
//			int b = i & 127;
//		}
//		long e1 = System.currentTimeMillis();
//		System.out.println(e1 - s1);
//		
//		long s2 = System.currentTimeMillis();
//		for (int i = 0; i < 100000000; i++) {
//			int b = i % 127;
//		}
//		long e2 = System.currentTimeMillis();
//		System.out.println(e2 - s2);
	}
}
