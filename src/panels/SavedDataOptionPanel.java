/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

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
public class SavedDataOptionPanel extends JPanel{
        JLabel title;
    JButton savedData;
    
    public SavedDataOptionPanel() {
        
        setLayout(new BorderLayout());
        
        title = new JLabel("Saved Data:");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Info button
        savedData = new JButton("View Data");
        
        add(title, BorderLayout.PAGE_START);
        add(savedData,BorderLayout.CENTER);
        
           setPreferredSize(new Dimension(200,50));
    }
}
