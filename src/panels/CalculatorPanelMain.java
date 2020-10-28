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
    
    JLabel title;
    
    public CalculatorPanelMain(){
        
        JPanel mid = new JPanel();
        JPanel main = new JPanel();
        
        GridLayout layout = new GridLayout(3,2);
        layout.setHgap(10);
        layout.setVgap(10);
        mid.setLayout(layout);
        
        title = new JLabel("PHYSICS CALCULATOR OPTIONS");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        mid.add(new ConversionOptionsPanel());
        mid.add(new MotionEquationOptionsPanel());
        mid.add(new WorkEnergyOptionsPanel());
        mid.add(new ForceOptionsPanel());
        mid.add(new SavedDataOptionPanel());
        mid.add(new AccountManagementInfoPanel());
        
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(Box.createRigidArea(new Dimension(10,0)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(10,0)), BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0,10)), BorderLayout.SOUTH);
        add(mid, BorderLayout.CENTER);
    }
    
}

