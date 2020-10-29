/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cam
 */
public class CheckPassword {

    public CheckPassword(Connection conn, String password) {
        boolean check = false;
        ResultSet rs = null;
        try{
            Statement statement = conn.createStatement();
            String sqlQuery = "select password";
            rs = statement.executeQuery(sqlQuery);
            String passCheck = rs.getString("password");
            if(passCheck.equals(password))
                check = true;
            else
                check = false;
        }
        catch (SQLException ex){
            //add error message
        }
    }
    
    
    
}
