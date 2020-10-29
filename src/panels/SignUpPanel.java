/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cam
 */
public class SignUpPanel extends JPanel {

    JLabel signUpLabel, usernameText, noteUsername1, noteUsername2, noteUsername3, passwordText, notePassword;
    JButton checkAvaliablilty, signUp;
    JTextField username, password;

    public SignUpPanel() {

        //labels
        signUpLabel = new JLabel("Sign Up:");
        signUpLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        usernameText = new JLabel("Username:");
        noteUsername1 = new JLabel("Note: ");
        noteUsername2 = new JLabel("Usernames can only contail letters and numbers");
        noteUsername3 = new JLabel("and must be one word and are case sensitive");

        passwordText = new JLabel("Password:");
        notePassword = new JLabel("Note: Case sensitive");

        //Buttons
        checkAvaliablilty = new JButton("Check Avaliability");
        signUp = new JButton("Sign Up");

        //Text Fields
        username = new JTextField("");
        username.setPreferredSize(new Dimension(100, 19));

        password = new JTextField("");
        password.setPreferredSize(new Dimension(100, 19));

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(signUpLabel, gbc);
        add(usernameText, gbc);
        add(username, gbc);
        add(noteUsername1, gbc);
        add(noteUsername2, gbc);
        add(noteUsername3, gbc);
        add(checkAvaliablilty, gbc);
        add(passwordText, gbc);
        add(password, gbc);
        add(notePassword, gbc);
        add(signUp, gbc);

        setPreferredSize(new Dimension(300, 350));

    }
}
