/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.service;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import springmodel.Product;
import springmodel.User;
import springmodel.UserForm;
import util.HibernateUtil;

/**
 *
 * @author Starik
 */
public class LoginValidator implements Validator {
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass()); 
    public boolean supports(Class clazz) {
        return UserForm.class.equals(clazz);
    } 
    public void validate(Object obj, Errors errors) {
        UserForm pi = (UserForm) obj;
        if (pi == null) {
            errors.rejectValue("login", "error.not-specified", null, "Value required.");
        }
        else {
            logger.info("Validating with " + pi + ": " + pi.getLogin());
            if (pi.getLogin().trim()=="") {
                errors.rejectValue("login", "error.required",
                    null, "Value required.");
            }
            if (pi.getPass().trim()=="") {
                errors.rejectValue("pass", "error.required",
                    null, "Value required.");
            }
            if (pi.getLogin().trim()!="" && pi.getPass().trim()!="") {
                boolean flag = true;
                Session session = HibernateUtil.getSession();
                List<User> userpr = (List<User>)session.createSQLQuery("select * from users").addEntity(User.class).list();

                for (Iterator<User> it = userpr.iterator(); it.hasNext();) {
                    User pr = it.next();
                    if (pr.getLogin().equals(pi.getLogin().trim()) && pr.getPass().equals(pi.getPass().trim())) {
                        flag = false;
                    }
                } 
                session.close();
                if (flag) {
                    errors.rejectValue("pass", "error.login-error",
                        null, "Login or password wrong.");
                }
            }
            
        }
    } 

}
