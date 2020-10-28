/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.JFrame;
import panels.AccountPanel;
import panels.ConversionEquationsPanel;
import panels.ForceEquationsPanel;
import panels.InfoPanel;
import panels.LogInPanel;
import panels.MotionEquationsPanel;
import panels.SignUpPanel;
import panels.WelcomePanel;
import panels.WorkandEnergyEquationsPanel;

/**
 *
 * @author Cam
 */
public class DisposeableFrames extends JFrame {

    public DisposeableFrames(String type) {

        if (type.equals("Welcome")) {
            getContentPane().add(new WelcomePanel());
        } else if (type.equals("LogIn")) {
            getContentPane().add(new LogInPanel());
        } else if (type.equals("SignUp")) {
            getContentPane().add(new SignUpPanel());
        } else if (type.equals("Test")) {
            getContentPane().add(new InfoPanel("THIS IS \n a \n test"));
        } else if (type.equals("Test2")) {
            getContentPane().add(new MotionEquationsPanel());
        } else if (type.equals("Test21")) {
            getContentPane().add(new ConversionEquationsPanel());
        } else if (type.equals("Test22")) {
            getContentPane().add(new WorkandEnergyEquationsPanel());
        } else if (type.equals("Test23")) {
            getContentPane().add(new ForceEquationsPanel());
        } else if (type.equals("Test24")) {
            getContentPane().add(new AccountPanel());
        }
            //frame settings
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pack();
            setLocationRelativeTo(null);
            setVisible(true);

        }
    }

