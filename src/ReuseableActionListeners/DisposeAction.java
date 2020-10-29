/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReuseableActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Cam
 */
public class DisposeAction extends JFrame implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
    
}
