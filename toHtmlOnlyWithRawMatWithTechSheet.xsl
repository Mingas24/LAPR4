<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>
                    Factory Floor
                </h2>
                <xsl:apply-templates select="FactoryFloor"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Products">
        <h3>
            Products
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
    </xsl:template>

    <xsl:template match="RawMaterials">
        <h3>
            Only Raw Materials With Tech Sheet
        </h3>
        <table border="1">
            <tr bgcolor="#f2ff00">
                <th>InternalCode</th>
                <th>Description</th>
                <th>TechSheet</th>
                <th>CategoryID</th>
            </tr>
            <!-- para cada materia prima -->
            <xsl:apply-templates select="RawMaterial"/>
        </table>
    </xsl:template>
    <xsl:template match="RawMaterial">
        <xsl:if test="TechSheet">
            <tr>
                <td>
                    <xsl:value-of select="@InternalCode"/>
                </td>
                <td>
                    <xsl:value-of select="Description"/>
                </td>
                <td>
                    <xsl:value-of select="TechSheet"/>
                </td>
                <td>
                    <xsl:value-of select="CategoryID"/>
                </td>
            </tr>
        </xsl:if>
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
        <h3>
            ProductionSheets
        </h3>
        <table border="1">
            <tr bgcolor="#ff00a6">
                <th>ProductID</th>
                <th>Quantity</th>
                <th>RawMaterialID</th>
            </tr>
            <!-- para cada ficha de producao -->
            <xsl:apply-templates select="ProductionSheet"/>
        </table>
    </xsl:template>
    <xsl:template match="ProductionSheet">
        <tr>
            <td>
                <xsl:value-of select="@ProductID"/>
            </td>
            <td>
                <xsl:value-of select="Quantity"/>
            </td>
            <td>
                <xsl:value-of select="RawMaterialID"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>