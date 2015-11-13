package me.logx.squartz;

public class WelcomeBean {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void welcome() {
		System.out.println(message);
	}
}