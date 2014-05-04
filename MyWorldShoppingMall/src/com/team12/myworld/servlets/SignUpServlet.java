package com.team12.myworld.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.management.relation.Role;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team12.myworld.manager.UserManager;
import com.team12.myworld.pojos.User;
import com.team12.myworld.pojos.UserOrder;
import com.team12.myworld.pojos.UserReview;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action.equals("signup")) {

			boolean flag = false;

			String fName = request.getParameter("firstName");
			String lName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String emailId = request.getParameter("emailId");
			String passWord = request.getParameter("passWord");
			String role = request.getParameter("role");

			User user = new User();

			user.setFirstName(fName);
			user.setLastName(lName);
			user.setGender(gender);
			user.setEmailAddress(emailId);
			user.setUserPassword(passWord);
			user.setRole(role);

			flag = userManager.signUpUser(user);

			if (flag == true) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/SignUp.jsp");
				request.setAttribute("Message",
						"You have signed up successfully.");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/SignUp.jsp");
				request.setAttribute("Message",
						"Email Id already in use. Please use different Email Id.");
				rd.forward(request, response);
			}

		} else if (action.equalsIgnoreCase("login")) {
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("password");

			User userObj = userManager.login(userName, passWord);

			HttpSession session = request.getSession();

			if (userObj != null) {
				session.setAttribute("userSession", session);
				session.setAttribute("userName", userName);
				session.setAttribute("userId", userObj.getUserId());
				session.setAttribute("role", userObj.getRole());
				System.out.println(userObj.getUserId());
				if (userObj.getRole().equalsIgnoreCase("user")) {
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/ProductPage.jsp");
					rd.forward(request, response);
				}
				if (userObj.getRole().equalsIgnoreCase("shopkeeper")) {
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/Profile.jsp");
					rd.forward(request, response);
				}
				System.out.println("Successful");
			}

			else {
				request.setAttribute("errorMsg", "Invalid Username or Password");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/SignUp.jsp");
				rd.forward(request, response);
			}

		} else if (action.equalsIgnoreCase("ViewPurchasedItemForReview")) {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");

			ArrayList<UserOrder> userOrdersList = new ArrayList<>();
			userOrdersList = userManager.viewPurchasedItemForReview(userName);
			if (userOrdersList != null) {
				session.setAttribute("userSession", session);
				request.setAttribute("userOrderArrayList", userOrdersList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewListForUserReview.jsp");
				rd.forward(request, response);
			}

			else {
				request.setAttribute("Message",
						"Something went wrong please try again");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewListForUserReview.jsp");
				rd.forward(request, response);
			}
		}

		else if (action.equalsIgnoreCase("getItemDetails")) {

			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");

			int userOrderId = Integer.parseInt(request
					.getParameter("userOrderId"));
			UserOrder userOrderObj = userManager
					.getDetailsOfItemsByOrderId(userOrderId);

			if (userOrderObj != null) {
				session.setAttribute("userSession", session);
				request.setAttribute("userOrderObj", userOrderObj);
				session.setAttribute("userOrderObj", userOrderObj);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/WriteUserReview.jsp");
				rd.forward(request, response);
			}

			else {
				request.setAttribute("Message",
						"Something went wrong please try again");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/WriteUserReview.jsp");
				rd.forward(request, response);
			}
		}

		else if (action.equalsIgnoreCase("writeReview")) {
			UserReview userReview = new UserReview();

			userReview.setItemId(Integer.parseInt(request
					.getParameter("itemId")));
			userReview.setDescription(request.getParameter("ReviewDesc"));
			userReview.setOrderId(Integer.parseInt(request
					.getParameter("orderId")));
			userReview.setRating(Integer.parseInt(request
					.getParameter("rating")));
			userReview.setShopId(Integer.parseInt(request
					.getParameter("shopId")));
			userReview.setUserId(Integer.parseInt(request
					.getParameter("userId")));

			boolean flag = userManager.insertUserReview(userReview);

			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");

			UserOrder userOrder = (UserOrder) session.getAttribute("userOrderObj");
			int userOrderId = userOrder.getOrderId();
			UserOrder userOrderObj = userManager
					.getDetailsOfItemsByOrderId(userOrderId);
			if (userOrderObj != null) {
				session.setAttribute("userSession", session);
				request.setAttribute("userOrderObj", userOrderObj);
			}

			if (flag == true) {
				
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/WriteUserReview.jsp");
				request.setAttribute("Message", "Review Submitted");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/WriteUserReview.jsp");
				request.setAttribute("Message",
						"Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}

		else if (action.equalsIgnoreCase("ViewUserReview")) {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");

			ArrayList<UserReview> userReviewsList = new ArrayList<>();

			userReviewsList = userManager.viewUserReview(userName);

			if (userReviewsList != null) {
				session.setAttribute("userSession", session);
				request.setAttribute("userReviewsList", userReviewsList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewUserReview.jsp");
				rd.forward(request, response);
			}

			else {
				request.setAttribute("Message",
						"Something went wrong please try again");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewUserReview.jsp");
				rd.forward(request, response);
			}

		}

		else if (action.equals("ViewUserReviewByItemId")) {
			HttpSession session = request.getSession();
			// int itemId = (int) session.getAttribute("itemId");

			ArrayList<UserReview> userReviewsList = new ArrayList<>();
			// userReviewsList = userManager.viewUserReviewByItemId(itemId);
			userReviewsList = userManager.viewUserReviewByItemId(1);

			if (userReviewsList != null) {
				session.setAttribute("userSession", session);
				request.setAttribute("userReviewsList", userReviewsList);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewUserReview.jsp");
				rd.forward(request, response);
			}

			else {
				request.setAttribute("Message",
						"Something went wrong please try again");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ViewUserReview.jsp");
				rd.forward(request, response);
			}

		}

		else if (action.equals("updateRewardPoints")) {
			HttpSession session = request.getSession();
			//double totalAmt = (double) session.getAttribute("totalAmt");
			int totalAmt = Integer.parseInt((String) session.getAttribute("total"));
			String userName = (String) session.getAttribute("userName");
			User userObj = userManager.updateRewardPoints(totalAmt, userName);

			if (userObj.getRewardPoints() >= 0) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/PaymentSuccess.jsp");
				request.setAttribute("Message", "Payment Succesfully");
				request.setAttribute("userObj", userObj);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/PaymentSuccess.jsp");
				request.setAttribute("Message",
						"Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}

		else if (action.equalsIgnoreCase("viewRewardPointsByUserId")) {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");

			User userObj = userManager.viewRewardPointsByUserId(userName);

			if (userObj.getRewardPoints() >= 0) {
				request.setAttribute("userObj", userObj);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/PaymentSuccess.jsp");
				request.setAttribute("Message", "Your Reward Points: " + userObj.getRewardPoints());
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message",
						"Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}

	}

}
