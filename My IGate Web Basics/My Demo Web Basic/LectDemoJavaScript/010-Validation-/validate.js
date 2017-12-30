function validate()
	{
	 var fname = document.getElementById("fname"); 
	 
	if(fname.value.length==0)
	{
		alert("Mandatory fields should not be empty");
		return false;
	}
		
}
