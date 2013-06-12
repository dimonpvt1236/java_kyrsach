/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
     private static SessionFactory sessionFactory = null;
     
     static {
         try {
                 //creates the session factory from hibernate.cfg.xml
                 sessionFactory = new AnnotationConfiguration().configure("/hibernate.cfg.xml").buildSessionFactory();
         } catch (Exception e) {
               e.printStackTrace();
         }
     }

     public static SessionFactory getSessionFactory() {
         return sessionFactory;
     }
     
     public static Session getSession() {
         return sessionFactory.openSession();
     }
}
