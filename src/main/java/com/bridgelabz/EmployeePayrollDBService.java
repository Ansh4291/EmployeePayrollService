package com.bridgelabz_JDBC;

//import java.sql.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmployeePayrollDBService {
//    private Connection getConnection() throws SQLException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
//        String userName = "root";
//        String password = "welcome123";
//        Connection connection;
//        System.out.println("Connecting to database : " + jdbcURL);
//        connection = DriverManager.getConnection(jdbcURL,userName,password);
//        System.out.println("Connection is sucessfull!!"+connection);
//        return connection;
//    }
//    public List<EmployeePayrollData> readData(){
//        String sql = "SELECT * FROM employee_payroll; ";
//        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
//        try {
//            Connection connection = this.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery(sql);
//            while (result.next()){
//                int id = result.getInt("id");
//                String name = result.getString("name");
//                int salary = result.getInt("salary");
//                LocalDate startDate = result.getDate("startDate").toLocalDate();
//                employeePayrollList.add(new EmployeePayrollData(id , name , salary , startDate));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employeePayrollList;
//    }
//
//
//}
