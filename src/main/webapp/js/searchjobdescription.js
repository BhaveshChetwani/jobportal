function searchjobdescriptiononload(){
	document.getElementById('clientDDId').value = document.getElementById('jobDescriptionClientId').value;
}
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

function saveCandidate(){
	//document.getElementById('updatecandidateform').action = 'savecandidate';
	//document.getElementById('updatecandidateform').submit();
}

function searchJobDescription(candidateId){

	document.getElementById('searchjobdescriptionform').action = 'searchjobdescription';
	document.getElementById('searchjobdescriptionform').submit();
}

function logout(){
document.getElementById('searchjobdescriptionform').action = 'prelogin';
document.getElementById('searchjobdescriptionform').submit();
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