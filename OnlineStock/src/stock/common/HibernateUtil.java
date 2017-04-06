package stock.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author arullap
 *
 */
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
    static
    {
    	try{
    		sessionFactory = new Configuration().configure().buildSessionFactory();
    	} catch(Exception e){
    		System.out.println("Exception at Hibernate Session factory creation: " 
    				+ Utility.getExceptionMessageWithStackTrace(e));
    		throw e;
    	}
    }
    
    public static Session getSession()
    {
        return sessionFactory.openSession();
    }
}