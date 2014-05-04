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
	function validateFun() {
		var fName = document.getElementById("firstName").value;
		var lName = document.getElementById("lastName").value;
		var genders = document.getElementsByName("gender");
		var email = document.getElementById("emailId").value;
		var pwd = document.getElementById("passWord").value;
		var pwdCnfrm = document.getElementById("passWordCnfrm").value;
		var role = document.getElementById("role").value;
		var emailRegEx = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		var NamRegEx = /^([a-zA-z\s]{1,20})$/;
		var passWordRegEx = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$/;

		if ("" == fName) {
			alert("Please enter First Name.");
			return false;
		}
		if (NamRegEx.test(fName) == false) {
			alert("Please enter correct First Name.");
			return false;
		}
		if ("" == lName) {
			alert("Please enter Last Name.");
			return false;
		}
		if (NamRegEx.test(lName) == false) {
			alert("Please enter correct Last Name.");
			return false;
		}
		if (genders[0].checked == false && genders[1].checked == false) {
			alert("Please select your gender.");
			return false;
		}
		if ("" == email) {
			alert("Please enter Email Address.");
			return false;
		}
		if (emailRegEx.test(email) == false) {
			alert("Please enter correct Email Address.");
			return false;
		}
		if (role == "selectRole") {
			alert("Please select role");
			return false;
		}
		if ("" == pwd) {
			alert("Please enter Password.");
			return false;
		}
		if (passWordRegEx.test(pwd) == false) {
			alert("Password must be at least 4 characters, no more than 8 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.");
			return false;
		}
		if (pwd != pwdCnfrm) {
			alert("The passwords are not matching");
			return false;
		} else {
			return true;
		}
	}

	function validateFun1() {
		var userName = document.getElementById("userName").value;
		var passWord = document.getElementById("password").value;

		if ("" == userName) {
			alert("Please enter First Name.");
			return false;
		}

		if ("" == passWord) {
			alert("Please enter Password.");
			return false;
		}

		else {
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
			<a class="navbar-brand" href="/MyWorldShoppingMall/jsp/Index.jsp"><i class="fa fa-home"></i> My
				World Shopping Mall</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			
			<ul class="nav navbar-nav navbar-right">

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
				<div class="col-lg-6">
					<form class="form-horizontal" name="signUpForm" id="signUpForm"
						action="/MyWorldShoppingMall/SignUpServlet" method="post"
						onSubmit="return validateFun();">
						<input type="hidden" name="action" value="signup">
						<fieldset>
							<legend>Register</legend>
							<div class="form-group">
								<input type="hidden" name="action" value="signup"> <label
									for="firstName" class="col-lg-2 control-label">Name</label><label
									style="color: red">*</label>
								<div class="col-lg-4">
									<input type="text" class="form-control" id="firstName"
										name="firstName" placeholder="First Name">
								</div>
								<div class="col-lg-4">
									<input type="text" class="form-control" name="lastName"
										id="lastName" placeholder="Last Name">
								</div>

							</div>
							<div class="form-group">
								<label for="gender" class="col-lg-2 control-label">Gender</label>
								<div class="col-lg-8">
									<input type="radio" name="gender" id="genderM" value="Male">Male
									<input type="radio" name="gender" id="genderM" value="Female">Female
									<label style="color: red">*</label>
								</div>
							</div>
							<div class="form-group">
								<label for="emailId" class="col-lg-2 control-label">Email
									ID</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" name="emailId"
										id="emailId" placeholder="Email ID"><label
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
										<option value="admin">Admin</option>
									</select> <label style="color: red">*</label>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-lg-2 control-label">Password</label>
								<div class="col-lg-8">
									<input type="password" class="form-control" name="passWord"
										id="passWord" placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<label for="inputConfirmPassword" class="col-lg-2 control-label">Confirm</label>
								<div class="col-lg-8">
									<input type="password" class="form-control"
										name="passWordCnfrm" id="passWordCnfrm"
										placeholder="Confirm Password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-8 col-lg-offset-2">
									<button type="submit" class="btn btn-primary">Register</button>
								</div>
							</div>
							<div class="form-group">
							<%String message=(String)request.getAttribute("Message");
								if(message != null){%>
							
								<label for="message" class="col-lg-10 control-label"><%=message%></label>
								
								<%}; %>
							</div>
						</fieldset>
					</form>
				</div>
				<div class="col-lg-4 col-lg-offset-1">
					<form class="form-horizontal" name="loginForm" id="loginForm"
						action="/MyWorldShoppingMall/SignUpServlet" method="post"
						onsubmit="return validateFun1();">
						<input type="hidden" name="action" value="login"></input>
						<fieldset>
							<legend>Login</legend>
							<div class="form-group">
								<label for="userName" class="col-lg-3 control-label">Email
									ID</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" name="userName"
										id="userName" placeholder="Email ID">
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-lg-3 control-label">Password</label>
								<div class="col-lg-9">
									<input type="password" class="form-control" name="password"
										id="password" placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-3">
									<button type="submit" class="btn btn-primary">Login</button>

								</div>
								
								<div class="form-group">
							<%String msg =(String)request.getAttribute("errorMsg");
								if(msg != null){%>
							
								<label for="message" class="col-lg-10 control-label"><%=msg%></label>
								
								<%}; %>
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