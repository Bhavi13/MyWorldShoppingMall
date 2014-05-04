package com.team12.myworld.manager;

import com.team12.myworld.dao.ShopDAO;
import com.team12.myworld.pojos.Shop;


public class ShopManager {
	ShopDAO shopDAO = new ShopDAO();
	
	public boolean createShop(Shop shopInfo)
	{
		boolean flag = shopDAO.createShop(shopInfo);
		return flag;
	}
	
	public boolean updateShop(Shop shopInfo)
	{
		boolean flag = shopDAO.updateShop(shopInfo);
		return flag;
	}
	
	public boolean deleteShop(Shop shopInfo)
	{
		boolean flag = shopDAO.deleteShop(shopInfo);
		return flag;
	}
}
