/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Alarts;
import Model.Students;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author USER
 */
public class SignUpController implements Initializable {
    
    //declare variables
    private Index index;
    @FXML
    private JFXTextField tfUsername;
    @FXML
    private JFXPasswordField tfPass;
    @FXML
    private JFXPasswordField tfConfirmPass;
    @FXML
    private JFXComboBox<?> comboSecurity;
    @FXML
    private JFXTextField tfAnswer;
    @FXML
    private Button btnCreateUser;
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
           //initialize combo box
           ObservableList list = FXCollections.observableArrayList();
           list.add("What is your mothers maiden name");
           list.add("What is your best food");
           list.add("How many wives does father have");
           comboSecurity.setItems(list);
    }
    
    public void setIndex(Index index)
    {
        this.index = index;
    }

    @FXML
    private void register(ActionEvent event) {
        //collect user details
        String user = tfUsername.getText();
        String pass  = tfPass.getText();
        String cPass = tfConfirmPass.getText();
        String question = comboSecurity.getSelectionModel().getSelectedItem().toString();
        String answer = tfAnswer.getText();
        
        //check if details are empty
        if(!user.isEmpty() && !pass.isEmpty() && !cPass.isEmpty() && !question.isEmpty() && !answer.isEmpty())
            if(Students.validateUsernanme(user))
            {
                if(Students.validatePassword(pass, cPass))
                {
                    //save record to db
                    //create student object
                     Students stud = new Students(user , cPass , question, answer);
                    
                     if(stud.registerStudent())
                     {
                         Alarts.Alart("Success", "Student " + user + " successfully created");
                         index.secondaryStage.close();
                     }
                     else
                         Alarts.Alart("Failure", "Could not create student record. Contact administrator");
                }
                else
                    Alarts.Alart("Passord Error Message", "Ensure password fields match");
            }
            else
                    Alarts.Alart("Username Error Message", "Use alphabets only for username");
              
    }

    
}
