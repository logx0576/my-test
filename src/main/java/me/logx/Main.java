package me.logx;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File f = new File("a.txt");
		System.out.println(f.getAbsoluteFile());
	}

}
