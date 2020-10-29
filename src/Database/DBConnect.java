/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cam
 */
public class DBConnect {

    String url; 
    Connection conn;
    Statement test;

    public DBConnect() {
        
        url = "jdbc:derby:CalculatorDB; create=true;";
        try{
            
            conn=DriverManager.getConnection(url, "root", "010101");
        }
        catch(SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
        
    }

}
