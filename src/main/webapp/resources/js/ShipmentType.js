$(document).ready(function(){
	
	$('#shipmentModeError').hide();
	$('#shipmentCodeError').hide();
	$('#enableError').hide();
	$('#gradeError').hide();
	$('#descrError').hide();
	
	
	var shipmentModeError = true;
	var shipmentCodeError = true;
	var enableError = true;
	var gradeError = true;
	var descrError = true;
	
	$('#shipmentMode').change(function(){
		validate_shipmentMode();
	});
	
	$('#shipmentCode').keyup(function(){
		validate_shipmentCode();
	});
	
	$('#enable').change(function(){
		validate_enable();
	});
	
	$("input[type='radio'][name='grade']:checked").change(function(){
		validate_grade();
	});
	
	$('#descr').keyup(function(){
		validate_descr();
	});
	
	function validate_shipmentMode(){
		var val=$("#shipmentMode").val();
		if(val == ''){
			$("#shipmentModeError").show();
			$("#shipmentModeError").html("Select one Option");
			$("#shipmentModeError").css("color","red");
			shipmentModeError = false;
		}else{
			$("#shipmentModeError").hide();
			shipmentModeError = true;
		}
		return shipmentModeError;
	}
	
	function validate_shipmentCode(){
		var val=$("#shipmentCode").val();
		var exp=/^[a-zA-Z0-9]{3,8}$/;
		if(val==''){
			$("#shipmentCodeError").show();
			$("#shipmentCodeError").html("Code cannot be empty");
			$("#shipmentCodeError").css("color","red");
			shipmentCodeError = false;
		}else if(!exp.test(val)){
			$("#shipmentCodeError").show();
			$("#shipmentCodeError").html("Code Must Be 3 to 8 chars only");
			$("#shipmentCodeError").css("color","red");
			shipmentCodeError = false;
		}else{
			$("#shipmentCodeError").hide();
			shipmentCodeError = true;
		}
		return shipmentCodeError;
	}
	
	function validate_enable(){
		var val=$("#enable").val();
		if(val == ''){
			$("#enableError").show();
			$("#enableError").html("Select one Option");
			$("#enableError").css("color","red");
			enableError = false;
		}else{
			$("#enableError").hide();
			enableError = true;
		}
		return enableError;
	}
	
	function validate_descr(){
		var val=$("#descr").val();
		var exp=/^[A-Za-z\s]{10,50}$/;
		if(val==''){
			$("#descrError").show();
			$("#descrError").html("Description should not be empty");
			$("#descrError").css("color","red");
			descrError = false;
		}else if(!exp.test(val)){
			$("#descrError").show();
			$("#descrError").html("Description must be 10 to 50 characters");
			$("#descrError").css("color","red");
			descrError = false;
		}else{
			$("#descrError").hide();
			descrError = true;
		}
		return descrError;
	}
	
	
	function validate_grade() {
		var val = $("input[type='radio'][name='grade']:checked").length;
		if (val == 0) {
			$('#gradeError').show();
			$('#gradeError').html("Choose One shipmentGrade");
			$('#gradeError').css("color", "red");
			gradeError = false;
		} else {
			$('#gradeError').hide();
			gradeError = true;
		}
		return gradeError;
	}
	

	/* 6. On Submit Form */
	$("#shipmentForm").submit(function() {
		validate_descr();
		validate_grade();
		validate_enable();
		validate_shipmentCode();
		validate_shipmentMode();
		if (descrError && gradeError && enableError && shipmentCodeError && shipmentModeError )
			return true;
		else
			return false;
	});
	
});