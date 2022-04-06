
package com.business;

/**
 * Author: Josiah Martin
 * Date: 24 March 2022
 */
public class User {
    //Protected fields for the sub-classes to inherit
    protected String id;
    protected String firstName;
    protected String lastName;
    private String password;
    
    //Constructor with parameters
    User(String id, String firstName, String lastName, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    
    //Parameterless constructor
    User(){
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
    }
    
    //Methods to get and set all protected fields
    public void setId(String id){this.id = id;}
    public String getId(){return this.id;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public String getFirstName(){return this.firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public String getLastName(){return this.lastName;}
    
    
    //Methods to get and set the one private field password
    public void setPassword(String password){this.password = password;}
    public String getPassword(){return this.password;}
    
    //Method to let the user login
    protected boolean login(){
        return false;
    }
}
