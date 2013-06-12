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
@Table( name = "product")
public class Product implements Serializable {
    
    private Integer id;
    private String name;
    private String description;
    private String image;
    private Double price;   
    private Integer qty;
    
    public Product(){
         name = null;
     }
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}
    
    @Column(name= "name")
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    @Column(name= "description")
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
    
    @Column(name= "qty")
    public Integer getQty(){return qty;}
    public void setQty(Integer qty){this.qty = qty;}
    
    @Column(name= "image")
    public String getImage(){return image;}
    public void setImage(String image){this.image = image;}
    
    @Column(name= "price")
    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price = price;}
   
}
