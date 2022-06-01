package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("***esult set of a database query*********Table is now created for given query***************");

            return true;

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
    public static boolean Insert(){
        try (Connection connection =DriverManager.getConnection(jdbcURL , userName, password);
             Statement statement = connection.createStatement()
        ) {
            String sqlQuery = "INSERT INTO employee_payroll_Service VALUES (121 , 'Lucky' , '15000' , '01-01-2021')";

            statement.executeUpdate(sqlQuery);
            System.out.println("***************Inserted data is updated now ***********");

            return true;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
    public List<EmployeePayrollData> SelectData(){
        String sqlQuery = "SELECT * FROM employee_payroll_Service";
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        try
            (Connection connection =DriverManager.getConnection(jdbcURL , userName, password);
            Statement statement = connection.createStatement()
        ){
            ResultSet resultSet=statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                String startdate = resultSet.getString("startdate");
                employeePayrollDataList.add(new EmployeePayrollData(id , name , salary , startdate));
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
           return employeePayrollDataList;
    }
}
