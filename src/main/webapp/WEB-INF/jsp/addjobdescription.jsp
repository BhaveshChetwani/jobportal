<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="/jobportal/js/addjobdescription.js?reload=<%=reload %>" type="text/javascript"></script>


<title>Login</title>
</head>
<body>
<%@ include file="customError.jsp" %>
	<form id="addjobdescriptionform" method="POST">
		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" id="name" value="${jobDescription.name }"  onkeyup="validateUserName(this.value);"/></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>
			
			
			<tr>
				<td>Description: </td>
				<td><input type="text" name="designation" id="description" value="${jobDescription.description }"  onkeyup="validateDescription(this.value);" /></td>
				<td colspan="2"><p class="error" type="text" id="description_error" readonly maxlength ="100" ></p></td>
			</tr>
			
			<tr>
				<td>Client Name: </td>
				<td><input type="hidden" name="clientId" id="clientId" value="${jobDescription.clientId }"  onkeyup="" />
				<select id="clientDDId" value="${jobDescription.clientId }" onchange="document.getElementById('clientId').value=document.getElementById('clientDDId').value;">
				<option value="" >-- Select a client Name --</option>
				<c:forEach items="${clientsList}" var="clients">
				<option value="${clients.id}" >${clients.name}</option>
				</c:forEach>
				</select>
				</td>
				
				<td colspan="2"><p class="error" type="text" id="clientId_error" readonly maxlength ="100" ></p></td>
			</tr>
			
			<tr>
				<td>Location: </td>
				<td><input type="text" name="location" id="location" value="${jobDescription.location }"  onkeyup="" /></td>
				<td colspan="2"><p class="error" type="text" id="location_error" readonly maxlength ="100" ></p></td>
			</tr>
			
			<tr>
				<td>Tags: </td>
				<td><input type="text" name="tags" id="tags" value="${jobDescription.tags }"  onkeyup="" /></td>
				<td colspan="2"><p class="error" type="text" id="tags_error" readonly maxlength ="100" ></p></td>
			</tr>

			<tr>
				<td>
					<input type="Submit" class="btn btn-success" value="Save Candidate" onclick="saveJobDescription();"/>
				</td>
			</tr>

		</table>
		
	</form>
</body>
</html>