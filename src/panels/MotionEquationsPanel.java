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
import javax.swing.SwingConstants;

/**
 *
 * @author Cam
 */
public class MotionEquationsPanel extends JPanel{
    
    JLabel title;
    JButton accelleration, linearVelocity, angularAccelleration;

    public MotionEquationsPanel() {

        title = new JLabel("Motion Equations:");
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //Accelleration
        accelleration = new JButton("Accelleration");
        accelleration.setPreferredSize(new Dimension(210, 30));

        //Linear Velocity
        linearVelocity = new JButton("Linear Velocity");
        linearVelocity.setPreferredSize(new Dimension(210, 30));

        //Angular Accelleration
        angularAccelleration = new JButton("Angular Accelleration");
        angularAccelleration.setPreferredSize(new Dimension(210, 30));

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(accelleration, gbc);
        add(angularAccelleration, gbc);
        add(linearVelocity, gbc);
    }
}
