<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	
	
	
	<xsl:template match="child::person">
 <html>
  <head>
   <title>
    <xsl:value-of select="descendant::firstname" />
    <xsl:text> </xsl:text>
    <xsl:value-of select="descendant::lastname" />
   </title>
  </head>
  <body>
   <xsl:value-of select="descendant::firstname" />
   <xsl:text> </xsl:text>
   <xsl:value-of select="descendant::lastname" />
  </body>
 </html>
</xsl:template>

</xsl:stylesheet>


<!--

The <xsl:text> element is used to create a space between the first name and the last name elements.

-->
