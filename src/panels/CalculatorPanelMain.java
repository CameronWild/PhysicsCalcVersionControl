/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Cam
 */
public class CalculatorPanelMain extends JPanel{
    
    JLabel title, note;
    public boolean logOut = true;
 
    
    public CalculatorPanelMain(){
        
        JPanel mid = new JPanel();
        
        GridLayout layout = new GridLayout(3,2);
        layout.setHgap(10);
        layout.setVgap(10);
        mid.setLayout(layout);
        
        title = new JLabel("PHYSICS CALCULATOR OPTIONS");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        note = new JLabel("To exit press X on this window");
        note.setHorizontalAlignment(SwingConstants.CENTER);
        
        mid.add(new ConversionOptionsPanel());
        mid.add(new MotionEquationOptionsPanel());
        mid.add(new WorkEnergyOptionsPanel());
        mid.add(new ForceOptionsPanel());
        mid.add(new SavedDataOptionPanel());
        mid.add(new AccountManagementInfoPanel());
        
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(20,0)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(20,0)), BorderLayout.WEST);
        add(mid, BorderLayout.CENTER);
        add(note, BorderLayout.SOUTH);
    }
    
    public boolean isLogOut() {
        return logOut;
    }
}

