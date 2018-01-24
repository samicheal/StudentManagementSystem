/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author USER
 */
public class Department {
    
    //declare variables
    private int deptId;
    private String department;
    
    /**
     * 
     * @param deptId
     * @param department 
     */
    public Department(int deptId, String department) {
        this.deptId = deptId;
        this.department = department;
    }
    
    //getters
    public int getDeptId() {
        return deptId;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Department{" + "deptId=" + deptId + ", department=" + department + '}';
    }
    
}
