<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>

<script type="text/javascript">
function validateFun()
{
	var fName= document.getElementById("firstName").value;
	var lName= document.getElementById("lastName").value;
	var genders = document.getElementsByName("gender");
	var email= document.getElementById("emailId").value;
	var pwd= document.getElementById("passWord").value;
	var pwdCnfrm = document.getElementById("passWordCnfrm").value;
	
	var emailRegEx = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var NamRegEx = /^([a-zA-z\s]{1,20})$/;
	var passWordRegEx = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$/;
	
	if("" == fName)
	{
		alert("Please enter First Name.");
		return false;
	}
	if(NamRegEx.test(fName) == false)
	{
		alert("Please enter correct First Name.");
		return false;
	}
	if(""==lName)
	{
		alert("Please enter Last Name.");
		return false;
	}
	if(NamRegEx.test(lName) == false)
	{
		alert("Please enter correct Last Name.");
		return false;
	}
	if(genders[0].checked == false && genders[1].checked == false)
		{
		alert("Please select your gender.");
		return false;
		}
	if(""==email)
	{
		alert("Please enter Email Address.");
		return false;
	}
	if(emailRegEx.test(email) == false)
	{
		alert("Please enter correct Email Address.");
		return false;
	}
	if(""==pwd)
	{
		alert("Please enter Password.");
		return false;
	}
	if(passWordRegEx.test(pwd) == false)
	{
		alert("Password must be at least 4 characters, no more than 8 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.");
		return false;
	}
	if(pwd != pwdCnfrm)
		{
		alert("The passwords are not matching");
		return false;
	}
	else
	{
		return true;
	}
}
</script>

</head>
<body>
<form name="signUpForm" id="signUpForm" action="/MyWorldShoppingMall/SignUpServlet" method="post" onSubmit="return validateFun();">
<input type="hidden" name="action" value="signup">

<table align="center">
		<tr>
			<td><label>First Name:</label><label style="color: red">*</label></td>
			<td><input type="text" name="firstName" id="firstName" ></td>
		</tr>

		<tr>
			<td><label>Last Name:</label><label style="color: red">*</label></td>
			<td><input type="text" name="lastName" id="lastName"></td>
		</tr>

		<tr>
			<td><label>Gender:</label></td>
			<td><input type="radio" name="gender" id="genderM" value="Male">Male</td>
			<td><input type="radio" name="gender" id="genderF" value="Female">Female</td>
		</tr>
		<tr>
			<td><label>Email Address:</label><label style="color: red">*</label></td>
			<td><input type="text" name="emailId" id="emailId"></td>
		</tr>
		<tr>
			<td><label>Role:</label><label style="color: red">*</label></td>
			<td>
				<select name="role" id="role">
				<!-- <option value="selectRole">Select Role</option> -->
				<option value="user">User</option>
				<option value="shopkeeper">Shopkeeper</option>
				<option value="admin">Admin</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><label>Password:</label><label style="color: red">*</label></td>
			<td><input type="password" name="passWord" id="passWord"></td>
		</tr>
		<tr>
			<td><label>Confirm Password:</label><label style="color: red">*</label></td>
			<td><input type="password" name="passWordCnfrm" id="passWordCnfrm"></td>
		</tr>
		<tr>
			<td></td>
			<td align="center"><input type="submit" name="Submit" value="Submit" align="middle"></td>
		</tr>
	</table>
	<div align="center">
			<br> 
			<label id="Message"> 
			<%if (request.getAttribute("Message") != null) { %><%=request.getAttribute("Message")%> <%} %>
			</label>
	</div>
</form>
</body>
</html>