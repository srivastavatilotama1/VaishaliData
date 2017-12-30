<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>	
		<!--<xsl:template match="day">
				<xsl:for-each select="ancestor::*">
							<xsl:value-of select="./name"/>
				</xsl:for-each>
		</xsl:template>
		<xsl:template match="planet">
				<xsl:apply-templates select="day"/>
		</xsl:template>-->
		
		<!--
<xsl:template match="day">
			<xsl:for-each select="ancestor-or-self::*[@author]">
				<xsl:value-of select="local-name(.)"/>
				<xsl:text> </xsl:text>
			</xsl:for-each>
		</xsl:template>
		<xsl:template match="planet">
				<xsl:apply-templates select="day"/>
		</xsl:template>-->
		
		<xsl:template match="planet[descendant::text()='Mercury']">
				<info>Sorry, Mercury cannot be found at this time.</info>
			</xsl:template>
		<xsl:template match="*">
			<xsl:apply-templates select="*"/>
		</xsl:template>

<!--
The following axis contains all nodes that come after the context node in document order,
excluding any of the context node’s descendants—and also excluding attribute nodes and
namespace nodes.


-->
		
		
</xsl:stylesheet>
