/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cam
 */
public class ComingSoonPanel extends JPanel{

    JLabel comingSoon;
    
    public ComingSoonPanel() {
        
        comingSoon = new JLabel("Coming Soon!");
        
        setLayout(new BorderLayout());
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.NORTH);
        add(comingSoon, BorderLayout.CENTER);
        
    }

}
