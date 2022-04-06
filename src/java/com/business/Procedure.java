
package com.business;

/**
 * Author: Josiah Martin
 * Date: 24 March 2022
 */
public class Procedure {
    private String procCode;
    private String procName;
    private String procDesc;
    private double cost;
    
    Procedure(){
        this.procCode = "";
        this.procName = "";
        this.procDesc = "";
        this.cost = 0.0;
    }
    
    Procedure(String procCode, String procName, String procDesc, double cost){
        this.procCode = procCode;
        this.procName = procName; 
        this.procDesc = procDesc;
        this.cost = cost;
    }
    
    //All the getter and setter methods
    public void setProcCode(String procCode){this.procCode = procCode;}
    public String getProcCode(){return this.procCode;}
    public void setProcName(String procName){this.procName = procName;}
    public String getProcName(){return this.procName;}
    public void setProcDesc(String procDesc){this.procDesc = procDesc;}
    public String getProcDesc(){return this.procDesc;}
    public void setCost(double cost){this.cost = cost;}
    public double getCost(){return this.cost;}
}
