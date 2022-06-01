package com.bridgelabz;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class EmployeeServiceTestDB {
    private EmployeePayrollService employeePayrollService;

    @Test

    public void givenEmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
        com.bridgelabz_JDBC.EmployeePayrollData[] employeePayrollData = {
                new com.bridgelabz_JDBC.EmployeePayrollData(101, "Anshul Rathore", 30000, "11 - 02-2022"),
                new com.bridgelabz_JDBC.EmployeePayrollData(102, "Deepesh", 20000, "01 -01 -2020"),
                new com.bridgelabz_JDBC.EmployeePayrollData(103, "Animesh", 25000, "20 -01 -2021")};
        EmployeePayrollFileIOService.writeData(List.of(employeePayrollData));
        employeePayrollService.printData(EmployeePayrollService.EnumIOService.FILE_IO);
        employeePayrollService.countEntries(EmployeePayrollService.EnumIOService.FILE_IO);
        System.out.println("No. of entries: " + employeePayrollData.length);
    }

}



