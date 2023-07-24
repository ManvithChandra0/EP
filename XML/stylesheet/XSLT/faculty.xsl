<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0" xmlns:xsl = "http://www.w3.org/1999/XSL/Transform"> 
<xsl:template match="/">

<html>
<body>
<h2 align="center">Faculty Information</h2>

<table align="center" bgcolor="lightblue" boder="2">
<tr bgcolor="yellow">
<td>ID</td>
<td>NAME</td>
<td>Gender</td>
<td>Contact</td>
<td>Email</td>
<td>Department</td>
</tr>

<xsl:for-each select="facultydata/faculty">
<tr>
<td> <xsl:value-of select="id"></xsl:value-of></td>
<td> <xsl:value-of select="name"></xsl:value-of></td>
<td> <xsl:value-of select="gender"></xsl:value-of></td>
<td> <xsl:value-of select="contact"></xsl:value-of></td>
<td> <xsl:value-of select="email"></xsl:value-of></td>
<td> <xsl:value-of select="@department"></xsl:value-of></td>

</tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>

</xsl:stylesheet>