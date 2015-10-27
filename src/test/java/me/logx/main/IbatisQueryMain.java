package me.logx.main;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import me.logx.dao.query.EmployeeQuery;
import me.logx.domain.Employee;

public class IbatisQueryMain {

	public static void main(String[] args) throws IOException, SQLException {
		Reader rd = Resources.getResourceAsReader("SqlMapConfig_backup.xml");
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
//		PropertyConfigurator.configure("log4j.properties");
		/* This would read all records from the Employee table. */
		System.out.println("Going to read records.....");
		
		EmployeeQuery query = new EmployeeQuery();
		
		query.setPageNo(1);
		query.setPageSize(2);
		query.setTotalCount(4);
		System.out.println(query.getBeginIndex());
		System.out.println(query.getEndIndex());
		
		List<Employee> ems = (List<Employee>) smc.queryForList("Employee.getEmployeePage", query);
		Employee em = null;

		for (Employee e : ems) {
			System.out.print("  " + e.getId());
			System.out.print("  " + e.getFirstName());
			System.out.print("  " + e.getLastName());
			System.out.print("  " + e.getSalary());
			em = e;
			System.out.println("");
		}

		System.out.println("Records Read Successfully ");
	}

}
