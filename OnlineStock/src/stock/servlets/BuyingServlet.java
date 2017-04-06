package stock.servlets;

import java.io.IOException;
import java.sql.SQLException;
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
import stock.entities.FundTypeEntity;
import stock.entities.UserEntity;
import stock.entities.UserFundEntity;
import stock.entities.UserSessionEntity;
import stock.managerbeans.TransactionManagerBeanLocal;

/**
 * Servlet implementation class BuyingServlet
 */
@WebServlet("/BuyingServlet")
public class BuyingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private TransactionManagerBeanLocal txnManager;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Executed doGet of BuyingServlet");
		
		HttpSession session = request.getSession(false);
		UserSessionEntity uSession = session != null ? (UserSessionEntity) session.getAttribute("UserSession") : null;
		if(uSession != null)
		{
			request.setAttribute("FullName", uSession.getFullName());
			try {
				// Loading funds DD
				List<FundTypeEntity> fundTypes = txnManager.getFundTypes(0);
				Map<String, String> ddFundTypes = new HashMap<String, String>();
				ddFundTypes.put("0", "--Select--");
				for(FundTypeEntity entity : fundTypes){
					ddFundTypes.put(String.valueOf(entity.getFundTypeId()), entity.getDescription());
				}
				System.out.println("Row count @ servlet : " + ddFundTypes.size());
				request.setAttribute("ddFundTypes", ddFundTypes);
			} catch (SQLException e) {
				Utility.getExceptionMessageWithStackTrace(e);
			}
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/buy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Executed doPost of BuyingServlet");
		int result = 0;
		HttpSession session = request.getSession(false);
		UserSessionEntity uSession = session != null ? (UserSessionEntity) session.getAttribute("UserSession") : null;
		if(uSession != null)
		{
			UserFundEntity ufEntity = new UserFundEntity();
			FundTypeEntity fType = new FundTypeEntity();
			fType.setFundTypeId(request.getParameter("ddFundType") != null 
					? Integer.parseInt(request.getParameter("ddFundType").toString()) : 0);
			ufEntity.setFundType(fType);
			UserEntity user = new UserEntity();
			user.setUserID(uSession.getUserId());
			
			ufEntity.setAmount(request.getParameter("Amount") != null ?
					Float.parseFloat(request.getParameter("Amount")) : 0);
			ufEntity.setFundType(fType);
			ufEntity.setUser(user);
			
			try {
				result = txnManager.saveUserFund(ufEntity);
				if(result > 0){
					request.setAttribute(Constants.SUCCESS_MESSAGE, Messages.FUND_SUCCESS);
				} else {
					request.setAttribute(Constants.ERROR_MESSAGE, Messages.FUND_FAILURE);
				}
				// Loading funds DD
				List<FundTypeEntity> fundTypes = txnManager.getFundTypes(0);
				Map<String, String> ddFundTypes = new HashMap<String, String>();
				ddFundTypes.put("0", "--Select--");
				for(FundTypeEntity entity : fundTypes){
					ddFundTypes.put(String.valueOf(entity.getFundTypeId()), entity.getDescription());
				}
				System.out.println("Row count @ servlet : " + ddFundTypes.size());
				request.setAttribute("ddFundTypes", ddFundTypes);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/buy.jsp").forward(request, response);
	}
}