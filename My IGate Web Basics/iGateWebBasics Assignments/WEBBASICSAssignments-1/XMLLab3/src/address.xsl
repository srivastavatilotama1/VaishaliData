<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Information</h2>
				<table>
					<tr bgcolor="#9acd32">
					<th>Name</th>
					<th>Address</th>
					</tr>
					<xsl:for-each select="addressbook/contact">
					<tr>
						<td rowspan="2"><xsl:value-of select="name"/></td>
						<td><xsl:value-of select="address"/></td>
					</tr>
					<tr>
						<td><xsl:value-of select="city"/>,<xsl:value-of select="state"/></td>
					</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>