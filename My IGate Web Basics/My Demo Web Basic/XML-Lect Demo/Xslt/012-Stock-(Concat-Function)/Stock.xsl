<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match = "/stocks">
<html>
    <body>
		 <ul>
            <xsl:for-each select = "stock">
				<xsl:if test =   "starts-with(@symbol, 'C')">
					<li>
						<xsl:value-of select = "concat(@symbol,' - ', name)"/>
					</li>
				 </xsl:if>
           </xsl:for-each>             
          </ul>
       </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
