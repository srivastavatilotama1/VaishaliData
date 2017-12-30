<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Using the XPath last() function.</title>
</head>
<body>
<p>The XPath last() function returns an integer equal to the context
size.</p>
<p>Here is the content of the last node in the context:</p>
<xsl:apply-templates select="PRODUCTDATA/PRODUCT[last()]"/>
</body>
</html>
</xsl:template>
<xsl:template match="PRODUCT">
<p><xsl:value-of select="PRODUCTNAME"/></p>
<p><xsl:value-of select="DESCRIPTION"/></p>
<p><xsl:value-of select="PRICE"/></p>
<p><xsl:value-of select="QUANTITY"/></p>
</xsl:template>
</xsl:stylesheet>
