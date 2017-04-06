package stock.entities;


public class FundTypeEntity implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int FundTypeId;
	private String Description;
	private float commPercent;
	private float returnPercent;
	private String ActiveIndicator;
	private UserFundEntity userFundEntity;
	
	/**
	 * @return the userFundEntity
	 */
	public UserFundEntity getUserFundEntity() {
		return userFundEntity;
	}


	/**
	 * @param userFundEntity the userFundEntity to set
	 */
	public void setUserFundEntity(UserFundEntity userFundEntity) {
		this.userFundEntity = userFundEntity;
	}


	/**
	 * @return the activeIndicator
	 */
	public String getActiveIndicator() {
		return ActiveIndicator;
	}

	
	/**
	 * @param activeIndicator the activeIndicator to set
	 */
	public void setActiveIndicator(String activeIndicator) {
		ActiveIndicator = activeIndicator;
	}
	/**
	 * @return the commPercent
	 */
	public float getCommPercent() {
		return commPercent;
	}
	/**
	 * @param commPercent the commPercent to set
	 */
	public void setCommPercent(float commPercent) {
		this.commPercent = commPercent;
	}
	/**
	 * @return the returnPercent
	 */
	public float getReturnPercent() {
		return returnPercent;
	}
	/**
	 * @param returnPercent the returnPercent to set
	 */
	public void setReturnPercent(float returnPercent) {
		this.returnPercent = returnPercent;
	}
	/**
	 * @return the fundTypeId
	 */
	public int getFundTypeId() {
		return FundTypeId;
	}
	/**
	 * @param fundTypeId the fundTypeId to set
	 */
	public void setFundTypeId(int fundTypeId) {
		FundTypeId = fundTypeId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
}