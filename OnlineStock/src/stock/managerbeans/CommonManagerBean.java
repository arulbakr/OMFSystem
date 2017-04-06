package stock.managerbeans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import stock.Dao.CommonDao;
import stock.entities.CountryEntity;

@Stateless
@LocalBean
public class CommonManagerBean implements CommonManagerBeanLocal {

	/**
	 * 
	 */
	public List<CountryEntity> getCountries() throws SQLException {
		System.out.println(String.format("getCountries in CommonManagerBean got executed"));
		
		CommonDao cDao = new CommonDao();
		return cDao.getCountries();
	}	
}