<?xml version="1.0" encoding="ISO-8859-1" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html> <body> <h2> Project List </h2>

        <xsl:apply-templates/>

        </body> </html>

    </xsl:template>

    <xsl:template match="/projectList/project">

        <p>
            <xsl:apply-templates select="projectId"/>
            <xsl:apply-templates select="projectName"/>
            <xsl:apply-templates select="team"/>
        </p>

    </xsl:template>

    <xsl:template match="projectId">

        Project Id: <span style="color:#ff0000"> 
            <xsl:value-of select="."/> </span> <br/>

    </xsl:template>

    <xsl:template match="projectName">

        Project Name: <span style="color:#00ff00"> 
            <xsl:value-of select="."/> </span> <br/>

    </xsl:template>

    <xsl:template match="team">

        <table border="1">
        <th> <td> Employee Id </td> <td> First Name </td>
                 <td> Last Name </td> </th>

        <xsl:apply-templates select="teamMember"/>
        </table>

    </xsl:template>

    <xsl:template match="teamMember">

        <tr>
               <td> <xsl:value-of select="employeeId"/> </td>
               <td> <xsl:value-of select="firstName"/> </td>
               <td> <xsl:value-of select="lastName"/> </td>
        </tr>

    </xsl:template>

</xsl:stylesheet>
