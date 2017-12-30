<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
<xsl:output method="text" encoding="UTF-8"/>
<xsl:template match="item">
<html>
	<head>
		<title>Hello</title>
	</head>
	<body bgcolor="pink">
			<xsl:for-each select="child::part-number">
  				 <xsl:value-of select="."/> 	<br></br>
  			</xsl:for-each>	  
  			
	</body>	
</html>  
		</xsl:template>
<xsl:template match="text()"><!--do nothing -->	<br/>	
</xsl:template>  
</xsl:stylesheet>
