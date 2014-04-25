package com.team12.myworld.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBaseConnection {
	
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://cmpe272.cn1huhw7fmgm.us-west-1.rds.amazonaws.com:3306/CMPE18038";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "rootcmpe";

	public static Connection getDataBaseConnection(){
		
		Connection connect = null;
		if(connect == null){
			try {
				Class.forName(DRIVER_NAME);// loading MySQL driver
				connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				//connect = DriverManager.getConnection("jdbc:mysql://cmpe272.cn1huhw7fmgm.us-west-1.rds.amazonaws.com:3306/CMPE18038?user=root&password=rootcmpe");
				//Set up connection with DB, username, password
			} catch (Exception e) {
				System.out.println("Exception in Login::"+e.getMessage());
				e.printStackTrace();
			}
		}
		return connect;
	}

	
public static void closeConnection(Connection con){
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void closeStatement(PreparedStatement ps){
		
		
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		//For testing purpose - create user table
		DataBaseConnection db = new DataBaseConnection();
		Statement stmt;
		String qType = "Select * from USER";
		Connection conn = db.getDataBaseConnection();
		try {
			stmt = conn.createStatement();
			// Statements allow to issue SQL queries to the database
			ResultSet rs = stmt.executeQuery(qType);
			while(rs.next()){
				System.out.println("username>>>>>>>>>>>>>>>"+rs.getString("USERNAME"));
				System.out.println("username>>>>>>>>>>>>>>>"+rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			System.out.println("Error in execute query::"+e.getMessage());
			e.printStackTrace();
		}
	}

}
