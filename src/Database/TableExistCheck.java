/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cam
 */
public class TableExistCheck {

    public boolean TableExistCheck(String username, Connection conn) {
        boolean check = false;
        //Check if table exists
        try {
            DatabaseMetaData dbData = conn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbData.getTables(null, null, null, types);
            Statement statement = conn.createStatement();
            while(rs.next()){
                String table_name = rs.getString("TABLE_NAME");
                //if statement true username taken
                if(table_name.equals(username)){
                    //username TAKEN BITCH
                    check = false;
                }
                //usernamer free
                else
                    check = true;
            }
            
            rs.close();
            statement.close();
        
        } catch (SQLException ex) {
            return true;
        }
        return check;

    }

}
