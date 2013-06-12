/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springmodel;

/**
 *
 * @author Starik
 */
public class OrdersTabs extends Orders {
    protected String username;
    protected Double total;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
