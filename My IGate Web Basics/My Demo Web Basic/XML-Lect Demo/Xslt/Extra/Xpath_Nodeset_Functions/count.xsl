<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Using the XPath Node Set functions</title>
</head>
<body>
<h4>Using count() Function</h4>
<p>In the source document there are <xsl:value-of
select="count(PRODUCTDATA/PRODUCT)"/> &lt;PRODUCT&gt; elements.</p>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
