/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
import springmodel.Config;
import springmodel.OrderProduct;
import springmodel.Orders;
import springmodel.User;
import util.HibernateUtil;

/**
 *
 * @author Starik
 */
public class OrderController implements Controller {
    private String viewName;
    protected final Log logger = LogFactory.getLog(getClass()); 
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException { 
        if (request.getParameter("order")==null) {        
            if (request.getSession().getAttribute("user_id")!=null) {
                Session session = HibernateUtil.getSession();
                Integer id = (Integer)request.getSession().getAttribute("user_id");
                List<User> userpr = (List<User>)session.createSQLQuery("select * from users where id = "+id).addEntity(User.class).list();
                request.getSession().setAttribute("user", userpr.get(0));
                session.close();
            }
        }
        if ("place".equals(request.getParameter("order")) && request.getSession().getAttribute("user_id")!=null && request.getSession().getAttribute("cartProd")!=null) {
            Session session = HibernateUtil.getSession(); 
            session.beginTransaction();
            List<Config> config = session.createSQLQuery("select * from config where name = 'lastorder'").addEntity(Config.class).list();
            Integer ordernumber = Integer.parseInt(config.get(0).getVal());
            //request.getSession().setAttribute("ordernumber", ordernumber);
            Date today = new Date();
          //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM H:mm:ss");
          //  String formattedDate=sdf.format(today);
            
            Orders orders = new Orders();
            orders.setData(today);
            orders.setOrdernumber(ordernumber);
            orders.setUser_id((Integer)request.getSession().getAttribute("user_id"));
            session.save(orders); 
            
            if (request.getSession().getAttribute("cartProd")!=null) {
                List<Cart>  cart = (List<Cart>) request.getSession().getAttribute("cartProd");
                for (Cart pr:cart) {
                    OrderProduct prod = new OrderProduct();
                    prod.setProd_id(pr.getId());
                    prod.setProd_name(pr.getName());
                    prod.setProd_qty(pr.getQty());
                    prod.setProd_price(pr.getPrice());
                    prod.setOrdernumber(ordernumber);
                    
                    session.save(prod);
                }
            
            }
            ordernumber +=1;
            config.get(0).setVal(ordernumber.toString());
            session.update(config.get(0));
            
            session.getTransaction().commit();    
            session.close();
            
            request.getSession().setAttribute("cartProd", null);
            request.getSession().setAttribute("flag", false); 
            request.getSession().setAttribute("sucs", true); 
            request.getSession().setAttribute("ord", ordernumber-1); 
        }
        return new ModelAndView("order");
    } 
     
    public void setviewName(String viewName){
        this.viewName = viewName;
    }
    public String getviewName(){
        return this.viewName;
    }    
}
