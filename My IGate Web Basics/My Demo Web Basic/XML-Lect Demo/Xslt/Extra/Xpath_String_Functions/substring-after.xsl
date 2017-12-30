<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Using the substring-after() function</title>
</head>
<body>
<h3>Using the substring() function.</h3>
<xsl:apply-templates select="Poem/Phrase"/>
</body>
</html>
</xsl:template>
<xsl:template match="Phrase">
<p>The substring after the first occurence of 'Twinkle' in <xsl:value-of
 select="."/>" is &gt;
<xsl:value-of select="substring-after(., 'Twinkle')"/></p>
</xsl:template>
</xsl:stylesheet>
