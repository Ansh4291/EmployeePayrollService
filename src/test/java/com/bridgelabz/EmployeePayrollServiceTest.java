package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeePayrollServiceTest {
    EmployeePayrollFileIOService employeePayrollFileIOService = new EmployeePayrollFileIOService();
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
}
