$(document).ready(function(){
	
	/*1.Hide Error column*/
	$('#userTypeError').hide();
	$('#userCodeError').hide();
	$('#uidTypeError').hide();
	$('#userContactError').hide();
	$('#userEmailError').hide();
	$('#uidNumberError').hide();
	
	/*2.Declare One boolean var*/
	var userTypeError = true;
	var userCodeError = true;
	var uidTypeError = true;
	var userEmailError = true;
	var uidNumberError = true;
	var userContactError = true;
	
	
	
	
	/*3.Link event using attribute */
	$("input[name='userType'][type='radio']").click(function(){
		validate_userType();
	});
	
	$("#uidType").change(function(){
		validate_uidType();
	});
	
	$("#userEmail").keyup(function(){
		validate_userEmail();
	});
	
	$("#userContact").keyup(function(){
		validate_userContact();
	});
	
	$('#userCode').keyup(function(){
		validate_userCode();
	});
	
	$('#uidNumber').keyup(function(){
		validate_uidNumber();
	});
	
	/*4.validate function*/
	function validate_userType(){
		var val = $("input[type='radio'][name='userType']:checked").length;
		if (val == 0) {
			$('#userTypeError').show();
			$('#userTypeError').html("Choose One userType");
			$('#userTypeError').css("color", "red");
			userTypeError = false;
		} else {
			$('#userTypeError').hide();
			userTypeError = true;
		}
		
		var val = $("input[type='radio'][name='userType']:checked").val();
		if(val=='CUSTOMER')
			$("#userFor").val("Sale");
		else if(val == 'VENDOR')
			$("#userFor").val("Purchase");
		return userTypeError;
	}
	
	function validate_userCode(){
		var val=$('#userCode').val();
		var exp=/^[A-Za-z0-9]{3,8}$/
		if(val == ''){
			$('#userCodeError').show();
			$('#userCodeError').html("UserCode should not be empty");
			$('#userCodeError').css('color','red');
			userCodeError = false;
		}else if(!exp.test(val)){
			$('#userCodeError').show();
			$('#userCodeError').html("UserCode should be 3 to 8 chars only");
			$('#userCodeError').css('color','red');
			userCodeError = false;
		}else{
			$('#userCodeError').hide();
			userCodeError = true;
		}return userCodeError;
	}
	
	function validate_uidNumber(){
		var val=$('#uidNumber').val();
		var exp=/^[A-Za-z0-9]{3,8}$/
		if(val == ''){
			$('#uidNumberError').show();
			$('#uidNumberError').html("UserID should not be empty");
			$('#uidNumberError').css('color','red');
			uidNumberError = false;
		}else if(!exp.test(val)){
			$('#uidNumberError').show();
			$('#uidNumberError').html("UserID should be 3 to 8 alpha_num chars only");
			$('#uidNumberError').css('color','red');
			uidNumberError = false;
		}else{
			$('#uidNumberError').hide();
			uidNumberError = true;
		}return uidNumberError;		
	}
	
	function validate_userContact(){
		var val=$('#userContact').val();
		var exp=/^[0-9]{6,10}$/
		if(val == ''){
			$('#userContactError').show();
			$('#userContactError').html("UserContact should not be empty");
			$('#userContactError').css('color','red');
			userContactError = false;
		}else if(!exp.test(val)){
			$('#userContactError').show();
			$('#userContactError').html("UserContact number should be 10 numbers only");
			$('#userContactError').css('color','red');
			userContactError = false;
		}else{
			$('#userContactError').hide();
			userContactError = true;
		}return userContactError;		
	}
	
	function validate_uidType(){
		var val=$("#uidType").val();
		if(val == ''){
			$('#uidTypeError').show();
			$('#uidTypeError').html("select one user ID");
			$('#uidTypeError').css('color','red');
			uidTypeError = false;
		}else{
			$('#uidTypeError').hide();
			uidTypeError = true;
		}
		if(val=='Other'){
			$('#other').removeAttr("readonly");
			uidTypeError = true;
		}else{
			$("#other").attr("readonly", 'true');
			$("#other").val('');
			uidTypeError = true;
		}
		return uidTypeError;
	}
	
	function validate_userEmail(){
		var exp= /^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/;
		var val = $("#userEmail").val();
		if(val==''){
			$('#userEmailError').show();
			$('#userEmailError').html("Email should not be empty");
			$('#userEmailError').css("color","red");
			userEmailError = false
		}else if(!exp.test(val)){
			$('#userEmailError').show();
			$('#userEmailError').html("Please Enter valid email");
			$('#userEmailError').css("color","red");
			userEmailError = false
		}else{
			$('#userEmailError').hide();
			userEmailError = true;
		}
		return userEmailError;
	}
	
	$("#myform").submit(function() {
		validate_userType();
		validate_userCode();
		validate_userContact();
		validate_uidType();
		validate_uidNumber();
		validate_userEmail();
		if (userTypeError && uidNumberError && userContactError &&  uidTypeError && userCodeError && userEmailError)
			return true;
		else
			return false;
	});
	
});