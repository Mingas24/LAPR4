# UC8 - Importar Catalogo de Produtos

## Planeamento de Testes

Estes ficheiros serão utilizados para testar a integridade do ficheiro XSD

### FactoryFloor.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<FactoryFloor xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<Products>
		<Product ID="22">
			<Category>Kitchen Utensils</Category>
			<CommercialCode>160000</CommercialCode>
			<CompleteDesc>chef knife</CompleteDesc>
			<ShortDesc>knife</ShortDesc>
			<UniqueFabCode>850001</UniqueFabCode>
			<Unity>UN</Unity>
			<Version>1</Version>
		</Product>
		<Product ID="23">
			<Category>Kitchen Utensils</Category>
			<CommercialCode>160001</CommercialCode>
			<CompleteDesc>dinner fork</CompleteDesc>
			<ShortDesc>fork</ShortDesc>
			<UniqueFabCode>850002</UniqueFabCode>
			<Unity>UN</Unity>
			<Version>1</Version>
		</Product>
	</Products>
	<RawMaterials>
		<RawMaterial InternalCode="600">
			<Description>zinco</Description>
			<TechSheet>ficha1</TechSheet>
			<CategoryID>19</CategoryID>
		</RawMaterial>
		<RawMaterial InternalCode="601">
			<Description>pinho</Description>
			<TechSheet>ficha2</TechSheet>
			<CategoryID>20</CategoryID>
		</RawMaterial>
	</RawMaterials>
	<Machines>
		<Machine ID="10">
			<Brand>HYUNDAY</Brand>
			<Config>Put it where product assembling is needed</Config>
			<InstallationDate>2019-09-11</InstallationDate>
			<Description>Assembles Product</Description>
			<Model>PRODUCT ASSEMBLER GENERATION3</Model>
			<SerialNum>9998887773</SerialNum>
			<PLID>Line 2</PLID>
			<Type>Assembler</Type>
		</Machine>
		<Machine ID="20">
			<Brand>FORD</Brand>
			<Config>Put it where object transporting is necessary</Config>
			<InstallationDate>2019-12-25</InstallationDate>
			<Description>USED FOR TRANSPORTING OBJECTS</Description>
			<Model>CONVEYOR BELT GENERATION DELTA</Model>
			<SerialNum>123456754</SerialNum>
			<PLID>Line 2</PLID>
			<Type>CONVEYOR BELT</Type>
		</Machine>
	</Machines>
	<ProductionLines>
		<ProductionLine ID="Line 1"/>
		<ProductionLine ID="Line 2"/>
	</ProductionLines>
	<Categories>
		<Category ID="19">
			<Description>Metais</Description>
			<CategoryID>1</CategoryID>
			<Version>0</Version>
		</Category>
		<Category ID="20">
			<Description>Madeira</Description>
			<CategoryID>2</CategoryID>
			<Version>0</Version>
		</Category>
	</Categories>
	<ProductionOrders>
		<ProductionOrder ID="25">
			<EmissionDate>2020-05-12</EmissionDate>
			<ExpectedExecutionDate>2020-05-14</ExpectedExecutionDate>
			<UniqueFabricationCode>50000106</UniqueFabricationCode>
			<ProductOrderID>100003363</ProductOrderID>
			<Quantity>65000</Quantity>
			<State>PENDING</State>
			<Unity>UN</Unity>
			<Version>1</Version>
		</ProductionOrder>
		<ProductionOrder ID="20">
			<EmissionDate>2020-05-12</EmissionDate>
			<ExpectedExecutionDate>2020-05-15</ExpectedExecutionDate>
			<UniqueFabricationCode>1600016</UniqueFabricationCode>
			<ProductOrderID>100003364</ProductOrderID>
			<Quantity>200000</Quantity>
			<State>PENDING</State>
			<Unity>UN</Unity>
			<Version>1</Version>
		</ProductionOrder>
	</ProductionOrders>
	<ProductionSheets>
		<ProductionSheet ProductID="22">
			<Quantity>2</Quantity>
			<RawMaterialID>1234</RawMaterialID>
		</ProductionSheet>
	</ProductionSheets>
</FactoryFloor>
```

### Products.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<FactoryFloor xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<Products>
		<Product ID="22">
			<Category>Kitchen Utensils</Category>
			<CommercialCode>160000</CommercialCode>
			<CompleteDesc>chef knife</CompleteDesc>
			<ShortDesc>knife</ShortDesc>
			<UniqueFabCode>850001</UniqueFabCode>
			<Unity>UN</Unity>
			<Version>1</Version>
		</Product>
		<Product ID="23">
			<Category>Kitchen Utensils</Category>
			<CommercialCode>160001</CommercialCode>
			<CompleteDesc>dinner fork</CompleteDesc>
			<ShortDesc>fork</ShortDesc>
			<UniqueFabCode>850002</UniqueFabCode>
			<Unity>UN</Unity>
			<Version>1</Version>
		</Product>
	</Products>
</FactoryFloor>
```

### RawMaterial.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<FactoryFloor xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<RawMaterials>
		<RawMaterial InternalCode="600">
			<Description>zinco</Description>
			<TechSheet>ficha1</TechSheet>
			<CategoryID>19</CategoryID>
		</RawMaterial>
		<RawMaterial InternalCode="601">
			<Description>pinho</Description>
			<TechSheet>ficha2</TechSheet>
			<CategoryID>20</CategoryID>
		</RawMaterial>
	</RawMaterials>
</FactoryFloor>
```

### Categories.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<FactoryFloor xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<Categories>
		<Category ID="19">
			<Description>Metais</Description>
			<CategoryID>1</CategoryID>
			<Version>0</Version>
		</Category>
		<Category ID="20">
			<Description>Madeira</Description>
			<CategoryID>2</CategoryID>
			<Version>0</Version>
		</Category>
	</Categories>
</FactoryFloor>
```

### Machines.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<FactoryFloor xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<Machines>
		<Machine ID="10">
			<Brand>HYUNDAY</Brand>
			<Config>Put it where product assembling is needed</Config>
			<InstallationDate>2019-09-11</InstallationDate>
			<Description>Assembles Product</Description>
			<Model>PRODUCT ASSEMBLER GENERATION3</Model>
			<SerialNum>9998887773</SerialNum>
			<PLID>Line 2</PLID>
			<Type>Assembler</Type>
		</Machine>
		<Machine ID="20">
			<Brand>FORD</Brand>
			<Config>Put it where object transporting is necessary</Config>
			<InstallationDate>2019-12-25</InstallationDate>
			<Description>USED FOR TRANSPORTING OBJECTS</Description>
			<Model>CONVEYOR BELT GENERATION DELTA</Model>
			<SerialNum>123456754</SerialNum>
			<PLID>Line 2</PLID>
			<Type>CONVEYOR BELT</Type>
		</Machine>
	</Machines>
</FactoryFloor>
```

### ProductionLines.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<FactoryFloor xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<ProductionLines>
		<ProductionLine ID="Line 1"/>
		<ProductionLine ID="Line 2"/>
	</ProductionLines>
</FactoryFloor>
```

### ProductionOrders.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<FactoryFloor xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<ProductionOrders>
		<ProductionOrder ID="25">
			<EmissionDate>2020-05-12</EmissionDate>
			<ExpectedExecutionDate>2020-05-14</ExpectedExecutionDate>
			<UniqueFabricationCode>50000106</UniqueFabricationCode>
			<ProductOrderID>100003363</ProductOrderID>
			<Quantity>65000</Quantity>
			<State>PENDING</State>
			<Unity>UN</Unity>
			<Version>1</Version>
		</ProductionOrder>
		<ProductionOrder ID="20">
			<EmissionDate>2020-05-12</EmissionDate>
			<ExpectedExecutionDate>2020-05-15</ExpectedExecutionDate>
			<UniqueFabricationCode>1600016</UniqueFabricationCode>
			<ProductOrderID>100003364</ProductOrderID>
			<Quantity>200000</Quantity>
			<State>PENDING</State>
			<Unity>UN</Unity>
			<Version>1</Version>
		</ProductionOrder>
	</ProductionOrders>
</FactoryFloor>
```

### ProductionSheets.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<FactoryFloor xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="file:///C:/Users/gonca/Documents/FactoryFloor.xsd">
	<ProductionSheets>
		<ProductionSheet ProductID="22">
			<Quantity>2</Quantity>
			<RawMaterialID>1234</RawMaterialID>
		</ProductionSheet>
	</ProductionSheets>
</FactoryFloor>
```