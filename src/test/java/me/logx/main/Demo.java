package me.logx.main;

public class Demo {
	private int i = 1;
	
	public void doDemo() {
		while(true) {
			System.out.println(i++);
			if(i == 2) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("over");
	}
	
	public static void main(String[] args) {
		new Demo().doDemo();
		System.gc();
	}
}
