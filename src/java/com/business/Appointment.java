
package com.business;

import java.util.Date;

/**
 * Author: Josiah Martin
 * Date: 24 March 2022
 */
class Appointment {
    private String patId;
    private String dentId;
    private String procCode;
    private Date appDate;
    
    Appointment(){
        this.patId = "";
        this.dentId = "";
        this.procCode = "";
        this.appDate = new Date();
    }
    
    //All the getter and setter methods
    public void setPatId(String patId){this.patId = patId;}
    public String getPatId(){return this.patId;}
    public void setDentId(String dentId){this.dentId = dentId;}
    public String getDentId(){return this.dentId;}
    public void setProcCode(String procCode){this.procCode = procCode;}
    public String getProcCode(){return this.procCode;}
    //No setter for appointment date
    public Date getAppDate(){return this.appDate;}
    
    public static void main(String[] args){
    }
}
