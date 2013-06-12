/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
public class CartController implements Controller {
    private String viewName;
    protected final Log logger = LogFactory.getLog(getClass()); 
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException { 
    
//        
//    object = (Object)request.getSession().getAttribute("nameAttribute")           
      Cart prod = new Cart();
      // добавление элементов вкорзину
      if (request.getParameter("qty")!=null && request.getParameter("id")!=null) {
          prod.setQty(Integer.parseInt(request.getParameter("qty")));      
          prod.setId(Integer.parseInt(request.getParameter("id")));
      
            String id = prod.getId().toString();
            Session session = HibernateUtil.getSession();
            List<Product> product = (List<Product>) session.createSQLQuery("select * from product where id = "+id).addEntity(Product.class).list();
            session.close();
            prod.setName(product.get(0).getName());
            prod.setPrice(product.get(0).getPrice());
            if (request.getSession().getAttribute("cartProd")!=null) {
                List<Cart>  cart = (List<Cart>) request.getSession().getAttribute("cartProd");
                boolean fg = false; 
                for (Iterator<Cart> it = cart.iterator(); it.hasNext();) {
                     Cart pr = it.next();
                     if (pr.getId()== prod.getId()) {
                         pr.setQty(prod.getQty());
                         fg = true;
                         break;
                     }    
                }
                if (!fg) {
                    cart.add(prod);
                }
                request.getSession().setAttribute("cartProd", cart);
                request.getSession().setAttribute("flag", true);
            }
            else {
                List<Cart>  cart = new ArrayList();
                cart.add(prod);
                request.getSession().setAttribute("cartProd", cart);
                request.getSession().setAttribute("flag", true);
            }
            // удаление из корзины если элемент последнийустанавливаем флаг в false
      } if (request.getParameter("delete")!=null && request.getSession().getAttribute("cartProd")!=null) {
          List<Cart>  cart = (List<Cart>) request.getSession().getAttribute("cartProd");
          Integer del = Integer.parseInt(request.getParameter("delete"));
          for (Iterator<Cart> it = cart.iterator(); it.hasNext();) {
              Cart pr = it.next();
              if (pr.getId()== del) {
                  it.remove();                  
                  break;
              }    
          }
          if (cart.isEmpty()) {
              request.getSession().setAttribute("cartProd", null);
              request.getSession().setAttribute("flag", false); 
          } else {
              request.getSession().setAttribute("cartProd", cart);
              request.getSession().setAttribute("flag", true); 
          }           
     } else {
          if (request.getSession().getAttribute("cartProd")!=null) {
             request.getSession().setAttribute("flag", true);   
          }
          else {
             request.getSession().setAttribute("flag", false); 
          } 
     }
      
        return new ModelAndView("cart"); 
    } 
     
    public void setviewName(String viewName){
        this.viewName = viewName;
    } 
    public String getviewName(){
        return this.viewName;
    }
}
