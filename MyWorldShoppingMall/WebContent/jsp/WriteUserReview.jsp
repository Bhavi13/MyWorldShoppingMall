<%@page import="java.util.ArrayList"%>
<%@page import="com.team12.myworld.pojos.UserOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My World Shopping Mall</title>
<link
	href=//netdna.bootstrapcdn.com/bootswatch/3.1.1/cosmo/bootstrap.min.css
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>

<body>
	<%
		UserOrder userOrderObj = (UserOrder) request
				.getAttribute("userOrderObj");
	%>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="/MyWorldShoppingMall/jsp/UserProfile.jsp"><i
				class="fa fa-home"></i> My World Shopping Mall</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<button type="submit" class="btn btn-default">
					Log out <img alt=""
						src="<%=request.getContextPath()%>/images/log_out.png">
				</button>
				<input type="hidden" name="action" value="logout">
			</form>
			<form class="navbar-form navbar-right"
				action="<%=request.getContextPath()%>/ShoppingCartServlet"
				method="post">
				<input type="hidden" name="action" value="openCart">
				<button type="submit" class="btn btn-default">
					<img alt=""
						src="<%=request.getContextPath()%>/images/shopping_cart.png">My
					Cart
				</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/jsp/UserAccount.jsp">My
						Account</a></li>
				<li></li>
			</ul>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-10">
					<div align="center">
						<a
							href="/MyWorldShoppingMall/SignUpServlet?action=ViewPurchasedItemForReview">Write
							User Review</a> &nbsp; | &nbsp; <a
							href="/MyWorldShoppingMall/SignUpServlet?action=ViewUserReview">View
							User Review</a> &nbsp; | &nbsp; <a
							href="/MyWorldShoppingMall/SignUpServlet?action=ViewUserReviewByItemId">View
							User Review of Item</a> &nbsp; | &nbsp;<a
							href="/MyWorldShoppingMall/SignUpServlet?action=viewRewardPointsByUserId">Reward
							Point</a>
					</div>
					<br> <br>
					<form class="form-horizontal" name="writeReviewForm"
						id="writeReviewForm" action="/MyWorldShoppingMall/SignUpServlet"
						method="post">
						<fieldset>
							<legend>Write Review</legend>
							<input type="hidden" name="action" value="writeReview"> <input
								type="hidden" name="orderId"
								value="<%=userOrderObj.getOrderId()%>"> <input
								type="hidden" name="itemId"
								value="<%=userOrderObj.getItemId()%>"> <input
								type="hidden" name="shopId"
								value="<%=userOrderObj.getShopId()%>"> <input
								type="hidden" name="userId"
								value="<%=userOrderObj.getUserId()%>">
							<table class="table table-striped table-hover ">
								<tr>
									<td><label>Item Name:</label></td>
									<td><%=userOrderObj.getItemName()%></td>
								</tr>
								<tr>
									<td><label>Item Description:</label></td>
									<td><%=userOrderObj.getItemDesc()%></td>
								</tr>
								<tr>
									<td><label>Item Category:</label></td>
									<td><%=userOrderObj.getCategory()%></td>
								</tr>
								<tr>
									<td><label>Shop Name:</label></td>
									<td><%=userOrderObj.getShopName()%></td>
								</tr>
								<tr>
									<td><label>Shop Category:</label></td>
									<td><%=userOrderObj.getShopCategory()%></td>
								</tr>
								<tr>
									<td><label>Purchased Date:</label></td>
									<td><%=userOrderObj.getOrderDate()%></td>
								</tr>
								<tr>
									<td><label>Rating:</label></td>
									<td><input class="form-control" type="text" name="rating" id="rating"></td>
								</tr>
								<tr>
									<td><label>Review:</label></td>
									<td><textarea class="form-control" rows="4" cols="50"
											name="ReviewDesc" id="ReviewDesc"></textarea></td>
								</tr>
								<tr>
									<td></td>
									<td align="center"><input type="submit" name="Submit"
										class="btn btn-primary" value="Submit" align="middle"></td>
								</tr>
							</table>
							<div class="form-group">
								<%
									String message = (String) request.getAttribute("Message");
									if (message != null) {
								%>

								<label for="message" class="col-lg-10 control-label"><%=message%></label>

								<%
									}
									;
								%>
							</div>
						</fieldset>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>