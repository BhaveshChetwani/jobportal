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
	document.getElementById('updatecandidateform').action = 'savecandidate';
	document.getElementById('updatecandidateform').submit();
}

function uploadDocument(){
	var file = document.getElementById('mydoc').files[0]; 
	document.getElementById('updatecandidateform').action = 'uploaddocument';
	document.getElementById('updatecandidateform').submit();
}

function logout(){
alert('Im here');
document.getElementById('updatecandidateform').action = 'prelogin';
document.getElementById('updatecandidateform').submit();
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
