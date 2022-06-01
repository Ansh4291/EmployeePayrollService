package com.bridgelabz;

import com.bridgelabz.EmployeePayrollFileIOService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

//import static com.bridgelabz_JDBC.EnumIOService.DB_IO;

public class EmployeePayrollServiceTest {
    EmployeePayrollFileIOService employeePayrollFileIOService = new EmployeePayrollFileIOService();
     public List<com.bridgelabz_JDBC.EmployeePayrollData> employeePayrollData;

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

//


}
