/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

import frames.DisposeableFrames;
import panels.ErrorInfoPanel;

/**
 * Checks number input in calculation text fields
 * @author Cam
 */
public class ValueInputTest {

    private boolean validation;
    DisposeableFrames error;
    
    //if true continues
    public ValueInputTest(String valueInput, String eq) {

        if (inputCheck(valueInput, eq)) {
            this.setValidation(true);
        } else {
            this.setValidation(false);
        }

    }
    
    //checks input
    private boolean inputCheck(String valueCheck, String equation) {

        try {
            Double.parseDouble(valueCheck);
            return true;
        } catch (NumberFormatException e) {
            //checks for spaces
            if(valueCheck.contains(" ")){
                error = new DisposeableFrames(new ErrorInfoPanel("Input Space",equation));
            }
            //checks for no input
            else if(valueCheck.length() == 0){
                error = new DisposeableFrames(new ErrorInfoPanel("No Input", equation));
            }
            else
                error = new DisposeableFrames(new ErrorInfoPanel("Not Number", equation));
            return false;
        }
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

}
