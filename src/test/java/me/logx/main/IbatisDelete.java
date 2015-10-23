package me.logx.main;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import me.logx.domain.Employee;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class IbatisDelete {
	public static void main(String[] args) throws IOException, SQLException {
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

		/* This would delete one record in Employee table. */
		System.out.println("Going to delete record.....");
		int id = 1;

		smc.delete("Employee.delete", id);
		System.out.println("Record deleted Successfully ");

		System.out.println("Going to read records.....");
		List<Employee> ems = (List<Employee>) smc.queryForList("Employee.getAll", null);
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