package me.logx.classloader;

public class Main {
	public static void main(String[] args) throws Exception {
		CustomClassloader loader = new CustomClassloader();
		Class objClass = loader.findClass("MyApp");
		Object obj = objClass.newInstance();
		System.out.println(objClass.getName());
		System.out.println(objClass.getClassLoader());
		System.out.println(obj);
		
		System.out.println(MyApp.class.getClassLoader());
		MyApp app = (MyApp)obj;
//		Class obj = loader.loadClass("me.logx.classloader.MyApp"); 
//		System.out.println(obj.getClass() + "..");
//		System.out.println(obj.getName()+"...");
//		System.out.println(obj.getClassLoader()+"...");
	}
}
