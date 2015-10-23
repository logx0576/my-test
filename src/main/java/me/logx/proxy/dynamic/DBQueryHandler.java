package me.logx.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import me.logx.proxy.quiet.DBQuery;
import me.logx.proxy.quiet.IDBQuery;

public class DBQueryHandler implements InvocationHandler {
	IDBQuery realQuery = null;// 定义主题接口

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		// 如果第一次调用，生成真实主题
		if (realQuery == null) {
			realQuery = new DBQuery();
		}
		// 返回真实主题完成实际的操作
		return realQuery.request();
	}

	public static IDBQuery createProxy() {
		IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] { IDBQuery.class }, new DBQueryHandler());
		return proxy;
	}
}