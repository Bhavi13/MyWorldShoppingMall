package com.team12.myworld.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team12.*;
import com.team12.myworld.manager.UserManager;
import com.team12.myworld.pojos.ShoppingCart;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int itemCount;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	UserManager userManager = new UserManager();

	public ShoppingCart cart;
	public List<ShoppingCart> primaryCart = new ArrayList<ShoppingCart>();
	public List itemsValue = new ArrayList();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		System.out.println(action);
		if (action.equals("addCart")) {

			// boolean flag=false;

			String itemId = request.getParameter("itemId");
			String shopId = request.getParameter("shopId");
			int itemCount = Integer.parseInt(request.getParameter("itemCount"));
			int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
			System.out.println(" user id:   " + session.getAttribute("userId"));
			System.out.println(itemCount);

			cart = new ShoppingCart(Integer.parseInt(itemId),
					Integer.parseInt(shopId),
					(Integer) session.getAttribute("userId"), itemCount,
					itemPrice);
			cart.setItemCount(itemCount);
			System.out.println(cart.getItemCount());
			primaryCart.add(cart);
			userManager.getCartDetails(cart);
			System.out.println("primaryCart size  :" + primaryCart.size());
			response.sendRedirect("/MyWorldShoppingMall/jsp/ProductPage.jsp");
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/jsp/ProductPage.jsp");
			// rd.forward(request, response);

			// flag=userManager.signUpUser(user);
		} else if (action.equals("openCart")) {

			// boolean flag=false;
			// for (int j=0;j<primaryCart.size();j++){
			// itemsValue.add(primaryCart.get(j).getItemId());
			// }//dont iterate thru arraylist
			// itemCount=userManager.insertCartCount(itemsValue);
			/*
			 * for(int i=0;i<primaryCart.size();i++){
			 * //primaryCart.get(i).getItemId();
			 * //primaryCart.get(i).getShopId();
			 * userManager.getCartDetails(primaryCart.get(i)); }
			 */
			System.out.println("primaryCart size abhi :");
			System.out.println(session.getAttribute("userId"));
			List<ShoppingCart> sCart = userManager
					.displayCart((Integer) session.getAttribute("userId"));
			if (!sCart.isEmpty()) {
				// response.sendRedirect(request.getContextPath()+
				// "/jsp/ShoppingCart.jsp");
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ShoppingCart.jsp");
				request.setAttribute("cartDetails", sCart);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/ShoppingCart.jsp");

				// response.sendRedirect("/ShoppingCart/jsp/ProductPage.jsp");
				request.setAttribute("cartDetails", sCart);
				request.setAttribute("Message",
						"Your cart is empty");
				rd.forward(request, response);
			}
			// flag=userManager.signUpUser(user); saveInvoice

		} else if (action.equals("saveInvoice")) {

			String[] options = request.getParameterValues("options");
			String total = request.getParameter("total");
			session.setAttribute("total", total);
			for (int i = 0; i < options.length; i++) {
				boolean status = userManager.generateInvoice(options.length,
						Integer.parseInt(options[i]),
						(Integer) session.getAttribute("userId"),Integer.parseInt(total));
				for (int j = 0; j < primaryCart.size(); j++) {
					if(primaryCart.get(j).getItemId() == Integer.parseInt(options[i])){
						userManager.insertUserOrder(primaryCart.get(j));
					}
				}
			}
			// for(int i=0;i<primaryCart.size();i++){
			// //options[i].equalsIgnoreCase(arg0)primaryCart.get(i).getItemId();
			// //primaryCart.get(i).getShopId();
			// userManager.insertUserOrder(primaryCart.get(i));
			// }
			// primaryCart.clear();
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Payment.jsp");
			request.setAttribute("total", total);
			rd.forward(request, response);
		}

	}

}
