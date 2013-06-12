/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springmodel;

import java.io.Serializable;
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
@Table( name = "config")
public class Config implements Serializable {
    protected Integer id;
    protected String name;
    protected String val;
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
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="val")
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
    
    
    
}
