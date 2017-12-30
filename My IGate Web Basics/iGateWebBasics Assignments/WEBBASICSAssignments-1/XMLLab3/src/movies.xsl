<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">
	<xsl:template match="/">
		<xsl:for-each select="movies/movie" order-by="-actor">
		<xsl:for-each select="actor" order-by="-actor">
					<xsl:value-of select="."/>
		<br/></xsl:for-each>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>