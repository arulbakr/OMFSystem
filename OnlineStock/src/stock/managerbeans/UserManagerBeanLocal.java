package stock.managerbeans;

import java.sql.SQLException;

import javax.ejb.Local;

import stock.entities.AccountEntity;
import stock.entities.UserEntity;

/**
 * 
 * @author arullap
 *
 */
@Local
public interface UserManagerBeanLocal {
	
	/**
	 * 
	 * @param emailId
	 * @param passowrd
	 * @return
	 * @throws SQLException 
	 */
	UserEntity getUser(String emailId, String password) throws SQLException;
	
	/**
	 * 
	 * @param emailId
	 * @param passowrd
	 * @return
	 */
	UserEntity getUser(int userId) throws SQLException;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	int updateUser(UserEntity user) throws SQLException;
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	AccountEntity getAccountDetails(int userId)throws SQLException;
}