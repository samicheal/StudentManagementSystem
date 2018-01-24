/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.DatabaseHandlerDerby;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author USER
 */
public class Student {
    
    //instance variables
    private SimpleIntegerProperty studentId;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty mobile;
    private SimpleStringProperty email;
    private SimpleStringProperty location;
    private SimpleStringProperty gender;
    private SimpleStringProperty registerDate;
    private SimpleStringProperty level;
    private SimpleStringProperty department;
    private SimpleStringProperty courseName;
    private SimpleDoubleProperty amount;
    private SimpleDoubleProperty balance;
    private SimpleDoubleProperty fee;
    private DatabaseHandlerDerby dbh;
            
    //constructor 
    public Student(int studentId, String firstName, String lastName, String mobile, String email, String location, String gender, String registerDate, String level, String department, String courseName, double amount, double balance, double fee) {
        this(firstName, lastName,mobile, email, location, gender, level, registerDate, department, courseName, amount, balance, fee);
        this.studentId = new SimpleIntegerProperty(studentId);
    }
    
   //constructor
    public Student(String firstName, String lastName, String mobile, String email, String location, String gender, String registerDate,  String level, String department, String courseName, double amount, double balance, double fee) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.mobile = new SimpleStringProperty(mobile);
        this.email = new SimpleStringProperty(email);
        this.location = new SimpleStringProperty(location);
        this.gender = new SimpleStringProperty(gender);
        this.level = new SimpleStringProperty(level);
        this.department = new SimpleStringProperty(department);
        this.courseName = new SimpleStringProperty(courseName);
        this.amount = new SimpleDoubleProperty(amount);
        this.balance = new SimpleDoubleProperty(balance);
        this.fee = new SimpleDoubleProperty(fee);
        this.registerDate = new SimpleStringProperty(registerDate);
    }
    
   //accessor method 
     public SimpleIntegerProperty getStudentId() {
        return studentId;
    }
    
    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getMobile() {
        return mobile.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getLocation() {
        return location.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getRegisterDate() {
        return registerDate.get();
    }

    public String getLevel() {
        return level.get();
    }

    public String getDepartment() {
        return department.get();
    }

    public String getCourseName() {
        return courseName.get();
    }

    public Double getAmount() {
        return amount.get();
    }

    public Double getBalance() {
        return balance.get();
    }

    public Double getFee() {
        return fee.get();
    }

    public boolean registerStudent()
    {
        dbh = new DatabaseHandlerDerby();
        String query = "INSERT into STUDENT(first_name, last_name, mobile, email, location, gender, register_date, level, department, course_name, amount, balance, fee)"
                       + " VALUES('"+firstName+"', '"+lastName+"', '"+mobile+"' , '"+email+"' , '"+location+"' , '"+gender+"' , '"+registerDate+"', '"+level+"' , '"+department+"' , '"+courseName+"' , "+amount+" , "+balance+" , "+fee+") ";
        return dbh.execUpdate(query);
    }
    
}                                                                                                                                                                                                                                                                                                           
