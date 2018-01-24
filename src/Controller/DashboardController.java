/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author USER
 */
public class DashboardController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private JFXToolbar toolBar;
    @FXML
    private HBox toolBarRight;
    @FXML
    private Label lblMenu;
    @FXML
    private AnchorPane sideAnchor;
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnView;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private AnchorPane holderPane;
    private AnchorPane home, profile, register;
    private Index index;
    
    public void setIndex(Index index)
    {
        this.index = index;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createdPages();
        displayContentNode( home);
    }

    @FXML
    private void openHomePage(ActionEvent event) {
        displayContentNode(home);
    }

    @FXML
    private void openRegisterStudentPage(ActionEvent event) {
        displayContentNode(register);
    }

    @FXML
    private void openStudentListPage(ActionEvent event) {
        displayContentNode(profile);
    }

    @FXML
    private void logout(ActionEvent event) {
        displayContentNode(profile);
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
    //Cache fxml file
    public void createdPages(){
        try {
            home = FXMLLoader.load(getClass().getResource("/View/overview/overviews.fxml"));
            register = FXMLLoader.load(getClass().getResource("/View/register/Registers.fxml"));
            profile = FXMLLoader.load(getClass().getResource("/View/profile/Profile.fxml"));
            
            //set up default no
            displayContentNode(home);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayContentNode(Node node){
        //clear content of holder pane
        holderPane.getChildren().clear();
        
        //add node to holder pANE
        holderPane.getChildren().add((Node) node);
        
        //add transition effect
        FadeTransition ft= new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
 
}
