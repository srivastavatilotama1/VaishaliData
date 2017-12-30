<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Using the normalize-space() function</title>
</head>
<body>
<h3>Using normalize-space() - the before" and after"</h3>
<xsl:apply-templates select="Whitespace/Text"/>
</body>
</html>
</xsl:template>
<xsl:template match="Text">
<p>Before:<xsl:value-of select="."/></p>
<p> After:<xsl:value-of select="normalize-space(.)"/></p>
</xsl:template>
</xsl:stylesheet>
