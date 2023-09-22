<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="/jobportal/js/dashboard.js?reload=<%=reload%>"
	type="text/javascript"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="dashboardform" method="POST">
		<h3>Welcome to Cubicle Consultancy, ${user.username }, you are a
			${user.roleName }</h3>

		<c:if
			test="${(user.roleName eq 'ADMIN') or (user.roleName eq 'INTERNALHR') or (user.roleName eq 'EXTERNALHR')}">
			<div>
				<div class="" id="">
					<table>
						<c:if
							test="${(user.roleName eq 'ADMIN') or (user.roleName eq 'INTERNALHR')}">
							<tr>
								<td><input type="Submit"
									class="btn btn-success addCandidate" value="Add Candidate"
									onclick="addCandidate();" /></td>
							</tr>
						</c:if>
						<tr>
							<td><input type="Submit"
								class="btn btn-success searchCandidate" value="Search Candidate"
								onclick="searchCandidate();" /></td>
						</tr>
					</table>
				</div>
		</c:if>

		<c:if
			test="${(user.roleName eq 'ADMIN') or (user.roleName eq 'INTERNALHR') or (user.roleName eq 'EXTERNALHR')}">
			<div class="" id="">
				<table>
					<c:if
						test="${(user.roleName eq 'ADMIN') or (user.roleName eq 'INTERNALHR')}">
						<tr>
							<td><input type="Submit"
								class="btn btn-success addJobDescription"
								value="Add Job Description" onclick="addJobDescription();" /></td>
						</tr>
					</c:if>
					<tr>
						<td><input type="Submit"
							class="btn btn-success searchJobDescription"
							value="Search Job Description" onclick="searchJobDescription();" />
						</td>
					</tr>
				</table>
			</div>
		</c:if>

		<c:if test="${(user.roleName eq 'ADMIN')}">
			<div class="" id="">
				<table>
					<tr>
						<td><input type="Submit" class="btn btn-success addClients"
							value="Add Clients" onclick="addClients();" /></td>
					</tr>
					<tr>
						<td><input type="Submit"
							class="btn btn-success searchClients" value="Search Clients"
							onclick="searchClients();" /></td>
					</tr>
				</table>
			</div>
		</c:if>
		</div>

	</form>
</body>
</html>