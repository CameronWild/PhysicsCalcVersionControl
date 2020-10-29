/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import ReuseableActionListeners.ButtonListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Cam
 */
public class ConversionEquationsPanel extends JPanel{
    JLabel title;
    JButton degreestoRadians, frequency, period;
    
    public ConversionEquationsPanel() {
        
        
        title = new JLabel("Conversion Equations:");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Degrees to Radians
        degreestoRadians = new JButton("Degrees to Radians Converter");
        degreestoRadians.setPreferredSize(new Dimension(210,30));
        degreestoRadians.addActionListener(new ButtonListener());
        
        //Frequency
        frequency = new JButton("Frequency");
        frequency.setPreferredSize(new Dimension(210,30));
        frequency.addActionListener(new ButtonListener());
        
        //Period
        period = new JButton("Period");
        period.setPreferredSize(new Dimension(210,30));
        period.addActionListener(new ButtonListener());
        
        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(degreestoRadians, gbc);
        add(frequency, gbc);
        add(period, gbc);
    }
}
