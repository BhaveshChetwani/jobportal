function validateUserName(username){
	if(username.length <5){
		displayError('#name_error','Username should be minimum five characters.');
		return false;
	}
	if(username.length>4){
		var params = 'username='+username;
		var op = callAjax('checkuserexists',params,false);
		
		if(op == 'true'){
			displayError('#name_error','Username \''+username+'\' already exists. Please enter a differet username.')
			return false;
		}
		
	}
	$('#name_error').hide();
	return true;
	
}

function searchCandidate(searchCandidateId){
	if(searchCandidateId!=undefined && searchCandidateId!=null){
		alert('Candidate ID:'+searchCandidateId);
		document.getElementById('searchCandidateId').value = searchCandidateId;
		document.getElementById('searchcandidateform').action = 'loadcandidate';
		document.getElementById('searchcandidateform').submit();
	}else{
		document.getElementById('searchcandidateform').action = 'searchcandidate';
		document.getElementById('searchcandidateform').submit();
	}
}

function applyJob(candidateId){
	let jdid = 'jobApplication'+candidateId;
	let jdfield = document.getElementById(jdid);
	if(jdfield!=null && jdfield.value!=null && jdfield.value!=""){
		document.getElementById('applyJobDescriptionId').value = jdfield.value;
		document.getElementById('applyCandidateId').value = candidateId;
		document.getElementById('searchcandidateform').action = 'searchcandidate';
		document.getElementById('searchcandidateform').submit();
	}else{
		alert('Select a Job before applying');
		jdfield.focus();
		return false;
	}
}

/*
function uploadDocument() {
	let formData = new FormData();
	var file = document.getElementById('mydoc').files[0];
	var candidateId = document.getElementById('id').value;
	formData.append("document", file);
	formData.append("candidateId", candidateId);
	var ajaxoutput = '';
	var url = 'uploaddocument', params = '', async = true;
	var op = callAjax(url, formData, async);

}
*/

function logout(){
document.getElementById('searchcandidateform').action = 'prelogin';
document.getElementById('searchcandidateform').submit();
}

function validateEmailId(value){
	return true;
}

function validateMobileNumber(value){
	return true;
}

function validateCountryCode(value){
	return true;
}

function validatePassword(password){
	if(password.length <8){
		displayError('#password_error','Password should be minimum eight characters.')
		return false;
	}
		
	$('#password_error').hide();
	return true;
	
	
}

function checkKeyCode(event){
	return true;
	//alert(event.keyCode);
}

function downloadDoc(){
	var formdata = new FormData();
	formdata.append("uuid",$('#documentUuid').val());
	formdata.append("documentName",$('#documentName').val());
	var op = callAjax('download/'+$('#documentUuid').val()+'/'+$('#documentName').val(),formdata,false);
	 var objbuilder = '';
	 objbuilder += ('<embed width=\'100%\' height=\'500px\'  src="data:application/pdf;base64,');
	 objbuilder += (op);
	 objbuilder += ('" type="application/pdf" />');
	 $('#docframeSection').html(objbuilder);
}