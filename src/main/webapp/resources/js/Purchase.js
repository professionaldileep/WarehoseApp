$(document).ready(function(){

	$('#orderCodeError').hide();
	$('#referenceNumError').hide();
	$('#shipmentCodeError').hide();
	$('#vendorError').hide();
	$('#descriptionError').hide();
	$('#qualityCheckError').hide();


	var referenceNumError = true;
	var orderCodeError = true;
	var shipmentCodeError = true;
	var vendorError = true;
	var descriptionError = true;
	var qualityCheckError = true;

	$('#referenceNum').keyup(function(){
		validate_referenceNum();
	});

	$('#orderCode').keyup(function(){
		validate_orderCode();
	});
	
	$('#shipmentCode').change(function(){
		validate_shipmentCode();
	});
	
	$('#vendor').change(function(){
		validate_vendor();
	});
	
	$('#description').keyup(function(){
		validate_description();
	});
	
	$("input[type='radio'][name='qualityCheck']").click(function() {
		validate_qualityCheck();
	});



	function validate_orderCode(){
		var val=$("#orderCode").val();
		var exp=/^[A-Z0-9]{3,8}$/;
		if(val==''){
			$("#orderCodeError").show();
			$("#orderCodeError").html("Code cannot be empty");
			$("#orderCodeError").css("color","red");
			orderCodeError = false;
		}else if(!exp.test(val)){
			$("#orderCodeError").show();
			$("#orderCodeError").html("Code Must Be 2 to 8 chars only");
			$("#orderCodeError").css("color","red");
			orderCodeError = false;
		}else{
			$("#orderCodeError").hide();
			orderCodeError = true;
		}
		return orderCodeError;
	}

	function validate_referenceNum(){
		var exp = /^[A-Z]{3}[0-9]{2}[/-][0-9]{1,4}$/;
		var val = $('#referenceNum').val();
		if(val == ''){
			$("#referenceNumError").show();
			$("#referenceNumError").html("RefNum should not be empty(Eg:ABC32-098)");
			$("#referenceNumError").css("color","red");
			referenceNumError = false;
		}else if(!exp.test(val)){
			$("#referenceNumError").show();
			$("#referenceNumError").html("Please Enter valid RefNum (Eg:ABC32-098)");
			$("#referenceNumError").css("color","red");
			referenceNumError = false;
		}else{
			$("#referenceNumError").hide();
			referenceNumError = true;
		}
	}
	
	function validate_shipmentCode(){
		var val=$("#shipmentCode").val();
		if(val == ''){
			$("#shipmentCodeError").show();
			$("#shipmentCodeError").html("Select one Option");
			$("#shipmentCodeError").css("color","red");
			shipmentCodeError = false;
		}else{
			$("#shipmentCodeError").hide();
			shipmentCodeError = true;
		}
		return shipmentCodeError;
	}
	

	function validate_vendor(){
		var val=$("#vendor").val();
		if(val == ''){
			$("#vendorError").show();
			$("#vendorError").html("Select one Option");
			$("#vendorError").css("color","red");
			vendorError = false;
		}else{
			$("#vendorError").hide();
			vendorError = true;
		}
		return vendorError;
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
	
	function validate_qualityCheck() {
		var val = $("input[type='radio'][name='qualityCheck']:checked").length;
		if (val == 0) {
			$('#qualityCheckError').show();
			$('#qualityCheckError').html(
			"Choose One qualityCheck");
			$('#qualityCheckError').css("color", "red");
			qualityCheckError = false;
		} else {
			$('#qualityCheckError').hide();
			qualityCheckError = true;
		}
		return qualityCheckError;
	}
	
	$("#purchaseForm").submit(function() {
		validate_qualityCheck();
		validate_description();
		validate_vendor();
		validate_shipmentCode();
		validate_orderCode();
		validate_referenceNum();
		if (qualityCheckError && descriptionError && referenceNumError && vendorError && shipmentCodeError && orderCodeError )
			return true;
		else
			return false;
	});
	
});