
function validation() {
		var custname = document.RegisterUserForm.custName.value;
		var mobileNo = document.RegisterUserForm.mobileNo.value;
		var uname = document.RegisterUserForm.uName.value;
		var pass = document.RegisterUserForm.pass.value;
		var repass = document.RegisterUserForm.rePass.value;
		var upattern = /[a-zA-Z]/;
		var number = /[0-9]{10}/;

		if (custname == "" || custname == null) {
			var custNameId=document.getElementById("custNameId");
			custNameId.innerHTML="Please enter your name";
			return false;
		}
		if (!custname.match(upattern)) {
			//alert("Name should be in characters only");
			var custNameId=document.getElementById("custNameId");
			custNameId.innerHTML="Name should be in characters only";
			return false;
		}

		if (mobileNo == "" || mobileNo == null) {
			//alert("Please enter your Mobile number");
			var mobileNoId=document.getElementById("mobileNoId");
			mobileNoId.innerHTML="Please enter your Mobile number";
			return false;
		}
		if (!mobileNo.match(number)) {
			//alert("Mobile number in digits only and maximum length is 10");
			var mobileNoId=document.getElementById("mobileNoId");
			mobileNoId.innerHTML="Mobile number in digits only and maximum length is 10";
			return false;
		}
		if (uname == "" || uname == null) {
			//alert("Please enter your Username");
			var uNameId=document.getElementById("uNameId");
			uNameId.innerHTML="Please enter your Username";
			return false;
		}
		if (pass == "" || pass == null)
		{
			//alert("Please enter your Password");
			var passId=document.getElementById("passId");
			passId.innerHTML="Please enter your Password";
			return false;
		}
		if (repass == "" || repass == null)
		{
			//alert("Please re-enter your Password")
			var rePassId=document.getElementById("rePassId");
			rePassId.innerHTML="Please re-enter your Password";
			return false;
		}
		if (repass != pass) 
		{
			//alert("Password didnt match")
			var rePassId=document.getElementById("rePassId");
			rePassId.innerHTML="Password didnt match";
			return false;
		}
	
	}


