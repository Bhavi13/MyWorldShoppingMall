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
<script type="text/javascript">
	function validateFunct() {
		var shopName = document.getElementById("shopName").value;
		var description = document.getElementById("description").value;
		if ("" == shopName || "" == description) {
			if ("" == shopName) {
				alert("Please enter shop name");
			}
			if ("" == description) {
				alert("Please enter description");
			}
			return false;
		} else {
			return true;
		}

	}

	function validateFunct1() {
		var shopName = document.getElementById("updateShopName").value;
		var description = document.getElementById("updateDescription").value;
		if ("" == shopName || "" == description) {
			if ("" == shopName) {
				alert("Please enter shop name");
			}
			if ("" == description) {
				alert("Please enter description");
			}
			return false;
		} else {
			return true;
		}

	}
</script>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/MyWorldShoppingMall/jsp/Profile.jsp"><i class="fa fa-home"></i> My
				World Shopping Mall</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right"></form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/MyWorldShoppingMall/jsp/CreateShop.jsp">Shop Management</a></li>
				<li><a href="/MyWorldShoppingMall/jsp/Account.jsp">My Account</a></li>
				<li><a href="/MyWorldShoppingMall/jsp/Index.jsp">Log out <img alt="" src="/MyWorldShoppingMall/images/log_out.png"></a></li>
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
						<fieldset>
							<legend>Inventory Management</legend>
							<ul class="nav nav-tabs" style="margin-bottom: 15px;">
								<li class="active"><a href="#create" data-toggle="tab">Create</a></li>
								<li class=""><a href="#update" data-toggle="tab">Update</a></li>
								<li class=""><a href="#delete" data-toggle="tab">Delete</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">

								<div class="tab-pane fade active in" id="create">
									<form name="addInventoryForm" id="addInventoryShopForm"
										action="/MyWorldShoppingMall/CreateShopServlet" method="post"
										onsubmit="return validateFunct();">
										<input type="hidden" name="action" value="createShop">
										<table class="table table-striped table-hover ">
											<tr>
												<td><label>Shop Name:</label><label style="color: red">*</label></td>
												<td><input type="text" class="form-control"
													name="shopName" id="shopName"></td>
											</tr>

											<tr>
												<td><label>Category:</label><label style="color: red">*</label></td>
												<td><select class="form-control" name="category"
													id="category">
														<option value="select">--Select Category--</option>
														<option value="Category 1">Category 1</option>
														<option value="Category 2">Category 2</option>
														<option value="Category 3">Category 3</option>
														<option value="Category 4">Category 4</option>
														<option value="Category 5">Category 5</option>
												</select></td>
											</tr>

											<tr>
												<td><label>Description: </label><label
													style="color: red">*</label></td>
												<td><textarea class="form-control" name="description"
														id="description" rows="4"></textarea></td>
											</tr>

										</table>
										<div class="form-group">
											<div class="col-lg-10 col-lg-offset-10">
												<input class="btn btn-primary" type="submit" name="Submit"
													value="Create">
											</div>
										</div>
									</form>
								</div>
								<div class="tab-pane fade" id="update">
									<form name="updateShop" id="updateShopForm"
										action="/MyWorldShoppingMall/CreateShopServlet" method="post"
										onsubmit="return validateFunct1();">
										<input type="hidden" name="action" value="updateShop">
										<table class="table table-striped table-hover ">
											<tr>
												<td><label>Shop ID:</label><label style="color: red">*</label></td>
												<td><input class="form-control" type="text"
													name="shopId" id="shopId"></td>
											</tr>
											<tr>
												<td><label>Shop Name:</label><label style="color: red">*</label></td>
												<td><input class="form-control" type="text"
													name="updateShopName" id="updateShopName"></td>
											</tr>
											<tr>
												<td><label>Description: </label><label
													style="color: red">*</label></td>
												<td><textarea class="form-control"
														name="updateDescription" id="updateDescription" rows="4"></textarea></td>
											</tr>

										</table>

										<div class="form-group">
											<div class="col-lg-10 col-lg-offset-10">
												<input class="btn btn-primary"
													type="submit" name="Update" value="Update" >
											</div>
										</div>
									</form>
								</div>
								<div class="tab-pane fade" id="delete">
									<form name="updateShop" id="deleteShopForm"
										action="/MyWorldShoppingMall/CreateShopServlet" method="post"
										onsubmit="return validateFunct2();">
										<input type="hidden" name="action" value="deleteShop">
										<table class="table table-striped table-hover ">
											<tr>
												<td><label>Shop ID:</label><label style="color: red">*</label></td>
												<td><input class="form-control" type="text"
													name="deleteShopId" id="deleteShopId"></td>
											</tr>
											
										</table>
										<div class="form-group">
											<div class="col-lg-10 col-lg-offset-10">
												<input class="btn btn-primary"
													type="submit" name="Delete" value="Delete" >
											</div>
										</div>
									</form>
								</div>
							</div>

						</fieldset>
				</div>
			</div>
		</div>
	</div>
</body>
</html>