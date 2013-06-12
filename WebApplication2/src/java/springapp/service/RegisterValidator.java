/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springapp.service;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.EmailValidator;
import org.hibernate.Session;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import springmodel.User;
import springmodel.UserRegister;
import util.HibernateUtil;

/**
 *
 * @author Starik
 */
public class RegisterValidator implements Validator{
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass()); 
    public boolean supports(Class clazz) {
        return UserRegister.class.equals(clazz);
    } 
    public void validate(Object obj, Errors errors) {
        UserRegister pi = (UserRegister) obj;
        if (pi == null) {
            errors.rejectValue("name", "error.not-specified", null, "Value required.");
        }
        else {
            pi.setName(pi.getName().trim());
            if (pi.getName().isEmpty()) {
                errors.rejectValue("name", "error.required",
                    null, "Value required.");
            }
            pi.setLogin(pi.getLogin().trim());
            if (pi.getLogin().isEmpty()) {
                errors.rejectValue("login", "error.required",
                    null, "Value required.");
            }
            pi.setPass(pi.getPass().trim());
            if (pi.getPass().isEmpty()) {
                errors.rejectValue("pass", "error.required",
                    null, "Value required.");
            }
            pi.setConfirm_pass(pi.getConfirm_pass().trim());
            if (pi.getConfirm_pass().isEmpty()) {
                errors.rejectValue("confirm_pass", "error.required",
                    null, "Value required.");
            }
            pi.setContry(pi.getContry().trim());
            if (pi.getContry().isEmpty()) {
                errors.rejectValue("contry", "error.required",
                    null, "Value required.");
            }
            pi.setRegion(pi.getRegion().trim());
            if (pi.getRegion().isEmpty()) {
                errors.rejectValue("region", "error.required",
                    null, "Value required.");
            }
            pi.setCity(pi.getCity().trim());
            if (pi.getCity().isEmpty()) {
                errors.rejectValue("city", "error.required",
                    null, "Value required.");
            }
            pi.setAddres(pi.getAddres().trim());
            if (pi.getAddres().isEmpty()) {
                errors.rejectValue("addres", "error.required",
                    null, "Value required.");
            }
            pi.setZip(pi.getZip().trim());
            if (pi.getZip().isEmpty()) {
                errors.rejectValue("zip", "error.required",
                    null, "Value required.");
            }
            pi.setMail(pi.getMail().trim());
            if (pi.getMail().isEmpty()) {
                errors.rejectValue("mail", "error.required",
                    null, "Value required.");
            }
            pi.setPhone(pi.getPhone().trim());
            if (pi.getPhone().isEmpty()) {
                errors.rejectValue("phone", "error.required",
                    null, "Value required.");
            }
            if (!pi.getConfirm_pass().equals(pi.getPass())) {
                errors.rejectValue("confirm_pass", "error.confirm",
                    null, "Error password.");
            }
            
            EmailValidator mail = EmailValidator.getInstance();
            if (!mail.isValid(pi.getMail())) {
                 errors.rejectValue("mail", "error.email",
                    null, "Not valid email.");
            }
            
                boolean flag_name = false;
                boolean flag_login = false;
                Session session = HibernateUtil.getSession();
                List<User> userpr = (List<User>)session.createSQLQuery("select * from users").addEntity(User.class).list();

                for (Iterator<User> it = userpr.iterator(); it.hasNext();) {
                    User pr = it.next();
                    if (pr.getLogin().equals(pi.getLogin())) {
                        flag_login = true;
                    }
                    if (pr.getName().equals(pi.getName())) {
                        flag_name = true;
                    }
                } 
                session.close();
            if (flag_name) {
                errors.rejectValue("name", "error.name",
                    null, "This Name is exist.");
            }
            if (flag_login) {
                errors.rejectValue("login", "error.login",
                    null, "This Login is exist.");
            }
            
        }
    } 
}
