package me.logx.proxy.dynamic;

//���ಢû������ BookProxy �ӿ�
public class BookProxyImpl implements BookProxy {
	@Override
	public void addBook() {
		System.out.println("����ͼ�����ͨ����...");
	}
}