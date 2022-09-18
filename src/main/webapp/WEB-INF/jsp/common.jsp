<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Calendar"  %>
<% String reload = Calendar.getInstance().getTimeInMillis()+""; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="/jobportal/js/common.js?reload=<%=reload %>" type="text/javascript"></script>
<script src="/jobportal/js/jquery.3.51.min.js?reload=<%=reload %>" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js?reload=<%=reload %>"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js?reload=<%=reload %>"></script>

<link href="/jobportal/css/common.css?reload=<%=reload %>" rel="stylesheet" type="text/css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css?reload=<%=reload %>">


</head>
<body>
<!-- <form id="logoutform" method="POST"> -->
<div>
<button style="align:right" align="right" class="btn btn-outline-danger" onclick="if(confirm('Are you sure you want to logout?')){logout();}">Logout</button>
</div>
<!-- </form> -->
</body>
<script type="text/javascript">
/* function logout(){
	alert('Im here');
	document.getElementById('logoutform').action = '';
	document.getElementById('logoutform').submit();
} */
</script>
</html>