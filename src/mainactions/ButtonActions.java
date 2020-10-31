/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainactions;

import database.Values;
import frames.DisposeableFrames;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import panels.AccellerationPanel;
import panels.AccountPanel;
import panels.AngularForcePanel;
import panels.AnswerPanel;
import panels.ComingSoonPanel;
import panels.ConversionEquationsPanel;
import panels.DegreestoRadiansPanel;
import panels.ForceEquationsPanel;
import panels.InfoPanel;
import panels.LinearKineticEnergyPanel;
import panels.MotionEquationsPanel;
import panels.SavedData;
import panels.WorkandEnergyEquationsPanel;

/**
 * This class takes in different actions for JButtons and causes an outcome depending
 * Needs more work.
 * @author Cam
 */
public class ButtonActions {

    DisposeableFrames disposeableFrame;
    private String type;
    Values valueSet = new Values();
    static JFrame degreesFrame, kineticFrame, accellFrame, angForceFrame;
    SolveAndSaveThread save;

    public ButtonActions(String button, String info) {
        
        //Actions resulting from different named buttons
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
                degreesFrame = new DisposeableFrames(new DegreestoRadiansPanel());
                break;
            case "Linear Kinetic Energy":
                kineticFrame = new DisposeableFrames(new LinearKineticEnergyPanel());
                break;
            case "Accelleration":
                accellFrame = new DisposeableFrames(new AccellerationPanel());
                break;
            case "Angular Force":
                angForceFrame = new DisposeableFrames(new AngularForcePanel());
                break;
            case "Log Out":
                //Closes all active windows and brings GUI BUILDER to beginning of loop
                System.gc();
                java.awt.Window win[] = java.awt.Window.getWindows();
                for (int i = 0; i < win.length; i++) {
                    win[i].dispose();
                    win[i] = null;
                }
                break;
                
            //Comming soon buttons
            case "Frequency":
            case "Period":
            case "Linear Momentum":
            case "Linear Work":
            case "Linear Velocity":
            case "Angular Accelleration":
            case "Linear Force":
            case "Torque":
                disposeableFrame = new DisposeableFrames(new ComingSoonPanel());
                break;
                
            //Solve button action
            case "Solve": {
                try {
                    save = new SolveAndSaveThread(info);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ButtonActions.class.getName()).log(Level.SEVERE, null, ex);
                }
                disposeableFrame = new DisposeableFrames(new AnswerPanel());
            }
            break;
            
            //View data button 
            case "View Data":
                //checks if guest attempting to view
                if(!Values.getUsername().equals("guest"))
                    disposeableFrame = new DisposeableFrames(new SavedData());
                else
                    disposeableFrame = new DisposeableFrames(new InfoPanel("Guest"));
        }
        
        //Button actions which all have same button name
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
}
