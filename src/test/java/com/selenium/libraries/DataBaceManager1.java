package com.selenium.libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DataBaceManager1 {
	final static Logger logger =Logger.getLogger(DataBaceManager1.class);
	
	private String Hostname;
	private String databasePort;
	private String databaseName;
	private String userName;
	private String userPassword;
	
	private String connectionURL=null;
	private ResultSet rusultSet= null;
	private Statement statement =null;
	private Connection connection=null;
	
	private void connectToOracleDB() {
		Hostname ="localcost";
		databasePort ="1521";
		databaseName="xe";
		userName="hr";
		userPassword="hr";
		
		
		try {
			connectionURL ="jdbc:oracle:thin:hr@//"+Hostname + ":" +databasePort +"/" +databaseName;
					Class.forName("oracole.jdbc.OracleDriver");
					connection =DriverManager.getConnection(connectionURL,userName, userPassword);
					statement= connection.createStatement();
					
			
		}catch(Exception e) {
			logger.error("Error: ",e);
		}
		
	}	
	
	

}
