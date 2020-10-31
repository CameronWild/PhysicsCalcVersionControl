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
public class AccountPanel extends JPanel {

    JLabel title;
    JButton logOut;

    public AccountPanel() {

        title = new JLabel("Account Settings:");
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //LogOut
        logOut = new JButton("Log Out");
        logOut.setPreferredSize(new Dimension(210, 30));
        logOut.addActionListener(new ButtonListener());
        //Layout organisation
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //Add abd align componenets
        add(title, gbc);
        add(logOut, gbc);

    }

}
