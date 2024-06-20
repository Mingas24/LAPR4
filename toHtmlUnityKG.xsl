<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>
                    Factory Floor
                </h2>
                <xsl:apply-templates select="FactoryFloor"/> <!-- para toda a fabrica-->
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Products">
        <h3>
            Products Which Unit is Kilo
        </h3>
        <table border="1">
            <tr bgcolor="#ff0000">
                <th>ID</th>
                <th>Category</th>
                <th>CommercialCode</th>
                <th>CompleteDesc</th>
                <th>ShortDesc</th>
                <th>UniqueFabCode</th>
                <th>Unity</th>
            </tr>
            <!-- para cada producto -->
            <xsl:apply-templates select="Product"/>
        </table>
    </xsl:template>
    <xsl:template match="Product">
        <xsl:if test="Unity = 'KG'">
            <tr>
                <td>
                    <xsl:value-of select="@ID"/>
                </td>
                <td>
                    <xsl:value-of select="Category"/>
                </td>
                <td>
                    <xsl:value-of select="CommercialCode"/>
                </td>
                <td>
                    <xsl:value-of select="CompleteDesc"/>
                </td>
                <td>
                    <xsl:value-of select="ShortDesc"/>
                </td>
                <td>
                    <xsl:value-of select="UniqueFabCode"/>
                </td>
                <td>
                    <xsl:value-of select="Unity"/>
                </td>
            </tr>
        </xsl:if>
    </xsl:template>
    <xsl:template match="RawMaterials">
    </xsl:template>
    <xsl:template match="RawMaterial">
    </xsl:template>
    <xsl:template match="Machines">
    </xsl:template>
    <xsl:template match="Machine">
    </xsl:template>
    <xsl:template match="ProductionLines">
    </xsl:template>
    <xsl:template match="ProductionLine">
    </xsl:template>
    <xsl:template match="Categories">
    </xsl:template>
    <xsl:template match="Category">
    </xsl:template>
    <xsl:template match="ProductionOrders">
    </xsl:template>
    <xsl:template match="ProductionOrder">
    </xsl:template>
    <xsl:template match="ProductionSheets">
    </xsl:template>
    <xsl:template match="ProductionSheet">
    </xsl:template>
</xsl:stylesheet>