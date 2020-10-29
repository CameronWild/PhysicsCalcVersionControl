/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cam
 */
public class CreateNewTable {

    public CreateNewTable(String username, Connection  conn) {
        
        try{
        Statement statement = conn.createStatement();
        String createTable ="CREATE TABLE"+username+"(TYPE VARCHAR(50) ,"
                + "ANSWER DOUBLE" + "UNITS VARCHAR(50)"+"PASSWORD VARCHAR(50))";
        statement.executeUpdate(createTable);
        
        statement.close();
        }
        
        catch (SQLException ex){
            //add message
        }
    }
    
    
    
    
}
