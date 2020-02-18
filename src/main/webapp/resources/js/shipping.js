$(document).ready(function(){


	/*1.Hide error column*/
	$('#shippingCodeError').hide();
	$('#shippingRefNumError').hide();
	$('#courierRefNumError').hide();
	$('#contactDetailsError').hide();
	$('#saleOrderCodeError').hide();
	$('#descriptionError').hide();
	$('#billToAddrError').hide();
	$('#shipToAddrError').hide();


	/*2.declare one boolean variable*/
	var shippingCodeError = true;
	var shippingRefNumError = true;
	var courierRefNumError = true;
	var contactDetailsError = true;
	var saleOrderCodeError = true;
	var descriptionError = true;
	var billToAddrError = true;
	var shipToAddrError = true;



	/*3.Link event using attribute*/
	$('#shippingCode').keyup(function(){
		validate_shippingCode();
	});

	$('#shippingRefNum').keyup(function(){
		validate_shippingRefNum();
	});

	$('#courierRefNum').keyup(function(){
		validate_courierRefNum();
	});


	$('#contactDetails').keyup(function(){
		validate_contactDetails();
	});


	$('#saleOrderCode').keyup(function(){
		validate_saleOrderCode();
	});
	
	
	$('#description').keyup(function(){
		validate_description();
	});	

	$('#billToAddr').keyup(function(){
		validate_billToAddr();
	});
	
	$('#shipToAddr').keyup(function(){
		validate_shipToAddr();
	});
	
	function validate_shippingCode(){
		var val=$("#shippingCode").val();
		var exp=/^[A-Za-z0-9]{3,8}$/;
		if(val==''){
			$("#shippingCodeError").show();
			$("#shippingCodeError").html("Code cannot be empty");
			$("#shippingCodeError").css("color","red");
			shippingCodeError = false;
		}else if(!exp.test(val)){
			$("#shippingCodeError").show();
			$("#shippingCodeError").html("Code Must Be 2 to 8 chars only");
			$("#shippingCodeError").css("color","red");
			shippingCodeError = false;
		}else{
			$("#shippingCodeError").hide();
			shippingCodeError = true;
		}return shippingCodeError;
	}

	function validate_shippingRefNum(){
		var exp = /^[A-Za-z]{3}[0-9]{2}[/-][0-9]{1,4}$/;
		var val = $('#shippingRefNum').val();
		if(val==''){
			$("#shippingRefNumError").show();
			$("#shippingRefNumError").html("RefNum should not be empty(Eg:ABC32-098)");
			$("#shippingRefNumError").css("color","red");
			shippingRefNumError = false;
		}else if(!exp.test(val)){
			$("#shippingRefNumError").show();
			$("#shippingRefNumError").html("Please Enter valid RefNum (Eg:ABC32-098)");
			$("#shippingRefNumError").css("color","red");
			shippingRefNumError = false;
		}else{
			$("#shippingRefNumError").hide();
			shippingRefNumError = true;
		}return shippingRefNumError;
	}

	function validate_courierRefNum(){
		var exp = /^[A-Za-z]{3}[0-9]{2}[/-][0-9]{1,4}$/;
		var val = $('#courierRefNum').val();
		if(val==''){
			$("#courierRefNumError").show();
			$("#courierRefNumError").html("RefNum should not be empty(Eg:ABC32-098)");
			$("#courierRefNumError").css("color","red");
			courierRefNumError = false;
		}else if(!exp.test(val)){
			$("#courierRefNumError").show();
			$("#courierRefNumError").html("Please Enter valid RefNum (Eg:ABC32-098)");
			$("#courierRefNumError").css("color","red");
			courierRefNumError = false;
		}else{
			$("#courierRefNumError").hide();
			courierRefNumError = true;
		}return courierRefNumError;
	}

	function validate_contactDetails(){
		var val = $('#contactDetails').val();
		if(val==''){
			$("#contactDetailsError").show();
			$("#contactDetailsError").html("contact details should not be empty");
			$("#contactDetailsError").css("color","red");
			contactDetailsError = false;
		}else{
			$("#contactDetailsError").hide();
			contactDetailsError = true;
		}return contactDetailsError;
	}
	
	function validate_saleOrderCode(){
		var val = $('#saleOrderCode').val();
		if(val==''){
			$("#saleOrderCodeError").show();
			$("#saleOrderCodeError").html("saleOrderCode should not be empty");
			$("#saleOrderCodeError").css("color","red");
			saleOrderCodeError = false;
		}else{
			$("#saleOrderCodeError").hide();
			saleOrderCodeError = true;
		}return saleOrderCodeError;
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
	
	function validate_billToAddr(){
		var val = $('#billToAddr').val();
		if(val==''){
			$("#billToAddrError").show();
			$("#billToAddrError").html("Address should not be empty");
			$("#billToAddrError").css("color","red");
			billToAddrError = false;
		}else{
			$("#billToAddrError").hide();
			billToAddrError = true;
		}return billToAddrError;
	}
	
	function validate_shipToAddr(){
		var val = $('#shipToAddr').val();
		if(val==''){
			$("#shipToAddrError").show();
			$("#shipToAddrError").html("Address should not be empty");
			$("#shipToAddrError").css("color","red");
			shipToAddrError = false;
		}else{
			$("#shipToAddrError").hide();
			shipToAddrError = true;
		}return shipToAddrError;
	}
	
	
	$("#myform").submit(function() {
		validate_shippingCode();
		validate_shippingRefNum();
		validate_courierRefNum();
		validate_contactDetails();
		validate_saleOrderCode();
		validate_description();
		validate_billToAddr();
		validate_shipToAddr();
		if (shippingCodeError && shippingRefNumError&& courierRefNumError && contactDetailsError && saleOrderError 
				&& descriptionError && billToAddrError && shipToAddrError)
			return true;
		else
			return false;
	});
	
});