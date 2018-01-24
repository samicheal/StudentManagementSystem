/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.DatabaseHandlerDerby;

/**
 *
 * @author USER
 */
public class Students {
    
    //declare globals
    private String user;
    private String pass;
    private String cPass;
    private String security;
    private String answer;
    private DatabaseHandlerDerby dbh;
    
    //constructor
    public Students(String user, String pass, String sec, String answer)
    {
        this.user = user;
        this.pass = pass;
        this.security = sec;
        this.answer = answer;
        dbh = new DatabaseHandlerDerby();
    }
    
    //no-args constructor for students
    public Students(){
    }
    
    //getters
    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getcPass() {
        return cPass;
    }

    public String getSecurity() {
        return security;
    }

    public String getAnswer() {
        return answer;
    }
    
    //methods
    public static boolean validateUsernanme(String user)
    {
        String regExpUser = "[a-zA-Z]+";
        return user.matches(regExpUser);
    }
    
    public static boolean validatePassword(String pass, String cPass)
    {
        String regExpPass = ".+";
        if(pass.matches(regExpPass))
            if(pass.equals(cPass))
               return true;
        
        return false;
    }
    
    
    public boolean registerStudent()
    {
        String query = "INSERT into users(username , password, security, answer) VALUES('"+user+"', '"+pass+"', '"+security+"' , '"+answer+"') ";
        return dbh.execUpdate(query);
    }
    
}
