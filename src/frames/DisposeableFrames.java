/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import panels.AccellerationPanel;
import panels.AccountPanel;
import panels.AngularForcePanel;
import panels.CalculatorPanelMain;
import panels.ComingSoonPanel;
import panels.ConversionEquationsPanel;
import panels.DegreestoRadiansPanel;
import panels.ForceEquationsPanel;
import panels.InfoPanel;
import panels.LinearKineticEnergyPanel;
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

    //DisposeableFrames test1 = new DisposeableFrames("Welcome");
//    public DisposeableFrames(){
//        DisposeableFrames test1 = new DisposeableFrames("Welcome");
//        dispose();
//    }
    public DisposeableFrames(String type) {

        if (type.equals("Log In")) {
            getContentPane().add(new LogInPanel());
        } else if (type.equals("Sign Up")) {
            getContentPane().add(new SignUpPanel());
        } else if (type.equals("App Info")) {
            getContentPane().add(new InfoPanel(type));
        } else if (type.equals("Motion Eq")) {
            getContentPane().add(new MotionEquationsPanel());
        } else if (type.equals("Conversion Eq")) {
            getContentPane().add(new ConversionEquationsPanel());
        } else if (type.equals("Work and Energy Eq")) {
            getContentPane().add(new WorkandEnergyEquationsPanel());
        } else if (type.equals("Force Eq")) {
            getContentPane().add(new ForceEquationsPanel());
        } else if (type.equals("Account")) {
            getContentPane().add(new AccountPanel());
        } else if (type.equals("Welcome")) {
            getContentPane().add(new WelcomePanel());
        } else if (type.equals("Calculator Main")) {
            getContentPane().add(new CalculatorPanelMain());
        } else if (type.equals("Comming Soon")) {
            getContentPane().add(new ComingSoonPanel());
        } else if (type.equals("Degrees to Radians Converter")) {
            getContentPane().add(new DegreestoRadiansPanel());
        } else if (type.equals("Accelleration")) {
            getContentPane().add(new AccellerationPanel());
        } else if (type.equals("Linear Kinetic Energy")) {
            getContentPane().add(new LinearKineticEnergyPanel());
        } else if (type.equals("Angular Force")) {
            getContentPane().add(new AngularForcePanel());
        }
        //frame settings
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        //  addWindowListener(this);

//this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public DisposeableFrames(String type, String info) {

        if (info.equals("Conversion Info")) {
            getContentPane().add(new InfoPanel("Conversion"));
        } else if (info.equals("Motion Info")) {
            getContentPane().add(new InfoPanel("Motion"));
        } else if (info.equals("Work and Energy Info")) {
            getContentPane().add(new InfoPanel("Work"));
        } else if (info.equals("Force Info")) {
            getContentPane().add(new InfoPanel("Force"));
        }
        //frame settings
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    
  
}
