package com.team12.myworld.manager;

import java.util.ArrayList;
import java.util.List;

import com.team12.myworld.dao.UserDAO;
import com.team12.myworld.pojos.ShoppingCart;
import com.team12.myworld.pojos.User;
import com.team12.myworld.pojos.UserOrder;
import com.team12.myworld.pojos.UserReview;

public class UserManager {

	UserDAO userDAO = new UserDAO();
	ShoppingCart s;

	public void getCartDetails(ShoppingCart s) {

		s = userDAO.cartDetails(s);
		userDAO.cartDetail(s);

	}

	public boolean signUpUser(User userInfo) {
		boolean flag = userDAO.signUpUser(userInfo);
		return flag;
	}

	public User login(String userId, String passWord) {
		User userObj = new User();
		userObj = userDAO.login(userId, passWord);
		return userObj;
	}

	public int insertCartCount(List itemsValue) {
		int itemCount = userDAO.insertCartCount(itemsValue);
		return itemCount;
	}

	public boolean generateInvoice(int itemCount, int itemId, int userId, int total) {
		boolean status = userDAO.generateInvoice(itemCount,itemId, userId, total);
		return false;
	}

	public void insertUserOrder(ShoppingCart shoppingCart) {
		userDAO.insertUserOrder(shoppingCart);

	}

	public List<ShoppingCart> displayCart(int userId) {
		// TODO Auto-generated method stub
		return userDAO.displayCart(userId);
	}
	
	public ArrayList<UserOrder> viewPurchasedItemForReview(String userName)
	{
		ArrayList<UserOrder> userOrdersList = new ArrayList<>();
		userOrdersList = userDAO.viewPurchasedItemForReview(userName);
		return userOrdersList;
	}

	public UserOrder getDetailsOfItemsByOrderId(int userOrderId)
	{
		UserOrder userOrder = new UserOrder();
		userOrder = userDAO.getDetailsOfItemsByOrderId(userOrderId);
		return userOrder;
	}
	
	public boolean insertUserReview(UserReview userReviewObj)
	{
		boolean flag = false;
		flag = userDAO.insertUserReview(userReviewObj);
		return flag;
	}
	public ArrayList<UserReview> viewUserReview(String userName)
	{
		ArrayList<UserReview> userReviewsList = new ArrayList<>();
		userReviewsList = userDAO.viewUserReview(userName);
		return userReviewsList;
	}
	public ArrayList<UserReview> viewUserReviewByItemId(int itemId)
	{
		ArrayList<UserReview> userReviewsList = new ArrayList<>();
		userReviewsList = userDAO.viewUserReviewByItemId(itemId);
		return userReviewsList;
	}
	
	public User updateRewardPoints(double totalAmount, String userName)
	{
		User userObj = new User();
		userObj = userDAO.updateRewardPoints(totalAmount, userName);
		return userObj;
	}
	public User viewRewardPointsByUserId(String userName)
	{
		User userObj = new User();
		userObj = userDAO.viewRewardPointsByUserId(userName);
		return userObj;
	}

}
