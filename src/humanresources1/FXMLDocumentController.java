/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanresources1;

import java.io.FileNotFoundException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author AlyBarakat
 */
public class FXMLDocumentController implements Initializable {
    
    //Employee emp = new Employee();
    //Employee emp1 = new Employee();
    
    
    @FXML
    private TextField username_text;
    @FXML
    private TextField password_text;
   
    
    @FXML
    private void login(ActionEvent event)throws IOException, Exception 
    {
        LoginCredentials user = new LoginCredentials(username_text.getText(),password_text.getText());
        if(user.login())
        {
            //System.out.println(user.getID());
            //move to scene(homeScene)
            //FXMLLoader loader = new FXMLLoader();
            //loader.setLocation(getClass().getResource("S1_Home.fxml"));
            //Parent HomeParent = loader.load();
            FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("S1_Home.fxml"));     
            Parent homeParent = (Parent)FXMLLoader.load();
            S1_HomeController controller = FXMLLoader.<S1_HomeController>getController();
            
            //Creating new employee with the given ID
            Employee emp = new Employee(user.getID());
            controller.loginInitialize(emp);
            
            Scene  homeScene = new Scene(homeParent);
            Stage homeWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
            homeWindow.setScene(homeScene);
            homeWindow.show();    
        }
        else
        {
            System.out.println("username or password is incorrect ");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setHeaderText("wrong username or password entered");
            alert.setContentText("Press OK to re-enter your data");
            alert.showAndWait();
        }
       
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            
    }    
    
}
