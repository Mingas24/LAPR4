<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" omit-xml-declaration="yes" indent="yes"/>
    <xsl:template match="FactoryFloor">
        <xsl:text>ID;Category;CommercialCode;CompleteDesc;ShortDesc;UniqueFabCode;Unity</xsl:text>
        <xsl:apply-templates select="Products"/>
        <xsl:text>&#10;</xsl:text>
    </xsl:template>

    <xsl:template match="Products">
        <xsl:choose>
            <xsl:when test="Product/Unity = 'KG'">
                <xsl:apply-templates select="Product"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>&#10;</xsl:text>
                <xsl:text>No Products using KG as UNIT</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <xsl:template match="Product">
        <xsl:if test="Unity = 'KG'">
            <xsl:text>&#10;</xsl:text>
            <xsl:value-of
                    select="concat(./@ID,';',./Category,';',./CommercialCode,';',./CompleteDesc,';',./ShortDesc,';',./UniqueFabCode,';',./Unity)"/>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>