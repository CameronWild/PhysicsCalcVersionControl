/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReuseableActionListeners;

import actionOutcomes.ButtonActions2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import physicscalcappgui.GuiBuilder.ButtonActions;

/**
 *
 * @author Cam
 */
public class ButtonListener implements ActionListener {

    ButtonActions action;
    private String buttonText = "";
    private String info = "";

    

    public ButtonListener() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = null;
        //if source is a button assing JButton casted source to it
        if (source instanceof JButton) {
            button = (JButton) source;
        }
        //checks for assigned value
        if (button != null) {
            setButtonText(button.getText());  //assings button text
            setInfo(e.getActionCommand());    //gets button action command
        }
        
        action = new ButtonActions(getButtonText(), getInfo());
      

    }


    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
}
