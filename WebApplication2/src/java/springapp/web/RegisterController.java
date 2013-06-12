/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import springmodel.User;
import springmodel.UserRegister;
import util.HibernateUtil;

/**
 *
 * @author Starik
 */
public class RegisterController extends SimpleFormController { 
    /** Logger for this class and subclasses */
   
    @Override
    public ModelAndView onSubmit(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
            //throws ServletException { 
            throws Exception {
        UserRegister user = (UserRegister) command;     
        User us = new User();
        us.setLogin(user.getLogin());
        us.setName(user.getName());
        us.setPass(user.getPass());
        us.setContry(user.getContry());
        us.setRegion(user.getRegion());
        us.setCity(user.getCity());
        us.setAddres(user.getAddres());
        us.setZip(user.getZip());
        us.setMail(user.getMail());
        us.setPhone(user.getPhone());
        us.setStatus(true);
            
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(us);
        session.getTransaction().commit();   
        return new ModelAndView(new RedirectView(getSuccessView()));
    } 
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        UserRegister reg = new UserRegister(); 
        return reg;
    } 
}
