<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Shop</title>
<script type="text/javascript">
function validateFunct(){
	var shopName = document.getElementById("shopName").value;
	var description = document.getElementById("description").value;
	
	if(shopName == "" || description == ""){
		if(shopName = ""){
			alert("Please enter shop name");
		}
		if(description = ""){
			alert("Please enter description");
		}
		return false;
	}else{
		return true;
	}
	
}
</script>
</head>
<body>
	<form name="createShopForm" id="createShopForm"
		action="/MyWorldShoppingMall/CreateShopServlet" method="post" onsubmit="return validateFunct();">
		<input type="hidden" name="action" value="createShop">
		<table align="center">
			<tr>
				<td><label>Shop Name:</label><label style="color: red">*</label></td>
				<td><input type="text" name="shopName" id="shopName"></td>
			</tr>

			<tr>
				<td><label>Category:</label><label style="color: red">*</label></td>
				<td><select name="category" id="category">
						<option value="Category 1">Category 1</option>
						<option value="Category 2">Category 2</option>
						<option value="Category 3">Category 3</option>
						<option value="Category 4">Category 4</option>
						<option value="Category 5">Category 5</option>
				</select></td>
			</tr>

			<tr>
				<td><label>Description: </label></td>
				<td><textarea name="description" id="description" rows="4"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td align="center"><input type="submit" name="Submit"
					value="Submit" align="middle"></td>
			</tr>
		</table>
	</form>
</body>
</html>