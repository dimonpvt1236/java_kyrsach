/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springmodel;

/**
 *
 * @author Starik
 */
public class UserRegister extends User {
    private String confirm_pass;

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }
    
}
