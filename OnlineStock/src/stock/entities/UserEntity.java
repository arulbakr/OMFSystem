package stock.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 
 * @author arullap
 *
 */
//@Entity
//@Table
public class UserEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column
	private int userID;
	//@Column
	private String FullName;
	//@Column
	private String password;
	//@Column
	private String emailId;
	//@Column
	private String activeIndicator;
	private String passport;
	private String contactNo;
	private String gender;
	private Date dateOfBirth;
	private String city;
	private String address;
	private String state;
	private String postalCode;
	private CountryEntity country;
	private Map<String, String> countries;
	private Set<UserFundEntity> userFunds = new HashSet<UserFundEntity>(0);
	
	/**
	 * @return the userFunds
	 */
	public Set<UserFundEntity> getUserFunds() {
		return userFunds;
	}

	/**
	 * @param userFunds the userFunds to set
	 */
	public void setUserFunds(Set<UserFundEntity> userFunds) {
		this.userFunds = userFunds;
	}

	/**
	 * @return the passport
	 */
	public String getPassport() {
		return passport;
	}
	
	/**
	 * @param passport the passport to set
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * Constructor
	 */
	public UserEntity()
	{
		
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return FullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the country
	 */
	public CountryEntity getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the counrtries
	 */
	public Map<String, String> getCountries() {
		return countries;
	}
	/**
	 * @param counrtries the counrtries to set
	 */
	public void setCountries(Map<String, String> counrtries) {
		this.countries = counrtries;
	}
}