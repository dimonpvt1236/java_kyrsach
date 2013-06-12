package springapp.web; 

import java.io.File;
import java.util.List;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView; 
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import springmodel.Product;
import springmodel.ProductForm;
import util.HibernateUtil;

public class PriceIncreaseFormController extends SimpleFormController { 
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass()); 
   
    @Override
    public ModelAndView onSubmit(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
            //throws ServletException { 
            throws Exception {
        if (request.getSession().getAttribute("user_login")==null || !"admin".equals(request.getSession().getAttribute("user_login")) ) {
            return new ModelAndView(new RedirectView("login.htm"));
        }
        ProductForm prod = (ProductForm) command;
        Product prod2 = new Product();
        prod2.setName(prod.getName());
        prod2.setPrice(prod.getPrice());
        prod2.setQty(prod.getQty());
        prod2.setDescription(prod.getDescription());
        prod2.setId(prod.getId());
        if (prod.getImage()!=null) {
            prod2.setImage(prod.getImage());
        }
        
                if (prod.getFile()!=null) {
                    MultipartFile multipartFile = prod.getFile();
                    String fileName="";
                    if(multipartFile!=null){
                            fileName = multipartFile.getOriginalFilename();
                            //do whatever you want
                            if (!fileName.equals("")) {
                                multipartFile.transferTo(new File(request.getRealPath("/images/"+fileName) ).getAbsoluteFile());
                                fileName = "/images/"+fileName;
                                prod2.setImage(fileName);
                            }
                    }
                    
                }

        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        if (prod2.getId()!=null) {
            session.update(prod2);
        } else {
            session.save(prod2);
        }
        
        session.getTransaction().commit();   
        return new ModelAndView(new RedirectView(getSuccessView()));
    } 
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        ProductForm priceIncrease = new ProductForm();
        if (request.getParameter("id")!=null) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Product> prod = session.createSQLQuery("select * from product where id ="+Integer.parseInt(request.getParameter("id"))).addEntity(Product.class).list();
            priceIncrease.setName(prod.get(0).getName());
            priceIncrease.setQty(prod.get(0).getQty());
            priceIncrease.setPrice(prod.get(0).getPrice());
            priceIncrease.setDescription(prod.get(0).getDescription());
            priceIncrease.setId(prod.get(0).getId());
            priceIncrease.setImage(prod.get(0).getImage());
            session.close();
            request.getSession().setAttribute("image", true);
        } else {
            priceIncrease.setPrice(0.0);
            priceIncrease.setQty(0);
            request.getSession().setAttribute("image", false);
        }
        return priceIncrease;
    } 
    
}
