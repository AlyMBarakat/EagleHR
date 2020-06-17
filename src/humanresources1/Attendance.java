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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author AlyBarakat
 */
public class Attendance {
    //private int empID;
    private LocalDate entryDate;
    private LocalTime entryTime;
    private LocalTime leavingTime;
    private LocalTime breakTime;
    

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalTime getLeavingTime() {
        return leavingTime;
    }

    public void setLeavingTime(LocalTime leavingTime) {
        this.leavingTime = leavingTime;
    }

    public LocalTime getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(LocalTime breakTime) {
        this.breakTime = breakTime;
    }
    
    public Attendance()
    {
        
    }
    
    public Attendance(LocalDate entryDate, LocalTime entryTime, LocalTime leavingTime, LocalTime breakTime) {
        this.entryDate = entryDate;
        this.entryTime = entryTime;
        this.leavingTime = leavingTime;
        this.breakTime = breakTime;
    }
    
    //Records day starting
    public static String currentTime() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
        return formattedDate;   
    }
    
    
    public void dayStart(int empID) throws IOException
    {
        //entryDate.adjustInto(entryDate);
        //entryTime.adjus
        File file = new File("entryData.txt");
        BufferedWriter writer = null; 
        writer = new BufferedWriter(new FileWriter( file, true));

        //writer.write(empID + "\n" + entryDate + "\t" + currentTime() + "\n" );
        
        //generates the format of the date and time now
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));  
        writer.write(empID + "\n" + dtf.format(now)+ "\n");
        
        writer.close();
    }
    
    //Records day ending
    public void dayEnd(int empID) throws IOException
    {
        File file = new File("LeaveSheet.txt");
        BufferedWriter writer = null; 
        writer = new BufferedWriter(new FileWriter( file, true));
        //writer.write(empID + "\n" + entryDate + "\t" + leavingTime + "\n" );
       
        //generates the format of the date and time now
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));  
        writer.write(empID + "\n" + dtf.format(now) + "\n");
        writer.close();
        /*
        File file = new File("LeaveData.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        String search_ID;
        int i = 1;
        while(scanner.hasNextLine() && scanner.hasNext())
        {
            
            search_ID = scanner.next();
            
            if(search_ID.equals(Integer.toString(empID)))
            {
                BufferedWriter writer = null; 
                writer = new BufferedWriter(new FileWriter( file, true));
                writer.newLine();
                
            }
            i++;
            
        }
        */    
    }
    
    String empList = "";
    public String listAttendance() throws Exception
    {
        File file = new File("entryData.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine())
        {
            empList +=  ""+scanner.nextLine()+"\n";
        }
        return empList;
    }
    
    public String listEmployeeAttendence(int empID) throws FileNotFoundException
    {
        File entryFile = new File("entryData.txt");
        //File leaveFile = new File("leaveData.txt");
        
        Scanner entryScanner = new Scanner(entryFile);
        //Scanner leaveScanner = new Scanner(leaveFile);
                   
        
        String search_ID;
        String data = null;
        boolean firstEntry = true;
        while(entryScanner.hasNextLine() && entryScanner.hasNext())
        {
            search_ID = entryScanner.next();
            if(search_ID.equals(Integer.toString(empID)))
            {
                entryScanner.nextLine();
                if(firstEntry)
                {
                    data = entryScanner.nextLine() + "\n";
                    firstEntry = false;
                }
                else
                {
                    data += entryScanner.nextLine() + "\n";
                }       
            }
            else
            {
                entryScanner.nextLine();
                entryScanner.nextLine();
            }
        }
        
        return data;    
    }
    
    
    
}
