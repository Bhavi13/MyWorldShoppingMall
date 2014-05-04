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
				href="/MyWorldShoppingMall/jsp/UserProfile.jsp"><i
				class="fa fa-home"></i> My World Shopping Mall</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><img alt=""
						src="/MyWorldShoppingMall/images/shopping_cart.png"> My Cart
						<span class="badge">42</span></a></li>
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
				<div class="col-lg-7">
					<form class="form-horizontal" onsubmit="return validateFun();"
						method="post" action="<%=request.getContextPath()%>/SignUpServlet" >
						<fieldset>
							<legend>Payment</legend>
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