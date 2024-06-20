<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:ns="http://www.dei.isep.ipp.pt/lprog" exclude-result-prefixes="ns" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" />
	<xsl:template match="/">
		<html>
			<head>
				<title>Relatório LPROG</title>
			</head>
			<body style="font-size: 18px;font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
				<xsl:apply-templates select="ns:relatório/ns:páginaRosto/ns:logotipoDEI" />
				<h1>
					<xsl:value-of select="ns:relatório/ns:páginaRosto/ns:disciplina/ns:sigla" />
				</h1>
				<h2>
					<xsl:value-of select="ns:relatório/ns:páginaRosto/ns:tema" />
				</h2>
				<h2>
					<xsl:value-of select="ns:relatório/ns:páginaRosto/ns:turma" />
				</h2>
				<table style="width:450px">
					<tr>
						<th>Autores:</th>
						<th>Professores:</th>
					</tr>
					<tr>
						<td>
							<ul>
								<xsl:apply-templates select="ns:relatório/ns:páginaRosto/ns:autor" />
							</ul>
						</td>
						<td>
							<ul>
								<xsl:apply-templates select="ns:relatório/ns:páginaRosto/ns:professor" />
							</ul>
						</td>
					</tr>
				</table>
				<xsl:apply-templates select="ns:relatório/ns:páginaRosto/ns:data" />
				<hr />

				<h2>Índice</h2>
				<ul style="list-style-type:none">
					<xsl:for-each select="//*[@tituloSecção]">
						<xsl:apply-templates select="." />
					</xsl:for-each>
				</ul>
				<hr />

				<!-- Introdução -->
				<h2 id="SEC001">
					<xsl:value-of select="ns:relatório/ns:corpo/ns:introdução/@tituloSecção" />
				</h2>
				<xsl:apply-templates select="ns:relatório/ns:corpo/ns:introdução/*" />
				<hr />

				<!-- Análise -->
				<h2 id="SEC002">
					<xsl:value-of select="ns:relatório/ns:corpo/ns:outrasSecções/ns:análise/@tituloSecção" />
				</h2>
				<xsl:apply-templates select="ns:relatório/ns:corpo/ns:outrasSecções/ns:análise/*" />
				<hr />

				<!-- Linguagem -->
				<h2 id="SEC003">
					<xsl:value-of select="ns:relatório/ns:corpo/ns:outrasSecções/ns:linguagem/@tituloSecção" />
				</h2>
				<xsl:apply-templates select="ns:relatório/ns:corpo/ns:outrasSecções/ns:linguagem/*" />
				<hr />

				<!-- Transformações -->
				<h2 id="SEC004">
					<xsl:value-of select="ns:relatório/ns:corpo/ns:outrasSecções/ns:transformações/@tituloSecção" />
				</h2>
				<xsl:apply-templates select="ns:relatório/ns:corpo/ns:outrasSecções/ns:transformações/*" />
				<hr />

				<!-- Conclusão -->
				<h2 id="SEC005">
					<xsl:value-of select="ns:relatório/ns:corpo/ns:conclusão/@tituloSecção" />
				</h2>
				<xsl:apply-templates select="ns:relatório/ns:corpo/ns:conclusão/*" />
				<hr />

				<!-- Referências -->
				<h2 id="SEC006">
					<xsl:value-of select="ns:relatório/ns:corpo/ns:referências/@tituloSecção" />
				</h2>
				<xsl:apply-templates select="ns:relatório/ns:corpo/ns:referências/*" />
				<hr />

				<!-- Anexos -->
				<h2 id="SEC007">
					<xsl:value-of select="ns:relatório/ns:anexos/@tituloSecção" />
				</h2>
				<xsl:apply-templates select="ns:relatório/ns:anexos/*" />

			</body>
		</html>
	</xsl:template>

	<xsl:template match="ns:logotipoDEI">
		<xsl:element name="img">
			<xsl:attribute name="src">
				<xsl:value-of select="." />
			</xsl:attribute>
			<xsl:attribute name="align">left</xsl:attribute>
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:autor">
		<xsl:element name="li">
			<xsl:value-of select="./ns:nome" />
			(
			<xsl:value-of select="./ns:número" />
			)
			<p>
				<xsl:value-of select="./ns:mail" />
			</p>
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:professor">
		<xsl:element name="li">
			<xsl:value-of select="@tipoAula" />
			:
			<xsl:value-of select="@sigla" />
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:data">
		<xsl:element name="p">
			<xsl:attribute name="align">left</xsl:attribute>
			<xsl:value-of select="." />
		</xsl:element>
	</xsl:template>

	<xsl:template match="//*[@tituloSecção]">
		<xsl:element name="li">
			<xsl:element name="a">
				<xsl:attribute name="href">
					#
					<xsl:value-of select="./@id" />
				</xsl:attribute>
				<xsl:value-of select="./@tituloSecção" />
			</xsl:element>
			<xsl:if test="./ns:subsecção != ''">
				<xsl:for-each select="./ns:subsecção">
					<xsl:element name="ul">
						<xsl:attribute name="style">list-style-type:none</xsl:attribute>
						<xsl:element name="li">
							<xsl:element name="a">
								<xsl:attribute name="href">
									#
									<xsl:value-of select="./@id" />
								</xsl:attribute>
								<xsl:value-of select="." />
							</xsl:element>
						</xsl:element>
					</xsl:element>
				</xsl:for-each>
			</xsl:if>
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:parágrafo">
		<xsl:element name="p">
			<xsl:attribute name="align">justify</xsl:attribute>
			<xsl:apply-templates />
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:negrito">
		<xsl:element name="b">
			<xsl:value-of select="." />
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:itálico">
		<xsl:element name="i">
			<xsl:value-of select="." />
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:sublinhado">
		<xsl:element name="u">
			<xsl:value-of select="." />
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:item">
		<xsl:element name="li">
			<xsl:value-of select="." />
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:subsecção">
		<xsl:element name="h3">
			<xsl:attribute name="id">
				<xsl:value-of select="./@id" />
			</xsl:attribute>
			<xsl:value-of select="." />
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:codigo">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="ns:bloco">
		<xsl:element name="details">
			<xsl:element name="summary">Código:</xsl:element>
			<xsl:element name="pre">
				<xsl:element name="code">
					<xsl:value-of select="." />
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:refWeb">
		<xsl:element name="p">
			<xsl:value-of select="./ns:descrição" />
			<xsl:element name="a">
				<xsl:attribute name="href">
					<xsl:value-of select="./ns:URL" />
				</xsl:attribute>
				<xsl:value-of select="./ns:URL" />
			</xsl:element>
			(
			<xsl:value-of select="./ns:consultadoEm" />
			)
		</xsl:element>
	</xsl:template>

	<xsl:template match="ns:figura">
		<xsl:element name="img">
			<xsl:attribute name="src">
				<xsl:value-of select="./@src" />
			</xsl:attribute>
			<xsl:attribute name="alt">
				<xsl:value-of select="./@descrição" />
			</xsl:attribute>
			<xsl:attribute name="width">1000px</xsl:attribute>
			<xsl:attribute name="border">1px</xsl:attribute>
			<xsl:attribute name="hspace">60px</xsl:attribute>
		</xsl:element>
		<xsl:element name="caption">
			<xsl:value-of select="./@descrição" />
		</xsl:element>
	</xsl:template>

</xsl:stylesheet>