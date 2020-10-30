/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Cam
 */
public class DisposeableFrames extends JFrame {


    public DisposeableFrames() {
    }
    
    public DisposeableFrames(JPanel type) {

        
        getContentPane().add(type);
        
        //frame settings
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }  
}
