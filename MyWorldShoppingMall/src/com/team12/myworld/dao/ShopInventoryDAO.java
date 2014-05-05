package com.team12.myworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.team12.myworld.pojos.Item;
import com.team12.myworld.pojos.Shop;
import com.team12.myworld.pojos.ShopInventory;
import com.team12.myworld.utility.DataBaseConnection;

public class ShopInventoryDAO {

	public boolean addInventory(ShopInventory si) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("insert into CMPE18038.SHOPINVENTORY(ShopId, Count, Price, ItemId) values(?,?,?,?)");

			ps.setString(1, si.getShopId());
			ps.setString(2, si.getCount());
			ps.setString(3, si.getPrice());
			ps.setString(4, si.getItemId());

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

	public ArrayList getItems() {
		ArrayList<Item> alItems = new ArrayList<Item>();
		Connection con = null;
		Statement stmt = null;

		try {

			con = DataBaseConnection.getDataBaseConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CMPE18038.ITEM");
			while (rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getString("ItemId"));
				item.setCategory(rs.getString("Category"));
				item.setItemName(rs.getString("ItemName"));
				item.setItemDesc(rs.getString("ItemDesc"));
				alItems.add(item);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
		}
		return alItems;
	}

	public ArrayList getShops(int UserId) {
		ArrayList<Shop> alShops = new ArrayList<Shop>();
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("select * from CMPE18038.SHOP where UserId = ?");
			ps.setInt(1, UserId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Shop shop = new Shop();
				shop.setApproval(rs.getString("UserId"));
				shop.setCategory(rs.getString("ShopCategory"));
				shop.setShopName(rs.getString("ShopName"));
				shop.setDescription(rs.getString("ShopDesc"));
				shop.setShopId(rs.getString("ShopId"));
				alShops.add(shop);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return alShops;
	}

	public ArrayList getInventory(int iShopId) {
		ArrayList<ShopInventory> alShopsInv = new ArrayList<ShopInventory>();
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("select i.ItemName, i.ItemDesc, s.Count, s.Price from CMPE18038.SHOPINVENTORY s, CMPE18038.ITEM i where s.ShopId = ? and s.ItemId = i.ItemId");
			ps.setInt(1, iShopId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopInventory shop = new ShopInventory();
				shop.setItemName(rs.getString("ItemName"));
				shop.setShopDesc(rs.getString("ItemDesc"));
				shop.setCount(rs.getString("Count"));
				shop.setPrice(rs.getString("Price"));
				alShopsInv.add(shop);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return alShopsInv;
	}

	public boolean delInventory(String strShopId, String strItemId) {
		String query = "Delete from CMPE18038.SHOPINVENTORY where ShopId = ? AND ItemId = ?";
		Connection con = null;
		PreparedStatement ps = null;
		boolean flag = false;
		
		try {

			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, strShopId);
			ps.setString(2, strItemId);
			flag = ps.execute();

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
