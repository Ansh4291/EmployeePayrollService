package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCFileOperations {
 public static String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
    public static String userName = "root";
   public static String password = "welcome123";
//    Connection connection = null;
    public static boolean createTable(){
        try (Connection connection =DriverManager.getConnection(jdbcURL , userName, password);
        Statement statement = connection.createStatement()
        ) {
            String sqlQuery ="CREATE TABLE employee_payroll_Service ("
                    +"id INTEGER NOT NULL PRIMARY KEY , "
                    +"name VARCHAR(80) , "
                    +"salary VARCHAR(15) ,"
                    +"StartDate VARCHAR(50))";
            statement.executeUpdate(sqlQuery);
            System.out.println("************Table is now created for given query***************");

            return true;

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
}
