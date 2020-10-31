/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import reuseableactionlistener.ButtonListener;
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
public class ForceEquationsPanel extends JPanel{
       JLabel title;
    JButton angularForce, linearForce, torque;
    
    public ForceEquationsPanel() {
        
        
        title = new JLabel("Force Equations:");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Angular Force
        angularForce = new JButton("Angular Force");
        angularForce.setPreferredSize(new Dimension(210,30));
        angularForce.addActionListener(new ButtonListener());
        
        //Linear Force
        linearForce = new JButton("Linear Force");
        linearForce.setPreferredSize(new Dimension(210,30));
        linearForce.addActionListener(new ButtonListener());
        
        //Torque
        torque = new JButton("Torque");
        torque.setPreferredSize(new Dimension(210,30));
        torque.addActionListener(new ButtonListener());
        
        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(angularForce, gbc);
        add(linearForce, gbc);
        add(torque, gbc);
    }
}
