package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC configuration class for connection to MySQL Database  
 * 
 * @author Valentin Latanska
 *
 */
public class JDBCConfig {
	
	private static Connection con;
	
	/**
	 * Connection opening 
	 * 
	 * @return
	 */
	public static Connection openConnection() {
		try {
            Class.forName("com.mysql.jdbc.Driver");            
            con = DriverManager.getConnection(
            		"jdbc:mysql://localhost:8889/Projet_TWIC", "root", "root");
            System.out.println("Project_TWIC database is connected");  
        }catch(Exception e) {
            e.printStackTrace();
        }
		return con;
	}
	
	/**
	 * Connection closing 
	 * @return 
	 * 
	 * @throws SQLException 
	 */
	public static Connection closeConnection() throws SQLException {
		con.close();
		return con;
	}

}
