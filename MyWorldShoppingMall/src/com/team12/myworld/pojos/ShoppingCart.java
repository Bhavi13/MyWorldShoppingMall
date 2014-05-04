package com.team12.myworld.pojos;

public class ShoppingCart {
	private int ItemId,ShopId,ItemCount,TotalAmount,itemQuantity,itemPrice,cartId;
	//private String itemName,shopName;
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	private String ItemName,ShopName;
	private int UserId;
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingCart(int ItemId, int ShopId, int UserId, int itemQuantity, int itemPrice){
		this.ItemId=ItemId;
		this.ShopId=ShopId;
		this.UserId=UserId;
		this.itemQuantity=itemQuantity;
		this.itemPrice=itemPrice;
	}
	public ShoppingCart(int ItemId, int ShopId, int ItemCount, int TotalAmount, String ItemName, String ShopName)
	{
		this.ItemId=ItemId;
		this.ShopId=ShopId;
		this.ItemCount=ItemCount;
		this.TotalAmount=TotalAmount;
		this.ItemName=ItemName;
		this.ShopName=ShopName;
	}
	
	
	
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public int getShopId() {
		return ShopId;
	}
	public void setShopId(int shopId) {
		ShopId = shopId;
	}
	public int getItemCount() {
		return ItemCount;
	}
	public void setItemCount(int itemCount) {
		ItemCount = itemCount;
	}
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getShopName() {
		return ShopName;
	}
	public void setShopName(String shopName) {
		ShopName = shopName;
	}
	
}
