/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import database.Values;
import frames.DisposeableFrames;
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
 *
 * @author Cam
 */
public class DegreestoRadiansPanel extends JPanel {

    JLabel title, equation, prompt;
    JTextField degrees;
    JButton solve;
    public Double degreesValue = 0.0;
    ValueInputTest inputTest;
    DisposeableFrames error;
    String fieldname;
    boolean inputWait = true;

    public DegreestoRadiansPanel() {

        title = new JLabel("Degrees to Radians Converter");
        equation = new JLabel("Equation: Degrees * PI/180");
        prompt = new JLabel("Degrees:");

        //Degrees Textfield
        degrees = new JTextField();
        degrees.setPreferredSize(new Dimension(100, 19));
        degrees.addActionListener(new ValueListener());

        //Solve Button
        solve = new JButton("Solve");
        solve.setActionCommand("Degrees");
        solve.addActionListener(new SolveListener());

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(equation, gbc);
        add(prompt, gbc);
        add(degrees, gbc);
        add(solve, gbc);
        setPreferredSize(new Dimension(300, 200));
    }

    private class ValueListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            inputTest = new ValueInputTest(degrees.getText(), "Degrees");

            if (inputTest.isValidation()) {
                Values.setDegrees(Double.parseDouble(degrees.getText()));
            }
        }

    }

    private class SolveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JButton source = (JButton)e.getSource();
            
            Thread solveRun = new Thread(new Runnable() {
                @Override
                public synchronized void run() {

                    ButtonActions action = new ButtonActions(source.getText() , source.getActionCommand());

                }
            });
            Thread test = new Thread(new Runnable() {
                @Override
                public synchronized void run() {
                    inputTest = new ValueInputTest(degrees.getText(), "Degrees");

                    if (inputTest.isValidation()) {
                        Values.setDegrees(Double.parseDouble(degrees.getText()));
                        System.out.println(Values.getDegrees());
                        
                        //Having issue with wait. Witht time left will leave as it
                        solveRun.start();
                    }
                }
            });

            test.start();
        }

    }
}
