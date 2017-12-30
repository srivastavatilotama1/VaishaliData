<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		
<html>
	<body>
		<h2>Information</h2>
			<table>

<tr bgcolor="#9abcd32">
	<th>Name</th>
	<th>Address</th>
</tr>

<xsl:for-each select="adressbook/contact">
<tr>
	<td rowspan="2"><xsl:value-of select="Name"/></td>
	<td><xsl:value-of select="Address"/></td>
</tr>

<tr>
	<td><xsl:value-of select="City"/><xsl:value-of select="State"/></td>	
</tr>
	</xsl:for-each>
	</table>
		</body>	
	</html>

	</xsl:template>
</xsl:stylesheet>