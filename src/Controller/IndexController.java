/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandlerDerby;
import Model.Alarts;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 *
 * @author USER
 */
public class IndexController implements Initializable {
   
    //declare variables
    private Index index;
    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfPass;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private Hyperlink linkForgotPass;
    @FXML
    private Hyperlink linkCreateUser;
    
    private DatabaseHandlerDerby dbh;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initialize db
        dbh = new DatabaseHandlerDerby();
        
    }
    
    public void setIndex(Index index)
    {
        this.index = index;
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        //collect login details
        String user = tfusername.getText();
        String pass = tfPass.getText();
        
        //check for empty fields
        if(!user.isEmpty() && !pass.isEmpty())
        {
            String query = "SELECT * from users where username = '"+ user +"' ";
            
            //execute query
            if(dbh.countRows(dbh.execAction(query)) == 1)
            {
                String query1 = "SELECT * from users where username = '"+ user +"' and password = '"+ pass+"' ";
                
                    if(dbh.countRows(dbh.execAction(query1)) == 1){
                        index.dashboard();  //move to dashboard
                        index.primaryStage.close();  //close login window
                    }
            }
            else
                 Alarts.Alart("Login Error Details", "Invalid Username");
        }
        else
            Alarts.Alart("Login Error Details", "Empty fields detected");
    }

    @FXML
    private void newPass(ActionEvent event) {
        
    }

    @FXML
    private void createUser(ActionEvent event) throws IOException {
        index.signUpWIndow();
    }
    
    
}
