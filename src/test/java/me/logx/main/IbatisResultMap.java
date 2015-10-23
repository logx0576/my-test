package me.logx.main;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import me.logx.domain.Employee;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class IbatisResultMap {
	public static void main(String[] args) throws IOException, SQLException {
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

		int id = 2;
		System.out.println("Going to read record.....");
		Employee e = (Employee) smc.queryForObject("Employee.useResultMap", id);

		System.out.println("ID:  " + e.getId());
		System.out.println("First Name:  " + e.getFirstName());
		System.out.println("Last Name:  " + e.getLastName());
		System.out.println("Salary:  " + e.getSalary());
		System.out.println("Record read Successfully ");
	}
}