package com.team12.myworld.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team12.myworld.manager.UserManager;
import com.team12.myworld.pojos.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    UserManager userManager = new UserManager();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String action = request.getParameter("action");
		
		if(action.equals("signup"))
		{
			
			boolean flag=false;

			String fName = request.getParameter("firstName");
			String lName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String emailId= request.getParameter("emailId");
			String passWord = request.getParameter("passWord");
			String role = request.getParameter("role");
			
			User user = new User();
			
			user.setFirstName(fName);
			user.setLastName(lName);
			user.setGender(gender);
			user.setEmailAddress(emailId);
			user.setUserPassword(passWord);
			user.setRole(role);
			
			flag=userManager.signUpUser(user);
			
			
			if(flag==true)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message","You have signed up successfully.");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message","Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("login"))
		{
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("password");

			User userObj = userManager.login(userName, passWord);

			HttpSession session = request.getSession();

			if(userObj != null)
			{
				session.setAttribute("userSeesion", session);
				session.setAttribute("userId", userName);
				session.setAttribute("role", userObj.getRole());
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/HomePage.jsp");
				rd.forward(request, response);
				System.out.println("Successful");
			}

			else
			{
				request.setAttribute("errorMsg", "Invalid Username or Password");
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/Login.jsp");
				rd.forward(request, response);
			}
		}
		
	}

}
