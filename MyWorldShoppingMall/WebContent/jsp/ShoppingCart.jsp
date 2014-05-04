<%@ page import="java.util.Iterator"%>
<%@ page import="com.team12.myworld.pojos.ShoppingCart"%>
<%@ page import="java.util.ArrayList"%>

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
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js">
	
</script>
<%
	ArrayList<ShoppingCart> cart = (ArrayList<ShoppingCart>) request.getAttribute("cartDetails");%>

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
				href="/MyWorldShoppingMall/jsp/UserProfile.jsp"><i
				class="fa fa-home"></i> My World Shopping Mall</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><img alt=""
						src="/MyWorldShoppingMall/images/shopping_cart.png"> My Cart</a></li>
				<li><a href="/MyWorldShoppingMall/jsp/Account.jsp">My
						Account</a></li>
				<li><a href="/MyWorldShoppingMall/jsp/Index.jsp">Log out <img
						alt="" src="/MyWorldShoppingMall/images/log_out.png"></a></li>
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
					<form class="form-horizontal" name="shoppingCart" method="post"
						action="<%=request.getContextPath()%>/ShoppingCartServlet">
						<fieldset>
							<legend>Shopping Cart</legend>
							<input type="hidden" name="action" value="saveInvoice">
							<%
								if (!cart.isEmpty()) {
							%>
							<table class="table table-striped table-hover ">
								<thead>
									<tr>
										<th>Select to Purchase</th>
										<th>No.</th>
										<th>Item Name</th>
										<th>Quantity</th>
										<th>Price $</th>

										<th></th>
									</tr>
								</thead>
								<tbody>
									<%
										int total = 0;
											for (int i = 0; i < cart.size(); i++) {
									%>

									<tr>
										<td><input type="checkbox" name="options"
											value="<%=cart.get(i).getItemId()%>"></td>
										<td><%=i + 1%></td>
										<td><input type="hidden" id="itemId<%=i + 1%>"
											name="itemId<%=i + 1%>" value="<%=cart.get(i).getItemId()%>"><%=cart.get(i).getItemName()%></td>
										<td><%=cart.get(i).getItemCount()%></td>
										<td><%=cart.get(i).getItemPrice()%></td>


									</tr>
									<%
										total = total + cart.get(i).getItemPrice();
											}
											
									%>
									<tr>
										<td colspan="4">Total:</td>
										<td><input type="hidden" id="total" name="total"
											value="<%=total%>"> <%=total%></td>
									</tr>
								</tbody>
							</table>

							<div class="form-group">
								<div class="col-lg-11 col-lg-offset-10">
									<button type="submit" class="btn btn-primary">Proceed</button>
								</div>
							</div>
							<%
								}else{ String message = (String) request.getAttribute("Message");
							%>
							<label for="message" class="col-lg-10 control-label"><%=message%></label>
							<%} %>
						</fieldset>
					</form>
				</div>

			</div>
		</div>
		<br>


	</div>
</body>
</html>