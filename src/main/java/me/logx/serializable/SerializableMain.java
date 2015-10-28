package me.logx.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import me.logx.bean.Student;

public class SerializableMain {
	public static Student getStudent() {
		Student student = new Student();
		student.setAge(10);
		student.setName("logx");
		return student;
	}

	public static void objectToFile() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/student")));
			oos.writeObject(getStudent());
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void fileToObject() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/student")));
			Student student = (Student) ois.readObject();
			ois.close();
			student.print();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
//		objectToFile();
		fileToObject();
		System.out.println("over");
	}
}
