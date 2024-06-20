<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>
                    Factory Floor
                </h2>
                <xsl:apply-templates select="FactoryFloor" /> <!-- para toda a fabrica-->
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
            <xsl:apply-templates select="Product" />
        </table>
    </xsl:template>
    <xsl:template match="Product">
        <tr>
            <td>
                <xsl:value-of select="@ID" />
            </td>
            <td>
                <xsl:value-of select="Category" />
            </td>
            <td>
                <xsl:value-of select="CommercialCode" />
            </td>
            <td>
                <xsl:value-of select="CompleteDesc" />
            </td>
            <td>
                <xsl:value-of select="ShortDesc" />
            </td>
            <td>
                <xsl:value-of select="UniqueFabCode" />
            </td>
            <td>
                <xsl:value-of select="Unity" />
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="RawMaterials">
        <h3>
            Raw Materials
        </h3>
        <table border="1">
            <tr bgcolor="#f2ff00">
                <th>InternalCode</th>
                <th>Description</th>
                <th>TechSheet</th>
                <th>CategoryID</th>
            </tr>
            <!-- para cada materia prima -->
            <xsl:apply-templates select="RawMaterial" />
        </table>
    </xsl:template>
    <xsl:template match="RawMaterial">
        <tr>
            <td>
                <xsl:value-of select="@InternalCode" />
            </td>
            <td>
                <xsl:value-of select="Description" />
            </td>
            <td>
                <xsl:value-of select="TechSheet" />
            </td>
            <td>
                <xsl:value-of select="CategoryID" />
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="Machines">
        <h3>
            Machines
        </h3>
        <table border="1">
            <tr bgcolor="#3a7bde">
                <th>ID</th>
                <th>Brand</th>
                <th>InstallationDate</th>
                <th>Description</th>
                <th>Model</th>
                <th>SerialNum</th>
                <th>PLID</th>
                <th>Type</th>
            </tr>
            <!-- para cada maquina -->
            <xsl:apply-templates select="Machine" />
        </table>
    </xsl:template>
    <xsl:template match="Machine">
        <tr>
            <td>
                <xsl:value-of select="@ID" />
            </td>
            <td>
                <xsl:value-of select="Brand" />
            </td>
            <td>
                <xsl:value-of select="InstallationDate" />
            </td>
            <td>
                <xsl:value-of select="Description" />
            </td>
            <td>
                <xsl:value-of select="Model" />
            </td>
            <td>
                <xsl:value-of select="SerialNum" />
            </td>
            <td>
                <xsl:value-of select="PLID" />
            </td>
            <td>
                <xsl:value-of select="Type" />
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="ProductionLines">
        <h3>
            Production Lines
        </h3>
        <table border="1">
            <tr bgcolor="#00ff44">
                <th>ID</th>
            </tr>
            <!-- para cada linha de producao -->
            <xsl:apply-templates select="ProductionLine" />
        </table>
    </xsl:template>
    <xsl:template match="ProductionLine">
        <tr>
            <td>
                <xsl:value-of select="@ID" />
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="Categories">
        <h3>
            Categories
        </h3>
        <table border="1">
            <tr bgcolor="#00ffff">
                <th>ID</th>
                <th>Description</th>
                <th>CategoryID</th>
            </tr>
            <!-- para cada categoria -->
            <xsl:apply-templates select="Category" />
        </table>
    </xsl:template>
    <xsl:template match="Category">
        <tr>
            <td>
                <xsl:value-of select="@ID" />
            </td>
            <td>
                <xsl:value-of select="Description" />
            </td>
            <td>
                <xsl:value-of select="CategoryID" />
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="ProductionOrders">
        <h3>
            Production Orders
        </h3>
        <table border="1">
            <tr bgcolor="#b300ff">
                <th>ID</th>
                <th>EmissionDate</th>
                <th>ExpectedExecutionDate</th>
                <th>UniqueFabricationCode</th>
                <th>ProductOrderID</th>
                <th>Quantity</th>
                <th>State</th>
                <th>Unity</th>
            </tr>
            <!-- para cada ordem de producao -->
            <xsl:apply-templates select="ProductionOrder" />
        </table>
    </xsl:template>
    <xsl:template match="ProductionOrder">
        <tr>
            <td>
                <xsl:value-of select="@ID" />
            </td>
            <td>
                <xsl:value-of select="EmissionDate" />
            </td>
            <td>
                <xsl:value-of select="ExpectedExecutionDate" />
            </td>
            <td>
                <xsl:value-of select="UniqueFabricationCode" />
            </td>
            <td>
                <xsl:value-of select="ProductOrderID" />
            </td>
            <td>
                <xsl:value-of select="Quantity" />
            </td>
            <td>
                <xsl:value-of select="State" />
            </td>
            <td>
                <xsl:value-of select="Unity" />
            </td>
        </tr>
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
            <xsl:apply-templates select="ProductionSheet" />
        </table>
    </xsl:template>
    <xsl:template match="ProductionSheet">
        <tr>
            <td>
                <xsl:value-of select="@ProductID" />
            </td>
            <td>
                <xsl:value-of select="Quantity" />
            </td>
            <td>
                <xsl:value-of select="RawMaterialID" />
            </td>
        </tr>
    </xsl:template>

</xsl:stylesheet>