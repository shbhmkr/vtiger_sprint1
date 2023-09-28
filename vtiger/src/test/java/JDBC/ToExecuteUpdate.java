package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class ToExecuteUpdate {

	public static void main(String[] args) throws SQLException {

		        //1. Creating an object of Driver of MySql vendor
				Driver dataBaseDriver=new Driver();             //this is the driver of mysql
				//2. Registering driver to JDBC API
				DriverManager.registerDriver(dataBaseDriver);   //registering mysql driver with java program (here java comes to know that he is working with mysql vendor)
				//3. Establishing connection with the database
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root" );   //it takes mySql database url(search in google add projectName) and username and password
				//4. Creating Statement to pass the select querry
				int result = connection.createStatement().executeUpdate("insert into lead values('shubham','kumar','Qspider')");  // statement is a interface of jdbc which has a method execute querry

				if(result==1) {
					System.out.println("data base has been updated");
				}
				else
					System.out.println("data base has not been updated");
				
				connection.close();
	}
	

}
