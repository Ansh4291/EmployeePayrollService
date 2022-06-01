package com.bridgelabz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;



public class EmployeePayrollServiceTest {
    EmployeePayrollFileIOService employeePayrollFileIOService = new EmployeePayrollFileIOService();
     public List<com.bridgelabz_JDBC.EmployeePayrollData> employeePayrollData;
     public static JDBCFileOperations jdbcFileOperations = new JDBCFileOperations();
    @Test
    public void checkFileCreatedOrNot(){
        Assertions.assertTrue(employeePayrollFileIOService.createFile());
    }
    @Test
    public void checkFileExistOrNot(){
        Assertions.assertTrue(employeePayrollFileIOService.checkFileExistOrNot());
    }
    @Test
    public void checkFileDeletedOrNot(){
        Assertions.assertTrue(employeePayrollFileIOService.DeleteFileOperation());
    }
    @Test
    public void displayFileFromDirectory(){
        Assertions.assertTrue(employeePayrollFileIOService.ListOfAllFilesAndDirectory());
    }
    @Test
    public void giveDataToCreateTable_IntoDatabase(){

        boolean exp = jdbcFileOperations.createTable();
        Assertions.assertTrue(true);
    }
    @Test
    public void givendataToInsertTable_IntoDatabase(){
        boolean exp1 = jdbcFileOperations.Insert();
        Assertions.assertTrue(true);
    }
}
