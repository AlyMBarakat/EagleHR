/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanresources1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import static java.util.logging.Level.parse;

/**
 *
 * @author AlyBarakat
 */
public class Employee {
    private int emp_ID = 16100000;
    private String empDepartment ; 
    private String empPosition;
    private String empName;
    private String empMail;
    private String empAdress;
    private float Salary = 15000;
    private LocalDate DOB = LocalDate.of(1998, Month.APRIL,24);
    private LocalDate DOS = LocalDate.of(1998, Month.APRIL,24);
    
    private String empUserName;
    private String empPassword;
    
    LoginCredentials loginData = new LoginCredentials();

    public LocalDate getDOS() {
        return DOS;
    }

    public void setDOS(LocalDate DOS) {
        this.DOS = DOS;
    }

    public int getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMail() {
        return empMail;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }

    public String getEmpAdress() {
        return empAdress;
    }

    public void setEmpAdress(String empAdress) {
        this.empAdress = empAdress;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    
    public Employee()
    {
        
    }
    
    public Employee(int emp_ID)
    {
        this.emp_ID = emp_ID;
    }
    
    public Employee(int emp_ID, String empDepartment, String empPosition, String empName, String empMail, String empAdress, float Salary, LocalDate DOB, LocalDate DOS ) {
        this.emp_ID = emp_ID;
        this.empDepartment = empDepartment;
        this.empPosition = empPosition;
        this.empName = empName;
        this.empMail = empMail;
        this.empAdress = empAdress;
        this.Salary = Salary;
        this.DOB = DOB;
        this.DOS = DOS;
        
    }
    
    public Employee(int emp_ID, String empDepartment, String empPosition, String empName, String empMail, String empAdress, float Salary, LocalDate DOB, LocalDate DOS, String UN, String PW) {
        this.emp_ID = emp_ID;
        this.empDepartment = empDepartment;
        this.empPosition = empPosition;
        this.empName = empName;
        this.empMail = empMail;
        this.empAdress = empAdress;
        this.Salary = Salary;
        this.DOB = DOB;
        this.DOS = DOS;
        this.empUserName = UN;
        this.empPassword = PW;
        System.out.println(empUserName + empPassword);
    }
    
    public void addEmployee() throws Exception
    {
        File file = new File("EmpData.txt");
        BufferedWriter writer = null; 
        writer = new BufferedWriter(new FileWriter( file, true));
        
        writer.write(loginData.getUserName() + "\t" + loginData.getPassWord());
        writer.newLine();
        writer.write(emp_ID + "\t" + empName + "\t" + empDepartment +"\t"+ empPosition+
                    "\t" +empMail+"\t"+empAdress+"\t"+Salary+ "\t"+ DOB + "\t" + DOS);
        writer.newLine();
        
        writer.close();
    }
      
    String empList = "";
    public String viewEmployees() throws Exception
    {
        File file = new File("EmpData.txt");
        try{
        Scanner scanner = new Scanner(file);
        empList = scanner.nextLine() + "\n";
        scanner.nextLine();
        while(scanner.hasNextLine())
        {
            empList +=  ""+scanner.nextLine()+"\n";
            if(scanner.hasNextLine())
               scanner.nextLine();
        }
            
            
        }catch(FileNotFoundException e)
        {
            System.out.println("ERROR File not found");

        }
        return empList;
    }
    
    public void viewBasicEmployee(int ID) throws Exception
    {
        File file = new File("EmpData.txt");
        try{
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        String search_ID;
        while(scanner.hasNextLine() && scanner.hasNext())
        {
            scanner.nextLine();
            search_ID = scanner.next();
            //System.out.println("shitt");
            //System.out.println(search_ID);
            //System.out.println(Integer.toString(emp_ID));
            
            if(search_ID.equals(Integer.toString(ID)))
            {
 
                empName = scanner.next();
                scanner.next();
                empDepartment = scanner.next();
                empPosition = scanner.next();
            }
            scanner.nextLine();
        } 
        } catch(FileNotFoundException e)
        {
           System.out.println("ERROR File not found");
        } 
    }

    
    @Override
    public String toString() {
        return "Employee{" + "emp_ID=" + emp_ID + ", empDepartment=" + empDepartment + ", empPosition=" + empPosition + ", empName=" + empName + ", empMail=" + empMail + ", empAdress=" + empAdress + ", Salary=" + Salary + ", DOB=" + DOB + '}';
    } 
}