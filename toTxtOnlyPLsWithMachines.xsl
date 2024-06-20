<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" omit-xml-declaration="yes" indent="yes"/>
    <xsl:template match="FactoryFloor">
        <xsl:text>ID</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:apply-templates select="Machines/Machine[not(PLID=preceding-sibling::Machine/PLID)]"/>
    </xsl:template>

    <xsl:template match="Machine">
        <xsl:value-of select="PLID"/>
        <xsl:text>&#xa;</xsl:text>
    </xsl:template>
</xsl:stylesheet>
