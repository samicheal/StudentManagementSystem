 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Index extends Application{
    
    //declare globals
    public Stage primaryStage;
    public Stage secondaryStage;
    
      public static void main(String [] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.primaryStage = primaryStage;
        
       //add fxml loader
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/main/index.fxml"));
       AnchorPane pane = loader.load();
       
       //create scene
       Scene scene = new Scene(pane);
       
       //create controller
       IndexController indCtrl = loader.getController();
       indCtrl.setIndex(this);
       
       //set up stage
       primaryStage.setTitle("Student Management System");
       primaryStage.setResizable(false);
       primaryStage.setScene(scene); 
       primaryStage.show();
    }
    
    public void signUpWIndow() throws IOException
    {
       
           //add fxml loader
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/main/signup.fxml"));
       AnchorPane pane = loader.load();
       
       //create stage
       secondaryStage = new Stage();
       secondaryStage.initOwner(primaryStage);
       secondaryStage.initModality(Modality.WINDOW_MODAL);
       
       //register controller
       SignUpController sign = loader.getController();
       sign.setIndex(this);
        
        //set scene
        Scene scene = new Scene(pane);
        
        //set stage
        secondaryStage.setScene(scene);
        secondaryStage.setResizable(false);
        secondaryStage.show();
           
    }
    
    public void dashboard() throws IOException
    {
       //add fxml loader
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/dashboard/Dashboards.fxml"));
       StackPane pane = loader.load();
       
       //create stage
       secondaryStage = new Stage();
       
       //dashboard controller
       DashboardController dbc = loader.getController();
       dbc.setIndex(this);
        
        //set scene
        Scene scene = new Scene(pane);
        
        //set stage
        secondaryStage.setScene(scene);
       // secondaryStage.setResizable(false);
        secondaryStage.show();
    
    }
       
}
