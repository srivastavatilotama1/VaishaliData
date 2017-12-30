<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Using the translate() function</title>
</head>
<body>
<h3>Using the translate() function</h3>
<xsl:apply-templates select="Poem/Phrase"/>
</body>
</html>
</xsl:template>
<xsl:template match="Phrase">
<p>Applying the translate() function specified to the string
"<xsl:value-of select="."/>" produces the string
"<xsl:value-of select="translate(., 'abcdefghijklmnopqrstuvwxyz',
'ABCDEFGHIJKLMNOPQRSTUVWXYZ')"/>".</p>
</xsl:template>
</xsl:stylesheet>
