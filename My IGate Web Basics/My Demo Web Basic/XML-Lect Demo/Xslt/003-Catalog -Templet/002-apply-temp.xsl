<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
<xsl:template match="/">
        <html>
            <body>
                <h2><font color=" blue">CD Collection</font>  </h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    
        <xsl:template match="cd">
        <p> <xsl:apply-templates select="title"/> </p>
    </xsl:template>    

    <xsl:template match="title">
        <p><b>Title:</b><xsl:value-of select="."/></p>
    </xsl:template>

</xsl:stylesheet>
