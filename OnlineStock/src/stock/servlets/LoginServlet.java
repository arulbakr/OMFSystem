package stock.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import stock.Dao.UserDao;
import stock.common.Constants;
import stock.common.Messages;
import stock.common.Utility;
import stock.entities.UserEntity;
import stock.entities.UserSessionEntity;
import stock.managerbeans.UserManagerBeanLocal;

/**
 * Servlet implementation class LoginServlet
 * @author arullap
 */
@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private UserManagerBeanLocal userManager;
	//private UserDao userDao = new UserDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Log off */
		HttpSession session = request.getSession(false);
		session.invalidate();
		request.getRequestDispatcher("./login.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(request != null){
				if(request.getParameter(Constants.EMAIL) == null || request.getParameter(Constants.EMAIL) == Constants.STRING_EMPTY){
					request.setAttribute(Constants.ERROR_MESSAGE, Messages.MAIL_EMPTY);
					request.getRequestDispatcher("./login.jsp").forward(request, response);
				}
				if(request.getParameter(Constants.PASSWWORD) == null || request.getParameter(Constants.PASSWWORD) == Constants.STRING_EMPTY){
					request.setAttribute(Constants.ERROR_MESSAGE, Messages.PASSWORD_EMPTY);
					request.getRequestDispatcher("./login.jsp").forward(request, response);
				}		
				System.out.println(String.format("request is not null"));
				/* Calling database */
				UserEntity user = userManager.getUser(request.getParameter(Constants.EMAIL), request.getParameter(Constants.PASSWWORD));
				//UserEntity user = userDao.getUser(request.getParameter(Constants.EMAIL), request.getParameter(Constants.PASSWWORD));
				if(user != null && user.getUserID() > 0){
					System.out.println("login successful : UserID : " + user.getUserID());
					/* Store user details in session */
					HttpSession session = request.getSession(true);
					UserSessionEntity uSession = new UserSessionEntity();
					uSession.setUserId(user.getUserID());
					uSession.setFullName(user.getFullName());
					session.setAttribute("UserSession", uSession);
					
					response.sendRedirect("./HomeServlet");
				}else{
					System.out.println("login failed");
					request.setAttribute(Constants.ERROR_MESSAGE, Messages.LOGIN_ERROR);
					request.getRequestDispatcher("./login.jsp").forward(request, response);
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception at loginServlet : " + Utility.getExceptionMessageWithStackTrace(e));
		}
	}
}