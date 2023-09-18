<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="/jobportal/js/dashboard.js?reload=<%=reload %>" type="text/javascript"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="dashboardform" method="POST">
		<h3>Welcome to Cubicle Consultancy, ${User.username }</h3>
		<table>
		<tr>
				<td>
					<input type="Submit" class="btn btn-success addCandidate" value="Add Candidate" onclick="addCandidate();"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="Submit" class="btn btn-success searchCandidate" value="Search Candidate" onclick="searchCandidate();"/>
				</td>
			</tr>
		</table>
		
		<table>
		<tr>
				<td>
					<input type="Submit" class="btn btn-success addJobDescription" value="Add Job Description" onclick="addJobDescription();"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="Submit" class="btn btn-success searchJobDescription" value="Search Job Description" onclick="searchJobDescription();"/>
				</td>
			</tr>
		</table> 
		 
	</form>
</body>
</html>