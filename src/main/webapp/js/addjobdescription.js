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

function validateDescription(description){
	if(username.length <3){
		displayError('#description_error','Description should be minimum twenty five characters.');
		return false;
	}
}

function saveJobDescription(){
	document.getElementById('addjobdescriptionform').action = 'savejobdescription';
	document.getElementById('addjobdescriptionform').submit();
}

function logout(){
alert('Im here');
document.getElementById('addjobdescriptionform').action = 'prelogin';
document.getElementById('addjobdescriptionform').submit();
}


function checkKeyCode(event){
	return true;
	//alert(event.keyCode);
}
