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
<script type="text/javascript">
	function validateFun() {
		var cardNo = document.getElementById("cardNo").value;
		var cardNo1 = document.getElementById("cardNo1").value;
		var cardNo2 = document.getElementById("cardNo2").value;
		var cardNo3 = document.getElementById("cardNo3").value;
		var expDate = document.getElementById("expDate").value;
		var expYear = document.getElementById("expYear").value;
		var cvvNo = document.getElementById("cvvNo").value;
		var monthRegex = /^0[1-9]|1[0-2]/;

		if (cardNo == "") {
			alert("Card No cannot be blank.");
			return false;
		}
		if (cardNo1 == "") {
			alert("Card No cannot be blank.");
			return false;
		}
		if (cardNo2 == "") {
			alert("Card No cannot be blank.");
			return false;
		}
		if (cardNo3 == "") {
			alert("Card No cannot be blank.");
			return false;
		}
		if ("" == expDate || "" == expYear) {
			alert("Please enter valid expiry date.");
			return false;
		}
		if (monthRegex.test(expDate) == false) {
			alert("Please enter valid month.");
			return false;
		}
		if ("" == cvvNo) {
			alert("Please enter CVV No.");
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
							<input type="hidden" name="action" value="updateRewardPoints">
							<table class="table table-striped table-hover ">
								<tr>
									<td>Credit/Debit Card No.:</td>
									<td>
									<input type="text" name="cardNo" id="cardNo" style="width: 100px" maxlength="4">
									 <input type="text" name="cardNo1" id="cardNo1" style="width: 100px" maxlength="4"> 
									 <input	type="text" name="cardNo2" id="cardNo2" style="width: 100px" maxlength="4"> 
									 <input type="text" style="width: 100px" name="cardNo3" id="cardNo3" maxlength="4"></td>
										</tr>
								<tr id="expiryDate">
									<td>Expiration Date:</td>
									<td>
									<input type="text" name="expDate" id="expDate"	style="width: 40px" maxlength="2" placeholder="MM"> 
									<input type="text" name="expYear" style="width: 50px" id="expYear"	maxlength="4" placeholder="YYYY">
									</td>
								</tr>
								<tr id="CVVNo">
									<td>CVV No.:</td>
									<td><input type="password" name="cvvNo" id="cvvNo"	style="width: 50px" maxlength="3"></td>
								</tr>

							</table>
							<div class="form-group">
								<div class="col-lg-6 col-lg-offset-9">
									<button type="submit" class="btn btn-primary" name="submit"
										id="submit">Proceed</button>
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