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
        <xsl:text> , </xsl:text>
        <xsl:text>&#10;</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(FactoryFloor/RawMaterials)"/>
        <xsl:text>" : [</xsl:text>
        <xsl:apply-templates select="FactoryFloor/RawMaterials"/>
        <xsl:text>]</xsl:text>
        <xsl:text> , </xsl:text>
        <xsl:text>&#10;</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(FactoryFloor/Machines)"/>
        <xsl:text>" : [</xsl:text>
        <xsl:apply-templates select="FactoryFloor/Machines"/>
        <xsl:text>]</xsl:text>
        <xsl:text> , </xsl:text>
        <xsl:text>&#10;</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(FactoryFloor/ProductionLines)"/>
        <xsl:text>" : [</xsl:text>
        <xsl:apply-templates select="FactoryFloor/ProductionLines"/>
        <xsl:text>]</xsl:text>
        <xsl:text> , </xsl:text>
        <xsl:text>&#10;</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(FactoryFloor/Categories)"/>
        <xsl:text>" : [</xsl:text>
        <xsl:apply-templates select="FactoryFloor/Categories"/>
        <xsl:text>]</xsl:text>
        <xsl:text> , </xsl:text>
        <xsl:text>&#10;</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(FactoryFloor/ProductionOrders)"/>
        <xsl:text>" : [</xsl:text>
        <xsl:apply-templates select="FactoryFloor/ProductionOrders"/>
        <xsl:text>]</xsl:text>
        <xsl:text> , </xsl:text>
        <xsl:text>&#10;</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(FactoryFloor/ProductionSheets)"/>
        <xsl:text>" : [</xsl:text>
        <xsl:apply-templates select="FactoryFloor/ProductionSheets"/>
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

    <!-- Materias Primas -->
    <xsl:template match="RawMaterial">
        <xsl:text>{</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(@InternalCode)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="@InternalCode"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Description)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Description"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(TechSheet)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="TechSheet"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(CategoryID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="CategoryID"/>
        <xsl:text>"</xsl:text>

        <xsl:text>}</xsl:text>
        <xsl:if test="following-sibling::*">
            <xsl:text> , </xsl:text>
        </xsl:if>
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

    <!-- Linhas de Producao -->
    <xsl:template match="ProductionLine">
        <xsl:text>{</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(@ID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="@ID"/>
        <xsl:text>"</xsl:text>

        <xsl:text>}</xsl:text>
        <xsl:if test="following-sibling::*">
            <xsl:text> , </xsl:text>
        </xsl:if>
    </xsl:template>

    <!-- Categorias -->
    <xsl:template match="Category">
        <xsl:text>{</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(@ID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="@ID"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Description)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Description"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(CategoryID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="CategoryID"/>
        <xsl:text>"</xsl:text>

        <xsl:text>}</xsl:text>
        <xsl:if test="following-sibling::*">
            <xsl:text> , </xsl:text>
        </xsl:if>
    </xsl:template>

    <!-- Ordens de Producao -->
    <xsl:template match="ProductionOrder">
        <xsl:text>{</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(@ID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="@ID"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(EmissionDate)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="EmissionDate"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(ExpectedExecutionDate)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="ExpectedExecutionDate"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(UniqueFabricationCode)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="UniqueFabricationCode"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(ProductOrderID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="ProductOrderID"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Quantity)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Quantity"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(State)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="State"/>
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

    <!-- Fichas de Producao -->
    <xsl:template match="ProductionSheet">
        <xsl:text>{</xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(@ProductID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="@ProductID"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(Quantity)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="Quantity"/>
        <xsl:text>"</xsl:text>
        <xsl:text> , </xsl:text>

        <xsl:text>"</xsl:text>
        <xsl:value-of select="name(RawMaterialID)"/>
        <xsl:text>" : "</xsl:text>
        <xsl:value-of select="RawMaterialID"/>
        <xsl:text>"</xsl:text>

        <xsl:text>}</xsl:text>
        <xsl:if test="following-sibling::*">
            <xsl:text> , </xsl:text>
        </xsl:if>
    </xsl:template>

</xsl:stylesheet>