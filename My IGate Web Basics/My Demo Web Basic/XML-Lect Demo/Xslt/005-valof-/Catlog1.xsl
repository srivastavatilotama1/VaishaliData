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
      <tr>
        <td><xsl:value-of select="catalog/cd/title" /></td>
        <td><xsl:value-of select="catalog/cd/artist" /></td>
      </tr>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>



<!--


he match attribute is used to associate a template with an XML element.
 The match attribute can also be used to define a template for the entire XML document. The value of the match attribute is an XPath expression (i.e. match="/" defines the whole document).
The match="/" attribute associates the template with the root of the XML source document.
-->