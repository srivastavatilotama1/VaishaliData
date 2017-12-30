<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:emp="http://kogentindia.com/emp">
<xsl:template match="/">
<html>
<head>
<title></title>
</head>
<body>
<h4>Using local-name()</h4>
<p>The local part of the &lt;emp:first&gt; element is <xsl:value-of
select="local-name(emp:employees/emp:name/emp:first)"/></p>
<h4>Using name()</h4>
<p>The name() function applied to the &lt;emp:first&gt; element returns:
<xsl:value-of select="name(emp:employees/emp:name/emp:first)"/></p>
<h4>Using namespace-uri()</h4>
<p>The namespace-uri() function applied to the &lt;emp:first&gt; element
 returns:
<xsl:value-of select="namespace-uri(emp:employees/emp:name/emp:first)"/></p>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
