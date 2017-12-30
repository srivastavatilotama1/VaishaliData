<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	 <xsl:template match="/">
    <html>
       <body>
         <h1>Sales Report</h1>
         <xsl:apply-templates select="SalesReport/Header/*"/>
         <xsl:apply-templates select="SalesReport/Body"/>
       </body>
     </html>
   </xsl:template>
   <xsl:template match="InputDate">
     - InputDate:<xsl:value-of select="." /><br/>
   </xsl:template>
   <xsl:template match="PropertyName">
     - PropertyName:<xsl:value-of select="." /><br/>
   </xsl:template>
   <xsl:template match="SalesPerson">
     - SalesPerson:<xsl:value-of select="." /><br/>
   </xsl:template>
   <xsl:template match="Body">
     <table border="1" width="300">
       <tr><th>ProductName</th><th>Price</th><th>Volume</th></tr>
       <xsl:apply-templates select="Results"/>
     </table>
   </xsl:template>
   <xsl:template match="Results">
     <tr>
       <td><xsl:value-of select="ProductName" /></td>
       <td align="right"><xsl:value-of select="UnitPrice" />
         (<xsl:value-of select="UnitPrice/@Units" />)</td>
       <td align="right"><xsl:value-of select="Volume" /></td>
     </tr>
   </xsl:template>

</xsl:stylesheet>