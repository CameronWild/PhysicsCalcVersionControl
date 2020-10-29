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
public class DegreestoRadiansPanel extends JPanel{

    JLabel title, equation, prompt;
    JTextField degrees;
    JButton solve;
    
    public DegreestoRadiansPanel() {
        
        title = new JLabel("Degrees to Radians Converter");
        equation = new JLabel("Equation: Degrees * PI/180");
        prompt = new JLabel("Degrees:");
        
        //Degrees Textfield
        degrees = new JTextField();
        degrees.setPreferredSize(new Dimension(100, 19));
        //Solve Button
        solve = new JButton("Solve");

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(equation, gbc);
        add(prompt, gbc);
        add(degrees, gbc);
        add(solve, gbc);
        setPreferredSize(new Dimension(300, 200));
    }
}
