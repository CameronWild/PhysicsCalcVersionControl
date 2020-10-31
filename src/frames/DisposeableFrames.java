/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A template for frames which allow closing without exiting program
 * 
 * @author Cam
 */
public class DisposeableFrames extends JFrame {

    
    public DisposeableFrames(JPanel type) {

        //adds different panels 
        getContentPane().add(type);
        
        //frame settings
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }  
}
