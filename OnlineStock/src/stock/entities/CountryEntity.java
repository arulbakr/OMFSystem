package stock.entities;

public class CountryEntity implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int CountryID;
	private String Name;
	private String ActiveIndicator;
	
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
	 * @return the countryID
	 */
	public int getCountryID() {
		return CountryID;
	}
	/**
	 * @param countryID the countryID to set
	 */
	public void setCountryID(int countryID) {
		CountryID = countryID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}	
}