package me.logx.main;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;

import jxl.CellView;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import me.logx.domain.Employee;

public class TestMain {
	
	public void doSqlMapClientTemplate() throws Exception {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("services.xml");
//		
//		SqlMapClient sqlMapClient = application.getBean("sqlMapClient", SqlMapClient.class);
//		
		Employee em = new Employee("Zara", "ccccddd", 5000);
		
//		sqlMapClient.insert("Employee.insert", em);
		
		SqlMapClientTemplate sqlMapClientTemplate = application.getBean("sqlMapClientTemplate", SqlMapClientTemplate.class);
		
		sqlMapClientTemplate.execute(new SqlMapClientCallback<String>() {
			@Override
			public String doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				executor.insert("Employee.insert", em);
				System.out.println(executor.executeBatch());
				return null;
			}
			
		});
	}
	
	public static void main(String[] args) throws IOException {
		WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("D:/test.xls"));
		
		WritableSheet writeSheet = writableWorkbook.createSheet("������", 0);
		
		CellView cellView = new CellView();
		cellView.setAutosize(true);
		
		WritableCellFormat writableCellFormat = new WritableCellFormat(new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD, false))
		
		Label lable = new Label(0, 0, "��Ʒ����", writableCellFormat);
		
		writeSheet.addCell(lable);
				
//		//�������������
//		jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(wf);
//		Label label = new Label(0, 0, "��Ʒ����", wcfF);
//		ws.addCell(label);
//		ws.setColumnView(0, cellView);
//		
//		label = new Label(1, 0, "��ͬ��", wcfF);
//		ws.addCell(label);
//		ws.setColumnView(1, cellView);
//		
//		label = new Label(2, 0, "����λ��", wcfF);
//		ws.addCell(label);
//		ws.setColumnView(2, cellView);
	}
}
