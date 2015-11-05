package me.logx.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassloader extends ClassLoader {
	
	public Class findClass(String name){
		System.out.println("enter into findClass...");
		System.out.println("parent class load: " + getParent());
		try {
			super.findClass("MyApp");
			System.out.println("is find class");
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println("is not find class");
		}
			
		byte[] data = loadClassData(name);
//		return defineClass("me.logx.classloader." + name, data, 0, data.length);
		try {
			return super.loadClass("me.logx.classloader.MyApp", true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private byte[] loadClassData(String name) {
		FileInputStream fis = null;
		byte[] data = null;
		try {
//			D:\Develop\hs-workspace\SourcesForInterface_20151019_Beta\my-test\target\classes\me\logx\classload
//			System.out.println(new File(System.getProperty("user.dir") + "\\target\\classes\\me\\logx\\classloader\\" + name + ".class"));
			System.out.println(new File("D:/" + name + ".class"));
			fis = new FileInputStream(new File("D:/" + name + ".class"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int ch = 0;
			while ((ch = fis.read()) != -1) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
