<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <body>
                <table border="1" bgcolor="#FF0000">

                    <xsl:for-each select="/projectList/project">

                        <tr>
                            <td> <xsl:value-of select="projectId"/> </td> 
                            <td> <xsl:value-of select="projectName"/> </td>
                        </tr>

                    </xsl:for-each>

                </table>
            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>
