package stock.entities;

import java.util.Date;

public class UserFundEntity implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userFundId;
	private float amount;
	private UserEntity user;
	private FundTypeEntity fundType;
	private float maturedAmount;
	private int userId;
	private String activeIndicator;
	private Date dateCreated;
	private Date dateModified;
	
	/**
	 * @return the dateModified
	 */
	public Date getDateModified() {
		return dateModified;
	}
	/**
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the activeIndicator
	 */
	public String getActiveIndicator() {
		return activeIndicator;
	}
	/**
	 * @param activeIndicator the activeIndicator to set
	 */
	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the maturedAmount
	 */
	public float getMaturedAmount() {
		return maturedAmount;
	}
	/**
	 * @param maturedAmount the maturedAmount to set
	 */
	public void setMaturedAmount(float maturedAmount) {
		this.maturedAmount = maturedAmount;
	}
	/**
	 * @return the userFundId
	 */
	public int getUserFundId() {
		return userFundId;
	}
	/**
	 * @param userFundId the userFundId to set
	 */
	public void setUserFundId(int userFundId) {
		this.userFundId = userFundId;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}
	/**
	 * @return the fundType
	 */
	public FundTypeEntity getFundType() {
		return fundType;
	}
	/**
	 * @param fundType the fundType to set
	 */
	public void setFundType(FundTypeEntity fundType) {
		this.fundType = fundType;
	}	
}