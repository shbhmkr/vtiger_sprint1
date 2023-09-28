package com.qsp.vtiger.genericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtility {
	
	public String fetchDataFromDataBase(Connection connection, String sqlQuerry, int index) throws SQLException {
		
		ResultSet result = connection.createStatement().executeQuery(sqlQuerry);
		
		while(result.next()) {
			return result.getString(index);
		}
		return "";
	}

    public void updateDataInDataBase(Connection connection, String sqlQuerry) throws SQLException {
		
		int result = connection.createStatement().executeUpdate(sqlQuerry);
		if(result==1) {
			System.out.println("Data base has been updated");
		}
		else
			System.out.println("Data base has not been updated ");
	}
}
