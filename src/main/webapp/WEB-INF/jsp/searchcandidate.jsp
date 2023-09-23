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
<script src="/jobportal/js/searchcandidate.js?reload=<%=reload %>" type="text/javascript"></script>


<title>Update</title>
</head>
<body>
<%@ include file="customError.jsp" %>
	<form id="searchcandidateform" method="POST">
<div class="d-flex row justify-content-center" style="display: flex;justify-content: left;">
<div class="d-inline-block col-6 pt-1">	

<td><input type="text" name="searchCandidateId" id="searchCandidateId" value="${searchCandidateId }" /></td>

<td><input type="text" name="applyCandidateId" id="applyCandidateId" value="${applyCandidateId}" /></td>
<td><input type="text" name="applyJobDescriptionId" id="applyJobDescriptionId" value="${applyJobDescriptionId}" /></td>


		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="candidateName" id="candidateName" value="${candidateName }" /></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>
			<tr>
				<td>Email Id: </td>
				<td><input type="text" name="candidateEmail" id="candidateEmail" value="${candidateEmail}" /></td>
				<td colspan="2"><p class="error" type="text" id="name_error" readonly maxlength ="100" ></p></td>
			</tr>
			
			<tr>
				<td>
					<input type="Submit" class="btn btn-success" value="Search Candidate" onclick="searchCandidate();"/>
				</td>
			</tr>

		</table>
		
		<table>
		<tr>
			<th>Name</th>
			<th>Designation</th>
			<th>Contact</th>
			<th>Profile</th>
			<th>View</th>
			<th>Jobs</th>
			<th>Apply</th>
		</tr>
		<c:forEach items="${candidates}" var="cand">
		<tr>
			<td>${cand.name }</td>
			<td>${cand.designation }</td>
			<td>${cand.mobileNumber }</td>
			<td>${cand.profile }</td>
			<td><input type="Submit" class="btn btn-success" value="Open Candidate" onclick="searchCandidate(${cand.id });"/></td>
			<td><select id="jobApplication${cand.id}"><option value=""> -- Select a job -- </option>
			<c:forEach items="${jobDescriptions }" var="jd">
			<option value="${jd.id }_${jd.clientId }">${jd.clientName } - ${jd.name }</option>
			</c:forEach>
			</select>
			</td>
			<td><input type="Submit" class="btn btn-success" value="Apply" onclick="return applyJob(${cand.id });"/></td>
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