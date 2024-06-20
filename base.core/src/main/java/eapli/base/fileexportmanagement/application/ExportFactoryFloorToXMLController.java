package eapli.base.fileexportmanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.base.productionordermanagement.domain.ProductionOrder;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductionSheet;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.rawmaterial.domain.RawMaterial;
import eapli.base.rawmaterial.repository.RawMaterialRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExportFactoryFloorToXMLController {
    private final ProductRepository productRepository = PersistenceContext.repositories().product();
    private final RawMaterialRepository rawMaterialRepository = PersistenceContext.repositories().rawMaterials();
    private final MachineRepository machineRepository = PersistenceContext.repositories().machines();
    private final ProductionLineRepository productionLineRepository = PersistenceContext.repositories().productionLines();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().categories();
    private final ProductionOrderRepository productionOrderRepository = PersistenceContext.repositories().productionOrder();

    public static String xsdDocument = "FactoryFloor.xsd";

    public boolean categoriesXML() {
        Iterable<Product> listProducts = productRepository.findAll();
        Iterable<RawMaterial> listRawMaterials = rawMaterialRepository.findAll();
        Iterable<Machine> listMachines = machineRepository.findAll();
        Iterable<ProductionLine> listProductionLines = productionLineRepository.findAll();
        Iterable<Category> listCategories = categoryRepository.findAll();
        Iterable<ProductionOrder> listProductionOrder = productionOrderRepository.findAll();
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("FactoryFloor");
            rootElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:noNamespaceSchemaLocation", xsdDocument);
            doc.appendChild(rootElement);

            //<Products>
            Element products = doc.createElement("Products");
            for (Product p : listProducts) {
                Long idProd = p.identity();
                String cat = p.category().category();
                String comCode = p.comCode().comCode();
                String compDesc = p.compDesc().compDesc();
                String shortDesc = p.shortDesc().shortDesc();
                String unFabCode = p.unFabCode().unFabCode();
                String un = p.unity().name();

                Element prod = doc.createElement("Product");

                Element prodCat = doc.createElement("Category");
                prodCat.setTextContent(cat);

                Element commercialCode = doc.createElement("CommercialCode");
                commercialCode.setTextContent(comCode);

                Element completeDescription = doc.createElement("CompleteDesc");
                completeDescription.setTextContent(compDesc);

                Element shortDescription = doc.createElement("ShortDesc");
                shortDescription.setTextContent(shortDesc);

                Element uniqueFabricationCode = doc.createElement("UniqueFabCode");
                uniqueFabricationCode.setTextContent(unFabCode);

                Element unity = doc.createElement("Unity");
                unity.setTextContent(un);

                prod.setAttribute("ID", Long.toString(idProd));

                prod.appendChild(prodCat);
                prod.appendChild(commercialCode);
                prod.appendChild(completeDescription);
                prod.appendChild(shortDescription);
                prod.appendChild(uniqueFabricationCode);
                prod.appendChild(unity);

                products.appendChild(prod);
            }
            rootElement.appendChild(products);

            //<RawMaterials>
            Element rawMaterials = doc.createElement("RawMaterials");
            for (RawMaterial rm : listRawMaterials) {
                String intCode = rm.identity().toString();
                String desc = rm.description().toString();
                String tSheet = rm.techSheet().toString();
                String catID = rm.categoryRawMaterial().iDCategory().categoryID();

                Element rawMaterial = doc.createElement("RawMaterial");

                Element description = doc.createElement("Description");
                description.setTextContent(desc);

                Element techSheet = doc.createElement("TechSheet");
                techSheet.setTextContent(tSheet);

                Element categoryID = doc.createElement("CategoryID");
                categoryID.setTextContent(catID);

                rawMaterial.setAttribute("InternalCode", intCode);

                rawMaterial.appendChild(description);
                rawMaterial.appendChild(techSheet);
                rawMaterial.appendChild(categoryID);

                rawMaterials.appendChild(rawMaterial);
            }
            rootElement.appendChild(rawMaterials);

            //<Machines>
            Element machines = doc.createElement("Machines");
            for (Machine m : listMachines) {
                String idMach = m.machineId().id();
                String macBrand = m.machineBrand().brand();
                String instDate = m.machineInstallDate().toString();
                String desc = m.machineDescription().machineDescription();
                String macModel = m.machineModel().model();
                String serNum = m.machineSerialNumber().serialNumber();
                String plID = m.machinePLID().productionLineID();
                String tp = m.machineType().type();

                Element machine = doc.createElement("Machine");

                Element brand = doc.createElement("Brand");
                brand.setTextContent(macBrand);

                Element installationDate = doc.createElement("InstallationDate");
                installationDate.setTextContent(instDate);

                Element description = doc.createElement("Description");
                description.setTextContent(desc);

                Element model = doc.createElement("Model");
                model.setTextContent(macModel);

                Element serialNumber = doc.createElement("SerialNum");
                serialNumber.setTextContent(serNum);

                Element productionLineID = doc.createElement("PLID");
                productionLineID.setTextContent(plID);

                Element type = doc.createElement("Type");
                type.setTextContent(tp);

                machine.setAttribute("ID", idMach);

                machine.appendChild(brand);
                machine.appendChild(installationDate);
                machine.appendChild(description);
                machine.appendChild(model);
                machine.appendChild(serialNumber);
                machine.appendChild(productionLineID);
                machine.appendChild(type);

                machines.appendChild(machine);
            }
            rootElement.appendChild(machines);

            //<ProductionLines>
            Element productionLines = doc.createElement("ProductionLines");
            for (ProductionLine pl : listProductionLines) {
                String prodLineID = pl.plID().productionLineID();

                Element productionLine = doc.createElement("ProductionLine");
                productionLine.setAttribute("ID", prodLineID);

                productionLines.appendChild(productionLine);
            }
            rootElement.appendChild(productionLines);

            //<Categories>
            Element categories = doc.createElement("Categories");
            for (Category c : listCategories) {
                String lId = Long.toString(c.identity());
                String desc = c.descriptionCategory().description();
                String catID = c.iDCategory().categoryID();

                Element category = doc.createElement("Category");

                Element description = doc.createElement("Description");
                description.setTextContent(desc);

                Element categoryID = doc.createElement("CategoryID");
                categoryID.setTextContent(catID);

                category.setAttribute("ID", lId);

                category.appendChild(description);
                category.appendChild(categoryID);

                categories.appendChild(category);
            }
            rootElement.appendChild(categories);

            //<ProductionOrders>
            Element productionOrders = doc.createElement("ProductionOrders");
            for (ProductionOrder po : listProductionOrder) {
                String lID = Long.toString(po.identity());
                String emissDate = po.EmissionDate().toString();
                String expExecDate = po.ExpectedExecutionDate().toString();
                String unFabCode = po.ProdUniqueFabCode().unFabCode();
                String prodOrderID = po.ProductionOrderID().productOrderId();
                String quant = Integer.toString(po.Quantity().quantity());
                String stt = po.unState().name();
                String un = po.Unity().name();

                Element productionOrder = doc.createElement("ProductionOrder");

                Element emissionDate = doc.createElement("EmissionDate");
                emissionDate.setTextContent(emissDate);

                Element expectedExecutionDate = doc.createElement("ExpectedExecutionDate");
                expectedExecutionDate.setTextContent(expExecDate);

                Element uniqueFabricationCode = doc.createElement("UniqueFabricationCode");
                uniqueFabricationCode.setTextContent(unFabCode);

                Element productOrderID = doc.createElement("ProductOrderID");
                productOrderID.setTextContent(prodOrderID);

                Element quantity = doc.createElement("Quantity");
                quantity.setTextContent(quant);

                Element state = doc.createElement("State");
                state.setTextContent(stt);

                Element unity = doc.createElement("Unity");
                unity.setTextContent(un);

                productionOrder.setAttribute("ID", lID);

                productionOrder.appendChild(emissionDate);
                productionOrder.appendChild(expectedExecutionDate);
                productionOrder.appendChild(uniqueFabricationCode);
                productionOrder.appendChild(productOrderID);
                productionOrder.appendChild(quantity);
                productionOrder.appendChild(state);
                productionOrder.appendChild(unity);

                productionOrders.appendChild(productionOrder);
            }
            rootElement.appendChild(productionOrders);

            //<ProductionSheets>
            Element productionSheets = doc.createElement("ProductionSheets");
            List<ProductionSheet> listAllProductionSheets = new ArrayList<>();
            for (Product p : listProducts) {
                listAllProductionSheets.addAll(p.prodSheet());
            }
            for (ProductionSheet ps : listAllProductionSheets) {
                String prodID = ps.productID();
                String quant = Double.toString(ps.quantity());
                String rawMID = ps.rawMaterialID();

                Element productionSheet = doc.createElement("ProductionSheet");

                Element quantity = doc.createElement("Quantity");
                quantity.setTextContent(quant);

                Element rawMaterial = doc.createElement("RawMaterialID");
                rawMaterial.setTextContent(rawMID);

                productionSheet.setAttribute("ProductID", prodID);

                productionSheet.appendChild(quantity);
                productionSheet.appendChild(rawMaterial);

                productionSheets.appendChild(productionSheet);
            }
            rootElement.appendChild(productionSheets);

            // Write the content into XML file
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("FactoryFloor.xml"));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Beautify the format of the resulted XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
