package com.socratesdiaz.manejadoreventos.database;

import java.sql.*;

public class DBManager {

	private Connection con;
	private ResultSet result;
	private Statement statement;
	private PreparedStatement preparedStmt;
	
	private boolean successConnection = false;
	private String error;
	
	public DBManager() {
		;
	}
	
	public int connect(String username, String password, String host) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+host, username, password);
			statement = con.createStatement();
			successConnection = true;
			error = "";
			return 0;
		}
		catch (SQLException sql_ex) {
			successConnection = false;
			error += sql_ex.getLocalizedMessage();
			return -1;
		}
		catch (ClassNotFoundException class_ex) {
			successConnection = false;
			error += class_ex.getLocalizedMessage();
			return -1;
		}
		catch (Exception ex) {
			successConnection = false;
			error += ex.getLocalizedMessage();
			return -1;
		}
	}
	
	public void executeUpdate(String update) {
		try {
			statement.executeUpdate(update);
		} catch (SQLException e) {
			error += e.getLocalizedMessage();
		}
	}
	
	public void executeQuery(String query) {
		try {
			statement = con.createStatement();
			result = statement.executeQuery(query);
		}
		catch (SQLException e) {
			error += e.getLocalizedMessage();
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public int disconnect() {
		try {
			if(isConnection()) {
				statement.close();
				con.close();
				successConnection = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error += e.getLocalizedMessage();
			return -1;
		}
		
		return 0;
	}
	
	public ResultSet getResult() {
		
		return result;
	}
	
	public boolean isConnection() {
		return successConnection;
	}
	
	public String getError() {
		return error;
	}
}
