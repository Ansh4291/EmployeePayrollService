package com.bridgelabz;

import java.io.File;
import java.io.IOException;

public class EmployeePayrollFileIOService {
    /**---Method To Create New File to particular Directory---
     */
    public boolean createFile(){
        File file = new File("//home//asus//IdeaProjects//EmployeePayrollService//src//Test.txt");
        try {
            if (file.createNewFile()){
                System.out.println("File is created " + file.getName());
                return true;
            }else {
                System.out.println("File is not created !! File is already exists");
                return false;
            }
        }catch (IOException e){
            System.out.println("Exception ");
            return false;
        }
    }
    /**---Method to Check file is Already exist or Not---
     */
    public boolean checkFileExistOrNot(){
        try {
            File file = new File("//home//asus//IdeaProjects//EmployeePayrollService//src//Test.txt");
            if (file.exists()){
                System.out.println("File is Already Exists");
                return true;
            }else {
                file.createNewFile();
                System.out.println(" New File is created");
                return false;
            }
        }catch (IOException e){
            System.out.println("Exception");
            return false;
        }
    }

    /**---Method to Delete the file from particular Directory---
     */
    public boolean DeleteFileOperation(){
        File file = new File("//home//asus//IdeaProjects//EmployeePayrollService//src//Test.txt");
        if (file.delete()){
            System.out.println(file.getName()+"File is deleted");
            return true;
        }else {
            System.out.println(file.getName()+"File is not exists to Delete");
            return false;
        }
    }
    /**---Method to List All the Files and Directories---
     */
    public boolean ListOfAllFilesAndDirectory(){
        File file = new File("//home//asus//IdeaProjects//EmployeePayrollService//src");
        File [] files;
        String [] FilesNames;
        files = file.listFiles();
        FilesNames = file.list();
        if(FilesNames.length==0){
            System.out.println("Directory Is Empty !!!");
            return false;
        }else {
            //Display Files With Directory
            System.out.println("\nFile Names With Directories\n");
            for (File s1 : files) {
                System.out.println(s1);
            }
            //Display Folders Name and Files With Extension
            System.out.println("\nFile Name With extension and Folder Names Available In Directory\n");
            for (String filename : FilesNames) {
                System.out.println(filename);
            }
            return true;
        }
    }
}
