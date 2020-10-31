/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class reads data from user saved answers and assigns them to a static array list in Values
 *  
 * @author Cam
 */
public class ReadData {

    public ReadData() {
        
        ArrayList<String> readingData = new ArrayList<>();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Values.getUrl(), "root", "010101");
            Statement statement = conn.createStatement();
            
            //selects data to be loaded for output
            String sql = "select type, value, unit from " + Values.getUsername() + "";
            ResultSet rs = statement.executeQuery(sql);
            
            //clears password row
            rs.next();
            
            //reads data and assings to static variable
            while(rs.next()){    
                readingData.add(rs.getString("type") + "= " + rs.getDouble("value") + " "
                        + rs.getString("unit"));
            }
            Values.setReadData(readingData);
            
            //Console confirmation
            System.out.println("Data Loaded");
            conn.close();
            statement.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Fail reading data");
        }

    }

}
