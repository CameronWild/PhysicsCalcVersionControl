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
import javax.swing.SwingConstants;

/**
 *
 * @author Cam
 */
public class InfoPanel extends JPanel{
    
    JLabel info;
    JPanel inner;

    
    public InfoPanel(String infoText){
        
        String formated = infoText.replace("\n", "<br>");
        formated = "<html><div style ='text-align: center;'>" + formated + "</div></html>";
        info = new JLabel(formated);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        
        setLayout(new BorderLayout());
        add(Box.createRigidArea(new Dimension(10,0)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(10,0)), BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0,10)), BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(0,10)), BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);
        
    }
}
