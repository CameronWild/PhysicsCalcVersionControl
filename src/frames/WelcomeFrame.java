/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import panels.WelcomePanel;

/**
 *
 * @author Cam
 */
public class WelcomeFrame extends AbstractFrame {

    public WelcomeFrame() {
        super();
        this.frameWidth = screenWidth / 4;
        this.frameHeight = 2 * screenHeight / 3;
        JFrame welcomeFrame;
        JLabel welcomeMessage, options;
        JButton logButton, guestButton, signUpButton;
        WelcomeImage image = new WelcomeImage();
        welcomeFrame = new JFrame("Physics Calculator Application");

        //Welcome Frame
        welcomeFrame.setSize(frameWidth, frameHeight);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Welcome Message 
        welcomeMessage = new JLabel("Welcome to the Physics Calculator Application");
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessage.setFont(new Font("Helvetica", Font.BOLD, 15));

        //Options Label Assignment
        options = new JLabel("Please select from the following:");
        options.setHorizontalAlignment(SwingConstants.CENTER);

        //Button Assignment
        logButton = new JButton("Log In");
        guestButton = new JButton("Guest");
        signUpButton = new JButton("Sign Up");

        //Layout with assistance/guidance from GUI Builder so will need to go over few more times
        //as to know what is really going on 
        GroupLayout layout = new GroupLayout(welcomeFrame.getContentPane());
        welcomeFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(logButton)
                            .addComponent(guestButton)
                            .addComponent(signUpButton))
                        .addContainerGap(165, Short.MAX_VALUE))
                .addComponent(welcomeMessage)
                .addComponent(options)
        );


        welcomeFrame.add(group);
        //layout.setHorizontalGroup(group);

        //welcomeFrame.getContentPane().add(image);
        image.setOpaque(true);

        welcomeFrame.setVisible(true);

    }

    public class WelcomeImage extends JComponent {

        private Image image;

        @Override
        public void paintComponent(Graphics g) {

            image = new ImageIcon("WelcomeImage.jpg").getImage();

            g.drawImage(image, 0, 0, frameWidth, frameHeight / 2, null);

        }
    }
}
