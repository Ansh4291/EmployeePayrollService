package com.bridgelabz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 Create an Employee
 Payroll Service to Read
 and Write Employee
 Payroll to a Console - Create Employee Payroll Class of id, name and Salary
 */

public class EmployeePayrollService {
    public List<EmployeePayrollData>employeePayrollList;
   static Scanner sc = new Scanner(System.in);
    /**Declared Constructor To Initialize Class Object*/
    public EmployeePayrollService (List<EmployeePayrollData> employeePayrollData){
        this.employeePayrollList=employeePayrollData;
    }
    /**---Method To Read Employee Payroll Data---*/

    public void readEmployeePayRoll(EnumIOService enumIOService){

        if (enumIOService.equals(EnumIOService.FILE_IO))
        {
            EmployeePayrollService.readFromFile();
        }else {
            int id;
            String name;
            int Salary;
            System.out.println("Enter the Employee id :- " );
            id = sc.nextInt();
            System.out.println("Enter the Employee Name :- ");
            name = sc.next();
            System.out.println("Enter the Employee Salary :- ");
            Salary = sc.nextInt();
            employeePayrollList.add(new EmployeePayrollData(id,name,Salary));
            AddDataToFile(employeePayrollList);
        }
    }

    private static void readFromFile() {
        try {
            File file = new File("//home//asus//IdeaProjects//EmployeePayrollService//src//Test.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String data;
            int  count = 0;
            while ((data=bufferedReader.readLine()) != null)
            {
                count++;
                System.out.println(data);
            }
            System.out.println(count);
        }catch (IOException e){
            throw new RuntimeException (e);
        }

    }

    /**     Create the Write Employee payroll Data Method and passing the message and print employeePayrolllist
     */

    public void writeEmployeepayrollData(EnumIOService enumIOService){
        if(enumIOService.equals(EnumIOService.FILE_IO)){
            EmployeePayrollService.readFromFile();
        }else {
            System.out.println("\nWriting Employee Payroll Service in Console" + employeePayrollList );
        }

    }
    /**---Method to Add Data to the File---*/
    public void AddDataToFile(List<EmployeePayrollData> employeeData){
        File file = new File("//home//asus//IdeaProjects//EmployeePayrollService//src//Test.txt");
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true))){
            bufferedWriter.write(String.valueOf(employeeData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Service project :-) ");
        //Created ArrayList To Store Employee Data
        ArrayList<EmployeePayrollData> employeepayrollList = new ArrayList<>();
        // taking the object of main class and calling the read and write method into main method
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeepayrollList);
        //Function Calling
        employeePayrollService.readEmployeePayRoll(EnumIOService.CONSOLE_IO);
        employeePayrollService.writeEmployeepayrollData(EnumIOService.FILE_IO);

    }
}