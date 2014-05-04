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
			<a class="navbar-brand"
				href="/MyWorldShoppingMall/jsp/ProductPage.jsp"><i
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
				<div class="col-lg-20">

					<fieldset>
						<legend>Shop 1</legend>
						<table class="table table-striped table-hover ">
							<%
								int x = 0;
								for (int i = 0; i < 4; i++) {
							%>
							<tr>
								<%
									for (int j = x; j < x + 4; j++) {
								%>
								<td><form name="shopUpForm" id="shopUpForm"
										action="<%=request.getContextPath()%>/ShoppingCartServlet"
										method="post">
										<a href="#">Product <%=j + 1%></a><br> <input
											type="hidden" name="action" value="addCart"> <input
											type="hidden" name="itemId" value="<%=j + 1%>"> <input
											type="hidden" name="shopId" value="2"> <input
											type="hidden" name="itemPrice" value="20"> Price:
										$20.00 <br> <img alt=""
											src="<%=request.getContextPath()%>/images/shopLogo (<%=j + 1%>).png"><br>
										<br> Quantity : <input type="text" name="itemCount"
											style="width: 40px" id="itemCount<%=j + 1%>" width="2px"><br>
										<br>
										<button type="submit" class="btn btn-primary btn-xs">Add
											to Cart</button>
									</form></td>
								<%
									}
										;
										x = x + 4;
								%>
							</tr>
							<%
								}
							%>

							<%
								int y = 0;
								for (int i = 0; i < 4; i++) {
							%>
							<tr>
								<%
									for (int j = y; j < y + 4; j++) {
								%>
								<td><a href="#">Shop Name <%=j + 1%></a> <br> <img
									alt=""
									src="<%=request.getContextPath()%>/images/shopLogo (<%=j + 1%>).png">
								</td>
								<%
									}
										;
										y = y + 4;
								%>
							</tr>
							<%
								}
							%>
						</table>
					</fieldset>

				</div>
			</div>
		</div>

	</div>
</body>
</html>