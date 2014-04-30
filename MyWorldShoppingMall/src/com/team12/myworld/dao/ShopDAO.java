package com.team12.myworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team12.myworld.pojos.Shop;
import com.team12.myworld.utility.DataBaseConnection;

public class ShopDAO {

	public boolean createShop(Shop shopInfo) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("insert into SHOP(ShopName,ShopOwner,ShopCategory,ShopDesc,ShopApproval) values(?,?,?,?,?)");

			ps.setString(1, shopInfo.getShopName());
			ps.setString(2, shopInfo.getOwner());
			ps.setString(3, shopInfo.getCategory());
			ps.setString(4, shopInfo.getDescription());
			ps.setString(5, shopInfo.getApproval());

			int check = ps.executeUpdate();

			if (check > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}

		return flag;
	}
}
