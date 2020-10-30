/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import Database.CreateNewTable;
import frames.DisposeableFrames;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import unittesting.PasswordInputTest;
import unittesting.UsernameExistsTest;
import unittesting.UsernameInputTest;

/**
 *
 * @author Cam
 */
public class SignUpPanel extends JPanel {

    JLabel signUpLabel, usernameText, noteUsername, passwordText, notePassword;
    JButton checkAvaliablilty, signUp;
    JTextField username, password;
    private String usernameInput = "";
    private String passwordInput = "";
    private boolean state = true;
    UsernameInputTest nameTest;
    boolean nameState = false;
    PasswordInputTest passTest;
    boolean passwordState = false;
    DisposeableFrames frame;
    UsernameExistsTest avaliable;
    boolean usernameState = false;

    public SignUpPanel() {

        //labels
        signUpLabel = new JLabel("Sign Up:");
        signUpLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        usernameText = new JLabel("Username:");
        noteUsername = new JLabel("<html><div style ='text-align: center;'>Note: <br>"
                + "Usernames can only contail letters and numbers,<br>"
                + "must be one word and are not case sensitive</div></html>");
        passwordText = new JLabel("Password:");
        notePassword = new JLabel("Note: Case sensitive");

        //Buttons
        checkAvaliablilty = new JButton("Check Avaliability");
        checkAvaliablilty.addActionListener(new CheckAvalableButton());

        signUp = new JButton("Sign Up");
        signUp.addActionListener(new TextInput());

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
        add(noteUsername, gbc);
        add(checkAvaliablilty, gbc);
        add(passwordText, gbc);
        add(password, gbc);
        add(notePassword, gbc);
        add(signUp, gbc);

        setPreferredSize(new Dimension(300, 350));

    }

    public class CheckAvalableButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setUsernameInput(username.getText());

            nameTest = new UsernameInputTest(getUsernameInput());
            nameState = nameTest.getValidation();

            if (nameState == false) {
                frame = new DisposeableFrames(new ErrorInfoPanel("Username"));

            } else if (nameState) {

                avaliable = new UsernameExistsTest(getUsernameInput(), getPasswordInput(), false);

                usernameState = avaliable.isValidation();
                if (usernameState) {
                    frame = new DisposeableFrames(new InfoPanel("Avaliable"));
                } else {
                    frame = new DisposeableFrames(new InfoPanel("Unavaliable"));
                }
            }
        }

    }

    public class TextInput implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setUsernameInput(username.getText());
            setPasswordInput(password.getText());

            nameTest = new UsernameInputTest(getUsernameInput());
            nameState = nameTest.getValidation();

            if (nameState == false) {
                frame = new DisposeableFrames(new ErrorInfoPanel("Username"));
            }

            if ((nameState)) {

                passTest = new PasswordInputTest(getPasswordInput());
                passwordState = passTest.getValidation();

                if (passwordState == false) {

                } else {
                    avaliable = new UsernameExistsTest(getUsernameInput(), getPasswordInput(), true);
                    usernameState = avaliable.isValidation();
                    if (usernameState) {
                        JButton button = (JButton) e.getSource();

                        //checks for assigned value
                        if (button != null) {
                            setState(false);
                        }
                    }
                    else{
                        frame = new DisposeableFrames(new ErrorInfoPanel("Username Taken"));
                    }
                }
            }
        }
    }

    public String getUsernameInput() {
        return usernameInput;
    }

    public void setUsernameInput(String usernameInput) {
        this.usernameInput = usernameInput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(String passwordInput) {
        this.passwordInput = passwordInput;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
