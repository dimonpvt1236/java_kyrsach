/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import springmodel.Cart;
import springmodel.Product;
import util.HibernateUtil;
/**
 *
 * @author Starik
 */
public class HelloController implements Controller {
    private String viewName;
    protected final Log logger = LogFactory.getLog(getClass()); 
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException { 
        if (request.getParameter("logout")!=null) {
            
            String logout = (String)request.getParameter("logout");  
            if ("1".equals(logout)) {
                request.getSession().setAttribute("loged", false);
                request.getSession().setAttribute("user_login", null); 
                request.getSession().setAttribute("user_id", null);
                request.getSession().setAttribute("user_name", null);
                request.getSession().setAttribute("menu", false);
            }
            
        }          
        
        Session session = HibernateUtil.getSession();
        List<List> mass = new  ArrayList<List>();
        List<Product> prod = (List<Product>) session.createSQLQuery("select * from product").addEntity(Product.class).list();
        mass.add(0, prod);
        List<Cart>  cart = (List<Cart>)request.getSession().getAttribute("cartProd");
        if (cart!=null) {
               mass.add(1, cart); 
        }
        session.close();
        return new ModelAndView("hello", "mass", mass);
    } 
     
    public void setviewName(String viewName){
        this.viewName = viewName;
    }
    public String getviewName(){
        return this.viewName;
    }
}
