/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import reuseableactionlistener.ButtonListener;
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
public class WorkandEnergyEquationsPanel extends JPanel {

    JLabel title;
    JButton linearKineticEnergy, linearMomentum, linearWork;

    public WorkandEnergyEquationsPanel() {

        title = new JLabel("Work and Energy Equations:");
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //Linear Kinetic Energy
        linearKineticEnergy = new JButton("Linear Kinetic Energy");
        linearKineticEnergy.setPreferredSize(new Dimension(210, 30));
        linearKineticEnergy.addActionListener(new ButtonListener());

        //Linear Momentum
        linearMomentum = new JButton("Linear Momentum");
        linearMomentum.setPreferredSize(new Dimension(210, 30));
        linearMomentum.addActionListener(new ButtonListener());

        //Linear Work
        linearWork = new JButton("Linear Work");
        linearWork.setPreferredSize(new Dimension(210, 30));
        linearWork.addActionListener(new ButtonListener());

        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(linearKineticEnergy, gbc);
        add(linearMomentum, gbc);
        add(linearWork, gbc);
    }
}
