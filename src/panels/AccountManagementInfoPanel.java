/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import ReuseableActionListeners.ButtonListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Cam
 */
public class AccountManagementInfoPanel extends JPanel{
        JLabel title;
    JButton info, account;
    
    public AccountManagementInfoPanel() {
        
        setLayout(new BorderLayout());
        
        title = new JLabel("Account Management and App Info:");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Info button
        info = new JButton("App Info");
        info.addActionListener(new ButtonListener());
        
        //Account button
        account = new JButton("Account");
        account.addActionListener(new ButtonListener());
        
        add(title, BorderLayout.PAGE_START);
        add(info, BorderLayout.EAST);
        add(account,BorderLayout.WEST);
        
        setPreferredSize(new Dimension(200,50));
    }
}
