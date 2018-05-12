package com.HttpPost.httppost;

import java.sql.Connection;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService implements LoginInterface{
	
	public LoginService() {
		
	}
	
	public static Connection conn;
	public static PreparedStatement stmt;
	public ResultSet rs = null;
	private boolean rv = false;
	public boolean isUsreLogin(List<Object> params) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";		
			Connection conn = DriverManager.getConnection(url,"mc","meichao");
			String sql = "select * from httppost where name=? and passwd=?";			
			stmt = (PreparedStatement ) conn.prepareStatement(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
		try {
			stmt.setString(1, params.get(0).toString());
			stmt.setString(2, params.get(1).toString());
		
			rs = stmt.executeQuery();		
			rv = rs.last();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rv;
	}
}
