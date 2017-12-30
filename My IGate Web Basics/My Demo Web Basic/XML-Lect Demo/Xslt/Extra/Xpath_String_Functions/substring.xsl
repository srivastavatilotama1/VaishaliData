<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Using the substring() function</title>
</head>
<body>
<h3>Using the substring() function.</h3>
<xsl:apply-templates select="Poem/Phrase"/>
</body>
</html>
</xsl:template>
<xsl:template match="Phrase">
<p>The substring of <xsl:value-of select="."/>" beginning at character
4 and of length 8 is “
<xsl:value-of select="substring(., 4, 8)"/>".</p>
</xsl:template>
</xsl:stylesheet>
