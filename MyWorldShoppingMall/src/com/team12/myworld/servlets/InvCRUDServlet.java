package com.team12.myworld.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team12.myworld.manager.ShopInvManager;
import com.team12.myworld.pojos.ShopInventory;

/**
 * Servlet implementation class InvCRUDServlet
 */
@WebServlet("/InvCRUDServlet")
public class InvCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvCRUDServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("addInvnentory".equalsIgnoreCase(action))
		{
			boolean flag=false;

			String sId = request.getParameter("shopName");
			String iId = request.getParameter("item");
			String iCount = request.getParameter("count");
			String iPrice = request.getParameter("price");

			ShopInventory si = new ShopInventory();
			si.setCount(iCount);
			si.setShopId(sId);
			si.setItemId(iId);
			si.setPrice(iPrice);

			ShopInvManager sim = new ShopInvManager();
			flag=sim.addInventory(si);


			if(flag==true)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Profile.jsp?res=Success");
				request.setAttribute("Message","Item Added Successfully.");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Profile.jsp?res=Failed");
				request.setAttribute("Message","Something went wrong.Please try again");
				rd.forward(request, response);
			}

		}
		else if("listItem".equalsIgnoreCase(action)){
			System.out.println("Inside list item");
			boolean flag=false;
			int sId = Integer.parseInt(request.getParameter("shopName"));
			ShopInvManager sim = new ShopInvManager();
			ArrayList<ShopInventory> alSI = null;
			
			try{
				alSI = sim.getInventories(sId);
				flag=true;
			}
			catch(Exception ex){
				flag=false;
			}

			if(flag==true)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Profile.jsp?res=Success");
				//request.setAttribute("Message","Item fetched Successfully.");
				request.setAttribute("items", alSI);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Profile.jsp?res=Failed");
				request.setAttribute("Message","Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}
		else if("deleteInventory".equalsIgnoreCase(action)){
			boolean flag = false;
			String strShopId = request.getParameter("shopName");
			String strItemId = request.getParameter("item");
			
			ShopInvManager sim = new ShopInvManager();
			flag=sim.delInventory(strShopId, strItemId);


			if(flag==true)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Profile.jsp?res=Success");
				request.setAttribute("Message","Item Deleted Successfully.");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/Profile.jsp?res=Failed");
				request.setAttribute("Message","Something went wrong.Please try again");
				rd.forward(request, response);
			}
		}
	}

}
