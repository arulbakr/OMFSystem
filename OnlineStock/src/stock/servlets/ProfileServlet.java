package stock.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stock.common.Constants;
import stock.common.Messages;
import stock.common.Utility;
import stock.entities.CountryEntity;
import stock.entities.UserEntity;
import stock.entities.UserSessionEntity;
import stock.managerbeans.CommonManagerBeanLocal;
import stock.managerbeans.UserManagerBeanLocal;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserManagerBeanLocal userManager;
	@EJB
	private CommonManagerBeanLocal commonManager;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Executed doGet of ProfileServlet");
		
		// Handling query string for edit
		boolean isEdit = false;
		String queryString = request.getQueryString();
		if(queryString != null && queryString.contains("edit=1") && queryString.length() == 6){
			isEdit = true;
		}
		System.out.println("Query : " + request.getQueryString());
		
		HttpSession session = request.getSession(false);
		UserSessionEntity uSession = session != null ? (UserSessionEntity) session.getAttribute("UserSession") : null;
		if(uSession != null)
		{
			request.setAttribute("FullName", uSession.getFullName());
			try {
				UserEntity uEntity = userManager.getUser(uSession.getUserId());
				request.setAttribute("name", uEntity.getFullName());
				request.setAttribute("passportNo", uEntity.getPassport());
				request.setAttribute("contactNo", uEntity.getContactNo());
				request.setAttribute("dob", uEntity.getDateOfBirth() != null
						? uEntity.getDateOfBirth().toString() : "");
				String genderText = uEntity.getGender();
				if(genderText != null){
					switch(genderText){
						case "M": genderText = "Male"; break;
						case "F": genderText = "Female"; break;
						default: genderText = "";
					}
				}
				request.setAttribute("gender", uEntity.getGender());
				request.setAttribute("genderText", genderText);
				request.setAttribute("address", uEntity.getAddress());
				request.setAttribute("city", uEntity.getCity());
				request.setAttribute("state", uEntity.getState());
				request.setAttribute("postalCode", uEntity.getPostalCode());
				request.setAttribute("countryName", uEntity.getCountry() != null 
						? uEntity.getCountry().getName() : "");
				
				if(isEdit){
					// Loading countries DD
					List<CountryEntity> countries = commonManager.getCountries();
					Map<String, String> ddCountries = new HashMap<String, String>();
					for(CountryEntity entity : countries){
						ddCountries.put(String.valueOf(entity.getCountryID()), entity.getName());
					}
					System.out.println("Row count @ servlet : " + ddCountries.size());
					request.setAttribute("ddCountries", ddCountries);
					// Loading edit profile
					request.getRequestDispatcher("/editprofile.jsp").forward(request, response);
					return;
				}
			} catch (SQLException e) {
				System.out.println("Exception at doGet of ProfileServlet : " + Utility.getExceptionMessageWithStackTrace(e));
			}
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// Loading view profile
		request.getRequestDispatcher("/viewprofile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserSessionEntity uSession = session != null ? (UserSessionEntity) session.getAttribute("UserSession") : null;
		if(uSession != null)
		{
			request.setAttribute("FullName", uSession.getFullName());
			try {
				// Getting profile data
				UserEntity user = new UserEntity();
				user.setUserID(uSession.getUserId());
				user.setFullName(request.getParameter("Name") != null ? request.getParameter("Name").toString() : null);
				user.setPassport(request.getParameter("PassportNo") != null ? request.getParameter("PassportNo").toString() : null);
				user.setContactNo(request.getParameter("ContactNo") != null ? request.getParameter("ContactNo").toString() : null);
				user.setGender(request.getParameter("Gender") != null ? request.getParameter("Gender").toString() : null);
				user.setAddress(request.getParameter("Address") != null ? request.getParameter("Address").toString() : null);
				user.setCity(request.getParameter("City") != null ? request.getParameter("City").toString() : null);
				user.setState(request.getParameter("State") != null ? request.getParameter("State").toString() : null);
				user.setPostalCode(request.getParameter("PostalCode") != null ? request.getParameter("PostalCode").toString() : null);
				CountryEntity country = new CountryEntity();
				if(request.getParameter("ddCountry") != null){
					country.setCountryID(Integer.parseInt(request.getParameter("ddCountry").toString()));
					user.setCountry(country);
				}
				if(request.getParameter("Dob") != null){
					@SuppressWarnings("deprecation")
					Date date = new Date(request.getParameter("Dob").toString());
					user.setDateOfBirth(date);
				}
				int result = userManager.updateUser(user);
				if(result > 0){
					doGet(request, response);
				} else {
					request.setAttribute(Constants.ERROR_MESSAGE, Messages.FUND_FAILURE);
					request.getRequestDispatcher("/editprofile.jsp").forward(request, response);
					return;
				}
			} catch (SQLException e) {
				System.out.println("Exception at doPost of ProfileServlet : " + Utility.getExceptionMessageWithStackTrace(e));
			}catch (Exception e) {
				System.out.println("Exception at doPost of ProfileServlet : " + Utility.getExceptionMessageWithStackTrace(e));
			}
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}
}