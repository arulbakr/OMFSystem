package stock.managerbeans;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import stock.Dao.TransactionDao;
import stock.common.Constants;
import stock.common.Utility;
import stock.entities.FundTypeEntity;
import stock.entities.UserFundEntity;

/**
 * Session Bean implementation class TransactionManagerBean
 */
@Stateless
@LocalBean
public class TransactionManagerBean implements TransactionManagerBeanLocal {

    /**
     * Default constructor. 
     */
    public TransactionManagerBean() {
        
    }

    /**
     * 
     * @param userFundEntity
     * @return
     * @throws SQLException 
     */
	@Override
	public int saveUserFund(UserFundEntity userFundEntity) throws SQLException {
		System.out.println(String.format("saveUserFund in TransactionManagerBean got executed; UserID: %s", 
				userFundEntity.getUser().getUserID()));
		
		TransactionDao txnDao = new TransactionDao();
		return txnDao.saveUserFund(userFundEntity);
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	@Override
	public List<FundTypeEntity> getFundTypes(int userId) throws SQLException {
		System.out.println(String.format("getFundTypes in TransactionManagerBean got called UserID: %s", userId));
		
		TransactionDao txnDao = new TransactionDao();
		return txnDao.getFundTypes(userId);
	}

	/**
	 * 
	 */
	@Override
	public int redeemUserFund(UserFundEntity userFundEntity) throws SQLException {
		System.out.println(String.format("redeemUserFund in TransactionManagerBean got executed; UserID: %s", 
				userFundEntity.getUser().getUserID()));
		
		TransactionDao txnDao = new TransactionDao();
		return txnDao.redeemUserFund(userFundEntity);
	}
}