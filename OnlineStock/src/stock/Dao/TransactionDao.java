package stock.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import stock.common.HibernateUtil;
import stock.common.Utility;
import stock.entities.FundTypeEntity;
import stock.entities.UserFundEntity;

public class TransactionDao {
	
	public TransactionDao(){
		
	}
	
	/**
	 * 
	 * @param userFundEntity
	 * @return
	 * @throws SQLException
	 */
	public int saveUserFund(UserFundEntity userFundEntity) throws SQLException {
		 System.out.println(String.format("saveUserFund in TransactionDao got executed; UserID: %s", 
				userFundEntity.getUser().getUserID()) + " FundTypeID:" + userFundEntity.getUserFundId());
		 int result = 0;
         float existingAmount = 0;
         float returnPercent = 0;
         float maturedAmt = 0;
         
         Session session = null;
         try {
         	session = HibernateUtil.getSession();
         	session.beginTransaction();
         	// Getting return percentage for selected fund
         	String hql = "FROM FundTypeEntity ft Where ft.FundTypeId = :fundTypeId";
         	Query query = session.createQuery(hql);
         	query.setParameter("fundTypeId", userFundEntity.getFundType().getFundTypeId());
         	
         	List<FundTypeEntity> results = (List<FundTypeEntity>) query.list();
         	
         	Iterator<FundTypeEntity> iterator = results.iterator();
            while(iterator.hasNext())
            {
             	FundTypeEntity ftEntity = iterator.next();
             	returnPercent = ftEntity.getReturnPercent();
             	break;
            }
            // Getting user funds if available for the user
            hql = "Select uf.userFundId, uf.userId, uf.amount, uf.maturedAmount, ft.FundTypeId, uf.dateCreated, uf.activeIndicator"
            		+ " FROM UserFundEntity uf Join uf.fundType ft WHERE uf.userId = :userID AND ft.FundTypeId = :fundTypeId";
          	query = session.createQuery(hql);
          	query.setParameter("userID", userFundEntity.getUser().getUserID());
          	query.setParameter("fundTypeId", userFundEntity.getFundType().getFundTypeId());
          	
      		List<Object> ufResults = (List<Object>) query.list();
         	Iterator<Object> ufIterator = ufResults.iterator();
         	
         	UserFundEntity updateEntity = null;
            while(ufIterator.hasNext())
            {
             	Object[] obj = (Object[])ufIterator.next();
             	
             	updateEntity = new UserFundEntity();
             	updateEntity.setUserFundId(Integer.parseInt(String.valueOf(obj[0])));
             	updateEntity.setUserId(Integer.parseInt(String.valueOf(obj[1])));
	            
             	existingAmount = Float.parseFloat(String.valueOf(obj[2]));
            	maturedAmt = Float.parseFloat(String.valueOf(obj[3]));
            	
            	FundTypeEntity ftEntity = new FundTypeEntity();
	            ftEntity.setFundTypeId(Integer.parseInt(String.valueOf(obj[4])));
	            updateEntity.setFundType(ftEntity);
	            
	            //updateEntity.setDateCreated(obj[5] != null ? new Date(String.valueOf(obj[5])) : null);
	            updateEntity.setActiveIndicator(String.valueOf(obj[6]));
             	break;
            }
            System.out.println("existingAmount : " + existingAmount);
            
            Date currDate = new Date();
            // Updating User funds if available
            if(updateEntity != null){
            	System.out.println("Updating user funds...");
            	// Updating user funds if available already
            	float amount = existingAmount + userFundEntity.getAmount();
            	System.out.println("Added amount : " + amount);
            	
            	if(returnPercent > 0){
            		maturedAmt = maturedAmt + userFundEntity.getAmount() 
            			+ ((userFundEntity.getAmount() * returnPercent) / 100);
            	}
            	System.out.println("Matured amount : " + maturedAmt + " UserFundId: " + updateEntity.getUserFundId());
            	
            	updateEntity.setAmount(amount);
            	updateEntity.setMaturedAmount(maturedAmt);
            	updateEntity.setDateModified(new java.sql.Date(currDate.getTime()));
            	
            	session.update(updateEntity);
            	result = 1;
             } else {
            	 System.out.println("Inserting user funds...");
            	// Inserting if not
	            if(returnPercent > 0){
            		maturedAmt =  userFundEntity.getAmount() 
            			+ ((userFundEntity.getAmount() * returnPercent) / 100);
            	}
	            
	            userFundEntity.setUserId(userFundEntity.getUser().getUserID());
	            FundTypeEntity ftEntity = new FundTypeEntity();
	            ftEntity.setFundTypeId(userFundEntity.getFundType().getFundTypeId());
	            userFundEntity.setFundType(ftEntity);
	            userFundEntity.setMaturedAmount(maturedAmt);
	            userFundEntity.setActiveIndicator("Y");
	            userFundEntity.setDateCreated(new java.sql.Date(currDate.getTime()));
	            
	            result = (int) session.save(userFundEntity);
            }
            session.getTransaction().commit();
         } catch(Exception e){
 			System.out.println("Exception at getUser in TransactionDao : "+ Utility.getExceptionMessageWithStackTrace(e));
 			return -1;
 		} finally {
            if(session != null){
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
	public List<FundTypeEntity> getFundTypes(int userId) throws SQLException {
		System.out.println(String.format("getFundTypes in TransactionDao got called UserID: %s", userId));
		
		List<FundTypeEntity> funds = new ArrayList<>();
		
		Session session = null;
        try {
        	session = HibernateUtil.getSession();
        	session.beginTransaction();
        	
        	String hql = null;
        	// Getting fund types based on user id
        	if(userId > 0){
        		//SELECT ft.FundTypeId, ft.Description
        		hql = "SELECT ft.FundTypeId, ft.Description FROM UserFundEntity uf Join uf.fundType ft " +
                      "WHERE ft.ActiveIndicator = 'Y' And uf.activeIndicator = 'Y' AND uf.userId = :userId Order By ft.FundTypeId";
        		Query query = session.createQuery(hql);
            	if(userId > 0){
            		query.setParameter("userId", userId);
            	}
            	System.out.println("UserID: " + userId + " Query at getFundTypes: " + query.getQueryString()); 
            	List<Object> results = (List<Object>) query.list();
            	System.out.println("results count : " + results.size());
            	Iterator<Object> iterator = results.iterator();
            	while(iterator.hasNext())
            	{
                	Object[] obj = (Object[]) iterator.next();
                	FundTypeEntity ftEntity = new FundTypeEntity();
                	ftEntity.setFundTypeId(Integer.parseInt(String.valueOf(obj[0])));
                	ftEntity.setDescription(String.valueOf(obj[1]));
                	funds.add(ftEntity);
            	}
        	} else {
        		hql = "FROM FundTypeEntity ft Where ft.ActiveIndicator = 'Y'";
        		Query query = session.createQuery(hql);
            	
            	funds = (List<FundTypeEntity>) query.list();
        	}
        	System.out.println("Row count : " + funds.size());
        } catch(Exception e){
			System.out.println("Exception at getUser in TransactionDao : "+ Utility.getExceptionMessageWithStackTrace(e));
		} finally {
           if(session != null){
        	   session.close();
           }
       }
        return funds;
	}
	
	/**
	 * 
	 * @param userFundEntity
	 * @return
	 * @throws SQLException
	 */
	public int redeemUserFund(UserFundEntity userFundEntity) throws SQLException {
		int result = 0;
		System.out.println(String.format("redeemUserFund in TransactionDao got executed; UserID: %s", 
				userFundEntity.getUser().getUserID()));
		
		Session session = null;
        try {
        	session = HibernateUtil.getSession();
        	session.beginTransaction();
        	
            float existingAmount = 0;
            float maturedAmt = 0;
            
            // Getting user funds if available for the user
            String selectQuery = "FROM UserFundEntity uf WHERE uf.userId = :userId AND fundTypeId = :fundTypeId";
            
            Query query = session.createQuery(selectQuery);
            query.setParameter("userId", userFundEntity.getUser().getUserID());
            query.setParameter("fundTypeId", userFundEntity.getFundType().getFundTypeId());
            
            List<UserFundEntity> selectResult = (List<UserFundEntity>) query.list();
            Iterator<UserFundEntity> iterator = selectResult.iterator();
            UserFundEntity entity = null;
            while(iterator.hasNext()){
            	entity = iterator.next();
            	existingAmount = entity.getAmount();
            	maturedAmt = entity.getMaturedAmount();
            	break;
            }
            System.out.println("existingAmount : " + existingAmount);
            System.out.println("maturedAmt : " + maturedAmt);
            System.out.println("enteredAmt : " + userFundEntity.getAmount());
            
            Date currDate = new Date();
            if(entity != null && userFundEntity.getAmount() <= maturedAmt){
            	
            	float tempAmt = existingAmount - userFundEntity.getAmount();
            	System.out.println("Redeemed amount : " + tempAmt);
            	float tempMatAmt = maturedAmt - userFundEntity.getAmount();
            	System.out.println("Redeemed Matured amount : " + tempMatAmt);
            	
            	entity.setAmount(tempAmt < 0 ? 0 : tempAmt);
            	entity.setMaturedAmount(tempMatAmt);
            	entity.setDateModified(new java.sql.Date(currDate.getTime()));
                
                session.update(entity);
                result = 1;
            } else {
            	result = -1;
            }
            System.out.println("Query result : " + result);
            session.getTransaction().commit();
        } catch(Exception e) {
			System.out.println("Exception at redeemUserFund in TransactionDao : "+ Utility.getExceptionMessageWithStackTrace(e));
			result = -1;
		} finally {
			if(session != null){
				session.close();
			}
		}
		return result;
	}
}