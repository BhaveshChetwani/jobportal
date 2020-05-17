function hideErrors(){
	$('.error').hide();
}

function callAjax(url, params, async, callback){
	var ajaxoutput = '';
	$.ajax({
		url : url,
		type : 'POST',
		data : params,
		async : async,
	}).done(function(data){
		console.log("data:"+data);
		ajaxoutput = data;
		console.log("ajaxoutput:"+ajaxoutput);
	});
	
	return ajaxoutput;
}

function displayError(errorId, errorMsg){
	$(errorId).html(errorMsg);
	$(errorId).val(errorMsg);
	$(errorId).show();
	$(errorId).css('color','red');
	$(errorId).css('font-weight','bold');
	//$(errorId).css('border','1px solid red');
}