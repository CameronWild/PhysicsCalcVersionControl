/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

import database.CreateNewTable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class checks if username already exists
 * @author Cam
 */
public class UsernameExistsTest {

    private boolean validation = true;
    CreateNewTable newUser;
    String urlCheck = "jdbc:derby:CalculatorDB; create=true";
    String pass = "010101";
    String user = "root";

    public UsernameExistsTest(String userCheck, String password, boolean create) {

        Connection con = null;

        try {
            //if username is not GUEST continues 
            if (!userCheck.equalsIgnoreCase("guest") || !userCheck.equalsIgnoreCase("null")) {
                
                con = DriverManager.getConnection(urlCheck, user, pass);
                DatabaseMetaData data = con.getMetaData();
                String[] types = {"TABLE"};
                ResultSet rs = data.getTables(null, null, null, types);

                //checks through tables to see if username(table) exists
                while (rs.next()) {
                    String table_name = rs.getString("TABLE_NAME");
                    System.out.println(table_name);
                    if (table_name.equalsIgnoreCase(userCheck)) {
                        setValidation(false);
                        break;

                    } else {
                        setValidation(true);
                        //break;
                    }
                }
                //if username is free and create is true (enables check avaliablitiy) then creates new table (user)
                if ((create == true) && (validation)) {
                    newUser = new CreateNewTable(userCheck, con, password);
                }
            rs.close();
            con.close();
            }
            

        } catch (SQLException e) {
            System.out.println("Username Exists Error");
        }
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }
}
