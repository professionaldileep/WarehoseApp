$(document).ready(function(){
	
	$('#userNameError').hide();
	$('#userEmailError').hide();
	$('#userPwdError').hide();
	$('#rolesError').hide();
	
	
	var userNameError = false;
	var userEmailError = false;
	var userPwdError = false;
	var rolesError = false;
	
	
	
	$('#userName').keyup(function(){
		validate_userName();
	});
	
	$('#userEmail').keyup(function(){
		validate_userEmail();
	});
	
	$('#userPwd').keyup(function(){
		validate_userPwd();
	});
	
	$('input[type="checkbox"][name="roles"]').click(function(){
		validate_roles();
	});
	
	
	
	
	function validate_userName(){
		var val=$('#userName').val();
		var exp = /^[A-Za-z]{6,10}$/
		if(val==''){
			$('#userNameError').show();
			$('#userNameError').html('User Name Should not be empty');
			$('#userNameError').css('color', 'red');
			userNameError = false;
		}else if(!exp.test(val)){
			$('#userNameError').show();
			$('#userNameError').html('UserName Should be 6-10 Chars Only');
			$('#userNameError').css('color', 'red');
			userNameError = false;
		}else{
			$('#userNameError').hide();
			userNameError = true;
		}
		return userNameError;
	}
	
	
	
	function validate_userEmail(){
		var val=$('#userEmail').val();
		var exp= /^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/;
		if(val == ''){
			$('#userEmailError').show();
			$('#userEmailError').html('UserEmail Should not be empty');
			$('#userEmailError').css('color', 'red');
			userEmailError = false;
		}else if(!exp.test(val)){
			$('#userEmailError').show();
			$('#userEmailError').html('UserEmail Should be correct format');
			$('#userEmailError').css('color', 'red');
			userEmailError = false;
		}else{
			$('#userEmailError').hide();
			userEmailError = true;
		}return userEmailError;
	}
	
	function validate_userPwd(){
		var val=$('#userPwd').val();
		var exp = /^[a-zA-Z0-9]{4,8}$/;
		if(val == ''){
			$('#userPwdError').show();
			$('#userPwdError').html('Password Should not be empty');
			$('#userPwdError').css('color', 'red');
			userPwdError = false;
		}else if(!exp.test(val)){
			$('#userPwdError').show();
			$('#userPwdError').html('password should contain 4-8 chars');
			$('#userPwdError').css('color', 'red');
			userPwdError = false;
		}else{
			$('#userPwdError').hide();
			userPwdError = true;
		}return userPwdError;
	}
	
	function validate_roles(){
		var val=$('input[type="checkbox"][name="roles"]:checked').length;
		if(val==0){
			$('#rolesError').show();
			$('#rolesError').html("Please choose atleast One");
			$('#rolesError').css('color', 'red');
			rolesError = false;
		}else{
			$('#rolesError').hide();
			rolesError = true;
		}
	}
	
	/* 6. On Submit Form */
	$("#userForm").submit(function() {
		validate_roles();
		validate_userPwd();
		validate_userEmail();
		validate_userName();
		if (userNameError && userEmailError && userPwdError && rolesError)
			return true;
		else
			return false;
	});
});