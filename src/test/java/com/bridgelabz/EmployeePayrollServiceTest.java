package com.bridgelabz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;



public class EmployeePayrollServiceTest {
    EmployeePayrollFileIOService employeePayrollFileIOService = new EmployeePayrollFileIOService();
     public List<EmployeePayrollData> employeePayrollData;
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
    public void givenDataToInsertTable_IntoDatabase(){
        boolean exp1 = jdbcFileOperations.Insert();
        Assertions.assertTrue(true);
    }
    @Test
    public void givenDataToRetriveDataFromTable_Database(){
        List<EmployeePayrollData> empData = jdbcFileOperations.SelectData();
        for (EmployeePayrollData empData1 : empData){
            System.out.println("Data will be retrived :- " + empData1);
        }
        Assertions.assertEquals(1, empData.size());
    }
    @Test
    public void givenData_Particulardata_RangeFromThe_Database(){
        boolean exp2 = jdbcFileOperations.selectDataUsingWhereTo();
        Assertions.assertTrue(true);
    }

}
