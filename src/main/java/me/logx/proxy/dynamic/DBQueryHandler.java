package me.logx.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import me.logx.proxy.quiet.DBQuery;
import me.logx.proxy.quiet.IDBQuery;

public class DBQueryHandler implements InvocationHandler {
	IDBQuery realQuery = null;// ��������ӿ�

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		// �����һ�ε��ã�������ʵ����
		if (realQuery == null) {
			realQuery = new DBQuery();
		}
		// ������ʵ�������ʵ�ʵĲ���
		return realQuery.request();
	}

	public static IDBQuery createProxy() {
		IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] { IDBQuery.class }, new DBQueryHandler());
		return proxy;
	}
}