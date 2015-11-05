package me.logx.activemq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Main {
	public static void send() {
		try {
			// ����һ�����ӹ���
			String url = "tcp://localhost:61616";
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			// �����û��������룬����û�����������confĿ¼�µ�credentials.properties�ļ��У�Ҳ������activemq.xml������
			connectionFactory.setUserName("system");
			connectionFactory.setPassword("manager");
			// ��������
			Connection connection = connectionFactory.createConnection();
			connection.start();
			// ����Session���������ͣ�
			// ��һ�������Ƿ�ʹ������:����Ϣ����������Ϣ�ṩ�ߣ�����Ϣ����������Ϣʱ����Ϣ�����ߵȴ���Ϣ�����ȷ�ϣ�û�л�Ӧ���׳��쳣����Ϣ���ͳ��������������
			// �ڶ���������Ϣ��ȷ��ģʽ��
			// AUTO_ACKNOWLEDGE �� ָ����Ϣ�ṩ����ÿ���յ���Ϣʱ�Զ�����ȷ�ϡ���Ϣֻ��Ŀ�귢��һ�Σ�����������п�����Ϊ�������ʧ��Ϣ��
			// CLIENT_ACKNOWLEDGE �� ����Ϣ������ȷ���յ���Ϣ��ͨ��������Ϣ��acknowledge()��������֪ͨ��Ϣ�ṩ���յ�����Ϣ��
			// DUPS_OK_ACKNOWLEDGE �� ָ����Ϣ�ṩ������Ϣ������û��ȷ�Ϸ���ʱ���·�����Ϣ������ȷ��ģʽ���ں��������յ��ظ�����Ϣ����
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// ����Ŀ�꣬�ʹ�������Ҳ���Դ�������
			Destination destination = session.createQueue("test");
			// ������Ϣ������
			MessageProducer producer = session.createProducer(destination);
			// ���ó־û���DeliveryMode.PERSISTENT��DeliveryMode.NON_PERSISTENT
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			// ������Ϣ
			String text = "Hello ActiveMQ!";
			TextMessage message = session.createTextMessage(text);
			// ������Ϣ��ActiveMQ
			producer.send(message);
			System.out.println("Message is sent!");
			// �ر���Դ
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void get(){
		try{
		    String url = "tcp://localhost:61616";
		    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		    // �����û��������룬����û�����������confĿ¼�µ�credentials.properties�ļ��У�Ҳ������activemq.xml������
		    connectionFactory.setUserName("system");
		    connectionFactory.setPassword("manager");
		    // ��������
		    Connection connection = connectionFactory.createConnection();
		    connection.start();
		    // ����Session
		    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		    // ����Ŀ�꣬�ʹ�������Ҳ���Դ�������
		    Destination destination = session.createQueue("test");
		    // ������Ϣ������
		    MessageConsumer consumer = session.createConsumer(destination);
		    // ������Ϣ��������������Ϣ�ĳ�ʱʱ�䣬Ϊ0�Ļ��򲻳�ʱ��receive������һ����Ϣ�����ǳ�ʱ�˻��������߱��رգ�����null
		    Message message = consumer.receive(1000);
		    if (message instanceof TextMessage) {
		        TextMessage textMessage = (TextMessage) message;
		        String text = textMessage.getText();
		        System.out.println("Received: " + text);
		    } else {
		        System.out.println("Received: " + message);
		    }
		    consumer.close();
		    session.close();
		    connection.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		send();
//		get();
		System.out.println(System.getProperty("java.io.tmpdir"));
	}
}
