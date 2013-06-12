/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;
import springmodel.Product;
import util.HibernateUtil;

/**
 *
 * @author Starik
 */
public class AdminProductsController implements Controller {
    private String viewName;
    protected final Log logger = LogFactory.getLog(getClass()); 
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException { 
        if (request.getSession().getAttribute("user_login")==null || !"admin".equals(request.getSession().getAttribute("user_login")) ) {
            return new ModelAndView(new RedirectView("login.htm"));
        }
        if (request.getParameter("delete")!=null && request.getParameter("id")!=null) {
            if ("1".equals(request.getParameter("delete"))) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                //session.createQuery("delete from product where id = "+Integer.parseInt(request.getParameter("id"))+" limit 1");
                Product prod = new Product();
                prod.setId(Integer.parseInt(request.getParameter("id")));
                session.delete(prod);
                session.getTransaction().commit();
                session.close();
            }
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Product> products = session.createSQLQuery("select * from product ").addEntity(Product.class).list();
        
        
        session.close();
        request.getSession().setAttribute("products", products);
        return new ModelAndView("adminproducts");
    } 
     
    public void setviewName(String viewName){
        this.viewName = viewName;
    }
    public String getviewName(){
        return this.viewName;
    }  
}
