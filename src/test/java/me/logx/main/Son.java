package me.logx.main;

public class Son extends Father {
	public Son() {
		System.out.println(name);
	}
	public static void main(String[] args) {
		new Son();
	}
}
