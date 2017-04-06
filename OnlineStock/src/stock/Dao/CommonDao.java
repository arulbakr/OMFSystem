package stock.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import stock.common.HibernateUtil;
import stock.common.Utility;
import stock.entities.CountryEntity;


public class CommonDao {
	
	public CommonDao(){
		
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<CountryEntity> getCountries() throws SQLException {
		System.out.println(String.format("getCountries in CommonDao got executed"));
		
		List<CountryEntity> countries = new ArrayList<>();
		Session session = null;
        try {
        	
        	session = HibernateUtil.getSession();
        	session.beginTransaction();
        	
        	String hql = "FROM CountryEntity c WHERE c.ActiveIndicator = 'Y' Order By c.CountryID";
        	Query query = session.createQuery(hql);
        	
        	countries = (List<CountryEntity>) query.list();
        	System.out.format("Countries: %s\n", countries.size());
        } catch(Exception e){
			System.out.println("Exception at getCountries in CommonDao : "+ Utility.getExceptionMessageWithStackTrace(e));
		} finally {
           if(session != null){
        	   session.close();
           }
        }
		return countries;
	}
}