<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script src="/jobportal/js/common.js" type="text/javascript"></script> -->
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

<div class="container text-center ">
	<form action="signup" method="post">

		
  <div class="row table-bordered bg-primary ">
  <div class="col-sm-12 ">
  <h1 class=""> 
  <svg class="bi bi-briefcase" width="2em" height="1.5em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M0 12.5A1.5 1.5 0 001.5 14h13a1.5 1.5 0 001.5-1.5v-6h-1v6a.5.5 0 01-.5.5h-13a.5.5 0 01-.5-.5v-6H0v6z" clip-rule="evenodd"/>
  <path fill-rule="evenodd" d="M0 4.5A1.5 1.5 0 011.5 3h13A1.5 1.5 0 0116 4.5v2.384l-7.614 2.03a1.5 1.5 0 01-.772 0L0 6.884V4.5zM1.5 4a.5.5 0 00-.5.5v1.616l6.871 1.832a.5.5 0 00.258 0L15 6.116V4.5a.5.5 0 00-.5-.5h-13zM5 2.5A1.5 1.5 0 016.5 1h3A1.5 1.5 0 0111 2.5V3h-1v-.5a.5.5 0 00-.5-.5h-3a.5.5 0 00-.5.5V3H5v-.5z" clip-rule="evenodd"/>
</svg>Cubicle 
  </h1>
  <h4 class="">We intend to get you one</h4>
  </div>
  </div>
  <div class="row">
    <div class="col-sm-3 form-group">		
		<label  class="form-control" style="border:0px white solid">Email ID: </label> <br>
		<label  class="form-control" style="border:0px white solid">Name : </label><br>
		<label  class="form-control" style="border:0px white solid">Password : </label><br>
		<label  class="form-control" style="border:0px white solid">Country Code : </label><br>
		<label  class="form-control" style="border:0px white solid">Contact : </label><br>
		</div>
		
    <div class="col-sm-4">
		<input type="text" class="form-control" name="emailId" id="emailId" value="${User.emailId }" onkeyup="validateEmailId(this.value);"/><br>
		<input type="text" class="form-control" name="username" id="username" value="${User.username }" onkeyup="validateUserName(this.value);"/><br>
		<input type="text" class="form-control" name="password" id="password" value="${User.password }" onkeyup="validatePassword(this.value);checkKeyCode(event)"/><br>
		<input type="text" class="form-control" name="countryCode" id="countryCode" value="${User.countryCode }" onkeyup="validateCountryCode(this.value);"/><br>
		<input type="text" class="form-control" name="mobileNumber" id="mobileNumber" value="${User.mobileNumber }" onkeyup="validateMobileNumber(this.value);"/><br>
</div>

    <div class="col-sm-5">		
		<div   ><span class="error" id="emailId_error"></span ></div><br>
		<div   ><span class="error" id="username_error"></span></div><br>
		<div   ><span class="error" id="password_error"></span></div><br>
		<div   ><span class="error" id="countryCode_error" ></span></div><br>
		<div  ><span class="error" id="mobileNumber_error" ></span></div><br>
</div>
</div>
	
			
				
		<div class="container text-center">
  <div class="row">
    <div class="col-sm-4">			
				
			<input type="Submit" value="Sign Up" class="btn btn-success"/>
			</div>
			<div class="col-sm-2">
			</div>
			<div class="col-sm-6">
				
					<input type="Submit" value="Existing User? Login Here." class="btn btn-success" onclick="document.form[0].action = '';document.form[0].submit();"/>
				</div>
				</div>
</div>				
				</form>
				</div>
			
		
		
	
</body>
</html>