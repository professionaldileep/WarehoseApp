$(document).ready(function(){

	/*1.Hide error section*/
	$("#codeError").hide();
	$("#dimensionsError").hide();
	$("#baseCostError").hide();
	$('#baseCurrError').hide();
	$('#uomError').hide();
	$('#saleError').hide();
	$('#purchaseError').hide();
	$('#noteError').hide();


	/*2.declare one boolean var*/
	var codeError = true;
	var dimensionsError = true;
	var baseCostError = true;
	var baseCurrError = true;
	var uomError = true;
	var saleError = true;
	var purchaseError = true;
	var noteError = true;


	/*3. Link event using attribute*/
	$('#code').keyup(function(){
		this.value = this.value.toUpperCase();
		validate_code();
	});

	$('#width').keyup(function(){
		validate_dimError();
	});

	$('#length').keyup(function(){
		validate_dimError();
	});
	$('#height').keyup(function(){
		validate_dimError();
	});

	$('#baseCost').keyup(function(){
		validate_baseCost();
	});

	$('#baseCurr').change(function(){
		validate_baseCurr();
	});

	$('#uom').change(function(){
		validate_uom();
	});

	$('#sale').change(function(){
		validate_sale();
	});

	$('#purchase').change(function(){
		validate_purchase();
	});

	$('#note').keyup(function(){
		validate_note();
	});

	/*4. function validation*/
	function validate_code(){
		var val = $('#code').val();
		var exp=/^[A-Z0-9]{3,6}$/;
		if(val==''){
			$('#codeError').show();
			$('#codeError').html("Code Should not be empty");
			$('#codeError').css('color','red');
			codeError = false;
		}else if(!exp.test(val)){
			$('#codeError').show();
			$('#codeError').html("Code Should be 3 to 6 chars only");
			$('#codeError').css('color','red');
			codeError = false;
		}else{
			$('#codeError').hide();
			codeError = true;
		}
		return codeError;
	}

	function validate_dimError(){
		var valw = $('#width').val();
		var vall = $('#length').val();
		var valh = $('#height').val();
		var exp=/^[0-9/.]{2,6}$/;
		if((valw=='')||(vall=='')||(valh=='')){
			$('#dimensionsError').show();
			$('#dimensionsError').html("dimensions Should not be empty");
			$('#dimensionsError').css('color','red');
			dimensionsError = false;
		}else if((!exp.test(valw))||(!exp.test(vall))||(!exp.test(valh))){
			$('#dimensionsError').show();
			$('#dimensionsError').html("dimensions Should be 2 to 4 double values only");
			$('#dimensionsError').css('color','red');
			dimensionsError = false;
		}else{
			$('#dimensionsError').hide();
			dimensionsError = true;
		}
		return dimensionsError;
	}

	function validate_baseCost(){
		var val = $('#baseCost').val();
		var exp=/^[0-9/.]{2,6}$/;
		if(val==''){
			$('#baseCostError').show();
			$('#baseCostError').html("baseCost Should not be empty");
			$('#baseCostError').css('color','red');
			baseCostError = false;
		}else if(!exp.test(val)){
			$('#baseCostError').show();
			$('#baseCostError').html("baseCost Should be double value only");
			$('#baseCostError').css('color','red');
			baseCostError = false;
		}else{
			$('#baseCostError').hide();
			baseCostError = true;
		}
		return baseCostError;
	}

	function validate_baseCurr(){
		var val=$("#baseCurr").val();
		if(val == ''){
			$("#baseCurrError").show();
			$("#baseCurrError").html("Please Select one Option");
			$("#baseCurrError").css("color","red");
			baseCurrError = false;
		}else{
			$("#baseCurrError").hide();
			baseCurrError = true;
		}
		return baseCurrError;
	}

	function validate_uom(){
		var val=$("#uom").val();
		if(val == ''){
			$("#uomError").show();
			$("#uomError").html("Please Select one Option");
			$("#uomError").css("color","red");
			uomError = false;
		}else{
			$("#uomError").hide();
			uomError = true;
		}
		return uomError;
	}


	function validate_sale(){
		var val=$("#sale").val();
		if(val == ''){
			$("#saleError").show();
			$("#saleError").html("Please Select one Option");
			$("#saleError").css("color","red");
			saleError = false;
		}else{
			$("#saleError").hide();
			saleError = true;
		}
		return saleError;
	}


	function validate_purchase(){
		var val=$("#purchase").val();
		if(val == ''){
			$("#purchaseError").show();
			$("#purchaseError").html("Please Select one Option");
			$("#purchaseError").css("color","red");
			purchaseError = false;
		}else{
			$("#purchaseError").hide();
			purchaseError = true;
		}
		return purchaseError;
	}

	
	function validate_note(){
		var val = $('#note').val();
		var exp=/^[A-Za-z\s]{10,50}$/;
		if(val==''){
			$('#noteError').show();
			$('#noteError').html("note Should not be empty");
			$('#noteError').css('color','red');
			noteError = false;
		}else if(!exp.test(val)){
			$('#noteError').show();
			$('#noteError').html("note Should be 10 to 50 char");
			$('#noteError').css('color','red');
			noteError = false;
		}else{
			$('#noteError').hide();
			noteError = true;
		}
		return noteError;
	}
	
	/* 6. On Submit Form */
	$("#myform").submit(function() {
		validate_code();
		validate_dimError();
		validate_baseCost();
		validate_baseCurr();
		validate_uom();
		validate_sale();
		validate_purchase();
		validate_note();
		if (codeError && dimensionsError && baseCostError && baseCurrError && uomError && saleError && purchaseError && noteError)
			return true;
		else
			return false;
	});
	
});