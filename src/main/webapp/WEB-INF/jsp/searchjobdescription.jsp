<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.io.FileUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="/jobportal/js/searchjobdescription.js?reload=<%=reload %>" type="text/javascript"></script>


<title>Update</title>
</head>
<body onload="searchjobdescriptiononload();">
<%@ include file="customError.jsp" %>
	<form id="searchjobdescriptionform" method="POST">
<div class="d-flex row justify-content-center" style="display: flex;justify-content: left;">
<div class="d-inline-block col-6 pt-1">	


		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="jobDescriptionName" id="jobDescriptionName" value="${jobDescriptionName }" /></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>
			<tr>
				<td>Location: </td>
				<td><input type="text" name="jobDescriptionLocation" id="jobDescriptionLocation" value="${jobDescriptionLocation }" /></td>
				<td colspan="2"><p class="error" type="text" id="location_error" readonly maxlength ="100" ></p></td>
			</tr>
			
			<tr>
				<td>Client Name: </td>
				<td><input type="hidden" name="jobDescriptionClientId" id="jobDescriptionClientId" value="${jobDescriptionClientId }"  onkeyup="" />
				<select id="clientDDId" value="" onchange="document.getElementById('jobDescriptionClientId').value=document.getElementById('clientDDId').value;">
				<option value="" >-- Select a client Name --</option>
				<c:forEach items="${clientsList}" var="clients">
				<option value="${clients.id}" >${clients.name}</option>
				</c:forEach>
				</select>
				</td>
				
				<td colspan="2"><p class="error" type="text" id="clientId_error" readonly maxlength ="100" ></p></td>
			</tr>
			
			<tr>
				<td>
					<input type="Submit" class="btn btn-success" value="Search Job Descriptions" onclick="searchJobDescription();"/>
				</td>
			</tr>

		</table>
		
		<table>
		<tr>
			<th>Name</th>
			<th>Designation</th>
			<th>Contact</th>
			<th>Profile</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${jobDescriptions}" var="jobDescription">
		<tr>
			<td>${jobDescription.name }</td>
			<td>${jobDescription.location }</td>
			<td><input type="Submit" class="btn btn-success" value="Open Candidate" onclick="searchCandidate(${jobDescription.id });"/></td>
		</tr>
		</c:forEach>
		</table>
		
		</div>
		</div>
	</form>
</body>
<script type="text/javascript">
$(document).ready(function(){
	console.log('Ready');
});

</script>
</html>