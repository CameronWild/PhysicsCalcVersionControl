/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import ReuseableActionListeners.DisposeAction;
import frames.DisposeableFrames;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cam
 */
public class LogInPanel extends JPanel {

    JTextField username, password;
    JLabel usernameText, passwordText, logInText, note;
    JButton ok;
    String usernameInput;
    String passwordInput;

    public LogInPanel() {

        //username Text Field
        username = new JTextField();
        username.setPreferredSize(new Dimension(100, 19));

        //password text field
        password = new JTextField();
        password.setPreferredSize(new Dimension(100, 19));

        //labels
        usernameText = new JLabel("Username:");
        passwordText = new JLabel("Password:");
        logInText = new JLabel("Log In:");
        logInText.setFont(new Font("Helvetica", Font.BOLD, 20));
        note = new JLabel("Username and Passowrds are case sensitive");

        //Button
        ok = new JButton("Log In");
        ok.addActionListener(new TextInput());
        ok.addActionListener(new DisposeAction());

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(logInText, gbc);
        add(usernameText, gbc);
        add(username, gbc);
        add(passwordText, gbc);
        add(password, gbc);
        add(ok, gbc);

        add(note, gbc);
        setPreferredSize(new Dimension(300, 200));
    }

    private class TextInput implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            usernameInput = username.getText();
            passwordInput = password.getText();
            System.out.println(usernameInput);
            System.out.println(passwordInput);
        }

    }

   

}
