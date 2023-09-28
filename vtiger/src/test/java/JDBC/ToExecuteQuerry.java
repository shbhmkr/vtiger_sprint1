package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToExecuteQuerry {

	public static void main(String[] args) throws SQLException {
		
        //1. Creating an object of Driver of MySql vendor
		Driver dataBaseDriver=new Driver();             //this is the driver of mysql
		//2. Registering driver to JDBC API
		DriverManager.registerDriver(dataBaseDriver);   //registering mysql driver with java program (here java comes to know that he is working with mysql vendor)
		//3. Establishing connection with the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root" );   //it takes mySql database url(search in google add projectName) and username and password
		//4. Creating Statement to pass the select querry
		Statement statement = connection.createStatement();  // statement is a interface of jdbc which has a method execute querry
		
		ResultSet result = statement.executeQuery("select * from lead;");  //ResultSet control is always at start of the table
		//5. Fetching the data From the data base
		while(result.next()) {                                 // first check whether any data is there or not
			System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3));
		}
		
	}

}
