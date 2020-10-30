/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

import Database.CreateNewTable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import physicscalcappgui.GuiBuilder;

/**
 *
 * @author Cam
 */
public class UsernameExistsTest {

    //String usernameCheck = this.username;
    private boolean validation = true;
    CreateNewTable newUser;
    String urlCheck = "jdbc:derby:CalculatorDB; create=true";
    String pass = "010101";
    String user = "root";

    public UsernameExistsTest(String userCheck, String password, boolean create) {

        Connection con = null;
        try {
            con = DriverManager.getConnection(urlCheck, user, pass);
            DatabaseMetaData data = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = data.getTables(null, null, null, types);
            
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
            if ((create == true) && (validation)) {
                newUser = new CreateNewTable(userCheck, con, password);
            }
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Oops");
        }
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }
}
