<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h3>CD Information .....</h3>
				<table border="2" bgcolor="cyan">
					<tr>
						<th>CD Title</th>
						<th>Price</th>
					</tr>
					<xsl:for-each select="/catalog/cd">
						<xsl:if test="price &gt; 10">
							<tr>
								<td>
									<xsl:value-of select="title"></xsl:value-of>
								</td>
								<td>
									<xsl:value-of select="price"></xsl:value-of>
								</td>
							</tr>
						</xsl:if>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>