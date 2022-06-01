package com.bridgelabz_JDBC;

import java.time.LocalDate;

public class EmployeePayrollData {
    public int id;
   public String name;
    public int salary;
    public String startdate;


    public EmployeePayrollData(int id, String name, int salary, String startdate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startdate=startdate;
    }

    @Override
    public String toString() {
        return "Employee PayRoll Data [id="+id + ", name = " +name+ ", Salary = " + salary + ",Start_date "+startdate+" ]";
    }
}