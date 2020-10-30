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

    public CreateNewTable(String username, Connection conn, String password) {

        try (Statement statement = conn.createStatement()) {
            String createTable = "CREATE  TABLE "+username+"  (INDEX INT,   TYPE  VARCHAR(50),   VALUE   FLOAT,   UNIT   VARCHAR(50), PASSWORD VARCHAR(50))";
            statement.executeUpdate(createTable);
            statement.addBatch("INSERT INTO "+username+" (password, index) values ('"+password+"', 1)");
            statement.executeBatch();
            System.out.println("Created");
            
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Fail" + ex.getMessage());
        }
    }

}
