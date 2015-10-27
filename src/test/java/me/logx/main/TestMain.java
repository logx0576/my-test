package me.logx.main;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.caucho.hessian.client.HessianProxyFactory;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;

import jxl.CellView;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import me.logx.bean.HessianBean;
import me.logx.domain.Employee;

public class TestMain {

	public void doSqlMapClientTemplate() throws Exception {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("services.xml");
		HessianBean h = application.getBean("remoteUserService", HessianBean.class);
		h.hessianPrint();
		//
		// SqlMapClient sqlMapClient = application.getBean("sqlMapClient",
		// SqlMapClient.class);
		//
//		Employee em = new Employee("Zara", "ccccddd", 5000);

		// sqlMapClient.insert("Employee.insert", em);

//		SqlMapClientTemplate sqlMapClientTemplate = application.getBean("sqlMapClientTemplate",
//				SqlMapClientTemplate.class);
//
//		sqlMapClientTemplate.execute(new SqlMapClientCallback<String>() {
//			@Override
//			public String doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
//				executor.startBatch();
//				executor.insert("Employee.insert", em);
//				System.out.println(executor.executeBatch());
//				return null;
//			}
//
//		});
		
	}

	public void workBookDemo() throws Exception {
		File xlsFile = new File("D:/test1.xls");

		// ����Excel�ļ�
		WritableWorkbook writableWorkbook = Workbook.createWorkbook(xlsFile);
		// ����������
		WritableSheet writeSheet = writableWorkbook.createSheet("������", 0);
		// ��Ԫ���ʽ
		CellView cellView = new CellView();
		cellView.setAutosize(true);
		// ��ʽ����
		WritableCellFormat writableCellFormat = new WritableCellFormat(
				new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD, false));

		Label lable = new Label(0, 0, "��Ʒ����1111", writableCellFormat);
		writeSheet.setColumnView(0, cellView);
		writeSheet.addCell(lable);

		// д�롢�ر�
		writableWorkbook.write();
		writableWorkbook.close();
	}

	public static void main(String[] args) throws WriteException, IOException {
//		new Write("D:/tt.xls").write();
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("services.xml");
//		HessianBean h = application.getBean("remoteUserService", HessianBean.class);
//		h.hessianPrint();
		
		String url = "http://127.0.0.1:8089/remoting/hessianBean.hessian";  
	       HessianProxyFactory factory = new HessianProxyFactory();  
	       HessianBean math = null;  
	       try {  
	          math = (HessianBean)factory.create(HessianBean.class, url);  
	          math.hessianPrint();
	       } catch (MalformedURLException e) {  
	       }  
	}
}
