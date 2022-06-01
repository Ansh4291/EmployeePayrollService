package com.bridgelabz;

import org.junit.jupiter.api.Test;


import java.util.List;

public class EmployeeServiceTestDB {
    private EmployeePayrollService employeePayrollService;

    @Test

    public void givenEmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayrollData[] employeePayrollData = {
                new EmployeePayrollData(101, "Anshul ", 30000, "01-01-2020"),
                new EmployeePayrollData(102, "Deepesh", 20000, "02-02-2021"),
                new EmployeePayrollData(103, "Animesh", 25000, "03-03-2022")};
        EmployeePayrollFileIOService.writeData(List.of(employeePayrollData));
        employeePayrollService.printData(EmployeePayrollService.EnumIOService.FILE_IO);
        employeePayrollService.countEntries(EmployeePayrollService.EnumIOService.FILE_IO);
        System.out.println("No. of entries: " + employeePayrollData.length);
    }

}



