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
}
