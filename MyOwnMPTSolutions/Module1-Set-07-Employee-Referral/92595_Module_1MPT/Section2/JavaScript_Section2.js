/*------------------------------------------------------------------------------------------------------------------
1.File				  :JavaScript_Section_2.js
2.Author		      :Samyaka Dalvi
3.Version			  :1.0
4.Last Modified date  :2-September-2016
5.Desription	      :MPT Question to create a webpage of employee referral
------------------------------------------------------------------------------------------------------------------*/


function ValidateAllDate()
{	
	var city=window.document.form1.txtCity.value;
	var firstName=window.document.form1.txtFn.value;
	var lastName =window.document.form1.txtln.value;
	var mobile =window.document.form1.txtMobile.value;
	var dob =window.document.form1.txtDoB.value;
	var email =window.document.form1.txtEmail.value;
	var state;	
	
	if (city=="Chennai")							//Check for TamilNadu
	{
		state="TamilNadu";
	}
	else if (city=="Mumbai"||city=="Pune")	       //Check for Maharashtra
	{
		state="Maharashtra";
	}
	else if(city=="Bangalore")					   //Check for Karnataka
	{
		state="Karnataka";
	}
	
	
	var winObj=window.open("","CgWin","width=500,height=500");
	winObj.document.write("The Employee details are as follows :<br/><br/>"+"First Name - "+ firstName 
	+"<br/>Last Name - "+ lastName +"<br/>Contact Number - "+ mobile +"<br/>Email Address - "+ email 
	+"<br/>Date of Birth - "+ dob +"<br/>Current City - "+ city +"<br/>State - "+ state);
	
}









