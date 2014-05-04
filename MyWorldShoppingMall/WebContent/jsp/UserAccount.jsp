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
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	
<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/MyWorldShoppingMall/jsp/UserProfile.jsp"><i class="fa fa-home"></i> My
				World Shopping Mall</a>
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
					<br>
					<br>
					<form class="form-horizontal">
						<fieldset>
							<legend>Account Details</legend>
							<div class="form-group">
								<input type="hidden" name="action" value="signup"> <label
									for="firstName" class="col-lg-2 control-label">Name</label><label
									style="color: red">*</label>
								<div class="col-lg-4">
									<input type="text" class="form-control" id="firstName"
										name="firstName" placeholder="First Name" value="First Name">
								</div>
								<div class="col-lg-4">
									<input type="text" class="form-control" name="lastName"
										id="lastName" placeholder="Last Name" value="Last Name">
								</div>

							</div>
							<div class="form-group">
								<label for="gender" class="col-lg-2 control-label">Gender</label>
								<div class="col-lg-8">
									<input type="radio" name="gender" id="genderM" value="Male" checked="checked">Male
									<input type="radio" name="gender" id="genderM" value="Female">Female
									<label style="color: red">*</label>
								</div>
							</div>
							<div class="form-group">
								<label for="emailId" class="col-lg-2 control-label">Email
									ID</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" name="emailId"
										id="emailId" placeholder="Email ID" value="Email ID"><label
										style="color: red">*</label>
								</div>
							</div>
							<div class="form-group">
								<label for="role" class="col-lg-2 control-label">Role</label>
								<div class="col-lg-8">
									<select name="role" id="role" class="form-control">
										<option value="selectRole">--Select Role--</option>
										<option value="user">User</option>
										<option value="shopkeeper">Shopkeeper</option>
										<option value="admin" selected="selected">Admin</option>
									</select> <label style="color: red">*</label>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-lg-8 col-lg-offset-2">
									<button type="submit" class="btn btn-primary">Update</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				
			</div>
		</div>
		<br>
		<div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-10">
					<form class="form-horizontal">
						<fieldset>
							<legend>Change Password</legend>
							<table class="table table-striped table-hover ">
							<tr>
							<td><label for="oldPassword" class="col-lg-7 control-label">Old Password</label></td>
							<td><input type="password" class="form-control" id="oldPassword"
										name="oldPassword" placeholder="Old Password"></td>
							</tr>
							<tr>
							<td><label for="newPassword" class="col-lg-7 control-label">New Password</label></td>
							<td><input type="password" class="form-control" id="newPassword"
										name="newPassword" placeholder="New Password"></td>
							</tr>
							<tr>
							<td><label for="confPassword" class="col-lg-7 control-label">Confirm Password</label></td>
							<td><input type="password" class="form-control" id="confPassword"
										name="confPassword" placeholder="Confirm Password"></td>
							</tr>
							</table>
							
							
							<div class="form-group">
								<div class="col-lg-8 col-lg-offset-2">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				
			</div>
		</div>
		
	</div>
</body>
</html>