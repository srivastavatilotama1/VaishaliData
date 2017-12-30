<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
	You Have Entered:
	<s:property value="name" />
	<br />
	<s:property value="surnameKey" />
	<br />
	<s:property value="locationKey" />
	<br />
	<h2>...........Conditional Tag.............</h2>

   <s:set name="urname" value="name"/>
   
	<s:if test="%{#urname=='Vaishali'}">  
  				<h2>Vaishali From Java Net Stream</h2>	
 	</s:if>
 	
	<s:elseif test="%{#urname=='Manish'}">  
    		<h2>Manish From Dot Net Stream</h2>
 	</s:elseif>
 	
	<s:else>  
  			 <h2>Other Cataegory</h2>
	 </s:else>
	
 	

</body>
</html>
