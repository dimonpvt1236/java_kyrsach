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
import springmodel.User;
import util.HibernateUtil;

/**
 *
 * @author Starik
 */
public class AdminUsersController implements Controller {
    private String viewName;
    protected final Log logger = LogFactory.getLog(getClass()); 
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException { 
        if (request.getSession().getAttribute("user_login")==null || !"admin".equals(request.getSession().getAttribute("user_login")) ) {
            return new ModelAndView(new RedirectView("login.htm"));
        }
        if (request.getParameter("status")!=null && request.getParameter("id")!=null) {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> users = session.createSQLQuery("select * from users where id = "+Integer.parseInt(request.getParameter("id"))).addEntity(User.class).list();
            if ("1".equals(request.getParameter("status"))) {
                users.get(0).setStatus(true);
            } else {
                users.get(0).setStatus(false);
            }
            session.save(users.get(0));            
            session.getTransaction().commit();
            session.close();
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createSQLQuery("select * from users ").addEntity(User.class).list();
        
        
        session.close();
        request.getSession().setAttribute("users", users);
        return new ModelAndView("adminusers");
    } 
     
    public void setviewName(String viewName){
        this.viewName = viewName;
    }
    public String getviewName(){
        return this.viewName;
    }  
}
