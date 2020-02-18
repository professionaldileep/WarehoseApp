$(document)
.ready(
		function() {

			$("#uomTypeError").hide();
			$("#uomModelError").hide();
			$("#descrError").hide();


			var uomTypeError = true;
			var uomModelError = true;
			var descrError = true;



			$("#uomType").change(function(){
				validate_uomType();
			});

			$("#uomModel").keyup(function(){
				this.value = this.value.toUpperCase();
				validate_uomModel();
			});
			
			$("#descr").keyup(function(){
				validate_descr();
			});


			function validate_uomType(){
				var val=$("#uomType").val();
				if(val == ''){
					$("#uomTypeError").show();
					$("#uomTypeError").html("Select one Option");
					$("#uomTypeError").css("color","red");
					uomTypeError = false;
				}else{
					$("#uomTypeError").hide();
					uomTypeError = true;
				}
				return uomTypeError;
			}

			function validate_uomModel(){
				var val=$("#uomModel").val();
				var exp=/^[A-Z]{3,8}$/;
				if(val==''){
					$("#uomModelError").show();
					$("#uomModelError").html("Code cannot be empty");
					$("#uomModelError").css("color","red");
					uomModelError = false;
				}else if(!exp.test(val)){
					$("#uomModelError").show();
					$("#uomModelError").html("Code Must Be 2 to 8 chars only");
					$("#uomModelError").css("color","red");
					uomModelError = false;
				}else{
					$("#uomModelError").hide();
					uomModelError = true;
				}
				return uomModelError;
			}
			
			function validate_descr(){
				var val=$("#descr").val();
				var exp=/^[A-Za-z\s]{10,50}$/;
				if(val==''){
					$("#descrError").show();
					$("#descrError").html("Description ShouldNot Be Empty");
					$("#descrError").css("color","red");
					descrError = false;
				}else if(!exp.test(val)){
					$("#descrError").show();
					$("#descrError").html("Description Should Be 10-50 Chars Only");
					$("#descrError").css("color","red");
					descrError = false;
				}else{
					$("#descrError").hide();
					descrError = true;
				}
				return descrError;
			}

			$("#myform").submit(function() {
				validate_uomType();
				validate_uomModel();
				validate_descr();
				if (uomTypeError && uomModelError && descrError)
					return true;
				else
					return false;
			});
		});	