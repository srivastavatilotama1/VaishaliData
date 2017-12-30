function isName()
{
	var re=/[a-zA-Z]{3,10}/;
	var v_name=document.form1.v_name.value;
	if(v_name.length==0)
		alert("enter name");
	else
		{
		if(re.exec(v_name)<=0)
			alert("Name should be between 3 to 10 characters");
		
		}
	}
function isDob()
{
	var re=/[0-9][0-9][\/][0-9][0-9][\/][0-9][0-9][0-9][0-9]?/;
	var dob=document .form1.dob.value;
	if(dob.length==0)
		alert("enter DOB");
	else
		{
		if(re.exec(dob)<=0)
			alert("dob must be in dd//mm//yyyy format");
		}
}
		
		function isPhno()
		{
			var re=/[0-9][0-9][\-][0-9][0-9][0-9][0-9][\-][0-9][0-9][0-9][0-9]/;
			var pno=document.form1.pno.value;
			if(pno.length==0)
			{
			alert("enter Phone Number");
			}
			else
			{
			if(re.exec(pno)<=0)
				alert("Phone number must be in xx-xxxx-xxxx format");
			}
		}
		function isEmail()
		{
			var re1=/[a-zA-Z][a-zA-Z0-9\_]*\@yahoo\.com/;
			var re2=/[a-zA-Z][a-zA-Z0-9\_]*\@yahoo\.in/;
			var re3=/[a-zA-Z][a-zA-Z0-9\_]*\@yahoo\.co.\in/;
			var mail=document.form1.mail.value;
			if(mail.length==0)
				{
				alert("enter email");
				}
			else if (re1.exec(mail)<=0)
				{
				 if (re2.exec(mail)<=0)
					 {
					 if (re3.exec(mail)<=0)
						 alert("invalid email"+re1.exec(mail));
					 }
				}
				 else return 1;
					 }
					
		function validate()
		{
			isName();
			isDob();
			isPhno();
			isEmail();
			
			}
		
			/**
 * 
 */