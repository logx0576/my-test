package me.logx.proxy.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyBean implements MethodInterceptor {

	public <T> T newInstance(Class<T> target) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target);
		enhancer.setCallback(this);
		return (T) enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("before method invoke...");
		Object ret = proxy.invokeSuper(obj, args);
		System.out.println("after method invoke...");
		return ret;
	}
}
