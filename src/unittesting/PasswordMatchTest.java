/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class checks if password is correct
 * @author Cam
 */
public class PasswordMatchTest {

    private boolean validation = false;
    String urlCheck = "jdbc:derby:CalculatorDB; create=true";
    String pass = "010101";
    String user = "root";
    String realPassword;

    public PasswordMatchTest(String username, String password) {

        Connection con = null;
        Statement statement = null;
        try {
            //Gets password from user table
            con = DriverManager.getConnection(urlCheck, user, pass);
            statement = con.createStatement();
            String query = "select password from "+username+" where index=1";
            ResultSet rs = statement.executeQuery(query);
            
            //Assigns real password to a string
            while(rs.next()){
                realPassword = (rs.getString("password"));
            }
            //Checks if right
            if(password.equals(realPassword)){
                System.out.println("Password Correct");
                setValidation(true);
            }
            else{
                setValidation(false);
                System.out.println("Wrong Password");
            }
            
            con.close();
            statement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Password Match Error" + e.getMessage());
        }

    }

    public boolean isValidation() {
        return validation;
    }

    private void setValidation(boolean validation) {
        this.validation = validation;
    }

}
