<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title></title>
</head>
<body>
<p>
Does the first phrase of the nursery rhyme start with Twink"? -
<xsl:value-of select="starts-with(
string(Poem/Phrase[position()=1]),'Twink')"/></p>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
