/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

import frames.DisposeableFrames;
import javax.swing.JFrame;
import panels.ErrorInfoPanel;

/**
 *
 * @author Cam
 */
public class PasswordInputTest {

    private String password;
    private Boolean validation;
    JFrame error;

    public PasswordInputTest(String passwordTest) {

        if (inputCheck(passwordTest)) {
            this.setValidation(true);
        } else {
            this.setValidation(false);
        }

    }

    private boolean inputCheck(String passwordCheck) {
        boolean check;
            System.out.println(passwordCheck);
            if (passwordCheck.contains(" ")) {
                error = new DisposeableFrames(new ErrorInfoPanel("Password"));
                check = false;
            }
            else if(passwordCheck.length() == 0){
                error = new DisposeableFrames(new ErrorInfoPanel("Password Length"));
                check = false;
            }
                
            else {
                check = true;
            }

        return check;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }
}
