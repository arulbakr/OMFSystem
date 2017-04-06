package stock.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stock.entities.AccountEntity;
import stock.entities.UserSessionEntity;
import stock.managerbeans.UserManagerBeanLocal;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserManagerBeanLocal userManager;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Executed doGet of HomeServlet");
		
		HttpSession session = request.getSession(false);
		UserSessionEntity uSession = session != null ? (UserSessionEntity) session.getAttribute("UserSession") : null;
		if(uSession != null)
		{
			request.setAttribute("FullName", uSession.getFullName());
			try {
				AccountEntity account = userManager.getAccountDetails(uSession.getUserId());
				 if(account != null){
					 System.out.println("account.getTotalDeposit() :: " + account.getTotalDeposit());
					 request.setAttribute("totalDeposit", account.getTotalDeposit() == 0.0 ? "" : account.getTotalDeposit());
					 request.setAttribute("totalMaturedAmt", account.getTotalMatured() == 0.0 ? "" : account.getTotalMatured());
					 request.setAttribute("growthPercent", account.getGrowthPercent() == 0 ? "" : account.getGrowthPercent());
					 System.out.println("Total deposit : " + request.getAttribute("totalDeposit"));
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("./home.jsp").forward(request, response);
	}
}