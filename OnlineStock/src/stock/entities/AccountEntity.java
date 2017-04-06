package stock.entities;

public class AccountEntity {
	private float totalDeposit;
	private float totalMatured;
	private float growthPercent;
	
	/**
	 * @return the growthPercent
	 */
	public float getGrowthPercent() {
		return growthPercent;
	}
	/**
	 * @param growthPercent the growthPercent to set
	 */
	public void setGrowthPercent(float growthPercent) {
		this.growthPercent = growthPercent;
	}
	/**
	 * @return the totalDeposit
	 */
	public float getTotalDeposit() {
		return totalDeposit;
	}
	/**
	 * @param totalDeposit the totalDeposit to set
	 */
	public void setTotalDeposit(float totalDeposit) {
		this.totalDeposit = totalDeposit;
	}
	/**
	 * @return the totalMatured
	 */
	public float getTotalMatured() {
		return totalMatured;
	}
	/**
	 * @param totalMatured the totalMatured to set
	 */
	public void setTotalMatured(float totalMatured) {
		this.totalMatured = totalMatured;
	}
}