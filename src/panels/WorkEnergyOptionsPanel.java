/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import ReuseableActionListeners.ButtonListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Cam
 */
public class WorkEnergyOptionsPanel extends JPanel{
    JLabel title;
    JButton info, equations;
    
    public WorkEnergyOptionsPanel() {
        
        setLayout(new BorderLayout());
        
        title = new JLabel("Work and Energy:");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Info button
        info = new JButton("Info");
        info.setActionCommand("Work and Energy Info");
        info.addActionListener(new ButtonListener());
        
        //Equations button
        equations = new JButton("Equations");
        equations.setActionCommand("Work and Energy Eq");
        equations.addActionListener(new ButtonListener());
        
        add(title, BorderLayout.PAGE_START);
        add(info, BorderLayout.EAST);
        add(equations,BorderLayout.CENTER);
        
           setPreferredSize(new Dimension(200,50));
    }
    
}
