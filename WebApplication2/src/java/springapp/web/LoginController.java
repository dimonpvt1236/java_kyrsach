/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.web;

import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import springmodel.User;
import springmodel.UserForm;
import util.HibernateUtil;

/**
 *
 * @author Starik
 */
public class LoginController extends SimpleFormController { 
    /** Logger for this class and subclasses */
   
    @Override
    public ModelAndView onSubmit(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
            //throws ServletException { 
            throws Exception {
        UserForm user = (UserForm) command;  

        Session session = HibernateUtil.getSession();
        List<User> userpr = (List<User>)session.createSQLQuery("select * from users").addEntity(User.class).list();
        
        for (Iterator<User> it = userpr.iterator(); it.hasNext();) {
            User pr = it.next();
            if (pr.getLogin().equals(user.getLogin()) && pr.getPass().equals(user.getPass())) {
                request.getSession().setAttribute("user_login", pr.getLogin()); 
                request.getSession().setAttribute("user_id", pr.getId());
                request.getSession().setAttribute("user_name", pr.getName());
                request.getSession().setAttribute("loged", true);
                request.getSession().setAttribute("user_status", pr.isStatus());
            }
        } 
        if ("admin".equals(request.getSession().getAttribute("user_login"))) {
            request.getSession().setAttribute("menu", true);
        }
        else {
            request.getSession().setAttribute("menu", false);
        }
        session.close();
        return new ModelAndView(new RedirectView(getSuccessView()));
    } 
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        UserForm login = new UserForm(); 
        return login;
    } 
    
}
