
package com.business;

import com.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Josiah Martin
 * Date: 24 March 2022
 */
public class Patient extends User {
    private String address;
    private String email;
    private String insurance;
    private Appointment app;
    
    public Patient(){
        super();
        this.address = "";
        this.email = "";
        this.insurance = "";
        this.app = new Appointment();
    }
    
    //All the getter and setter methods
    public void setAddress(String address){this.address = address;}
    public String getAddress(){return this.address;}
    public void setEmail(String email){this.email = email;}
    public String getEmail(){return this.email;}
    public void setInsurance(String insurance){this.insurance = insurance;}
    public String getInsurance(){return this.insurance;}
    public Appointment getAppointment(){return this.app;}
    
    // Method to let the patient login to his or her account
    public boolean login(String username, String password){
        // Set the email equal to the username parameter
        email = username;
        // Select the patient from the datbase using the email as the username
        // If the select statement does not throw an error, then the person is in the database
        // Test the password entered against the password in the database
        selectByEmail();
        if(password.equals(getPassword())){
            return true;
        } else {
            System.out.println("Dentist input wrong password.");
        }
        return false;
    }
    
    //Method that lets the patient schedule an appointment
    public void scheduleAppointment(){
        
    }
    
    public void selectByEmail(){
        Database db = new Database();
        String sql = "SELECT * FROM Patients WHERE email = '" + email + "';";
        ResultSet rs = db.executeSQLSelect(sql);
        db.closeConnection();
        try{
            rs.next();
            setId(rs.getString("patId"));
            setPassword(rs.getString("passwd"));
            setFirstName(rs.getString("firstName"));
            setLastName(rs.getString("lastName"));
            setAddress(rs.getString("addr"));
            setEmail(rs.getString("email"));
            setInsurance(rs.getString("insCo"));
        } catch(SQLException e){
            System.out.println("Could not process patient... " + e);
        }
    }
    
    public void update(){
        
    }
    
    public void insert(){
        
    }
    
    public void delete(){
        
    }
    
    @Override
    public String toString(){
        return "Patient ID: " + id +
                "\nFirst name: " + firstName +
                "\nLast name: " + lastName +
                "\nPassword: " + getPassword() +
                "\nAddress: " + address +
                "\nEmail: " + email +
                "\nInsurance: " + insurance;
    }
    
    public void display(){
        System.out.println(toString());
    }
}
