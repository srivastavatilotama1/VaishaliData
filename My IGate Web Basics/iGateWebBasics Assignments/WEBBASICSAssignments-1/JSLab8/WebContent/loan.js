
function validloan(field)
{	
	 var field1=parseInt(field);
	if(field.length==0)
		{
			alert("Enter Loan Amount");
		}
	else if(isNaN(field1))
		{
			alert("Enter amount in digits only");
		}
	else if(field1>1500000)
		{
			alert("amount should not be more than 15 lakhs");
		}
}
function validrate(field)
{
	var field1=parseInt(field);
	if(field.length==0)
		{
			alert("Enter annual percent of interest");
		}
	else if(isNaN(field1))
		{
			alert("Enter interest in digits only");
		}

}
function validyears(field)
{
	var field1=parseInt(field);
	if(field.length==0)
		{
			alert("Enter repayment period");
		}
	else if(isNaN(field1))
		{
			alert("Enter period in digits only");
		}
	else if(field1<7||field1>15)
		{
			alert("years should be between 7 and 15");
		}
}
function calculate()
{
	var principleV=document.form1.LoanAmt.value;
	var rateV=document.form1.Interest.value;
	var tenureV=document.form1.Years.value;
	var principle=parseInt(principleV);
	var rate=parseInt(rateV);
	var tenure=parseInt(tenureV);
	if(principleV.length==0||rateV.length==0||tenureV.length==0)
		alert("Enter all the values");
	else
		{
		var res1=(principle+((principle*tenure*rate)/100))/tenure*12;
		var res2=(principle+(((principle*tenure*rate)/100)));
		var res3=(((principle*tenure*rate)/100));
		document.form1.Monthly.value=res1;
		document.form1.Total.value=res2;
		document.form1.TotalInterest.value=res3;
		document.form1.Monthly.disabled="disabled";
		document.form1.Total.disabled="disabled";
		document.form1.TotalInterest.disabled="disabled";
		}
}

