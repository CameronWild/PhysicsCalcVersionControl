/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physicscalcappgui;

import frames.DisposeableFrames;
import frames.ExitFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import panels.AccountManagementInfoPanel;
import panels.CalculatorPanelMain;
import panels.ConversionOptionsPanel;
import panels.ErrorInfoPanel;
import panels.ForceOptionsPanel;
import panels.InfoPanel;
import panels.LogInPanel;
import panels.MotionEquationOptionsPanel;
import panels.SavedDataOptionPanel;
import panels.SignUpPanel;
import panels.WelcomePanel;
import panels.WorkEnergyOptionsPanel;
import unittesting.PasswordMatchTest;

/**
 *
 * @author Cam
 */
public class GuiBuilder extends JFrame {

    JFrame welcomeFrame;
    JFrame logIn;
    JFrame signUp;
    JFrame main;
    JFrame mid;
    JFrame info;
    JFrame error;
    JLabel title;
    JLabel note;
    String action;
    public String username = "";
    public String password = "";
    public static String url = "jdbc:derby:CalculatorDB; create=true";
    public static Connection conn;
    public static String user = "root";
    public static String pass = "010101";
    boolean loggedIn = false;
    PasswordMatchTest passwordTest;
    boolean hold = true;
    boolean close = true;

    WelcomePanel welcomePanel = new WelcomePanel();
    LogInPanel logInPanel = new LogInPanel();
    SignUpPanel signUpPanel = new SignUpPanel();
    InfoPanel appInfo = new InfoPanel("App Info");
    ConversionOptionsPanel convOpt = new ConversionOptionsPanel();
    MotionEquationOptionsPanel motOpt = new MotionEquationOptionsPanel();
    WorkEnergyOptionsPanel workOpt = new WorkEnergyOptionsPanel();
    ForceOptionsPanel forceOpt = new ForceOptionsPanel();
    SavedDataOptionPanel saveDataOpt = new SavedDataOptionPanel();
    AccountManagementInfoPanel accOpt = new AccountManagementInfoPanel();
    CalculatorPanelMain mainPanel = new CalculatorPanelMain(convOpt, motOpt, workOpt, forceOpt, saveDataOpt, accOpt);

    public GuiBuilder() throws InterruptedException {

        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        while (close) {
            //Opens Welcome Frame first
            welcomeFrame = new ExitFrame(welcomePanel);

            //Holds for action
            while (welcomePanel.isState()) {
                Thread.sleep(1000);  //checks for change in state (action) every 1000 mili sec
            }

            //Assigns decision
            action = welcomePanel.getButtonText();
            System.out.println(action);

            //closes welcome frame
            welcomeFrame.dispose();
            welcomePanel.setState(true);
            //If decision is log in opens log in window
            switch (action) {
                case "Log In":
                    logIn = new ExitFrame(logInPanel);
                    logIn.toFront();
                    while (hold) {
                        while (logInPanel.isState()) {
                            Thread.sleep(1000);
                        }
                        username = logInPanel.getUsernameInput();
                        password = logInPanel.getPasswordInput();

                        passwordTest = new PasswordMatchTest(username, password);

                        if (passwordTest.isValidation()) {
                            hold = false;
                        } else {
                            error = new DisposeableFrames(new ErrorInfoPanel("Incorrect Password"));
                            hold = true;
                        }
                        logInPanel.setState(true);
                    }
                    hold = true;
                    logIn.dispose();
                    break;
                case "Guest":
                    username = "guest";
                    password = "guest";
                    break;
                case "Sign Up":
                    signUp = new ExitFrame(signUpPanel);
                    signUp.toFront();
                    while (signUpPanel.isState()) {
                        Thread.sleep(1000);
                    }
                    username = signUpPanel.getUsernameInput();
                    password = signUpPanel.getPasswordInput();
                    System.out.println(username);
                    System.out.println(password);
                    //if unit test passes
                    signUpPanel.setState(true);
                    signUp.dispose();
                    break;
                default:
                    break;
            }

            //Build Main Window
            main = new ExitFrame(mainPanel);
            while (main.isVisible()) {
                Thread.sleep(1000);
            }
            System.out.println("testend");
        }

    }
    
    public static class ButtonActions {

    DisposeableFrames disposeableFrame;
    private String type;
    public boolean loggingOut = true;

    public ButtonActions() {
    }

    public ButtonActions(String button, String info) {
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

}
