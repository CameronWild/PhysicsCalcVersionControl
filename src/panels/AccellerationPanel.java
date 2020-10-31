/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import database.Values;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mainactions.ButtonActions;
import unittesting.ValueInputTest;

/**
 * Panel class for Acceleration calculation. Contains type in acceleration but
 * don't have time to fix it.
 * @author Cam
 */
public class AccellerationPanel extends JPanel {

    JLabel title, equation, prompt1, prompt2, prompt3, prompt4;
    JTextField finalTime, finalVelocity, initialTime, initialVelocity;
    JButton solve;
    public double velInitial, velFinal, timeInitial, timeFinal;
    ValueInputTest velITest, velFTest, timeITest, timeFTest;

    public AccellerationPanel() {

        title = new JLabel("Accelleration Calculator");
        equation = new JLabel("Equation: a =  (vf - vi) / (tf - ti)");
        prompt1 = new JLabel("Final Velocity:");
        prompt2 = new JLabel("Initial Velocity:");
        prompt3 = new JLabel("Final Time:");
        prompt4 = new JLabel("Initial Time:");

        //Textfield
        finalVelocity = new JTextField();
        finalVelocity.setPreferredSize(new Dimension(100, 19));
        finalVelocity.addActionListener(new ValueListener());
        finalVelocity.setActionCommand("Final Velocity");

        finalTime = new JTextField();
        finalTime.setPreferredSize(new Dimension(100, 19));
        finalTime.addActionListener(new ValueListener());
        finalTime.setActionCommand("Final Time");

        initialVelocity = new JTextField();
        initialVelocity.setPreferredSize(new Dimension(100, 19));
        initialVelocity.addActionListener(new ValueListener());
        initialVelocity.setActionCommand("Initial Time");

        initialTime = new JTextField();
        initialTime.setPreferredSize(new Dimension(100, 19));
        initialTime.addActionListener(new ValueListener());
        initialTime.setActionCommand("Initial Time");

        //Solve Button
        solve = new JButton("Solve");
        solve.setActionCommand("Accelleration");
        solve.addActionListener(new SolveListener());

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add and align componenets
        add(title, gbc);
        add(equation, gbc);
        add(prompt1, gbc);
        add(finalVelocity, gbc);
        add(prompt2, gbc);
        add(initialVelocity, gbc);
        add(prompt3, gbc);
        add(finalTime, gbc);
        add(prompt4, gbc);
        add(initialTime, gbc);
        add(solve, gbc);
        setPreferredSize(new Dimension(300, 200));
    }

    // Solve button listener
    private class SolveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();

            Thread solveRun = new Thread(new Runnable() {
                @Override
                public synchronized void run() {
                    ButtonActions action = new ButtonActions(source.getText(), source.getActionCommand());
                }
            });
            Thread test = new Thread(new Runnable() {
                @Override
                public synchronized void run() {
                    velITest = new ValueInputTest(initialVelocity.getText(), "Initial Velocity");

                    if (velITest.isValidation()) {
                        Values.setInitalVel(Double.parseDouble(initialVelocity.getText()));
                        velFTest = new ValueInputTest(finalVelocity.getText(), "Final Velocity");

                        if (velFTest.isValidation()) {
                            Values.setFinalVel(Double.parseDouble(finalVelocity.getText()));
                            timeITest = new ValueInputTest(initialTime.getText(), "Iniital Time");

                            if (timeITest.isValidation()) {
                                Values.setInitialTime(Double.parseDouble(initialTime.getText()));
                                timeFTest = new ValueInputTest(finalTime.getText(), "Final Time");

                                if (timeFTest.isValidation()) {
                                    Values.setFinalTime(Double.parseDouble(finalTime.getText()));
                                    //Having issue with wait. Witht time left will leave as it
                                    solveRun.start();
                                }
                            }
                        }
                    }
                }

            });

            test.start();
        }
    }

    // Text field enter listner
    private class ValueListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = e.getActionCommand();
            JTextField box = (JTextField) e.getSource();
            velITest = new ValueInputTest(box.getText(), name);

            if (velITest.isValidation()) {
                switch (name) {
                    case "Initial Velocity":
                        Values.setInitalVel(Double.parseDouble(box.getText()));
                        break;
                    case "Final Velocity":
                        Values.setFinalTime(Double.parseDouble(box.getText()));
                        break;
                    case "Inital Time":
                        Values.setInitialTime(Double.parseDouble(box.getText()));
                        break;
                    case "Final Time":
                        Values.setFinalTime(Double.parseDouble(box.getText()));
                        break;

                    default:
                        break;
                }
            }
        }
    }

    //Getter and setters
    public double getVelInitial() {
        return velInitial;
    }

    public void setVelInitial(double velInitial) {
        this.velInitial = velInitial;
    }

    public double getVelFinal() {
        return velFinal;
    }

    public void setVelFinal(double velFinal) {
        this.velFinal = velFinal;
    }

    public double getTimeInitial() {
        return timeInitial;
    }

    public void setTimeInitial(double timeInitial) {
        this.timeInitial = timeInitial;
    }

    public double getTimeFinal() {
        return timeFinal;
    }

    public void setTimeFinal(double timeFinal) {
        this.timeFinal = timeFinal;
    }

}
