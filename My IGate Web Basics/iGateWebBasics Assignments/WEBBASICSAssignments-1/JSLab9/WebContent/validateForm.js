function isName()
	{
		var re=/[a-zA-Z]{3,10}/;
		var uname=document.form1.uname.value;
		if(uname.length==0)
			alert("enter name");
		else
			{
				if(re.exec(uname)<=0)
					alert("Name should be between 3 to 10 characters");
			}
	}
function isDob()
{
	var re=/[0-9][0-9][\/][0-9][0-9][\/][0-9][0-9]\([0-9][0-9])?/;
	var dob=document.form1.dob.value;
	if(dob.length==0)
		alert("enter dob");
	else
		{
		if(re.exec(dob)<=0)
			alert("dob must be in dd/mm/yy or dd/mm/yyyy format");
		}
	}
function isPhno()
{
	var re=/[0-9][0-9][\-][0-9][0-9][0-9][0-9][\-][0-9][0-9][0-9][0-9]/;
	var phno=document.form1.phno.value;
	if(phno.length==0)
		alert("enter phno");
	else
		{
		if(re.exec(phno)<=0)
			alert("Phno must be in xx-xxxx-xxxx format");
		}
	}
function isEmail()
{
	var re1=/[a-zA-Z][a-zA-Z0-9\_]*\@yahoo\.com/;
	var re2=/[a-zA-Z][a-zA-Z0-9\_]*\@yahoo\.in/;
	var re3=/[a-zA-Z][a-zA-Z0-9\_]*\@yahoo\.co.\in/;
	var email=document.form1.email.value;
	if(email.length==0)
		alert("enter email");
	else if(re1.exec(email)<=0)
		{
			if(re2.exec(email)<=0)
				{
				if(re3.exec(email)<=0)
					alert("invalid email"+re1.exec(email));
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
	alert("Submitted successfully");
}