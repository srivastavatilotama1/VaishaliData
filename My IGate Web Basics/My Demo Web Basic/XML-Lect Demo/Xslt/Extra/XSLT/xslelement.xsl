<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" indent="yes"/>
<xsl:template match="/">
<PRODUCTDATA>
<PRODUCT>
<xsl:for-each select="PRODUCTDATA/PRODUCT/PRODID/@*">
<xsl:element name="{name()}">
<xsl:value-of select="."/>
</xsl:element>
</xsl:for-each>
</PRODUCT>
</PRODUCTDATA>
</xsl:template>
</xsl:stylesheet>
