$(document).ready(function(){
	$("#orderCodeError").hide();
	$("#shipmentCodeError").hide();
	$("#customerError").hide();
	$("#refNumberError").hide();
	$("#stockModeError").hide();
	$("#stockSourceError").hide();
	$("#descriptionError").hide();


	var orderCodeError = true;
	var shipmentCodeError = true;
	var customerError = true;
	var refNumberError = true;
	var stockModeError = true;
	var stockSourceError = true;
	var descriptionError = true;



	$("#orderCode").keyup(function(){
		this.value = this.value.toUpperCase();
		validate_orderCode();
	});


	$("#shipmentCode").change(function(){
		validate_shipmentCode();
	});

	$("#customer").change(function(){
		validate_customer();
	});

	$("#refNumber").keyup(function(){
		validate_refNumber();
	});

	$("input[type='radio'][name='stockMode']").change(function(){
		validate_stockMode();
	});

	$("#stockSource").change(function(){
		validate_stockSource();
	});
	
	$("#description").keyup(function(){
		validate_description();
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


	function validate_customer(){
		var val=$("#customer").val();
		if(val == ''){
			$("#customerError").show();
			$("#customerError").html("Select one Option");
			$("#customerError").css("color","red");
			customerError = false;
		}else{
			$("#customerError").hide();
			customerError = true;
		}
		return customerError;
	}

	function validate_refNumber(){
		var exp = /^[A-Za-z]{3}[0-9]{2}[/-][0-9]{1,4}$/;
		var val = $('#refNumber').val();
		if(val==''){
			$("#refNumberError").show();
			$("#refNumberError").html("RefNum should not be empty(Eg:ABC32-098)");
			$("#refNumberError").css("color","red");
			refNumberError = false;
		}else if(!exp.test(val)){
			$("#refNumberError").show();
			$("#refNumberError").html("Please Enter valid RefNum (Eg:ABC32-098)");
			$("#refNumberError").css("color","red");
			refNumberError = false;
		}else{
			$("#refNumberError").hide();
			refNumberError = true;
		}return refNumberError;
	}

	function validate_stockMode() {
		var val = $("input[type='radio'][name='stockMode']:checked").length;
		if (val == 0) {
			$('#stockModeError').show();
			$('#stockModeError').html("Choose One OrderMode");
			$('#stockModeError').css("color", "red");
			stockModeError = false;
		} else {
			$('#stockModeError').hide();
			stockModeError = true;
		}
		return stockModeError;
	}
	
	function validate_stockSource(){
		var val=$("#stockSource").val();
		if(val == ''){
			$("#stockSourceError").show();
			$("#stockSourceError").html("Select one Option");
			$("#stockSourceError").css("color","red");
			stockSourceError = false;
		}else{
			$("#stockSourceError").hide();
			stockSourceError = true;
		}
		return stockSourceError;
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
	$("#saleform").submit(function() {
		validate_description();
		validate_stockSource();
		validate_stockMode();
		validate_refNumber();
		validate_customer();
		validate_shipmentCode();
		validate_orderCode();
		if (orderCodeError && shipmentCodeError && customerError 
				&& refNumberError && descriptionError && stockModeError && stockSourceError)
			return true;
		else
			return false;
	});
});