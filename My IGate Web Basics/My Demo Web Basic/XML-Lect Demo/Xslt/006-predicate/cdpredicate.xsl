<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>George Miachel CD INFO</h2>
				<xsl:for-each select="/catalog/cd[artist='George Michel']">
					Title:
					<font color='red'>
						<xsl:value-of select="title" />
					</font>
					<br />
					Country:
					<font color='red'>
						<xsl:value-of select="country" />
					</font>
					<br />
					Artist:
					<font color='red'>
						<xsl:value-of select="artist" />
					</font>
					<br />
					Company:
					<font color='red'>
						<xsl:value-of select="company" />
					</font>
					<br />
					Price:
					<font color='red'>
						<xsl:value-of select="price" />
					</font>
					<br />
					Year:
					<font color='red'>
						<xsl:value-of select="year" />
					</font>
					..........................................................
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>