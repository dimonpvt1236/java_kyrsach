package springapp.service; 

import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import springmodel.Product;
import springmodel.ProductForm;
import springmodel.User;
import util.HibernateUtil;

public class PriceIncreaseValidator implements Validator {
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass()); 
    public boolean supports(Class clazz) {
        return ProductForm.class.equals(clazz);
    } 
    public void validate(Object obj, Errors errors) {
        ProductForm pi = (ProductForm) obj;
        if (pi == null) {
            errors.rejectValue("name", "error.not-specified", null, "Value required.");
        }
        else {
            logger.info("Validating with " + pi + ": " + pi.getName());
            pi.setName(pi.getName().trim());
            if (pi.getName().isEmpty()) {
                errors.rejectValue("name", "error.required",
                    null, "Value required.");
            }
            if (pi.getPrice()==null) {
                errors.rejectValue("price", "error.required",
                    null, "Value required.");
            }
            if (pi.getPrice()!=null) {
                if (pi.getPrice()<=0.0) {
                    errors.rejectValue("price", "error.required2",
                        null, "The price must be greater than 0.");
                }
            }
            if (pi.getQty()!=null) {
                if (pi.getQty()<=0) {
                    errors.rejectValue("qty", "error.required2",
                        null, "The Qty must be greater than 0.");
                }
            }
            if (pi.getQty()==null) {
                    errors.rejectValue("qty", "error.required",
                        null, "Value required.");
            }
            pi.setDescription(pi.getDescription().trim());
            if (pi.getDescription().isEmpty()) {
                errors.rejectValue("description", "error.required",
                    null, "Value required.");
            }           
        }
    } 
}