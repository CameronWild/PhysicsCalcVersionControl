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
import javax.xml.transform.Source;
import mainactions.ButtonActions;
import unittesting.ValueInputTest;

/**
 *
 * @author Cam
 */
public class AngularForcePanel extends JPanel {

    JLabel title, equation, prompt1, prompt2, prompt3;
    JTextField mass, angularVelocity, radius;
    JButton solve;
    ValueInputTest massTest;
    ValueInputTest radiusTest;
    ValueInputTest velTest;

    public AngularForcePanel() {

        title = new JLabel("Angular Force Calculator");
        equation = new JLabel("Equation: F = m*r*w^2");
        prompt1 = new JLabel("Mass:");
        prompt2 = new JLabel("Radius:");
        prompt3 = new JLabel("Angular Velocity:");

        //Textfield
        angularVelocity = new JTextField();
        angularVelocity.setPreferredSize(new Dimension(100, 19));
        angularVelocity.addActionListener(new ValueListener());
        angularVelocity.setActionCommand("Angular Velocity");

        mass = new JTextField();
        mass.setPreferredSize(new Dimension(100, 19));
        mass.addActionListener(new ValueListener());
        mass.setActionCommand("Mass");

        radius = new JTextField();
        radius.setPreferredSize(new Dimension(100, 19));
        radius.addActionListener(new ValueListener());
        radius.setActionCommand("Radius");

        //Solve Button
        solve = new JButton("Solve");
        solve.setActionCommand("Angular Force");
        solve.addActionListener(new SolveListener());

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(equation, gbc);
        add(prompt1, gbc);
        add(mass, gbc);
        add(prompt2, gbc);
        add(radius, gbc);
        add(prompt3, gbc);
        add(angularVelocity, gbc);
        add(solve, gbc);
        setPreferredSize(new Dimension(300, 200));
    }

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
                    massTest = new ValueInputTest(mass.getText(), "Mass");

                    if (massTest.isValidation()) {
                        Values.setMass(Double.parseDouble(mass.getText()));
                        radiusTest = new ValueInputTest(radius.getText(), "Radius");

                        if (radiusTest.isValidation()) {
                            Values.setRadius(Double.parseDouble(radius.getText()));
                            velTest = new ValueInputTest(angularVelocity.getText(), "Angular Velocity");

                            if (velTest.isValidation()) {
                                Values.setAngVelocity(Double.parseDouble(angularVelocity.getText()));
                                //Having issue with wait. Witht time left will leave as it
                                solveRun.start();
                            }
                        }
                    }
                }

            });

            test.start();
        }
    }

    private class ValueListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = e.getActionCommand();
            JTextField box = (JTextField) e.getSource();
            massTest = new ValueInputTest(box.getText(), name);

            if (massTest.isValidation()) {
                switch (name) {
                    case "Mass":
                        Values.setMass(Double.parseDouble(box.getText()));
                        break;
                    case "Radius":
                        Values.setRadius(Double.parseDouble(box.getText()));
                        break;
                    case "Angular Velocity":
                        Values.setAngVelocity(Double.parseDouble(box.getText()));
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
