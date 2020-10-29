/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionOutcomes;

import frames.DisposeableFrames;
import frames.ExitFrame;
import javax.swing.JTextField;

/**
 *
 * @author Cam
 */
public class ButtonActions {

    ExitFrame exitFrame;
    DisposeableFrames disposeableFrame;

    public ButtonActions(String button) {

        switch (button) {
            case "Log In":
            case "Sign Up":
            case "App Info":
            case "Account":
            case "Conversion Eq":
            case "Force Eq":
            case "Work and Energy Eq":
            case "Motion Eq":
            case "Info":
            case "Degrees to Radians Converter":
            case "Linear Kinetic Energy":
            case "Accelleration":
            case "Angular Force":
                disposeableFrame = new DisposeableFrames(button);
                break;
            case "Guest":
                disposeableFrame = new DisposeableFrames("Calculator Main");
                break;
            case "Frequency":
            case "Period":
            case "Linear Momentum":
            case "Linear Work":
            case "Linear Velocity":
            case "Angular Accelleration":
            case "Linear Force":
            case "Torque":
                //case "":
                disposeableFrame = new DisposeableFrames("Comming Soon");
                break;

            // case "":
            //case "":
            //case "":
        }

    }

    public String getText(JTextField test) {
return "sfs";
    }

    public ButtonActions(String button, String info) {

        disposeableFrame = new DisposeableFrames(button, info);
    }

}
