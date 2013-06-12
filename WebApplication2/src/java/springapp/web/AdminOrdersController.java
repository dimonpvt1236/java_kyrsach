/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import springmodel.Cart;
import springmodel.Config;
import springmodel.OrderProduct;
import springmodel.Orders;
import springmodel.OrdersTabs;
import springmodel.User;
import util.HibernateUtil;

/**
 *
 * @author Starik
 */
public class AdminOrdersController implements Controller {
    private String viewName;
    protected final Log logger = LogFactory.getLog(getClass()); 
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException { 
        if (request.getSession().getAttribute("user_login")==null || !"admin".equals(request.getSession().getAttribute("user_login")) ) {
            return new ModelAndView(new RedirectView("login.htm"));
        }
        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Orders> orders = (List<Orders>)session.createSQLQuery("select * from orders order by date desc").addEntity(Orders.class).list();
        List<User> users = session.createSQLQuery("select * from users ").addEntity(User.class).list();
        
        List<OrdersTabs> tabs = new ArrayList();
        for (Orders or:orders) {
            OrdersTabs order = new OrdersTabs();
            order.setId(or.getId());
            order.setData(or.getData());
            order.setOrdernumber(or.getOrdernumber());
            order.setUser_id(or.getUser_id());
            
            for (User us:users) {
                if (order.getUser_id().equals(us.getId())) {
                    order.setUsername(us.getName());
                    break;
                }
            }
            
            List<OrderProduct> prod = session.createSQLQuery("select * from order_product where ordernumber = "+or.getOrdernumber()).addEntity(OrderProduct.class).list();
            Double total = 0.0;
            for (OrderProduct pr:prod) {
                total += pr.getProd_price()*pr.getProd_qty();
            }
            order.setTotal(total);
            tabs.add(order);            
        }
        session.close();
        request.getSession().setAttribute("tabs", tabs);
        return new ModelAndView("adminorders");
    } 
     
    public void setviewName(String viewName){
        this.viewName = viewName;
    }
    public String getviewName(){
        return this.viewName;
    }  
}
