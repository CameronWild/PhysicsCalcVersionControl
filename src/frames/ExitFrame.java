/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is a template for frames which are intended to exit when closed
 * @author Cam
 */
public class ExitFrame extends JFrame {


    public ExitFrame(JPanel type) {

        getContentPane().add(type);

        //frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
