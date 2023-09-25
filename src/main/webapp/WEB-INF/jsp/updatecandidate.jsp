<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.File"%>
<%@ page import="org.apache.commons.io.FileUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="/jobportal/js/updatecandidate.js?reload=<%=reload%>"
	type="text/javascript"></script>


<title>Update</title>
</head>
<body>
	<%@ include file="customError.jsp"%>
	<form id="updatecandidateform" method="POST">
		<div class="d-flex row justify-content-center"
			style="display: flex; justify-content: left;">
			<div class="d-inline-block col-3 pt-1">
				<input type="text" name="id" id="id" value="${candidate.id }" />
				<table>
					<tr>
						<td>Name:</td>
						<td><input type="text" name="name" id="name"
							value="${candidate.name }" /></td>
						<td colspan="2"><p class="error" type="text" id="name_error"
								readonly maxlength="100"></p></td>
					</tr>
					<tr>
						<td>Email Id:</td>
						<td><input type="text" name="emailId" id="emailId"
							value="${candidate.emailId }" /></td>
						<td colspan="2"><p class="error" type="text" id="name_error"
								readonly maxlength="100"></p></td>
					</tr>
					<tr>
						<td>Mobile Number:</td>
						<td><input type="text" name="mobileNumber" id="mobileNumber"
							value="${candidate.mobileNumber }" /></td>
						<td colspan="2"><p class="error" type="text" id="name_error"
								readonly maxlength="100"></p></td>
					</tr>
					<tr>
						<td>Designation:</td>
						<td><input type="text" name="designation" id="designation"
							value="${candidate.designation }" /></td>
						<td colspan="2"><p class="error" type="text" id="name_error"
								readonly maxlength="100"></p></td>
					</tr>
					<tr>
						<td>Profile:</td>
						<td><input type="text" name="profile" id="profile"
							value="${candidate.profile }" /></td>
						<td colspan="2"><p class="error" type="text" id="name_error"
								readonly maxlength="100"></p></td>
					</tr>

					<tr>
						<td><input type="Submit" class="btn btn-success"
							value="Update Candidate" onclick="saveCandidate();" /></td>
					</tr>

				</table>
				<input type="text" name="documentUuid" id="documentUuid"
					value="${document.uuid}" /> <input type="text" name="documentName"
					id="documentName" value="${document.documentName}" />
			</div>
			<div class="d-inline-block col-6 pt-2" id="docUploadSection">
				<table>
					<tr>
						<td><input type="file" id="mydoc" /></td>
					</tr>
					<tr>
						<td>
							<!-- <input type="Submit" class="btn btn-success" value="Upload Document" onclick="uploadDocument();"/> -->
							<button class="btn btn-success" onclick="uploadDocument();">Upload
								Document</button>
						</td>
					</tr>
				</table>
			</div>
			<div class="d-inline-block col-6 pt-3" id="docframeSection">
				<%-- <iframe src="http://docs.google.com/gview?url=http://infolab.stanford.edu/pub/papers/google.pdf&embedded=true" style="width:600px; height:500px;display:none" frameborder="0"></iframe>
		
		<iframe src="download/${document.uuid}/${document.documentName}" style="width:600px; height:500px;display:none" frameborder="0"></iframe> --%>


				<%-- 		<%
File pdfFile = (File) request.getAttribute("pdf");
byte[] pdfByteArray = FileUtils.readFileToByteArray(pdfFile);
response.setContentType("application/pdf");
response.getOutputStream().write(pdfByteArray);
response.getOutputStream().flush();
%> --%>
			</div>
			<div class="d-inline-block col-3 pt-4">
				<table>
					<c:forEach items="${history }" var="jh">
						<tr>
							<%-- <td>${jh.status }</td>
							<td>${jh.updatedOn }</td> --%>
						</tr>
					</c:forEach>
				</table>

				<div class="myContainer">
					<div class="progress-container" style="display:flex;flex-direction:column;">
						
						<c:forEach items="${history }" var="jh" varStatus="historyIndex">
						<div  style="display:flex;flex-direction:row;">
							<c:choose>
								<c:when test="${historyIndex.index eq 0 }">
									<div class="circle active">${historyIndex.index+1}.&nbsp;</div>
									<div class="postlinebox"></div>
									<div class="verticaldiv">${jh.status }</div>
									<div class="postemptyline verticaldiv"></div>
									<div class="verticaldiv">${jh.updatedOn }</div>
									
								</c:when>
								<c:otherwise>
									<div class="circle active">${historyIndex.index+1}.&nbsp;</div>
									<div class="postlinebox"></div>
										<div class="verticaldiv">${jh.status }</div>
										<div class="postblueline verticaldiv"></div>
										<div class="verticaldiv">${jh.updatedOn }</div>
									
									
								</c:otherwise>
							</c:choose>
</div>
						</c:forEach>

					</div>
				</div>
			</div>

		</div>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		console.log('Ready');
		if ($('#documentUuid').val() != '') {
			$('#docUploadSection').hide();
			$('#docframeSection').show();

			downloadDoc();
		} else {
			$('#docUploadSection').show();
			$('#docframeSection').hide();

		}
	});
</script>
</html>