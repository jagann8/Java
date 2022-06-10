package com.hdfc.datasource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnectionFactory {
	
	private final static Properties properties=new Properties();
	static {
		try {
		FileInputStream fis=new FileInputStream("src/resources/datasource.properties");
		properties.load(fis);
		fis.close();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	static {
		//  step-1 register jdbc-driver
		
		try {
			Class.forName(properties.getProperty("datasource.driver-class-name"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// factory method
	
	/*
	 * why we need Factory
	 * => isolate complex obejct creation logic from regular code
	 * */
	
	
	public static Connection getConenction() throws SQLException {
		
		//  step-2 create database connection
		
		String url=properties.getProperty("datasource.url");
		String username=properties.getProperty("datasource.username");
		String password=properties.getProperty("datasource.password");
		return DriverManager.getConnection(url,username,password);
	
		
	}
}
