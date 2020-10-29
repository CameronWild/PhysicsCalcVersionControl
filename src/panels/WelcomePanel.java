/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import ReuseableActionListeners.ButtonListener;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    JLabel welcomeMessage, options, image, note, note2;
    JButton logButton, guestButton, signUpButton;

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
        logButton.addActionListener(new ButtonListener());
        
        guestButton = new JButton("Guest");
        guestButton.addActionListener(new ButtonListener());
        
        //Sign Up Button
        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ButtonListener());
        
        //Notes Assignment
        note = new JLabel("Please not if you use Guest you will not be able to save data.");
        note2 = new JLabel("At any time press X to exit. Note this will not save your data");

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
        add(note2, gbc);

    }

}
