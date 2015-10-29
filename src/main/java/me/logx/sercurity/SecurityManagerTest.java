package me.logx.sercurity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecurityManagerTest {

	/**
	 * vm arguments
	 * -Djava.security.manager
	 * -Djava.security.policy=D:/protect.policy
	 * 
	 * D:\\protect.policy
	 * grant { 
	 * 		permission java.io.FilePermission "D:/protect.txt", "read";
	 * 		//permission java.util.PropertyPermission "file.encoding", "read";
	 * };
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("SecurityManager: " + System.getSecurityManager());
//		System.out.println(System.getProperty("java.security.manager"));
		
		FileInputStream fis = new FileInputStream("D:\\protect.txt");
		try {
			System.out.println(System.getProperty("file.encoding"));
			
		} finally {
			if (fis != null) {
				fis.close();
			}
			System.out.println("over");
		}
	}
}