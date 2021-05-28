package com.rit.oracle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeptSelectTest {

public static void main(String[] args)throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from dept");
		
		while(resultSet.next() != false)
		{
			System.out.println(" "+resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
			//System.out.println(" "+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
			//System.out.println(" "+resultSet.getInt("sno")+" "+resultSet.getString("sname")+" "+resultSet.getString("sadd")+" "+resultSet.getFloat("avg")+" ");
			//System.out.println(" "+resultSet.getString("sno")+" "+resultSet.getString("sname")+" "+resultSet.getString("sadd")+" "+resultSet.getString("avg")+" ");

		}
		resultSet.close();
		statement.close();
		connection.close();
	}

}
