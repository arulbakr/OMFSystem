package stock.managerbeans;

import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.naming.NamingException;

import stock.Dao.UserDao;
import stock.entities.AccountEntity;
import stock.entities.UserEntity;

/**
 * Session Bean implementation class UserManager
 * @author arullap
 */
@Stateless
@LocalBean
public class UserManagerBean implements UserManagerBeanLocal {

	/**
     * Default constructor. 
     * @throws NamingException 
     */
    public UserManagerBean() throws NamingException {

    }
    
    /**
	 * 
	 * @param emailId
	 * @param passowrd
	 * @return
     * @throws SQLException 
	 */
    @Override
	public UserEntity getUser(String emailId, String password) throws SQLException{
    	System.out.println(String.format("getUser in UserManagerBean got executed; Email: %s, Pass: %s", emailId, password));
    	
    	UserDao userDoa = new UserDao();
    	return userDoa.getUser(emailId, password);
	}

    /**
	 * 
	 * @param emailId
	 * @param passowrd
	 * @return
	 */
	@Override
	public UserEntity getUser(int userId) throws SQLException {
		System.out.println(String.format("getUser in UserManagerBean got executed; UserID: %s", userId));
		
		UserDao userDoa = new UserDao();
    	return userDoa.getUser(userId);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public int updateUser(UserEntity user) throws SQLException {
		System.out.println(String.format("updateUser in UserManagerBean got executed; UserID: %s", user.getUserID()));
		
		UserDao userDoa = new UserDao();
    	return userDoa.updateUser(user);
	}

	/**
	 * @throws SQLException 
	 * 
	 */
	@Override
	public AccountEntity getAccountDetails(int userId) throws SQLException {
		System.out.println(String.format("getAccountDetails in UserManagerBean got executed; Email: %s", userId));
		
		UserDao userDoa = new UserDao();
    	AccountEntity accEntity = userDoa.getAccountDetails(userId);
    	//Calculating growth
    	float growth = 0;
        if(accEntity.getTotalDeposit() > 0 && accEntity.getTotalMatured() > 0){
        	growth = ((accEntity.getTotalMatured() - accEntity.getTotalDeposit()) / accEntity.getTotalDeposit()) * 100;
        }
        System.out.println("Growth % : " + growth);
        accEntity.setGrowthPercent(growth);
        return accEntity;
	}
}