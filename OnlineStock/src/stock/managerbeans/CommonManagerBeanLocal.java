package stock.managerbeans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import stock.entities.CountryEntity;

/**
 * 
 * @author arullap
 *
 */
@Local
public interface CommonManagerBeanLocal {
	
	/**
	 * 
	 * @return
	 */
	List<CountryEntity> getCountries() throws SQLException;
}