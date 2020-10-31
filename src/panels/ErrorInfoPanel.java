/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static panels.InfoPanel.InfoText;

/**
 *
 * @author Cam
 */
public class ErrorInfoPanel extends JPanel {

    String text;
    JLabel info;

    public ErrorInfoPanel(String error, String eq) {
        if(eq.length() == 0){
            text = ErrorText(error);
        }
        else{
            text = ErrorText(error, eq);
        }
        String formated = text.replace("\n", "<br>");
        formated = "<html><div style ='text-align: center;'>" + formated + "</div></html>";
        info = new JLabel(formated);
        info.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);

    }

    public static String ErrorText(String type) {

        String errorText = "";
        if (type.equals("Username")) {
            errorText = "Invalid input!\n"
                    + "Usernames must be only letters or numbers!";
        } else if (type.equals("Password")) {
            errorText = "Invalid input!\n"
                    + "Passwords cannot contain spaces!!!";
        } else if (type.equals("Username Taken")) {
            errorText = "Username is taken! \n\n"
                    + "Please try another";
        } else if (type.equals("Username not found")) {
            errorText = "Username doesn't exist! \n\n"
                    + "Please try another";
        } else if (type.equals("Incorrect Password")) {
            errorText = "Wrong Password! \n\n"
                    + "Please try again";
        } else if (type.equals("Password Length")) {
            errorText = "Please input a password!";
        } else if (type.equals("Guest Username")) {
            errorText = "That username is reserved for the guest account!\n"
                    + "Sorry!";
        } else if (type.equals("Null Username")) {
            errorText = "Username can't be null!\n"
                    + "Sorry!";
        } else if (type.equals("Password Null")) {
            errorText = "Password can't be null!\n"
                    + "Sorry!";
        }

        return errorText;

    }

    public static String ErrorText(String type, String eq) {
        String errorText = "";
        if (type.equals("Input Space")){
            errorText ="Error in "+ eq+" <\n>"
                    + "Input cannot contain spaces!";
        }
        else if (type.equals("Not Number")){
            errorText = "Error in "+eq+"\n"
                    + "Please input a numerical value!";
        }
        else if (type.equals("No Input")){
            errorText = "Error in" +eq+"\n"
                    + "Pleave input value in the space provided";
        }

        return errorText;
    }
}
