<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>	
	<xsl:template match="/">

//all text  element in the document
     <xsl:for-each select="//text">
          <xsl:choose>
               <xsl:when test='@size="H1"'>
                    <H1>
                         <xsl:value-of select="."/>
                    </H1>
               </xsl:when>
               <xsl:when test='@size="H3"'>
                    <H3>
                         <xsl:value-of select="."/>
                    </H3>
               </xsl:when>
               <xsl:when test='@size="b"'>
                    <b>
                         <xsl:value-of select="."/>
                    </b>
               </xsl:when>
               <xsl:when test='@size="sub"'>
                    <sub>
                         <xsl:value-of select="."/>
                    </sub>
               </xsl:when>
               <xsl:when test='@size="sup"'>
                    <sup>
                         <xsl:value-of select="."/>
                    </sup>
               </xsl:when>
          </xsl:choose>
     </xsl:for-each>
</xsl:template>
</xsl:stylesheet>
