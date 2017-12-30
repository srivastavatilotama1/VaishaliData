<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">

<html>
<head>

<title>Delhi's Temperatures - rounded up using the ceiling()
function</title>
</head>
<body>
<h3>Delhi's Temperatures - rounded up, using ceiling() function</h3>
<xsl:apply-templates select="DelhiTemperature/*"/>
</body>
</html>
</xsl:template>

<xsl:template match="Monday | Tuesday | Wednesday | Thursday | Friday">
<p><xsl:value-of select="ceiling(.)"/> - <xsl:value-of select="name()"
/></p>
</xsl:template>
</xsl:stylesheet>
