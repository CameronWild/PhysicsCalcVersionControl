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
 *
 * @author Cam
 */
public class LinearKineticEnergyPanel extends JPanel {

    JLabel title, equation, prompt1, prompt2;
    JTextField mass, velocity;
    JButton solve;
    ValueInputTest massTest, velocityTest;

    public LinearKineticEnergyPanel() {

        title = new JLabel("Linear Kinetic Energy Calculator");
        equation = new JLabel("Equation: Ek = 0.5*m*v^2");
        prompt1 = new JLabel("Mass:");
        prompt2 = new JLabel("Velocity:");

        //Textfield
        velocity = new JTextField();
        velocity.setPreferredSize(new Dimension(100, 19));
        velocity.addActionListener(new ValueListener());
        velocity.setActionCommand("Velocity");

        mass = new JTextField();
        mass.setPreferredSize(new Dimension(100, 19));
        mass.addActionListener(new ValueListener());
        mass.setActionCommand("Mass");

        //Solve Button
        solve = new JButton("Solve");
        solve.setActionCommand("Kinetic Energy");
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
        add(velocity, gbc);
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
                        velocityTest = new ValueInputTest(velocity.getText(), "Velocity");

                        if (velocityTest.isValidation()) {
                            Values.setVelocity(Double.parseDouble(velocity.getText()));
                            //Having issue with wait. Witht time left will leave as it
                            solveRun.start();
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
            System.out.println(name);

            if (massTest.isValidation()) {
                switch (name) {
                    case "Mass":
                        Values.setMass(Double.parseDouble(box.getText()));
                        System.out.println(Values.getMass());
                        System.out.println("h");
                        break;
                    case "Velocity":
                        Values.setVelocity(Double.parseDouble(box.getText()));
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
