<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="/jobportal/js/addcandidate.js?reload=<%=reload %>" type="text/javascript"></script>


<title>Login</title>
</head>
<body>
<%@ include file="customError.jsp" %>
	<form id="addcandidateform" method="post">
		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" id="name" value="${candidate.name }" /></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>
			<tr>
				<td>Email Id: </td>
				<td><input type="text" name="emailId" id="emailId" value="${candidate.emailId }" /></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>
			<tr>
				<td>Mobile Number: </td>
				<td><input type="text" name="mobileNumber" id="mobileNumber" value="${candidate.mobileNumber }" /></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>
			<tr>
				<td>Designation: </td>
				<td><input type="text" name="designation" id="designation" value="${candidate.designation }" /></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>
			<tr>
				<td>Profile: </td>
				<td><input type="text" name="profile" id="profile" value="${candidate.profile }" /></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>

			<tr>
				<td>
					<input type="Submit" class="btn btn-success" value="Save Candidate" onclick="saveCandidate();"/>
				</td>
			</tr>

		</table>
		
	</form>
</body>
</html>