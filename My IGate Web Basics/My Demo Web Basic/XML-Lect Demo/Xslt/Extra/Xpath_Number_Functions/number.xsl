<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Using the number() function</title>
</head>
<body>
<h4>Accessing Text</h4>
<p><xsl:value-of select="number(DelhiTemperature/Monday)"/></p>
<h4>Accessing Number</h4>
<p><xsl:value-of select="number(DelhiTemperature/Tuesday)"/></p>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
