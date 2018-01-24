/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DatabaseHandlerDerby {
    
    //declare database constants
    private Connection con;   //for establishing connection to dnb
    private final String URL = "jdbc:derby:SMS;create=true";
    private Statement stmt;
    private ResultSet res;
    
    public DatabaseHandlerDerby()
    {
        connection();  //establish connection 
        createUsersTable(); //create users table
        createDepartmentTable(); //create users table
        createFeesTable(); //create fees table
        createStudentTable();  //create student table
    }
    
    /**
     * method to establish connection
     */
    public void connection()
    {
        try {
            //register driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            
            //create connection
            con = DriverManager.getConnection(URL);
            
            System.out.println("connection successful");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DatabaseHandlerDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param query
     * @return 
     */
    public Boolean execUpdate(String query)
    {
        try {
            stmt = con.createStatement();
            stmt.execute(query);  //execute query with statement
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    /**
     * 
     * @param query
     * @return 
     */
    public ResultSet execAction(String query)
    {
        try {
            stmt = con.createStatement();
            return stmt.executeQuery(query); 
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }   
    
    /**
     * 
     */
    public void retrieveTableInfo()
    {
        try {
            DatabaseMetaData dbmd = con.getMetaData();
          
            ResultSet rsTables = dbmd.getTables(null, null, null, new String[]{"TABLE"});
            
            System.out.println("USER TABLES");
            
            while(rsTables.next()){
                System.out.println(rsTables.getString("TABLE_NAME"));
//                        System.out.println("Table already exists");
//                        break;   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * method to return number of records in result set
     * @param res
     * @return 
     */
    public int countRows(ResultSet res)
    {
        //declare count variable
        int count = 0;
        
        try{
        //run result set throught loop
            while(res.next())
                    count++;
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        
        return count;
        
    }
    
    /**
     * 
     */
    public void createUsersTable()
    {
        //declare local variable 
        String TABLE_NAME = "USERS";
        
        //create try-catch block
        try{
            //create statement for query execution
            stmt = con.createStatement();
            
            //get database metadata
            DatabaseMetaData dbm = con.getMetaData();
            
            //check if table book exists
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            //check if table name exists
            if(tables.next())
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
             else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                            + " id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1 , INCREMENT BY 1), \n "
                            + " username varchar(50), \n "
                            + " password varchar(50), \n "
                            + " security varchar(200), \n "
                            + " answer varchar(50) \n "
                            + " )" ); 
                
            }
            
        }
        catch(SQLException sql){
            System.err.println(sql.getMessage() + "------setupDatabase");
        }
    }
    
    /**
     * 
     */
     public void createDepartmentTable()
    {
        //declare local variable 
        String TABLE_NAME = "DEPARTMENT";
        
        //create try-catch block
        try{
            //create statement for query execution
            stmt = con.createStatement();
            
            //get database metadata
            DatabaseMetaData dbm = con.getMetaData();
            
            //check if table book exists
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            //check if table name exists
            if(tables.next())
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
             else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                            + " department_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1 , INCREMENT BY 1), \n "
                            + " department_name varchar(100) \n "
                            + " )" ); 
                
            }
            
        }
        catch(SQLException sql){
            System.err.println(sql.getMessage() + "------setupDatabase");
        }
    }
     
    /**
     * 
     */
     public void createFeesTable()
    {
        //declare local variable 
        String TABLE_NAME = "FEES";
        
        //create try-catch block
        try{
            //create statement for query execution
            stmt = con.createStatement();
            
            //get database metadata
            DatabaseMetaData dbm = con.getMetaData();
            
            //check if table book exists
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            //check if table name exists
            if(tables.next())
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
             else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                            + " Fees_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1 , INCREMENT BY 1), \n "
                            + " department_id INTEGER NOT NULL, \n "
                            + " price INTEGER NOT NULL, \n "
                            + " years INTEGER NOT NULL \n "
                            + " )" ); 
                
            }
            
        }
        catch(SQLException sql){
            System.err.println(sql.getMessage() + "------setupDatabase");
        }
    }
     
    /**
     * 
     */
     public void createStudentTable()
    {
        //declare local variable 
        String TABLE_NAME = "STUDENT";
        
        //create try-catch block
        try{
            //create statement for query execution
            stmt = con.createStatement();
            
            //get database metadata
            DatabaseMetaData dbm = con.getMetaData();
            
            //check if table book exists
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            //check if table name exists
            if(tables.next())
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
             else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                            + " student_id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 , INCREMENT BY 1) PRIMARY KEY, \n "
                            + " first_name VARCHAR(30) NOT NULL, \n "
                            + " last_name VARCHAR(30) NOT NULL, \n "
                            + " mobile VARCHAR(15) NOT NULL \n, "
                            + " email VARCHAR(70) NOT NULL, \n "
                            + " location VARCHAR(100) NOT NULL, \n "
                            + " gender VARCHAR(10) NOT NULL \n, "
                            + " register_date DATE NOT NULL, \n "
                            + " level VARCHAR(30) NOT NULL, \n "
                            + " department VARCHAR(30) NOT NULL \n, "
                            + " course_name VARCHAR(30) NOT NULL, \n "
                            + " amount DOUBLE, \n "
                            + " balance DOUBLE \n, "
                            + " fee DOUBLE \n "
                            + " )" ); 
                
            }
            
        }
        catch(SQLException sql){
            System.err.println(sql.getLocalizedMessage() + "------setupDatabase");
        }
    } 
     
    public static void main(String [] args)
    {
        DatabaseHandlerDerby dbh = new DatabaseHandlerDerby();     
        System.out.println("tade".compareTo("zip"));
    }
    
}
