function getUserModel() {
	var user = $("#username").val();
	var pass = $("#password").val();

	var model = {
		username : user,
		password : pass
	};

	return model;
}

function registerUser() {
	$.ajax({
		url : "/register",
		method : "POST",
		data : getUserModel(),
	}).done(function(response) {
		if (response === "home") {
			alert("Register succesful! Welcome");
			window.location.href = "home";
		} else {
			alert(response);
		}
	});
}

$(document).ready(function (){
	$('#userId').text("Test");
});