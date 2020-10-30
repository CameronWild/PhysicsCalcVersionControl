/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

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
public class InfoPanel extends JPanel {

    JLabel info;
    String text;

    public InfoPanel(String type) {

        text = InfoText(type);
        String formated = text.replace("\n", "<br>");
        formated = "<html><div style ='text-align: center;'>" + formated + "</div></html>";
        info = new JLabel(formated);
        info.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);
        add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);
        add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);

    }

    public static String InfoText(String type) {
        String infoText = "";
        //Conversion info text
        if (type.equals("Conversion Info")) {
            infoText = "This where you can convert values"
                    + "\n Supported Functions:\n"
                    + "Degrees to Raidians: \n"
                    + "Equation: radians = degrees * PI / 180 \n"
                    + "Coming Soon:\n"
                    + "Frequency:\n"
                    + "Equation: f = 1/T\n"
                    + "Period:\n"
                    + "Equation: T =  2 * PI / w";
        } //Motion info text
        else if (type.equals("Motion Info")) {
            infoText = "This where you can calculate Accelleration and Velocity"
                    + "\n Supported Functions:\n"
                    + "Linear Accelleration: \n"
                    + "Equation: a =  (vf - vi) / (tf - ti)\n"
                    + "Coming Soon:\n"
                    + "Angular Accelleration:\n"
                    + "Equation: a = (wf - wi) / (tf - ti)\n"
                    + "Linear Velocity:\n"
                    + "Equation: v = (d/t)";
        } //Work info text
        else if (type.equals("Work and Energy Info")) {
            infoText = "This where you can calculate Work and Energy"
                    + "\n Supported Functions:\n"
                    + "Linear Kinetic Energy: \n"
                    + "Equation: Ek = 0.5*m*v^2\n"
                    + "Coming Soon:\n"
                    + "Linear Momentum:\n"
                    + "Equation: p  = m*v\n"
                    + "Linear Work:\n"
                    + "Equation: W = F*s";
        } //Force Info Text
        else if (type.equals("Force Info")) {
            infoText = "This where you can calculate Force"
                    + "\n Supported Functions:\n"
                    + "Angular Force: \n"
                    + "Equation: F = m*r*w^2\n"
                    + "Coming Soon:\n"
                    + "Linear Force:\n"
                    + "Equation: F = m*a\n"
                    + "Torque:\n"
                    + "Equation: torque = F*r";
        } //App Info Text
        else if (type.equals("App Info")) {
            infoText = "Welcome to the Physics Calculator GUI addition!\n\n"
                    + "We are currently working hard to implement all the functions\n"
                    + "that you enjoyed in the CUI addition.\n"
                    + "Please hold tight while we work on implementing everything!\n\n"
                    + "We currently only have 4 equations ready for use :( BUT\n"
                    + "you can STILL save your data and view it as per last program.\n\n"
                    + "Note: Data is automatically saved to your profile upon each calculation\n\n"
                    //How to use text
                    + "How to use:\n\n"
                    //Equations Info text
                    + "Equations \n"
                    + "Opens a window for you to pick which equation to do.\n"
                    + "When you select which equation to use you will be abe prompted to input the data.\n"
                    + "Once the data has been input click 'solve' and your answer will be shown in a new window.\n\n"
                    //Info information text 
                    + "Info \nProvides information on the equations (also provides formulas for unsupported equations)\n\n"
                    //Saved Data info text
                    + "Saved Data\n"
                    + "Will display a list of all calculations saved\n"
                    + "Ability to manage saved data coming soon!!\n\n"
                    + "Account\n"
                    + "Will take you to window with log out option\n\n"
                    + "App Info\n"
                    + "Will display this information again";

        }
        else if(type.equals("Avaliable")){
            infoText = "Username is avaliable";
        }
        else if(type.equals("Unavaliable")){
            infoText = "Username is taken!!";
        }

        return infoText;
    }
}
