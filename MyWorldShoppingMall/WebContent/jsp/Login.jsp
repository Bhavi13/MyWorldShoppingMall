<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<script type="text/javascript">

function validateFun()
{
	var userName=document.getElementById("userName").value;
	var passWord=document.getElementById("password").value;
	
	if("" == userName)
	{
		alert("Please enter First Name.");
		return false;
	}
	
	if(""== passWord)
	{
		alert("Please enter Password.");
		return false;
	}
	
	else
	{
		return true;
	}
}
</script>

<body>

	<form name="loginForm" id="loginForm"
		action="/MyWorldShoppingMall/SignUpServlet" method="post"
		onsubmit="return validateFun();">
		<input type="hidden" name="action" value="login"></input>
		<table align="center">
			<tr>
				<td><label>User Name:</label></td>
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" name="Submit"
					value="Submit"></td>
			</tr>
		</table>
		<div align="center">
			<br> <label id="Message"> <%
 	if (request.getAttribute("Message") != null) {
 %><%=request.getAttribute("Message")%> <%
 	}
 %>
			</label>
		</div>
		<p align="center">
			Not registered ? Click here to <a
				href="/MyWorldShoppingMall/jsp/Signup.jsp">Sign Up</a>
	</form>


</body>
</html>