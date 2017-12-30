function isDate(value)
{
	var str="Select";
	if(value==str)
		alert("Select atleast one value");
}
function isNotEmpty(fieldV)
{
	var field=parseInt(fieldV);
	if(fieldV.length==0)
		alert("All * fields should be filled");
}
function isName(fieldV)
{
	var re=/^[a-zA-Z]/;
	if(fieldV.length==0)
		alert("All * fields should be filled");
	else if(re.exec(fieldV)<=0)
		{
			alert("Name sholud not start with numbers or special characters");
		}
}
function isPass(password)
{
	var re=/[a-zA-Z]*[0-9]+[a-zA-Z]*/;
	if(password.length==0)
		alert("Enter password");
	else if(password.length<6)
		alert("password length should not be less than 6");
	else if(re.exec(password)<=0)
		alert("password should be combination of characters and numerics");
}
function isPassMatch(password)
{
	var password1=document.form1.pwd.value;
	if(password.length==0)
		alert("Enter password");
	else if(password.length<6)
		alert("password length should not be less than 6");
	else if(!(password==password1))
		alert("password doesn't match");
}
function isFullName(name)
{
	var re=/[a-zA-Z]*/;
	if(name.length==0)
		alert("Enter first Name");
	if(re.exec(name)<=0)
			{
				alert("Name should only contain characters");
			}
	
	} 
function isHintQuesAns()
{
	var selectHint=document.form1.qstn.value;
	var userqstn=document.form1.Qstn2.value;
	var ans=document.form1.Answer.value;
	var str="Select";
	if(selectHint==str)
		{
			if(userqstn.length==0)
				alert("choose question from given list or enter your question");
		}
	else
		document.form1.Qstn2.disabled="disabled";
	if(ans.length==0)
	alert("Enter answer for question");
}
function isCountry(country)
{
	if(country=="Select")
		alert("Select alteast one country");
}
function isCity(city)
{
	if(city=="Select")
		alert("Select alteast one city");
}
function validate()
{
	var day=document.form1.day.value;
	isDate(day);
	var month=document.form1.month.value;
	isDate(month);
	var year=document.form1.year.value;
	isDate(year);
	var name=document.form1.uname.value;
	isName(name);
	var pwd=document.form1.pwd.value;
	isPass(pwd);
	var pwd1=document.form1.retypePwd.value;
	isPassMatch(pwd1);
	var fName=document.form1.fname.value;
	isFullName(fName);
	var lname=document.form1.lname.value;
	isFullName(lname);
	isHintQuesAns();
	var country1=document.form1.country.value;
	isCountry(country1);
	var city=document.form1.city.value;
	isCity(city);
	alert("Validation successful");	
			
}

