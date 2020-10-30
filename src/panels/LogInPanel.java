/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

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
import unittesting.PasswordInputTest;
import unittesting.UsernameExistsTest;
import unittesting.UsernameInputTest;

/**
 *
 * @author Cam
 */
public class LogInPanel extends JPanel {

    private boolean state = true;

    JTextField username, password;
    JLabel usernameText, passwordText, logInText, note1, note2;
    JButton ok;
    private String usernameInput;
    private String passwordInput;
    UsernameInputTest nameTest;
    boolean nameState = false;
    PasswordInputTest passTest;
    boolean passwordState = false;
    DisposeableFrames frame;
    UsernameExistsTest avaliable;
    boolean usernameState = false;

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
        note1 = new JLabel("Usernames are not case sensitive");
        note2 = new JLabel("Passowrds are case sensitive");

        //Button
        ok = new JButton("Log In");
        ok.addActionListener(new Action());

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(logInText, gbc);
        add(usernameText, gbc);
        add(username, gbc);
        add(note1,gbc);
        add(passwordText, gbc);
        add(password, gbc);
        add(ok, gbc);

        add(note2, gbc);
        setPreferredSize(new Dimension(300, 200));
    }

    public class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setUsernameInput(username.getText());
            setPasswordInput(password.getText());

            nameTest = new UsernameInputTest(getUsernameInput());
            nameState = nameTest.getValidation();
            
            //check for username input
            if (nameState == false) {   
                frame = new DisposeableFrames(new ErrorInfoPanel("Username"));
            } 
            //if username input is good carrys on
            else{
                
                avaliable = new UsernameExistsTest(getUsernameInput(), getPasswordInput(), false);
                usernameState = avaliable.isValidation();
                
                if(usernameState){
                    frame = new DisposeableFrames(new ErrorInfoPanel("Username not found"));
                }
                
                else if ((usernameState==false) && (nameState)) {

                    passTest = new PasswordInputTest(getPasswordInput());
                    passwordState = passTest.getValidation();

                    if (passwordState == false) {
                        //do nothing

                    } else {
                        JButton button = (JButton) e.getSource();

                        //checks for assigned value
                        if (button != null) {
                            setState(false);
                        }
                    }
                }
            }
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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

}
