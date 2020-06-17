/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanresources1;

import static humanresources1.S1_HomeController.loggedEmployee;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AlyBarakat
 */
public class S2_AddEmpController implements Initializable {

    @FXML
    private TextField id_text;
    @FXML
    private TextField name_text;
    @FXML
    private TextField userName_text;
    @FXML
    private TextField password_text;
    @FXML
    private TextField department_text;
    @FXML
    private TextField position_text;
    @FXML
    private TextField email_text;
    @FXML
    private TextField adress_text;
    @FXML
    private TextField salary_text;
    @FXML
    private DatePicker dob_date;
    @FXML
    private DatePicker dos_date;
    @FXML
    private DatePicker dateStarting_date;
    @FXML
    private Label success;
    
    
    
    
    
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
    private void B1(ActionEvent event)throws IOException {
        //move to scene(homeScene)
        Parent HomeParent = FXMLLoader.load(getClass().getResource("S1_Home.fxml"));
        Scene  homeScene = new Scene(HomeParent);
        
        Stage homeWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        homeWindow.setScene(homeScene);
        homeWindow.show();
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

    
    //Adding an employee
    @FXML
    private void AddEmployee(ActionEvent event) throws Exception{
        Employee emp;
        emp = new Employee(Integer.parseInt(id_text.getText()), department_text.getText(), position_text.getText(),
                      name_text.getText(), email_text.getText(), adress_text.getText(), 
                      Integer.parseInt(salary_text.getText()), dob_date.getValue(), dateStarting_date.getValue());
        emp.loginData.setUserName(userName_text.getText());
        emp.loginData.setPassWord(password_text.getText());
        emp.addEmployee();
        //success.setText("Employee added successfully");
    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
