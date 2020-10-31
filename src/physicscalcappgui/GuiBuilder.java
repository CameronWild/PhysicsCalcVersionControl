/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physicscalcappgui;

import database.Values;
import frames.DisposeableFrames;
import frames.ExitFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import panels.CalculatorPanelMain;
import panels.ErrorInfoPanel;
import panels.LogInPanel;
import panels.SignUpPanel;
import panels.WelcomePanel;
import unittesting.PasswordMatchTest;

/**
 * Main class for carry out program. Will loop until user exits program.
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
    CalculatorPanelMain mainPanel = new CalculatorPanelMain();

    public GuiBuilder() throws InterruptedException {
        //not sure if needed
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        
        //beginningg of program
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
                        Values.setUsername(logInPanel.getUsernameInput());
                        password = logInPanel.getPasswordInput();

                        passwordTest = new PasswordMatchTest(Values.getUsername(), password);

                        if (passwordTest.isValidation()) {
                            hold = false;
                        } else {
                            error = new DisposeableFrames(new ErrorInfoPanel("Incorrect Password", ""));
                            hold = true;
                        }
                        logInPanel.setState(true);
                        logInPanel.password.setText("");
                    }
                    logInPanel.username.setText("");
                    hold = true;
                    logIn.dispose();
                    break;
                    
                //If user selects guest
                case "Guest":
                    Values.setUsername("guest");
                    password = "guest";
                    break;
                    
                //If user slects sign up
                case "Sign Up":
                    signUp = new ExitFrame(signUpPanel);
                    signUp.toFront();
                    while (signUpPanel.isState()) {
                        Thread.sleep(1000);
                    }
                    Values.setUsername(signUpPanel.getUsernameInput());
                    password = signUpPanel.getPasswordInput();
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
            System.out.println("Logged Out");

        }

    }

}

