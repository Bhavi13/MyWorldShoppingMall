package com.team12.myworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team12.myworld.pojos.ShoppingCart;
import com.team12.myworld.pojos.User;
import com.team12.myworld.pojos.UserOrder;
import com.team12.myworld.pojos.UserReview;
import com.team12.myworld.utility.DataBaseConnection;

public class UserDAO {

	static int totalPrice;
	static int cartCount;
	List<ShoppingCart> displayItems = new ArrayList<ShoppingCart>();

	// static String shopName;
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public boolean signUpUser(User userInfo) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("insert into USER(FirstName,LastName,Email,Password,Role,Gender) values(?,?,?,?,?,?)");

			ps.setString(1, userInfo.getFirstName());
			ps.setString(2, userInfo.getLastName());
			ps.setString(3, userInfo.getEmailAddress());
			ps.setString(4, userInfo.getUserPassword());
			ps.setString(5, userInfo.getRole());
			ps.setString(6, userInfo.getGender());

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

	public ShoppingCart cartDetails(ShoppingCart sCart) {
		// boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = DataBaseConnection.getDataBaseConnection();

			ps = con.prepareStatement("select * from SHOP,ITEM where ItemId = ? and ShopId= ?");
			ps.setInt(1, sCart.getItemId());
			ps.setInt(2, sCart.getShopId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				// itemName = rs.getString("ItemName");
				// shopName = rs.getString("Shop_Name");
				sCart.setItemName(rs.getString("ItemName"));
				sCart.setShopName(rs.getString("ShopName"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return sCart;

	}

	public boolean cartDetail(ShoppingCart sCart) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataBaseConnection.getDataBaseConnection();
			
			ps = con.prepareStatement("Select Count(*), Item_Quantity from SHOP_CART where ItemId = ? AND ShopId = ? AND ItemName = ? AND User_Id = ?");
			//ps = con.prepareStatement("insert into SHOP_CART(ItemId,ShopId,ItemName,ShopName,User_Id,Item_Quantity,Item_Price) values(?,?,?,?,?,?,?)");
			// ps.setInt(1, cartCount);
//			ps.setInt(1, sCart.getItemId());
//			ps.setInt(2, sCart.getShopId());
//			ps.setString(3, sCart.getItemName());
//			ps.setString(4, sCart.getShopName());
//			ps.setInt(5, sCart.getUserId());
//			ps.setInt(6, sCart.getItemQuantity());
//			ps.setInt(7, sCart.getItemPrice());
			
			ps.setInt(1, sCart.getItemId());
			ps.setInt(2, sCart.getShopId());
			ps.setString(3, sCart.getItemName());
			ps.setInt(4, sCart.getUserId());
			
			ResultSet set = ps.executeQuery();
			int check = 0;
			if(set.next()){
				if(set.getInt(1)>0){
					int count = set.getInt(2) + sCart.getItemCount();
					System.out.println(sCart.getItemCount());
					System.out.println(set.getInt(2));
					System.out.println(count);
					ps = con.prepareStatement("update SHOP_CART SET Item_Quantity=? , Item_Price=? where ItemId=? AND ShopId=? AND ItemName=? AND User_Id=?");
					
					ps.setInt(1, count);
					ps.setInt(2, sCart.getItemPrice());
					ps.setInt(3, sCart.getItemId());
					ps.setInt(4, sCart.getShopId());
					ps.setString(5, sCart.getItemName());
					ps.setInt(6, sCart.getUserId());
					check = ps.executeUpdate();
					
				}else{
					ps = con.prepareStatement("insert into SHOP_CART(ItemId,ShopId,ItemName,ShopName,User_Id,Item_Quantity,Item_Price) values(?,?,?,?,?,?,?)");
					ps.setInt(1, cartCount);
					ps.setInt(1, sCart.getItemId());
					ps.setInt(2, sCart.getShopId());
					ps.setString(3, sCart.getItemName());
					ps.setString(4, sCart.getShopName());
					ps.setInt(5, sCart.getUserId());
					ps.setInt(6, sCart.getItemQuantity());
					ps.setInt(7, sCart.getItemPrice());
					
					check = ps.executeUpdate();
				}
			}

			if (check > 0)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return flag;

	}

	public User login(String userId, String passWord) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement prpstmnt = null;
		PreparedStatement ps = null;
		User userObj = null;

		con = DataBaseConnection.getDataBaseConnection();
		try {
			prpstmnt = con.prepareStatement("Select count(*) from USER where Email = ? && Password = ?");
			prpstmnt.setString(1, userId);
			prpstmnt.setString(2, passWord);

			ResultSet result = prpstmnt.executeQuery();

			if (result.next())
				if (result.getInt(1) > 0)
					flag = true;

			if (flag == true) {
				ps = con.prepareStatement("select * from USER where Email = ? && Password = ?");
				ps.setString(1, userId);
				ps.setString(2, passWord);
				userObj = new User();
				ResultSet set = ps.executeQuery();
				while (set.next()) {
					userObj.setUserId(set.getInt("UserId"));
					userObj.setFirstName(set.getString("FirstName"));
					userObj.setEmailAddress(set.getString("Email"));
					userObj.setGender(set.getString("Gender"));
					userObj.setLastName(set.getString("LastName"));
					userObj.setRole(set.getString("Role"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(prpstmnt);
			DataBaseConnection.closeStatement(ps);
		}
		return userObj;
	}

	@SuppressWarnings("resource")
	public int insertCartCount(List itemsValue) {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < itemsValue.size(); i++) {
			builder.append("?,");
		}

		String stmt = "select SUM(ItemPrice) from ITEM where ItemId in ( "
				+ builder.deleteCharAt(builder.length() - 1).toString() + ")";
		String stmt2 = "insert into CART_COUNT(ItemCount,TotalCount) values(?,?)";
		String stmt3 = "select * from CART_COUNT";
		System.out.println(" sqlllll:  " + stmt);
		try {
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement(stmt, ps.RETURN_GENERATED_KEYS);
			int index = 1;
			for (Object o : itemsValue) {
				ps.setObject(index++, (Integer) o); // or whatever it applies
			}
			// ps.setInt(1, sCart.getItemId());

			ResultSet rs = ps.executeQuery();
			// ResultSet rs1 = ps.getGeneratedKeys();
			// rs.insertRow();
			while (rs.next()) {
				totalPrice = rs.getInt(1);
				// cartCount=rs.get
				// System.out.println("Total price:   "+totalPrice);
			}
			// to get total price
			ps = con.prepareStatement(stmt2);
			ps.setInt(1, itemsValue.size());
			ps.setInt(2, totalPrice);
			ps.executeUpdate();
			// to get latest cart id
			ps = con.prepareStatement(stmt3);
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				cartCount = rs1.getInt("CartId");

				// cartCount=rs.get
				// System.out.println("Total cartCount:   "+cartCount);
				// break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return totalPrice;

	}

	public boolean generateInvoice(int itemCount,int itemId, int userId, int total) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "Delete from SHOP_CART where User_Id = ? AND ItemId = ?";
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("insert into INVOICE(Quantity,Date,Total_Amt) values(?,?,?)");
			ps.setInt(1, itemCount);
			ps.setDate(2, getCurrentDate());
			ps.setInt(3, total);
			int check = ps.executeUpdate();

			if (check > 0) {
				flag = true;
			}
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			ps.setInt(2, itemId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}

		return flag;
	}

	public void insertUserOrder(ShoppingCart shoppingCart) {
		// boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		Date date = getCurrentDate();

		try {
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("insert into USER_ORDER(Order_Date,USer_Id,Shop_Id,Item_Id) values(?,?,?,?)");
			ps.setString(1, date.toString());
			ps.setInt(2, shoppingCart.getUserId());
			ps.setInt(3, shoppingCart.getShopId());
			ps.setInt(4, shoppingCart.getItemId());

			int check = ps.executeUpdate();

			// if(check> 0)
			// return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		// return flag;

	}

	public List<ShoppingCart> displayCart(int userId) {

		// displayItems
		Connection con = null;
		PreparedStatement ps = null;
		Date date = getCurrentDate();
		ShoppingCart sCart;
		try {
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("SELECT * FROM SHOP_CART WHERE USER_ID= ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			displayItems.clear();
			while (rs.next()) {
				sCart = new ShoppingCart();
				sCart.setCartId(rs.getInt(1));
				sCart.setItemId(rs.getInt(2));
				sCart.setShopId(rs.getInt(3));
				sCart.setItemName(rs.getString(4));
				sCart.setShopName(rs.getString(5));
				sCart.setUserId(rs.getInt(6));
				sCart.setItemCount(rs.getInt(7));
				sCart.setItemPrice(rs.getInt(8));
				
				displayItems.add(sCart);
			}

			// if(check> 0)
			// return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		// return flag;
		return displayItems;
	}
	
	public ArrayList<UserOrder> viewPurchasedItemForReview(String userName)
	{
		ArrayList<UserOrder> userOrderList = new ArrayList<>();
		UserOrder userOrder = new UserOrder();
		Connection con = null;
		PreparedStatement ps = null;

		con = DataBaseConnection.getDataBaseConnection();
		try
		{
			ps = con.prepareStatement("select * from USER_ORDER UO INNER JOIN ITEM I ON (I.ItemId = UO.Item_Id) INNER JOIN SHOP S ON (S.ShopId = UO.Shop_Id) Where UO.User_Id in (Select UserId from USER  where Email = ?)");
			ps.setString(1, userName);
			
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				userOrder.setItemId(set.getInt("Item_Id"));
				userOrder.setOrderDate(set.getString("Order_Date"));
				userOrder.setOrderId(set.getInt("Order_Id"));
				userOrder.setShopId(set.getInt("Shop_Id"));
				userOrder.setUserId(set.getInt("User_Id"));
				userOrder.setUserName(userName);
				userOrder.setCategory(set.getString("Category"));
				userOrder.setItemDesc(set.getString("ItemDesc"));
				userOrder.setItemName(set.getString("ItemName"));
				userOrder.setShopName(set.getString("ShopName"));
				userOrder.setShopCategory(set.getString("ShopCategory"));

				userOrderList.add(userOrder);
				
			}
				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return userOrderList;
	}

	public UserOrder getDetailsOfItemsByOrderId(int userOrderId)
	{
		UserOrder userOrder = new UserOrder();
		Connection con = null;
		PreparedStatement ps = null;
		
		con = DataBaseConnection.getDataBaseConnection();
		try
		{
			ps = con.prepareStatement("select * from USER_ORDER UO INNER JOIN ITEM I ON (I.ItemId = UO.Item_Id) INNER JOIN SHOP S ON (S.ShopId = UO.Shop_Id) where UO.Order_Id = ?");
			
			ps.setInt(1, userOrderId);
			
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				userOrder.setItemId(set.getInt("Item_Id"));
				userOrder.setOrderDate(set.getString("Order_Date"));
				userOrder.setOrderId(set.getInt("Order_Id"));
				userOrder.setShopId(set.getInt("Shop_Id"));
				userOrder.setUserId(set.getInt("User_Id"));
				userOrder.setCategory(set.getString("Category"));
				userOrder.setItemDesc(set.getString("ItemDesc"));
				userOrder.setItemName(set.getString("ItemName"));
				userOrder.setShopName(set.getString("ShopName"));
				userOrder.setShopCategory(set.getString("ShopCategory"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return userOrder;
	}

	public boolean insertUserReview(UserReview userReviewObj)
	{
		boolean flag = false;
		Connection con =null;
		PreparedStatement ps = null;
		
		con=DataBaseConnection.getDataBaseConnection();
		try
		{
			ps = con.prepareStatement("insert into USER_REVIEW(UserId, ItemId, ShopId, Rating, Description) values (?,?,?,?,?)");
			ps.setInt(1, userReviewObj.getUserId());
			ps.setInt(2, userReviewObj.getItemId());
			ps.setInt(3, userReviewObj.getShopId());
			ps.setInt(4, userReviewObj.getRating());
			ps.setString(5, userReviewObj.getDescription());
			
			int check = ps.executeUpdate();
			
			if(check>0)
			{
				flag = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return flag;
	}
	
	public ArrayList<UserReview> viewUserReview(String userName)
	{
		ArrayList<UserReview> userReviewsList = new ArrayList<>();
		UserReview userReviewObj = new UserReview();
		Connection con = null;
		PreparedStatement ps=null;
		
		con = DataBaseConnection.getDataBaseConnection();
		try
		{
			ps = con.prepareStatement("select * from USER_REVIEW UR INNER JOIN ITEM I ON (I.ItemId = UR.ItemId) INNER JOIN SHOP S ON (S.ShopId = UR.ShopId) INNER JOIN USER U ON (U.UserId = UR.UserId) Where UR.UserId in (Select UserId from USER  where Email = ?)");
			ps.setString(1, userName);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				userReviewObj.setDescription(set.getString("Description"));
				userReviewObj.setItemCategory(set.getString("Category"));
				userReviewObj.setItemDesc(set.getString("ItemDesc"));
				userReviewObj.setItemName(set.getString("ItemName"));
				userReviewObj.setItemId(set.getInt("ItemId"));
				userReviewObj.setRating(set.getInt("Rating"));
				userReviewObj.setShopCategory(set.getString("ShopCategory"));
				userReviewObj.setShopDesc(set.getString("ShopDesc"));
				userReviewObj.setShopId(set.getInt("ShopId"));
				userReviewObj.setShopName(set.getString("ShopName"));
				userReviewObj.setUserId(set.getInt("UserId"));
				userReviewObj.setUserName(set.getString("Email"));
				userReviewObj.setFirstName(set.getString("FirstName"));
				userReviewObj.setLastName(set.getString("LastName"));
				
				userReviewsList.add(userReviewObj);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return userReviewsList;
	}

	public ArrayList<UserReview> viewUserReviewByItemId(int itemId)
	{
		ArrayList<UserReview> userReviewsList = new ArrayList<>();
		UserReview userReviewObj = new UserReview();
		Connection con = null;
		PreparedStatement ps=null;
		
		con = DataBaseConnection.getDataBaseConnection();
		try
		{
			ps = con.prepareStatement("select * from USER_REVIEW UR INNER JOIN ITEM I ON (I.ItemId = UR.ItemId) INNER JOIN SHOP S ON (S.ShopId = UR.ShopId) INNER JOIN USER U ON (U.UserId = UR.UserId) Where UR.ItemId in (Select ItemId from ITEM  where ItemId = ?)");
			ps.setInt(1, itemId);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				userReviewObj.setDescription(set.getString("Description"));
				userReviewObj.setItemCategory(set.getString("Category"));
				userReviewObj.setItemDesc(set.getString("ItemDesc"));
				userReviewObj.setItemName(set.getString("ItemName"));
				userReviewObj.setItemId(set.getInt("ItemId"));
				userReviewObj.setRating(set.getInt("Rating"));
				userReviewObj.setShopCategory(set.getString("ShopCategory"));
				userReviewObj.setShopDesc(set.getString("ShopDesc"));
				userReviewObj.setShopId(set.getInt("ShopId"));
				userReviewObj.setShopName(set.getString("ShopName"));
				userReviewObj.setUserId(set.getInt("UserId"));
				userReviewObj.setUserName(set.getString("Email"));
				userReviewObj.setFirstName(set.getString("FirstName"));
				userReviewObj.setLastName(set.getString("LastName"));
				
				userReviewsList.add(userReviewObj);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		
		}
		return userReviewsList;
	}
	
	public User updateRewardPoints(double totalAmount, String userName)
	{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		int tempRewardPoints =0;
		int rewardPoints = 0;
		User userObj = null;
		con = DataBaseConnection.getDataBaseConnection();
		try
		{
			if(totalAmount <= 50)
			{
				rewardPoints = 5;
			}
			else if(totalAmount> 50 && totalAmount<=100)
			{
				rewardPoints = 10;
			}
			else if(totalAmount > 100 && totalAmount <= 150)
			{
				rewardPoints = 15;
			}
			else if(totalAmount>=150) 
			{
				rewardPoints = 20;
			}
			
			ps = con.prepareStatement("select Reward from USER where Email =?");
			ps.setString(1, userName);
			
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				tempRewardPoints = set.getInt("Reward");
			}
			
			rewardPoints = tempRewardPoints + rewardPoints;
			
			ps1 = con.prepareStatement("update USER set Reward = ? where Email = ?");
			ps1.setInt(1, rewardPoints);
			ps1.setString(2, userName);
			
			ps1.executeUpdate();
			
			ps2 = con.prepareStatement("select Reward from USER where Email = ?");
			ps2.setString(1, userName);
			
			ResultSet set2 = ps2.executeQuery();
			
			while(set2.next())
			{
				userObj = new User();
				userObj.setRewardPoints(set2.getInt("Reward"));
				
			}
				
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		return userObj;
	}
	
	public User viewRewardPointsByUserId(String userName)
	{
		Connection con = null;
		PreparedStatement ps =null;
		User userObj = new User();
		
		con =DataBaseConnection.getDataBaseConnection();
		try
		{
			ps = con.prepareStatement("select * from USER where Email = ?");
			ps.setString(1, userName);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				userObj.setEmailAddress(userName);
				userObj.setRewardPoints(set.getInt("Reward"));
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		
		return userObj;
	}

}