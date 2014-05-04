package com.team12.myworld.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team12.myworld.manager.ShopManager;
import com.team12.myworld.pojos.Shop;

/**
 * Servlet implementation class CreateShopServlet
 */
@WebServlet("/CreateShopServlet")
public class CreateShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    ShopManager shopManager = new ShopManager();
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
		
		if(action.equals("createShop")){
			
			boolean flag =false;
			
			String shopName = request.getParameter("shopName");
			String owner = "Owner's Name";
			String category = request.getParameter("category");
			String description = request.getParameter("description");
			String approval = "not approved";
			int userId = 1;
			Shop shop = new Shop();
			
			shop.setShopName(shopName);
			shop.setCategory(category);
			shop.setOwner(owner);
			shop.setApproval(approval);
			shop.setDescription(description);
			
			flag = shopManager.createShop(shop);
			
			if(flag == true){
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message","You have successfully created your shop.");
				rd.forward(request, response);
				
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message","Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}
		
		if(action.equals("updateShop")){
			boolean flag =false;
			String shopId = request.getParameter("shopId");
			String shopName = request.getParameter("updateShopName");
			String description = request.getParameter("updateDescription");
			
			Shop shopInfo = new Shop();
			shopInfo.setShopId(shopId);
			shopInfo.setShopName(shopName);
			shopInfo.setDescription(description);
			
			flag = shopManager.updateShop(shopInfo);
			
			if(flag == true){
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message","You have successfully updated your shop.");
				rd.forward(request, response);
				
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message","Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}
		
		if(action.equals("deleteShop")){
			boolean flag =false;
			String shopId = request.getParameter("deleteShopId");
			
			
			Shop shopInfo = new Shop();
			shopInfo.setShopId(shopId);
			
			
			flag = shopManager.deleteShop(shopInfo);
			
			if(flag == true){
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message","You have successfully deleted your shop.");
				rd.forward(request, response);
				
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Success.jsp");
				request.setAttribute("Message","Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}
	}

}
