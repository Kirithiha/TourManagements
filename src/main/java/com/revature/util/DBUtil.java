package com.revature.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// DB UTIL FILE.
public class DBUtil {

	// TO GET CONNECTION FOR DATABASE.
		public static Connection getDbConnection() throws Exception{
			
			FileInputStream file = new FileInputStream("dbConnection.properties"); 
			Properties properties = new Properties(); 
			properties.load(file);
			String url = properties.getProperty("url");	
			String id = properties.getProperty("user"); 
			String pwd = properties.getProperty("password"); 
			
			// CONNECTION TO DB USING DRIVER MANAGEMENT.
			Connection con = DriverManager.getConnection(url,id,pwd); 
			return con;
		}
}
