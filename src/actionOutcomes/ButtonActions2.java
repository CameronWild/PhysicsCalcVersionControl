/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionOutcomes;

import frames.DisposeableFrames;

import panels.AccellerationPanel;
import panels.AccountPanel;
import panels.AngularForcePanel;

import panels.ComingSoonPanel;
import panels.ConversionEquationsPanel;
import panels.DegreestoRadiansPanel;

import panels.ForceEquationsPanel;
import panels.InfoPanel;
import panels.LinearKineticEnergyPanel;
import panels.MotionEquationsPanel;
import panels.WorkandEnergyEquationsPanel;
import physicscalcappgui.GuiBuilder;

/**
 *
 * @author Cam
 */
public class ButtonActions2 {

    DisposeableFrames disposeableFrame;
    private String type;
    public boolean loggingOut = true;

    public ButtonActions2() {
    }

    public ButtonActions2(String button, String info) {
        switch (button) {
            case "App Info":
                disposeableFrame = new DisposeableFrames(new InfoPanel(button));
                break;
            case "Account":
                disposeableFrame = new DisposeableFrames(new AccountPanel());
                break;
            case "Info":
                disposeableFrame = new DisposeableFrames(new InfoPanel(info));
                break;
            case "Degrees to Radians Converter":
                disposeableFrame = new DisposeableFrames(new DegreestoRadiansPanel());
                break;
            case "Linear Kinetic Energy":
                disposeableFrame = new DisposeableFrames(new LinearKineticEnergyPanel());
                break;
            case "Accelleration":
                disposeableFrame = new DisposeableFrames(new AccellerationPanel());
                break;
            case "Angular Force":
                disposeableFrame = new DisposeableFrames(new AngularForcePanel());
                break;
            case "Log Out":
                System.gc();
                java.awt.Window win[] = java.awt.Window.getWindows();
                for (int i = 0; i < win.length; i++) {
                    win[i].dispose();
                    win[i] = null;
                }
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
                disposeableFrame = new DisposeableFrames(new ComingSoonPanel());
                break;
        }
        switch (info) {
            case "Conversion Eq":
                disposeableFrame = new DisposeableFrames(new ConversionEquationsPanel());
                break;
            case "Force Eq":
                disposeableFrame = new DisposeableFrames(new ForceEquationsPanel());
                break;
            case "Work and Energy Eq":
                disposeableFrame = new DisposeableFrames(new WorkandEnergyEquationsPanel());
                break;
            case "Motion Eq":
                disposeableFrame = new DisposeableFrames(new MotionEquationsPanel());
                break;

        }

    }

    public boolean isLoggingOut() {
        return loggingOut;
    }

    public void setLoggingOut(boolean loggingOut) {
        this.loggingOut = loggingOut;
    }

}
