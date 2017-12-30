function validate(fm)
{
var validform=true;
var type=fm[1];
var reason=fm[2];
var start= fm[3];
var end=fm[4];

if(type.value == -1)
{
//alert('Please select leave type.')
document.getElementById("msgtype").innerHTML="Please select leave type."
type.selectedIndex=0;
type.focus();
validform=false;
return false;
}

if(reason.value==-1)
{
//alert('Please select leave reason.')
document.getElementById("msgreason").innerHTML="Please select leave reason."
reason.selectedIndex=0;
reason.focus();
validform=false;
return false;
}
if(start.value=='')
{
//alert('Please Enter leave start date.')
document.getElementById("msgstart").innerHTML="Please Enter leave start date."
start.value='';
start.focus();
validform=false;
return false;
}
if(end.value=='')
{
//alert('Please Enter leave end date.')
document.getElementById("msgend").innerHTML="Please Enter leave end date."
end.value='';
end.focus();
validform=false;
return false;
}
if(start.value>end.value)
{
alert('Leave start date should be less than leave end date');
start.value=''
end.value=''
start.focus();
validform=false;
return false;
}



if(validform)
{alert('Form is valid');
var win=window.open("","Leave Details","height=500 width=500")
win.document.write("<html><head><title>Form Details</title></head><body>");
win.document.write("<h2>Leave Details</h2>");
win.document.write("<b>Employee Id:</b> "+fm[0].value+"<br/>");
win.document.write("<b>Leave Type: </b>"+fm[1].value+"<br/>");
win.document.write("<b>Leave Reason: </b>"+fm[2].value+"<br/>");
win.document.write("<b>Leave Start Date: </b>"+fm[3].value+"<br/>");
win.document.write("<b>Leave End Date: </b>"+fm[4].value+"<br/>");
win.document.write("<b>Duration of leave: </b>"+dur)
win.document.write("</body></html>");
}

}
