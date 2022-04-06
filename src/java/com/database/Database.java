
package com.database;

import com.business.Dentist;
import com.business.Patient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author josia
 */
public class Database {
    private final String path = "jdbc:ucanaccess://C:\\Users\\josia\\OneDrive\\Desktop\\DentistOffice\\database\\DentistOfficeMDB.mdb";
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    private Connection conn = null;
    
    public Database(){
        try{
           establishConnection(); 
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e + " Database connection failed...");
        }
    }
    
    private void establishConnection() throws SQLException, ClassNotFoundException {
        //Load the driver
        Class.forName(driver);
        //Get the connection
        conn = DriverManager.getConnection(path);
    }
    
    public ResultSet executeSQLSelect(String sql){
        ResultSet rs = null;
        try{
            rs = conn.createStatement().executeQuery(sql);
        } catch(SQLException e){
            System.out.println("Could not execute query... " + e);
        }
        return rs;
    }
    
    public int executeSQLUpdate(String sql){
        int rs = -1;
        try{
            rs = conn.createStatement().executeUpdate(sql);
        } catch(SQLException e){
            System.out.println("Could not execute update... "  + e);
        }
        return rs;
    }
    
    public boolean closeConnection(){
        boolean isClosed = false;
        if(conn != null)
            try{
                conn.close();
                isClosed = true;
            } catch(SQLException e){
                System.out.println("Cannot close the connection... " + e);
            }
        return isClosed;
    }
    
    public void selectPatient(Patient p){
        String sql = "SELECT * FROM Patients WHERE patId = '" + p.getId() + "';";
        ResultSet rs = executeSQLSelect(sql);
        closeConnection();
        try{
            rs.next();
            p.setId(rs.getString("patId"));
            p.setPassword(rs.getString("passwd"));
            p.setFirstName(rs.getString("firstName"));
            p.setLastName(rs.getString("lastName"));
            p.setAddress(rs.getString("addr"));
            p.setEmail(rs.getString("email"));
            p.setInsurance(rs.getString("insCo"));
        } catch(SQLException e){
            System.out.println("Could not process patient... " + e);
        }
    }
    
    public void selectDentist(Dentist d){
        String sql = "SELECT * FROM Dentists WHERE id = '" + d.getId() + "';";
        ResultSet rs = executeSQLSelect(sql);
        closeConnection();
        try{
            rs.next();
            d.setId(rs.getString("id"));
            d.setPassword(rs.getString("passwd"));
            d.setFirstName(rs.getString("firstName"));
            d.setLastName(rs.getString("lastName"));
            d.setOffice(rs.getString("office"));
            d.setEmail(rs.getString("email"));

        } catch(SQLException e){
            System.out.println("Could not process patient... " + e);
        }
    }
    
    
    public static void main(String[] args) throws SQLException{
        // Creates a pointer variable "db" that holds a reference to the object in memery
        Database db = new Database();
        Dentist d = new Dentist();
        d.setId("D201");
        db.selectDentist(d);
        d.display();
    }
}
