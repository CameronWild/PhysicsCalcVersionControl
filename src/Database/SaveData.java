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
public class SaveData {

    public SaveData(Connection conn, String type, Double result, String username, String units) {
        
        try{
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO "+username+" ('"+type+", "+result+", "+units+")");
        }
        catch (SQLException ex){
            //
        }
        
    }
    
    
    
}
