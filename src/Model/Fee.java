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
public class Fee {
    
    //instance variables
    private final int feeId;
    private final int departmentId;
    private final int price;
    private final int year;
    
    /**
     * constructor
     * @param feeId
     * @param departmentId
     * @param price
     * @param year 
     */
    public Fee(int feeId, int departmentId, int price, int year) {
        this.feeId = feeId;
        this.departmentId = departmentId;
        this.price = price;
        this.year = year;
    }

    //accessor methods
    public int getFeeId() {
        return feeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Fee{" + "feeId=" + feeId + ", departmentId=" + departmentId + ", price=" + price + ", year=" + year + '}';
    }
    
    
    
}
