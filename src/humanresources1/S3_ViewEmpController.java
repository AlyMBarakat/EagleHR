/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanresources1;

import static humanresources1.S1_HomeController.loggedEmployee;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AlyBarakat
 */
public class S3_ViewEmpController implements Initializable {
    
    Employee emp = new Employee();
    @FXML
    private Label labelList;
    @FXML
    private TextArea textArea; 
    
    
    
    
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
    private void B2(ActionEvent event)throws IOException {
        //move to scene(homeScene)
        Parent AddEmpParent = FXMLLoader.load(getClass().getResource("S2_AddEmp.fxml"));
        Scene  AddEmpScene = new Scene(AddEmpParent);
        
        Stage AddEmpWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        AddEmpWindow.setScene(AddEmpScene);
        AddEmpWindow.show();
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
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            textArea.setText(emp.viewEmployees());
        } catch (Exception ex) {
            Logger.getLogger(S3_ViewEmpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
