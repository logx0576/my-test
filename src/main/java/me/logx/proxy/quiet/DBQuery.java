package me.logx.proxy.quiet;

public class DBQuery implements IDBQuery {
	public DBQuery() {
		try {
			Thread.sleep(1000);// 假设数据库连接等耗时操作
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String request() {
		// TODO Auto-generated method stub
		return "request string";
	}

}
