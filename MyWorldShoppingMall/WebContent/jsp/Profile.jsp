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
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/MyWorldShoppingMall/jsp/Profile.jsp"><i
				class="fa fa-home"></i> My World Shopping Mall</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/MyWorldShoppingMall/jsp/CreateShop.jsp">Shop
						Management</a></li>
				<li><a href="/MyWorldShoppingMall/jsp/Account.jsp">My
						Account</a></li>
				<li><a href="/MyWorldShoppingMall/jsp/Index.jsp"><i
						class="ionicons ion-log-out"></i>Log out <img alt=""
						src="/MyWorldShoppingMall/images/log_out.png"></a></li>
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
				<div class="col-lg-2">
					<form class="form-horizontal">
						<fieldset>
							<legend>Your Shops</legend>
							<table class="table table-striped table-hover ">
								<%
									for (int i = 0; i < 10; i++) {
								%>
								<tr>
									<td>Shop <%=i + 1%></td>
								</tr>
								<%
									}
									;
								%>
							</table>
						</fieldset>
					</form>
				</div>
				<div class="col-lg-8">
					<fieldset>
						<legend>Inventory Managment</legend>
						<ul class="nav nav-tabs" style="margin-bottom: 15px;">
							<li class="active"><a href="#view" data-toggle="tab">View
									Item</a></li>
							<li class=""><a href="#add" data-toggle="tab">Add Item</a></li>
							<li class=""><a href="#delete" data-toggle="tab">Delete
									Item</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade active in" id="view">
								<form class="form-horizontal" name="viewInvnetoryForm" id="viewInventoryForm"
									action="/MyWorldShoppingMall/CreateShopServlet" method="post"
									onsubmit="return validateFunct1();">
									<input type="hidden" name="action" value="viewInventory">
									<div class="form-group">
										<label for="select" class="col-lg-3 control-label">Shop Name:</label>
										 <div class="col-lg-5">
										<select
											class="form-control" name="shopName" id="shopName">
											<option value="select">--Select Shop--</option>
											<option value="Category 1">Category 1</option>
											<option value="Category 2">Category 2</option>
											<option value="Category 3">Category 3</option>
											<option value="Category 4">Category 4</option>
											<option value="Category 5">Category 5</option>
										</select>
										</div>
									</div><br>
									
									<table class="table table-striped table-hover ">
										<thead>
											<tr>
												<th>Item Id</th>
												<th>Item Name</th>
												<th>Description</th>
												<th>Category</th>
												<th>Count</th>
												<th>Price</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
									</table>

								</form>
							</div>
							<div class="tab-pane fade" id="add">
								<form class="form-horizontal" name="addInventoryForm" id="addInventoryForm"
									action="/MyWorldShoppingMall/CreateShopServlet" method="post"
									onsubmit="return validateFunct();">
									<input type="hidden" name="action" value="addInvnentory">
									<table class="table table-striped table-hover ">
										<tr>
											<td><label>Shop Name:</label><label style="color: red">*</label></td>
											<td><select class="form-control" name="shopName"
												id="shopName">
													<option value="select">--Select Shop--</option>
													<option value="Category 1">Category 1</option>
													<option value="Category 2">Category 2</option>
													<option value="Category 3">Category 3</option>
													<option value="Category 4">Category 4</option>
													<option value="Category 5">Category 5</option>
											</select></td>
										</tr>

										<tr>
											<td><label>Item Name:</label><label style="color: red">*</label></td>
											<td><select class="form-control" name="item" id="item">
													<option value="select">--Select Item--</option>
													<option value="Category 1">Category 1</option>
													<option value="Category 2">Category 2</option>
													<option value="Category 3">Category 3</option>
													<option value="Category 4">Category 4</option>
													<option value="Category 5">Category 5</option>
											</select></td>
										</tr>

										<tr>
											<td><label>Count: </label><label style="color: red">*</label></td>
											<td><input class="form-control" name="description"
												id="description" type="text"></td>
										</tr>
										<tr>
											<td><label>Price: </label><label style="color: red">*</label></td>
											<td><input class="form-control" name="description"
												id="description" type="text"></td>
										</tr>

									</table>
									<div class="form-group">
										<div class="col-lg-10 col-lg-offset-10">
											<input class="btn btn-primary" type="submit" name="Submit"
												value="Add">
										</div>
									</div>
								</form>
							</div>
							<div class="tab-pane fade" id="delete">
								<form class="form-horizontal" name="updateShop" id="deleteShopForm"
									action="/MyWorldShoppingMall/CreateShopServlet" method="post"
									onsubmit="return validateFunct2();">
									<input type="hidden" name="action" value="deleteInventory">
									<table class="table table-striped table-hover ">
										<tr>
											<td><label>Shop ID:</label><label style="color: red">*</label></td>
											<td><input class="form-control" type="text"
												name="deleteShopId" id="deleteShopId"></td>
										</tr>

									</table>
									<div class="form-group">
										<div class="col-lg-10 col-lg-offset-10">
											<input class="btn btn-primary" type="submit" name="Delete"
												value="Delete">
										</div>
									</div>
								</form>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
		<!-- <div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-10">
					<form class="form-horizontal">
						<fieldset>
							<legend></legend>

						</fieldset>
					</form>
				</div>
			</div>
		</div> -->
	</div>
</body>
</html>