package stock.managerbeans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import stock.entities.FundTypeEntity;
import stock.entities.UserFundEntity;

/**
 * 
 * @author arullap
 *
 */
@Local
public interface TransactionManagerBeanLocal {
	
	/**
	 * @param userId
	 * @return
	 */
	List<FundTypeEntity> getFundTypes(int userId)throws SQLException;
	/**
	 * 
	 * @param userFundEntity
	 * @return
	 */
	int saveUserFund(UserFundEntity userFundEntity)throws SQLException;
	/**
	 * 
	 * @param userFundEntity
	 * @return
	 */
	int redeemUserFund(UserFundEntity userFundEntity)throws SQLException;
}