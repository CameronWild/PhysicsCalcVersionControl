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
 * Class for checking password input
 * @author Cam
 */
public class PasswordInputTest {

    private String password;
    private Boolean validation;
    JFrame error;

    public PasswordInputTest(String passwordTest) {

        //If password is good enables continue
        if (inputCheck(passwordTest)) {
            this.setValidation(true);
        } else {
            this.setValidation(false);
        }

    }

    //checks input
    private boolean inputCheck(String passwordCheck) {
        boolean check;
            System.out.println(passwordCheck);
            //if contains a space
            if (passwordCheck.contains(" ")) {
                error = new DisposeableFrames(new ErrorInfoPanel("Password", ""));
                check = false;
            }
            //if has no value
            else if(passwordCheck.length() == 0){
                error = new DisposeableFrames(new ErrorInfoPanel("Password Length", ""));
                check = false;
            }
            // null check
            else if(passwordCheck.equalsIgnoreCase("null")){
                error = new DisposeableFrames(new ErrorInfoPanel("Password Null", ""));
                check = false;
            }
                
            else {
                check = true;
            }

        return check;
    }

    //getter and setters
    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }
}
