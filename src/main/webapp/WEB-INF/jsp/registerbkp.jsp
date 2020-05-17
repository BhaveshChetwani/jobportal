<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="/jobportal/js/common.js" type="text/javascript"></script>
<script src="/jobportal/js/login.js" type="text/javascript"></script>
<script src="/jobportal/js/jquery.3.51.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link href="/jobportal/css/common.css" rel="stylesheet" type="text/css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
<title>Sign Up</title>
</head>
<body>
	<form action="signup" method="post">
	
		<table>
			<tr>
				<td><label>Email ID: </label></td>
				<td><input type="text" name="emailId" id="emailId" value="${User.emailId }" onkeyup="validateEmailId(this.value);"/></td>
				<td><textarea class="error" type="text" id="emailId_error" readonly cols="2" /></textarea></td>
			</tr>
			<tr>
				<td><label>Name : </label></td>
				<td><input type="text" name="username" id="username" value="${User.username }" onkeyup="validateUserName(this.value);"/></td>
				<td><textarea class="error" type="text" id="username_error" readonly cols="2" /></textarea></td>
			</tr>
			<tr>
				<td><label>Password : </label></td>
				<td><input type="text" name="password" id="password" value="${User.password }" onkeyup="validatePassword(this.value);"/></td>
				<td><textarea class="error" id="password_error"  readonly cols="2" ></textarea></td>
			</tr>
			<tr>
				<td><label>Country Code : </label></td>
				<td><input type="text" name="countryCode" id="countryCode" value="${User.countryCode }" onkeyup="validateCountryCode(this.value);"/></td>
				<td><textarea class="error" id="countryCode_error"  readonly cols="2" ></textarea></td>
			</tr>
			<tr>
				<td><label>Contact : </label></td>
				<td><input type="text" name="mobileNumber" id="mobileNumber" value="${User.mobileNumber }" onkeyup="validateMobileNumber(this.value);"/></td>
				<td><textarea class="error" id="mobileNumber_error"  readonly cols="2" ></textarea></td>
			</tr>
			<tr>
				<td>
					<input type="Submit" value="Sign Up" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="Submit" value="Existing User? Login Here." onclick="document.form[0].action = '';document.form[0].submit();"/>
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>