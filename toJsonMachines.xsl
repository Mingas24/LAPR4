<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="utf-8"/>
    <xsl:template match="/">
        <xsl:text>{</xsl:text>
        <xsl:text>&#10;</xsl:text>
        <xsl:text>"</xsl:text><xsl:value-of select="name(FactoryFloor)"/>
        <xsl:text>" : {</xsl:text>
        <xsl:text>&#10;</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(FactoryFloor/Machines)"/>
        <xsl:text>" : [</xsl:text>
        <xsl:apply-templates select="FactoryFloor/Machines"/>
        <xsl:text>]</xsl:text>

        <xsl:text>&#10;</xsl:text>
        <xsl:text>}</xsl:text>
        <xsl:text>}</xsl:text>
    </xsl:template>

    <!-- Maquinas -->
    <xsl:template match="Machine">
        <xsl:text>{</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(@ID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="@ID"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Brand)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Brand"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(InstallationDate)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="InstallationDate"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Description)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Description"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Model)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Model"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(SerialNum)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="SerialNum"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(PLID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="PLID"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Type)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Type"/>
        <xsl:text>"</xsl:text>

        <xsl:text>}</xsl:text>
        <xsl:if test="following-sibling::*">
            <xsl:text> , </xsl:text>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>