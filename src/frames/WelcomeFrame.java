/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.JFrame;
import panels.AccountManagementInfoPanel;
import panels.CalculatorPanelMain;
import panels.ConversionOptionsPanel;
import panels.InfoPanel;
import panels.LogInPanel;
import panels.SavedDataOptionPanel;
import panels.SignUpPanel;
import panels.WelcomePanel;

/**
 *
 * @author Cam
 */
public class WelcomeFrame extends JFrame {

    JFrame frame;

    public WelcomeFrame(String type) {

        frame = new JFrame();

        if (type.equals("Welcome")) {
            getContentPane().add(new WelcomePanel());
        } else if (type.equals("Test1")) {
            getContentPane().add(new CalculatorPanelMain());
        }

        //frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
