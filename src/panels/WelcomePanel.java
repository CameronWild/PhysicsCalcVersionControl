/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;


import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cam
 */
public class WelcomePanel extends JPanel {

    public WelcomePanel(int width, int height) {
    
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(1,4));
        
        JLabel welcomeMessage = new JLabel("Welcome to the Physics Calculator Application");
        welcomeMessage.setSize(10, 10);
        welcomePanel.add(welcomeMessage);
        
        JTextField username =  new JTextField("Username: ");
        welcomePanel.add(username);
        
        JTextField password = new JTextField("Password");
        welcomePanel.add(password);
        
        JLabel note = new JLabel("Note: Username and Password are case sensitive!");
        welcomePanel.add(note);
        
        //welcomePanel.setOpaque(false);
       // welcomePanel.setLocation(width, height);
        //welcomePanel.setPreferredSize(new Dimension(width/2, height/2));
    }

}
