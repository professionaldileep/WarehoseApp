$(document)
.ready(
		function() {

			/* 1.hide error column */
			$("#orderModeError").hide();
			$("#orderAcceptError").hide();
			$("#orderTypeError").hide();
			$("#orderCodeError").hide();
			$("#descriptionError").hide();

			/* 2.Declare One Boolean Var */
			var orderModeError = true;
			var orderAcceptError = true;
			var orderTypeError = true;
			var orderCodeError = true;
			var descriptionError = true;


			/* 3.Link Event using attribute */
			$("input[type='radio'][name='orderMode']").click(
					function() {

						/* 5.Call validator */
						validate_orderMode();

					});

			$("input[type='checkbox'][name='orderAccept']")
			.click(function() {

				validate_orderAccept();

			});

			$("#orderType").change(function(){
				validate_orderType();
			});
			
			$("#orderCode").keyup(function(){
				this.value = this.value.toUpperCase();
				validate_orderCode();
			});
			
			$("#description").keyup(function(){
				validate_description();
			});
			
			
			/* 4.Validate Function */
			function validate_orderMode() {
				var val = $("input[type='radio'][name='orderMode']:checked").length;
				if (val == 0) {
					$('#orderModeError').show();
					$('#orderModeError').html(
					"Choose One OrderMode");
					$('#orderModeError').css("color", "red");
					orderModeError = false;
				} else {
					$('#orderModeError').hide();
					orderModeError = true;
				}
				return orderModeError;
			}

			function validate_orderAccept() {
				var val = $("input[type='checkbox'][name='orderAccept']:checked").length;
				if (val == 0) {
					$('#orderAcceptError').show();
					$('#orderAcceptError').html(
					"Atleast ChooseOne Method");
					$('#orderAcceptError').css("color", "red");
					orderAcceptError = false;
				} else {
					$('#orderAcceptError').hide();
					orderAcceptError = true;
				}
				return orderAcceptError;
			}

			function validate_orderType(){
				var val=$("#orderType").val();
				if(val == ''){
					$("#orderTypeError").show();
					$("#orderTypeError").html("Select one Option");
					$("#orderTypeError").css("color","red");
					orderTypeError = false;
				}else{
					$("#orderTypeError").hide();
					orderTypeError = true;
				}
				return orderTypeError;
			}

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
				validate_orderMode();
				validate_orderAccept();
				validate_orderType();
				validate_orderCode();
				validate_description();
				if (orderModeError && orderAcceptError && orderTypeError &&orderCodeError && descriptionError )
					return true;
				else
					return false;
			});
});