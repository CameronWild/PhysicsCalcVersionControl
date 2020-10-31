/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;



/**
 * This class checks username input validity
 * @author Cam
 */
public class UsernameInputTest {

    private String username;
    private Boolean validation;

    
    public UsernameInputTest(String usernameTest) {

        //if good enables continue 
        if (inputCheck(usernameTest)) {
            this.setValidation(true);
        } else {
            this.setValidation(false);
        }

    }
    //Checks for correct input
    private boolean inputCheck(String usernameCheck) {
        boolean check = false;
        char[] inputChar = usernameCheck.toCharArray();

        for (char c : inputChar) {
            if ((c > 47 && c < 58) || (c > 64 && c < 91) || (c > 96 && c < 123)) {
                check = true;
            } else {
                check = false;
                break;
            }
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
