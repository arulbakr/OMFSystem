package stock.Dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import stock.common.HibernateUtil;

import stock.common.Utility;
import stock.entities.AccountEntity;
import stock.entities.CountryEntity;
import stock.entities.UserEntity;

public class UserDao {
	
	public UserDao(){
		
	}
	
	/**
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 */
	public UserEntity getUser(String emailId, String password){
		System.out.println(String.format("getUser in UserDao got executed; Email: %s, Pass: %s", emailId, password));
    	UserEntity user = null;
    	Session session = null;
        try {
        	
        	session = HibernateUtil.getSession();
        	session.beginTransaction();
        	
        	String hql = "SELECT u.userID, u.FullName, u.emailId FROM UserEntity u " +
                    "WHERE u.emailId = :Email And u.password = :Password And u.activeIndicator = 'Y'";
        	Query query = session.createQuery(hql);
        	query.setParameter("Email", emailId.trim());
        	query.setParameter("Password", password.trim());
        	List<Object> results = (List<Object>) query.list();
        	
        	user = new UserEntity();
        	
        	Iterator<Object> iterator = results.iterator();
            while(iterator.hasNext())
            {
            	Object[] obj = (Object[]) iterator.next();
            	user.setUserID(Integer.parseInt(String.valueOf(obj[0])));
            	user.setFullName(String.valueOf(obj[1]));
            	user.setEmailId(String.valueOf(obj[2]));
            	// print the results
            	System.out.format("%s, %s, %s\n", user.getUserID(), user.getFullName(),
            			user.getEmailId());
            	break;
            }
        } catch(Exception e){
			System.out.println("Exception at getUser in UserDao : "+ Utility.getExceptionMessageWithStackTrace(e));
		} finally {
           if(session != null){
        	   session.close();
           }
        }
		return user;
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public UserEntity getUser(int userId) {
		System.out.println(String.format("getUser in UserDao got executed; UserID: %s", userId));
		
		UserEntity user = null;
    	Session session = null;
        try {
        	
        	session = HibernateUtil.getSession();
        	session.beginTransaction();
        	
        	String hql = "SELECT u.userID, u.FullName, u.emailId, u.passport, u.contactNo, u.dateOfBirth, u.gender, "
            		+ "u.address, u.city, u.state, u.postalCode, c.CountryID, c.Name"
            		+ " FROM UserEntity u  "
            		+ " Join u.country c " +
                    " WHERE u.userID = :UserId And u.activeIndicator = 'Y' And c.ActiveIndicator = 'Y'";
        	Query query = session.createQuery(hql);
        	query.setParameter("UserId", userId);
        	
        	List<Object> results = (List<Object>) query.list();
        	
        	user = new UserEntity();
        	Iterator<Object> iterator = results.iterator();
            while(iterator.hasNext())
            {
            	Object[] obj = (Object[]) iterator.next();
            	user.setUserID(Integer.parseInt(String.valueOf(obj[0])));
            	user.setFullName(String.valueOf(obj[1]));
            	user.setEmailId(String.valueOf(obj[2]));
            	user.setPassport(String.valueOf(obj[3])); 
            	user.setContactNo(String.valueOf(obj[4]));
            	if(obj[5] != null){
            		user.setDateOfBirth(new Date(String.valueOf(obj[5]))); 
            	}
            	user.setGender(String.valueOf(obj[6]));
            	user.setAddress(String.valueOf(obj[7]));
            	user.setCity(String.valueOf(obj[8])); 
            	user.setState(String.valueOf(obj[9])); 
            	user.setPostalCode(String.valueOf(obj[10]));
            	if(obj[11] != null){
            		CountryEntity cEntity = new CountryEntity();
                	cEntity.setCountryID(Integer.parseInt(String.valueOf(obj[11])));
                	cEntity.setName(String.valueOf(obj[12]));
                	user.setCountry(cEntity);
            	}
            	// print the results
            	System.out.format("%s, %s, %s\n", user.getUserID(), user.getFullName(),
            			user.getEmailId());
            	break;
            }
        } catch(Exception e){
			System.out.println("Exception at getUser in UserDao : "+ Utility.getExceptionMessageWithStackTrace(e));
		} finally {
           if(session != null){
        	   session.close();
           }
        }
		return user;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updateUser(UserEntity user) throws SQLException {
		System.out.println(String.format("updateUser in UserDao got executed; UserID: %s", user.getUserID()));
		int result = 0;
		Session session = null;
		try{
			session = HibernateUtil.getSession();
        	session.beginTransaction();
        	
        	if(user.getUserID() > 0){
        		UserEntity userEntity = (UserEntity) session.get(UserEntity.class, user.getUserID());
        		userEntity.setFullName(user.getFullName());
        		userEntity.setPassport(user.getPassport());
        		userEntity.setContactNo(user.getContactNo());
        		userEntity.setDateOfBirth(user.getDateOfBirth());
        		userEntity.setGender(user.getGender());
        		userEntity.setAddress(user.getAddress());
        		userEntity.setCity(user.getCity());
        		userEntity.setState(user.getState());
        		userEntity.setPostalCode(user.getPostalCode());
        		userEntity.setCountry(user.getCountry());
        		session.update(userEntity);
        		result = 1;
            } else {
            	user.setActiveIndicator("Y");
            	result = (int) session.save(user);
            }
        	session.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("Exception at getUser in UserDao : "+ Utility.getExceptionMessageWithStackTrace(e));
		} finally {
		    if (session != null) {
		    	session.close();
		    }
		}
		return result;
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public AccountEntity getAccountDetails(int userId) throws SQLException {
		System.out.println(String.format("getAccountDetails in UserDao got executed; Email: %s", userId));
		AccountEntity account = null;
		Session session = null;
        try {
        	
        	session = HibernateUtil.getSession();
        	session.beginTransaction();
    		
        	String hql = "Select u.userID, Sum(uf.amount) as TotalAmount, Sum(uf.maturedAmount) as TotalMaturedAmt"
    				+ " From UserEntity u"
					+ " Join u.userFunds uf" 
					+ " Join uf.fundType ft"
					+ " Where u.userID = :UserId And" 
					+ " u.activeIndicator = 'Y' And uf.activeIndicator = 'Y' And ft.ActiveIndicator = 'Y'"
					+ " Group By u.userID";
        	System.out.println("Query @ getAccountDetails: " + hql + " DB Session: " + session.isConnected());
        	Query query = session.createQuery(hql);
        	query.setParameter("UserId", userId);
        	List<Object> results = (List<Object>) query.list();
        	
        	account = new AccountEntity();
        	
        	Iterator<Object> iterator = results.iterator();
            while(iterator.hasNext())
            {
            	Object[] obj = (Object[]) iterator.next();
            	account.setTotalDeposit(Float.parseFloat(String.valueOf(obj[1])));
            	account.setTotalMatured(Float.parseFloat(String.valueOf(obj[2])));
            	// print the results
            	System.out.format("UserID: %s, TotalDeposit:%s, TotalMatured:%s\n", userId, account.getTotalDeposit(), 
            			account.getTotalMatured());
            	break;
            }
        } catch(Exception e){
			System.out.println("Exception at getUser in UserDao : "+ Utility.getExceptionMessageWithStackTrace(e));
		} finally {
           if(session != null){
        	   session.close();
           }
        }
		return account;
	}
}