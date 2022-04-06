
package com.business;

import com.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Josiah Martin
 * Date: 24 March 2022
 */
public class Dentist extends User{
    private String email;
    private String office;
    private Appointment app;
    
    public Dentist(){
        super();
        this.email = "";
        this.office = "";
        this.app = new Appointment();
    }
    
    //All the getter and setter methods
    public void setEmail(String email){this.email = email;}
    public String getEmail(){return this.email;}
    public void setOffice(String office){this.office = office;}
    public String getOffice(){return this.office;}
    public Appointment getAppointment(){return this.app;}
    
    // Method that lets the dentist login to his or her account
    public boolean login(String username, String password){
        // Set the email to the username parameter
        email = username;
        selectByEmail();
        // Select the patient from the datbase using the email as the username
        // If the select statement does not throw an error, then the person is in the database
        // Test the password entered against the password in the database
        if(password.equals(getPassword())){
            return true;
        } else {
            System.out.println("Dentist input wrong password.");
        }
        return false;
    }
    
    public void selectByEmail(){
        Database db = new Database();
        String sql = "SELECT * FROM Dentists WHERE email = '" + email + "';";
        ResultSet rs = db.executeSQLSelect(sql);
        db.closeConnection();
        try{
            rs.next();
            setId(rs.getString("id"));
            setPassword(rs.getString("passwd"));
            setFirstName(rs.getString("firstName"));
            setLastName(rs.getString("lastName"));
            setEmail(rs.getString("email"));
            setOffice(rs.getString("office"));
        } catch(SQLException e){
            System.out.println("Could not process dentist... " + e);
        }
    }
    
    public void update(){
        String sql = "UPDATE Dentists "
                + "SET passwd = '" + getPassword() + "', " 
                + "firstName = '" + firstName +  "', "
                + "lastName = '" + lastName + "', "
                + "email = '" + email + "', "
                + "office = '" + office + "'"
                + " WHERE id = '" + id + "';";
        System.out.println(sql);
        Database db = new Database();
        int rs = db.executeSQLUpdate(sql);
        db.closeConnection();
        System.out.println((rs == 1)? "Update on Dentists table was a success!" : "Update on Dentists table failed!");
    }
    
    public void insert(){
        String sql = "INSERT INTO Dentists (id, passwd, firstName, lastName, email, office)"
                + " VALUES('" + id + "', '" + getPassword() + "', '" + firstName + "', '" + lastName + "', '" + email + "', '" + office + "');";
        System.out.println(sql);
        Database db = new Database();
        int rs = db.executeSQLUpdate(sql);
        db.closeConnection();
        System.out.println((rs == 1)? "Insert on Dentists table was a success!" : "Insert on Dentists table failed!");
    }
    
    public void delete(){
        String sql = "DELETE FROM Dentists WHERE id = '" + id + "'";
        System.out.println(sql);
        Database db = new Database();
        int rs = db.executeSQLUpdate(sql);
        db.closeConnection();
        System.out.println((rs == 1)? "Delete on Dentists table was a success!" : "Delete on Dentists table failed!");
    }
    
    @Override
    public String toString(){
        return "Dentist ID: " + id +
                "\nFirst name: " + firstName +
                "\nLast name: " + lastName +
                "\nPassword: " + getPassword() +
                "\nEmail: " + email +
                "\nOffice: "  + office;
    }
    
    public void display(){
        System.out.println(toString());
    }
    
    public static void main(String[] args){
//        Dentist d = new Dentist();
//        d.setId("D201");
//        d.setPassword("55555");
//        d.setFirstName("joe");
//        d.setLastName("martin");
//        d.setEmail("email@example.com");
//        d.setOffice("403");
//        d.update();
//        d.display();
    }
}
