/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Starik
 */
@Entity
@Table( name = "order_product")
public class OrderProduct {
    private Integer id;
    private Integer ordernumber;
    private Integer prod_id;
    private Integer prod_qty;
    private Double prod_price;   
    private String prod_name;
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="ordernumber")
    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }
    @Column(name="prod_id")
    public Integer getProd_id() {
        return prod_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }
    @Column(name="prod_qty")
    public Integer getProd_qty() {
        return prod_qty;
    }

    public void setProd_qty(Integer prod_qty) {
        this.prod_qty = prod_qty;
    }
    @Column(name="prod_price")
    public Double getProd_price() {
        return prod_price;
    }

    public void setProd_price(Double prod_price) {
        this.prod_price = prod_price;
    }
    @Column(name="prod_name")
    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }
    
    
}
