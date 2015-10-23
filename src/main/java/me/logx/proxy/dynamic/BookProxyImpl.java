package me.logx.proxy.dynamic;

//该类并没有申明 BookProxy 接口
public class BookProxyImpl implements BookProxy {
	@Override
	public void addBook() {
		System.out.println("增加图书的普通方法...");
	}
}