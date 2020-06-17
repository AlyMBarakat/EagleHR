/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanresources1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AlyBarakat
 */
public class S1_HomeController implements Initializable {
    //initializing a logged in employee to store logedin user's data and 
    static Employee loggedEmployee;
    
    
    @FXML
    private Label ID_label;
    @FXML
    private Label name_label;
    @FXML
    private Label department_label;
    @FXML
    private Label position_label;
    
    
    

    
    
    
    
       
    
    @FXML
    private void signOut(ActionEvent event) throws IOException
    {
        //move to scene(login)
        Parent loginParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene  loginScene = new Scene(loginParent);
        
        Stage loginWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        loginWindow.setScene(loginScene);
        loginWindow.show();
        Attendance attendance = new Attendance();
        attendance.dayEnd(loggedEmployee.getEmp_ID());
    }
    
    @FXML
    private void B2(ActionEvent event)throws IOException {
        
        //move to scene(homeScene)
        Parent AddEmpParent = FXMLLoader.load(getClass().getResource("S2_AddEmp.fxml"));
        Scene  AddEmpScene = new Scene(AddEmpParent);
        
        Stage AddEmpWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        AddEmpWindow.setScene(AddEmpScene);
        AddEmpWindow.show();    
    }
    
    @FXML
    private void B3(ActionEvent event)throws IOException {
        //move to scene(homeScene)
        Parent ViewEmpParent = FXMLLoader.load(getClass().getResource("S3_ViewEmp.fxml"));
        Scene  ViewEmpScene = new Scene(ViewEmpParent);
        
        Stage ViewEmpWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        ViewEmpWindow.setScene(ViewEmpScene);
        ViewEmpWindow.show();
    }
    
    @FXML
    private void B4(ActionEvent event)throws IOException {
        //move to scene(homeScene)
        Parent ManageEmpParent = FXMLLoader.load(getClass().getResource("S4_ManageEmp.fxml"));
        Scene  ManageEmpScene = new Scene(ManageEmpParent);
        
        Stage ManageEmpWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        ManageEmpWindow.setScene(ManageEmpScene);
        ManageEmpWindow.show();
    }
    
    
    
    //displays user data in the home screen
    public void displayHomeData() throws IOException
    {   
        ID_label.setText(Integer.toString(loggedEmployee.getEmp_ID()));
        name_label.setText(loggedEmployee.getEmpName());
        department_label.setText(loggedEmployee.getEmpDepartment());
        position_label.setText(loggedEmployee.getEmpPosition());
        
    }
    
   
    /**
     * login Initializer
     * This method displays the current user data in the main home screen
     */
    public void loginInitialize(Employee emp) throws Exception{
        this.loggedEmployee = emp;
        loggedEmployee.viewBasicEmployee(emp.getEmp_ID());
        displayHomeData();
        Attendance attendance = new Attendance();
        attendance.dayStart(loggedEmployee.getEmp_ID());
        
        /* uncomment for debugging
        System.out.println(loggedEmployee.getEmp_ID());
        System.out.println(loggedEmployee.getEmpName());
        System.out.println(loggedEmployee.getEmpDepartment());
        System.out.println(loggedEmployee.getEmpPosition());
        */
    }
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //applying delay to let the login initializer take place and sets it's data
        Platform.runLater(() -> {
            try {
                displayHomeData();
            } catch (IOException ex) {
                Logger.getLogger(S1_HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
    }
    
}
