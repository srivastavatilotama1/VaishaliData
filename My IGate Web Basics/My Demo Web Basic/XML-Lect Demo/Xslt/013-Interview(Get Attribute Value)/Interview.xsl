<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:template match=" / ">
		<html>
			<body>
				<table border="5" align="center" bgcolor="#fedcba">
					<tr>
						<td>Name</td>
						<td>DOB</td>
						<td>Project</td>
						<td>Score</td>
					</tr>
		<xsl:for-each select="Interview/Candidate[@Skill='Computer']">
					<tr>
						<td><xsl:value-of select="Name"></xsl:value-of></td>
						<td><xsl:value-of select="Name/@DOB"></xsl:value-of></td>
						<td><xsl:value-of select="Project"></xsl:value-of></td>
						<td><xsl:value-of select="Score"></xsl:value-of></td>
					</tr>
		</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>





