<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">


<xsl:template match="/">
  <html>
  <body>
  <h2>My CD Collection</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Title</th>
      <th>Artist</th>
    </tr>
    <xsl:for-each select="catalog/cd">
    <tr>
      <td><xsl:value-of select="title"/></td>
      <xsl:choose>
        <xsl:when test="price &gt; 10">
          <td bgcolor="#ff00ff">
          <xsl:value-of select="artist"/></td>
        </xsl:when>
        <xsl:otherwise>
          <td><xsl:value-of select="artist"/></td>
        </xsl:otherwise>
      </xsl:choose>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>


</xsl:stylesheet>


<!--
The <xsl:choose> element is used in conjunction with <xsl:when> and <xsl:otherwise> to express multiple conditional tests


 <xsl:for-each select="/calatog/cd"> 
<tr> 
<td> <xsl:value-of select="title"></xsl:value-of> </td>
 <xsl:choose>
 <xsl:when test="price &gt; 10">
 <td bgcolor="pink">
 <xsl:value-of 	select="artist"></xsl:value-of> </td> 
</xsl:when> 
<xsl:otherwise>
 <td bgcolor="cyan"> 
<xsl:value-of select="artist">
</xsl:value-of>
 </td> </xsl:otherwise> </xsl:choose> 
						</tr> </xsl:for-each> -->





-->
