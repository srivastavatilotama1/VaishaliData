/**
 * 
 */
//function to populate colors for mobiles
function populateColor()
{
	var mobileName=document.seller.mobName.value;
	if(mobileName.match("iPhone6"))
	{
		document.seller.color.options[0].value="black";
		document.seller.color.options[0].text="Black";
		document.seller.color.options[1].text="Leather";
		document.seller.color.options[1].value="leather";
		document.seller.color.options[2].value="greenSilicon";
		document.seller.color.options[2].text="Green Silicon";
		document.seller.color.options[3].text="Red";
		document.seller.color.options[3].value="red";
	}
	else if(mobileName.match("iPhone5S"))
	{
		document.seller.color.options[0].value="gold";
		document.seller.color.options[0].text="Gold";
		document.seller.color.options[1].text="Silver";
		document.seller.color.options[1].value="silver";
		document.seller.color.options[2].value="spacrGray";
		document.seller.color.options[2].text="Space Grey";
	}
	else if(mobileName.match("iPhone5C"))
	{
		document.seller.color.options[0].value="yellow";
		document.seller.color.options[0].text="Yellow";
		document.seller.color.options[1].text="Pink";
		document.seller.color.options[1].value="pink";
		document.seller.color.options[2].value="white";
		document.seller.color.options[2].text="White";
		document.seller.color.options[3].text="Blue";
		document.seller.color.options[3].value="blue";
	}
}
//function to display seller details in new window
function displayDetails()
{
	var ownerName= document.seller.name.value;
	var mob= document.seller.mobName.value;
	var colorSelected= document.seller.color.value;
	var description= document.seller.descrip.value;
	var cost= document.seller.sellingCost.value;
	if(mob=="SelectMobileName")
		{
		document.getElementById("err").innerHTML="Select mobile name";
		return false;
		}
	var newwin=window.open("","new window","toolbar,status,resizable");
	newwin.document.write("<center><h1>All DATA ENTERED SUCCESSFULLY</h1><br/><br/>");
	newwin.document.write("<h3>OWNWR NAME:     "+ownerName+"</h3>");
	newwin.document.write("<h3>MOBILE NAME:     "+mob+"</h3>");
	newwin.document.write("<h3>COLOR SELECTED:     "+colorSelected+"</h3>");
	newwin.document.write("<h3>DESCRIPTION:     "+description+"</h3>");
	newwin.document.write("<h3>SELLING COST:     "+cost+"</h3>");
	if(document.seller.negotiable.checked)
		{
			newwin.document.write("<h3>NEGOTIABLE: "+"YES"+"</h3></center>");
		}
	else
		newwin.document.write("<h3>NEGOTIABLE: "+"NO"+"</h3></center>");
		return true;
}