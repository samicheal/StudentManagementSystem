/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandlerDerby;
import Model.Department;
import Model.Fee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import java.util.Iterator;

/**
 *
 * @author USER
 */
public class RegisterController implements Initializable {

    @FXML
    private JFXTextField txtFname;
    @FXML
    private JFXTextField txtLname;
    @FXML
    private JFXTextField txtMobile;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtLocation;
    @FXML
    private JFXRadioButton rdMale;
    @FXML
    private ToggleGroup gender;
    @FXML
    private JFXRadioButton rdFemale;
    @FXML
    private TextField currentTimeTextfield;
    @FXML
    private JFXRadioButton rdDegree;
    @FXML
    private ToggleGroup level;
    @FXML
    private JFXRadioButton rdDiploma;
    @FXML
    private JFXRadioButton rdCertificate;
    @FXML
    private JFXTextField txtCourseName;
    @FXML
    private JFXComboBox<?> comboDepartmenT;
    @FXML
    private Label price;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXTextField txtBal;
    @FXML
    private ProgressBar progressPersonal;
    @FXML
    private Label lblComplete;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnEdit;
    @FXML
    private JFXButton btnSave;
    
    private double progress1;
    private double progress2;
    private double progress3;
    private double progress4;
    private double progress5;
    private double progress6;
    private double progress7;
    private double progress8;
    private double progress9;
    private double progress10;
    private double sum;
    
    private int deptID;
    private int prices;
    private ArrayList<Department> deptList;
    private ArrayList<Fee> feesList;
    DatabaseHandlerDerby dbh = new DatabaseHandlerDerby ();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currenttime(); //set up current time
        setupCombo(); //populate department combo box
        getFeeData(); //collect fee data
        getDepartmentData(); //collect department data
        registerProgressStatus(); //registration progress
    }
    
     public void setupCombo(){
        try {            
            ObservableList list = FXCollections.observableArrayList();
            String query  = "select * from DEPARTMENT";
            ResultSet rs = dbh.execAction(query);
            while(rs.next()){
                String name = rs.getString("Department_name");
                list.add(name);
            }
            
            comboDepartmenT.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     /**
      * method to display current time
      */
     public void currenttime(){
         LocalDate ld = LocalDate.now();
        String time = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        currentTimeTextfield.setText(time); 
       }
     
     /**
     * method to monitor form update progress
     */
     public void registerProgressStatus(){
        
        DecimalFormat decimalFormat = new DecimalFormat("###.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
         
        // set progress bar status
        double sum_progress = progress10 + progress1 + progress2 + progress3 + progress4 +
                progress5 + progress6+ + progress7+ progress8 + progress9;
        
        //set listener for textfield firstname
        txtFname.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)->{
            
            //check if text field value has changed
            if (!newValue.isEmpty())
                progress1 = 0.1;
            else
                progress1 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
        //set listener for textield lastname
        txtLname.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)->{
            
            //check if text field value has changed
            if (!newValue.isEmpty())
                progress2 = 0.1;
            else
                progress2 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        //set listener for txtMobile
        txtMobile.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)->{
            
            //check if text field value has changed
            if (!newValue.isEmpty())
                progress3 = 0.1;
            else
                progress3 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
       
         //set listener for txtEmail
        txtEmail.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)->{
            
            //check if text field value has changed
            if (!newValue.isEmpty())
                progress4 = 0.1;
            else
                progress4 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
         //set listener for txtLocation
        txtLocation.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)->{
            
            //check if text field value has changed
            if (!newValue.isEmpty())
                progress5 = 0.1;
            else
                progress5 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
         //set listener for rdMale
        rdMale.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue,  Boolean newValue)->{
            
            //check if text field value has changed
            if (!oldValue)
                progress6 = 0.1;
            else
                progress5 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
        
         //set listener for rdFeMale
        rdFemale.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue,  Boolean newValue)->{
            
            //check if text field value has changed
            if (!oldValue)
                progress6 = 0.1;
            else
                progress5 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
          //set listener for rdDegree
        rdDegree.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue,  Boolean newValue)->{
            
            //check if text field value has changed
            if (!oldValue)
                progress7 = 0.1;
            else
                progress7 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
           //set listener for rdDiploma
        rdDiploma.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue,  Boolean newValue)->{
            
            //check if text field value has changed
            if (!oldValue)
                progress7 = 0.1;
            else
                progress7 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
          //set listener for rdCertificate
        rdCertificate.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue,  Boolean newValue)->{
            
            //check if text field value has changed
            if (!oldValue)
                progress7 = 0.1;
            else
                progress7 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
         //set listener for textfield txtCourseName
        txtCourseName.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)->{
            
            //check if text field value has changed
            if (!newValue.isEmpty())
                progress8 = 0.1;
            else
                progress8 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
        
         //set listener for textfield txtAmount
        txtAmount.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)->{
            
            //check if text field value has changed
            if (!newValue.isEmpty())
            {
                double amountPaid = Double.parseDouble(txtAmount.getText());
                double balance = prices - amountPaid;
                txtBal.setText(Double.toString(balance));
                progress9 = 0.1;
            }
            else
                progress9 = 0.0;
            
            sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5+
                    progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            
        });
    
          //set listener for comboDepartmenT
       comboDepartmenT.getSelectionModel().selectedItemProperty().addListener((options, oldValue,newValue)->{         
           
           deptID = 0;  
           prices = 0;
           
        if (!newValue.toString().isEmpty()) {
            String dept = newValue.toString();
            System.out.println(dept);
            Iterator iter = deptList.iterator();
            while(iter.hasNext()){
                Department depart = (Department)iter.next();
                if(dept.equals(depart.getDepartment())){
                    deptID = depart.getDeptId();
                    break;  
                }    
            }
            
            System.out.println("Department id: " + deptID);

            for(Fee fee: feesList){
                if(fee.getFeeId()==deptID){
                    prices = fee.getPrice();
                   
                    price.setText(Integer.toString(prices));
                    double amountPaid = Double.parseDouble(txtAmount.getText());
                    double balance = prices - amountPaid;
                    txtBal.setText(Double.toString(balance));
                    
                    
                    break;
                }
            }
            System.out.println("price: " + price);

                    progress10 = 0.1;
                } 
               else {
                    progress10 = 0.0;
                }
                double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
                progressPersonal.setProgress(sum);
                lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
            });       
}
     
        public void getFeeData(){
            feesList = new ArrayList<>();//initialize feelist

            String query = "select * from FEES";
            ResultSet rset = dbh.execAction(query);
                try {
                    //create objects and save in arraylist
                    while(rset.next()){
                     int feeId = rset.getInt(1);
                     int deptId = rset.getInt(2);
                     int price = rset.getInt(3);
                     int years = rset.getInt(4);
                     Fee fee = new Fee(feeId, deptId,price,years);
                     feesList.add(fee);
                    }  
                    System.out.println("Size: "+feesList.size());
                    System.out.println("Array: "+ feesList.toString());
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         
        public void getDepartmentData(){
                                deptList = new ArrayList<>();//initialize feelist
                                String query = "select * from DEPARTMENT";
                                ResultSet rset = dbh.execAction(query);
                try {
                    //create objects and save in arraylist
                    while(rset.next()){
                     int feeId = rset.getInt(1);
                     String deptid = rset.getString(2);

                     Department dept = new Department(feeId,deptid);
                     deptList.add(dept);
                    }  
                    System.out.println("Size: "+deptList.size());
                    System.out.println("Array: "+ deptList.toString());
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
}
