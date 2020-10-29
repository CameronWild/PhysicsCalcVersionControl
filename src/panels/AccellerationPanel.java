/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.Dimension;
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
public class AccellerationPanel extends JPanel{
    
        JLabel title, equation, prompt1,prompt2,prompt3,prompt4 ;
    JTextField finalTime,finalVelocity, initialTime, initialVelocity;
    JButton solve;
    
    public AccellerationPanel() {
        
        title = new JLabel("Accelleration Calculator");
        equation = new JLabel("Equation: a =  (vf - vi) / (tf - ti)");
        prompt1 = new JLabel("Final Velocity:");
        prompt2 = new JLabel("Initial Velocity:");
        prompt3 = new JLabel("Final Time:");
        prompt4 = new JLabel("Initial Time:");
        
        //Textfield
        finalVelocity = new JTextField();
        finalVelocity.setPreferredSize(new Dimension(100, 19));
        finalTime = new JTextField();
        finalTime.setPreferredSize(new Dimension(100, 19));
        initialVelocity = new JTextField();
        initialVelocity.setPreferredSize(new Dimension(100, 19));
        initialTime = new JTextField();
        initialTime.setPreferredSize(new Dimension(100, 19));
        //Solve Button
        solve = new JButton("Solve");

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(equation, gbc);
        add(prompt1, gbc);
        add(finalVelocity, gbc);
        add(prompt2, gbc);
        add(initialVelocity, gbc);
        add(prompt3, gbc);
        add(finalTime, gbc);
        add(prompt4, gbc);
        add(initialTime, gbc);
        add(solve, gbc);
        setPreferredSize(new Dimension(300, 200));
    }
}
