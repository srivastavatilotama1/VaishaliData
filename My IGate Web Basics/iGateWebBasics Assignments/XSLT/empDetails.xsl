<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl">
  <xsl:template match="/">

    <html>
      <body bgcolor="pink">
        <table border="1">
          <tr bgcolor="olive">
            <th>Emp ID</th>
            <th colspan="3">EMP NAME</th>
            <th>EMP SAL</th>
            <th>EMP AGE</th>
          </tr>
          <xsl:for-each select="employees/employee">                  
          <tr>
            <td>
              <xsl:value-of select="@eid"/>              
            </td>
            <td>
              <xsl:value-of select="ename/fname"/>
            </td>
            <td>
              <xsl:value-of select="ename/mname"/>
            </td>
            <td>
              <xsl:value-of select="ename/lname"/>
            </td>
            <td>
              <xsl:value-of select="esal"/>
            </td>
            <td>
              <xsl:value-of select="eage"/>
            </td>            
          </tr>
          </xsl:for-each>
        </table>
      </body>      
    </html>
  </xsl:template>  
</xsl:stylesheet>
