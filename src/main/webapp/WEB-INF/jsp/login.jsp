<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="/jobportal/js/common.js" type="text/javascript"></script>
<script src="/jobportal/js/login.js" type="text/javascript"></script>
<script src="/jobportal/js/jquery.3.51.min.js" type="text/javascript"></script>

<link href="/jobportal/css/common.css" rel="stylesheet" type="text/css" >

<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="username" id="username" value="${User.username }" /></td>
				<td colspan="2"><input class="error" type="text" id="username_error" readonly maxlength ="100" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password" id="password" value="${User.password }" onkeyup="validatePassword(this.value);"/></td>
				<td colspan="2"><textarea class="error" id="password_error"  readonly ></textarea></td>
			</tr>
			<tr>
				<td>
					<input type="Submit" class="btn btn-success" value="Login" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="Submit" class="btn btn-success" value="Sign Up" onclick="window.open('register','_target');"/>
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>