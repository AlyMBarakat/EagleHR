/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanresources1;

import java.io.File;
import java.io.FileNotFoundException;
import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author AlyBarakat
 */
public class LoginCredentials {
    
    private String userName;
    private String u;
    private String passWord;
    private String p ;
    private int ID = 1;

    
    public LoginCredentials() {
        
    }
    public LoginCredentials(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
    
    
    //checks for user and if available returns 
    public boolean login() throws FileNotFoundException
    {
        File file = new File("EmpData.txt");
        Scanner scanner = new Scanner(file);
        //int i = 0;
        scanner.nextLine();
        while(scanner.hasNextLine() && scanner.hasNext())
        {
            u = scanner.next();
            p = scanner.next();
            //System.out.println(i+"\n");
            //i++;
            ID = scanner.nextInt();
            scanner.nextLine();
            if(userName.equals(u) && passWord.equals(p))
            {
                return true;
                
            }    
        }   
        return false;  
    }
    
    
    
}
