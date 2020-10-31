/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import database.Values;
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
public class AnswerPanel extends JPanel {

    JLabel answer;
    
    public AnswerPanel() {
        
        answer = new JLabel("<html><div style ='text-align: center;'> "
                + "Answer:<br>"
                + Values.getType() + " =<br>"
                + Values.getAnswer()+" "+Values.getUnit() + "</html></div>");
        //answer.setHorizontalAlignment(SwingConstants.CENTER);
        
        setLayout(new BorderLayout());
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.NORTH);
        add(answer, BorderLayout.CENTER);
        
    }

}
