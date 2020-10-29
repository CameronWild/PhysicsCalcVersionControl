/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cam
 */
public class LinearKineticEnergyPanel extends JPanel {

    JLabel title, equation, prompt1, prompt2;
    JTextField mass, velocity;
    JButton solve;

    public LinearKineticEnergyPanel() {

        title = new JLabel("Linear Kinetic Energy Calculator");
        equation = new JLabel("Equation: Ek = 0.5*m*v^2");
        prompt1 = new JLabel("Mass:");
        prompt2 = new JLabel("Velocity:");

        //Textfield
        velocity = new JTextField();
        velocity.setPreferredSize(new Dimension(100, 19));
        mass = new JTextField();
        mass.setPreferredSize(new Dimension(100, 19));

        //Solve Button
        solve = new JButton("Solve");

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(equation, gbc);
        add(prompt1, gbc);
        add(velocity, gbc);
        add(prompt2, gbc);
        add(mass, gbc);
        add(solve, gbc);
        setPreferredSize(new Dimension(300, 200));
    }
}
