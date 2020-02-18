$(document).ready(function(){
	
	/*1.Hide the error*/
	$("#grnCodeError").hide();
	$("#grnTypeError").hide();
	$('#orderCodeError').hide();
	$('#descriptionError').hide();
	
	
	/*2.Declare Boolean Variable*/
	var grnCodeError = true;
	var grnTypeError = true;
	var orderCodeError = true
	var descriptionError = true
	
	
	/*3.Link event with attribute*/
	$('#grnCode').keyup(function(){
		validate_grnCode();
	});
	$('#grnType').keyup(function(){
		validate_grnType();
	});
	
	$('#orderCode').click(function(){
		validate_orderCode();
	});
	
	$('#description').keyup(function(){
		validate_description();
	});
	/*4.Validate Function*/
	function validate_grnCode(){
		var exp = /^[a-zA-Z0-9]{4,6}$/;
		var val = $('#grnCode').val();
		if(val==''){
			$('#grnCodeError').show();
			$('#grnCodeError').html('GrnCode Should Not be empty');
			$('#grnCodeError').css('color','red');
			grnCodeError = false;
		}else if(!exp.test(val)){
			$('#grnCodeError').show();
			$('#grnCodeError').html('GrnCode Should be 4 to 6 Chars Only');
			$('#grnCodeError').css('color','red');
			grnCodeError = false;
		}else{
			$('#grnCodeError').hide();
			grnCodeError = true;
		}return grnCodeError
	}
	
	function validate_grnType(){
		var exp = /^[a-zA-Z]{4,6}$/;
		var val = $('#grnType').val();
		if(val==''){
			$('#grnTypeError').show();
			$('#grnTypeError').html('GrnType Should Not be empty');
			$('#grnTypeError').css('color','red');
			grnTypeError = false;
		}else if(!exp.test(val)){
			$('#grnTypeError').show();
			$('#grnTypeError').html('GrnType Should be 4 to 6 Chars Only');
			$('#grnTypeError').css('color','red');
			grnTypeError = false;
		}else{
			$('#grnTypeError').hide();
			grnTypeError = true;
		}return grnTypeError
	}
	
	function validate_orderCode(){
		var val=$("#orderCode").val();
		if(val == ''){
			$("#orderCodeError").show();
			$("#orderCodeError").html("Select one Option");
			$("#orderCodeError").css("color","red");
			orderCodeError = false;
		}else{
			$("#orderCodeError").hide();
			orderCodeError = true;
		}
		return orderCodeError;
	}
	
	function validate_description(){
		var val=$("#description").val();
		var exp=/^[A-Za-z\s]{10,50}$/;
		if(val==''){
			$("#descriptionError").show();
			$("#descriptionError").html("Description should not be empty");
			$("#descriptionError").css("color","red");
			descriptionError = false;
		}else if(!exp.test(val)){
			$("#descriptionError").show();
			$("#descriptionError").html("Description must be 10 to 50 characters");
			$("#descriptionError").css("color","red");
			descriptionError = false;
		}else{
			$("#descriptionError").hide();
			descriptionError = true;
		}
		return descriptionError;
	}
	
	
	/* 6. On Submit Form */
	$("#myform").submit(function() {
		validate_grnCode();
		validate_orderCode();
		validate_grnType();
		validate_description();
		if (grnCodeError && orderCodeError && grnTypeError && descriptionError )
			return true;
		else
			return false;
	});
});