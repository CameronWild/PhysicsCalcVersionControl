/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReuseableActionListeners;

import actionOutcomes.ButtonActions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import panels.ConversionOptionsPanel;

/**
 *
 * @author Cam
 */
public class ButtonListener implements ActionListener {

    ButtonActions action;
    String usernameInput;
    String passwordInput;

    public ButtonListener() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = null;
        String buttonText = "";
        String info = "";

        //if source is a button assing JButton casted source to it
        if (source instanceof JButton) {
            button = (JButton) source;
        }
        //checks for assigned value
        if (button != null) {
            buttonText = button.getText();  //assings button text
            info = e.getActionCommand();    //gets button action command

            //checks action command
            if (info.equals("Conversion Info")) {
                action = new ButtonActions(buttonText, info);
            } else if (info.equals("Motion Info")) {
                action = new ButtonActions(buttonText, info);
            } else if (info.equals("Work and Energy Info")) {
                action = new ButtonActions(buttonText, info);
            } else if (info.equals("Force Info")) {
                action = new ButtonActions(buttonText, info);
            } else if (info.equals("Conversion Eq")) {
                action = new ButtonActions(info);
            } else if (info.equals("Motion Eq")) {
                action = new ButtonActions(info);
            } else if (info.equals("Work and Energy Eq")) {
                action = new ButtonActions(info);
            } else if (info.equals("Force Eq")) {
                action = new ButtonActions(info);
            } else {
                action = new ButtonActions(buttonText);
            }
            
            
        }
//        if (e.getActionCommand().equals("Conversion Info")) {
//            buttonText = "test";
//            action = new ButtonActions(buttonText);
//        }

        // NEED ERROR HANDLING try catch
    }
        public ButtonListener(JTextField username, JTextField password){
        super();
        username.setText(usernameInput);
        password.setText(passwordInput);
        
            System.out.println(usernameInput);
            System.out.println(passwordInput);
            
            //actionPerformed(e);
    }
}

