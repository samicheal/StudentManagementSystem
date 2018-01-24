/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author USER
 */
public class ProfileController implements Initializable {

    @FXML
    private TableView<Student> _tableStudents;
    @FXML
    private TableColumn<Student, Integer> _id;
    @FXML
    private TableColumn<Student, String> _course;
    @FXML
    private TableColumn<Student, String> _lname;
    @FXML
    private TableColumn<Student, String> _fname;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblPhone;
    @FXML
    private Label lblLocation;
    @FXML
    private Label lblDepartment;
    @FXML
    private Label lblLevel;
    @FXML
    private Label lblCourse;
    @FXML
    private AnchorPane fabPane;
    @FXML
    private Label fabEdit;
    
    private ObservableList<Student> studentList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       studentList = FXCollections.observableArrayList();  //instantiate personList object
       setTableData(); //set up table data
       initCol();  //initialize columns
       _tableStudents.getItems().setAll(studentList);  //populate table with student list
       
       
    }
    
    private void initCol() {
        _id.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        _lname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        _fname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        _course.setCellValueFactory(new PropertyValueFactory<>("courseName"));
    }
    
    
     public void setTableData()
    {
        studentList.add(new Student(1 , "Majemu" , "Ifeloju" , "08036516503" , "majems@4life.com", "Lagos" , "female" , "2018-1-12", "Degree" , "Science" , "Computer Science", 145000 , 0, 145000));
        studentList.add(new Student(2 , "Tosin" , "Brown" , "09099291758" , "tbrown@yahoo.com", "Lagos" , "male" , "2018-1-12", "Degree" , "Science" , "Statistics", 145000 , 55000, 90000));
        studentList.add(new Student(3 , "Beatrinc" , "falzy" , "08064657518" , "phonyleaves.com", "Lagos" , "male" , "2018-1-12", "Degree" , "Science" , "Mathematics", 145000 , 0, 145000));
    }
    
}
 