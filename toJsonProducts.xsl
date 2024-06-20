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
        <xsl:value-of select="name(FactoryFloor/Products)"/>
        <xsl:text>" : [</xsl:text>
        <xsl:apply-templates select="FactoryFloor/Products"/>
        <xsl:text>]</xsl:text>

        <xsl:text>&#10;</xsl:text>
        <xsl:text>}</xsl:text>
        <xsl:text>}</xsl:text>
    </xsl:template>

    <!-- Produtos -->
    <xsl:template match="Product">
        <xsl:text>{</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(@ID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="@ID"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Category)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Category"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(CommercialCode)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="CommercialCode"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(CompleteDesc)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="CompleteDesc"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(ShortDesc)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="ShortDesc"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(UniqueFabCode)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="UniqueFabCode"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Unity)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Unity"/>
        <xsl:text>"</xsl:text>

        <xsl:text>}</xsl:text>
        <xsl:if test="following-sibling::*">
            <xsl:text> , </xsl:text>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>