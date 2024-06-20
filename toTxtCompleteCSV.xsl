<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" omit-xml-declaration="yes" indent="yes"/>
    <xsl:template match="FactoryFloor">
        <xsl:text>ID;Category;CommercialCode;CompleteDesc;ShortDesc;UniqueFabCode;Unity</xsl:text>
        <xsl:apply-templates select="Products"/>
        <xsl:text>&#10;</xsl:text>
        <xsl:text>InternalCode;Description;TechSheet;CategoryID</xsl:text>
        <xsl:apply-templates select="RawMaterials"/>
        <xsl:text>&#10;</xsl:text>
        <xsl:text>ID;Brand;InstallationDate;Description;Model;SerialNum;PLID;Type</xsl:text>
        <xsl:apply-templates select="Machines"/>
        <xsl:text>&#10;</xsl:text>
        <xsl:text>ID</xsl:text>
        <xsl:apply-templates select="ProductionLines"/>
        <xsl:text>&#10;</xsl:text>
        <xsl:text>ID;Description;CategoryID</xsl:text>
        <xsl:apply-templates select="Categories"/>
        <xsl:text>&#10;</xsl:text>
        <xsl:text>ID;EmissionDate;ExpectedExecutionDate;UniqueFabricationCode;ProductOrderID;Quantity;State;Unity</xsl:text>
        <xsl:apply-templates select="ProductionOrders"/>
        <xsl:text>&#10;</xsl:text>
        <xsl:text>ProductID;Quantity;RawMaterialID</xsl:text>
        <xsl:apply-templates select="ProductionSheets"/>
        <xsl:text>&#10;</xsl:text>
    </xsl:template>

    <xsl:template match="Products/Product">
        <xsl:value-of
                select="concat(./@ID,';',./Category,';',./CommercialCode,';',./CompleteDesc,';',./ShortDesc,';',./UniqueFabCode,';',./Unity)"/>
    </xsl:template>

    <xsl:template match="RawMaterials/RawMaterial">
        <xsl:value-of select="concat(./@InternalCode,';',./Description,';',./TechSheet,';',./CategoryID)"/>
    </xsl:template>

    <xsl:template match="Machines/Machine">
        <xsl:value-of
                select="concat(./@ID,';',./Brand,';',./InstallationDate,';',./Description,';',./Model,';',./SerialNum,';',./PLID,';',./Type)"/>
    </xsl:template>

    <xsl:template match="ProductionLines/ProductionLine">
        <xsl:value-of select="./@ID"/>
    </xsl:template>

    <xsl:template match="Categories/Category">
        <xsl:value-of select="concat(./@ID,';',./Description,';',./CategoryID)"/>
    </xsl:template>

    <xsl:template match="ProductionOrders/ProductionOrder">
        <xsl:value-of
                select="concat(./@ID,';',./EmissionDate,';',./ExpectedExecutionDate,';',./UniqueFabricationCode,';',./ProductOrderID,';',./Quantity,';',./State,';',./Unity)"/>
    </xsl:template>

    <xsl:template match="ProductionSheets/ProductionSheet">
        <xsl:value-of select="concat(./@ProductID,';',./Quantity,';',./RawMaterialID)"/>
    </xsl:template>
</xsl:stylesheet>