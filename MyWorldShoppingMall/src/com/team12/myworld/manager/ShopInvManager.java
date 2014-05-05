package com.team12.myworld.manager;

import java.util.ArrayList;

import com.team12.myworld.dao.ShopDAO;
import com.team12.myworld.dao.ShopInventoryDAO;
import com.team12.myworld.dao.UserDAO;
import com.team12.myworld.pojos.Item;
import com.team12.myworld.pojos.Shop;
import com.team12.myworld.pojos.ShopInventory;
import com.team12.myworld.pojos.User;

public class ShopInvManager {

	
	ShopInventoryDAO shopInvDAO = new ShopInventoryDAO();
	
	public boolean addInventory(ShopInventory si)
	{
		boolean flag = shopInvDAO.addInventory(si);
		return flag;
	}
	
	public boolean delInventory(String strShopId, String strItemId)
	{
		boolean flag = shopInvDAO.delInventory(strShopId, strItemId);
		return flag;
	}
	public ArrayList<ShopInventory> getInventories(int iShopId){
		ArrayList alRetList = new ArrayList();
		alRetList = shopInvDAO.getInventory(iShopId);
		return alRetList;
	}
	public ArrayList<Shop> getShops(int iUserId){
		ArrayList alRetList = new ArrayList();
		alRetList = shopInvDAO.getShops(iUserId);
		return alRetList;
	}
	
	
	public ArrayList<Item> getItems(){
		ArrayList alRetList = new ArrayList();
		alRetList = shopInvDAO.getItems();
		return alRetList;
	}

}
