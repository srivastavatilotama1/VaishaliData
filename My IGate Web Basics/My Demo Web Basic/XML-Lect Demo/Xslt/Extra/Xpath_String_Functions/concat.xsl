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

The start of the Poem rhyme is:
<xsl:value-of select="concat(string(Poem/Phrase[position()=1]),'
', string(Poem/Phrase[position()=2]))"/></p>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
