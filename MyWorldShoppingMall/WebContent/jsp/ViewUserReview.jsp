<%@page import="com.team12.myworld.pojos.UserReview"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<UserReview> userReviewList = (ArrayList<UserReview>) request
				.getAttribute("userReviewsList");
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
							User Review of Item</a> &nbsp; | &nbsp; <a
							href="/MyWorldShoppingMall/SignUpServlet?action=viewRewardPointsByUserId">Reward
							Point</a>
					</div>
					<br> <br>
					<form class="form-horizontal">
						<fieldset>
							<legend>View Review</legend>
							<table class="table table-striped table-hover ">
								<thead>
									<tr>
										<th>Item Name</th>
										<th>Item Description</th>
										<th>Shop Name</th>
										<th>User Name</th>
										<th>Rating</th>
										<th>Review Description</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < userReviewList.size(); i++) {
									%>
									<tr>
										<td><%=userReviewList.get(i).getItemName()%></td>
										<td><%=userReviewList.get(i).getItemDesc()%></td>
										<td><%=userReviewList.get(i).getShopName()%></td>
										<td><%=userReviewList.get(i).getFirstName()%> <%=userReviewList.get(i).getLastName()%></td>
										<td><%=userReviewList.get(i).getRating()%></td>
										<td><%=userReviewList.get(i).getDescription()%></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</fieldset>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>