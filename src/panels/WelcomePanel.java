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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Cam
 */
public class WelcomePanel extends JPanel {

    JPanel welcomePanel;
    JLabel welcomeMessage, options, image, note;
    JButton logButton, guestButton, signUpButton;
    Action action = new Action();
    public String buttonText = "fail";
    private boolean state = true;


    public WelcomePanel() {

        welcomePanel = new JPanel();

        //Welcome Message 
        welcomeMessage = new JLabel("Welcome to the Physics Calculator Application");
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessage.setFont(new Font("Helvetica", Font.BOLD, 15));

        //Options Label Assignment
        options = new JLabel("Please select from the following:", SwingConstants.CENTER);
        options.setHorizontalAlignment(SwingConstants.CENTER);

        //Image assignment
        image = new JLabel();
        image.setIcon(new ImageIcon(getClass().getResource("WelcomeImage.jpg")));

        //Button Assignment
        //LogIn
        logButton = new JButton("Log In");
        logButton.setPreferredSize(new Dimension(100, 30));
        logButton.addActionListener(action);
        //Guest Button
        guestButton = new JButton("Guest");
        guestButton.addActionListener(action);
        guestButton.setPreferredSize(new Dimension(100, 30));
        //Sign Up Button
        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(action);
        signUpButton.setPreferredSize(new Dimension(100, 30));

        //Notes Assignment
        note = new JLabel("<html><div style ='text-align: center;'>Please note:<br>"
                + "If you use Guest you will not be able to save or load data.<br>"
                + "Press X to exit<br><br></html></div>");
                

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Adding components and alligning
        add(image, gbc);
        add(welcomeMessage, gbc);
        add(options, gbc);
        add(logButton, gbc);
        add(guestButton, gbc);
        add(signUpButton, gbc);
        add(note, gbc);
        

    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
    
    
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


    public class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JButton button = (JButton)e.getSource();
            //if source is a button assing JButton casted source to it
//            if (source instanceof JButton) {
//                button = (JButton) source;
//            }
            //checks for assigned value
            if (button != null) {
                setButtonText(button.getText());  //assings button text
                setState(false);
            }
        }
    }
}
