/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionListeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;

/**
 *
 * @author Cam
 */
public class TextFieldClearListener implements FocusListener {

    private final JTextField textField;
    private String text;

    public TextFieldClearListener(JTextField field) {
        this.textField = field;
        this.text = field.getText();
    }

    @Override
    public void focusGained(FocusEvent e) {
        textField.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.textField.getText().equals("")) {
            textField.setText(text);
        }
    }
}
