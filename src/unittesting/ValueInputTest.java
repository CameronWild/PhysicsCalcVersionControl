/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

/**
 *
 * @author Cam
 */
public class ValueInputTest {

    private Double value;
    private Boolean validation;

    public ValueInputTest(String valueInput) {

        if (inputCheck(valueInput)) {
            this.setValidation(true);
        } else {
            this.setValidation(false);
        }

    }

    private boolean inputCheck(String valueCheck) {

        try {
            Double.parseDouble(valueCheck);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

}
