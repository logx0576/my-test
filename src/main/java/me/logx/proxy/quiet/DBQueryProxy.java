package me.logx.proxy.quiet;

public class DBQueryProxy implements IDBQuery {

	private DBQuery real = null;

	@Override
	public String request() {
		// TODO Auto-generated method stub
		// ��������Ҫ��ʱ����ܴ�����ʵ���󣬴������̿��ܺ���
		if (real == null) {
			real = new DBQuery();
		} // �ڶ��̻߳����£����ﷵ��һ������࣬������ Future ģʽ
		return real.request();
	}

}