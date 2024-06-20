package eapli.base.fileexportmanagement.application;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TransformXML {
    private static String XML_DOC = "FactoryFloor.xml";

    public boolean transformationSelector(int option) {
        switch (option) {
            case 1:
                try {
                    TransformerFactory tFactory = TransformerFactory.newInstance();
                    Source xslDoc = new StreamSource("toHtmlComplete.xsl");
                    Source xmlDoc = new StreamSource(XML_DOC);
                    String outputFileName = "FactoryFloorComplete.html";
                    OutputStream htmlFile = new FileOutputStream(outputFileName);
                    Transformer transform = tFactory.newTransformer(xslDoc);
                    transform.transform(xmlDoc, new StreamResult(htmlFile));
                    String url = "FactoryFloorComplete.html";
                    File htmlF = new File(url);
                    Desktop.getDesktop().browse(htmlF.toURI());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 2:
                try {
                    TransformerFactory tFactory = TransformerFactory.newInstance();
                    Source xslDoc = new StreamSource("toHtmlOnlyWithRawMatWithTechSheet.xsl");
                    Source xmlDoc = new StreamSource(XML_DOC);
                    String outputFileName = "FactoryFloorOnlyWithRawMatWithTechSheet.html";
                    OutputStream htmlFile = new FileOutputStream(outputFileName);
                    Transformer transform = tFactory.newTransformer(xslDoc);
                    transform.transform(xmlDoc, new StreamResult(htmlFile));
                    String url = "FactoryFloorOnlyWithRawMatWithTechSheet.html";
                    File htmlF = new File(url);
                    Desktop.getDesktop().browse(htmlF.toURI());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 3:
                try {
                    TransformerFactory tFactory = TransformerFactory.newInstance();
                    Source xslDoc = new StreamSource("toHtmlUnityKG.xsl");
                    Source xmlDoc = new StreamSource(XML_DOC);
                    String outputFileName = "FactoryFloorUnityKG.html";
                    OutputStream htmlFile = new FileOutputStream(outputFileName);
                    Transformer transform = tFactory.newTransformer(xslDoc);
                    transform.transform(xmlDoc, new StreamResult(htmlFile));
                    String url = "FactoryFloorUnityKG.html";
                    File htmlF = new File(url);
                    Desktop.getDesktop().browse(htmlF.toURI());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 7:
                try {
                    TransformerFactory tFactory = TransformerFactory.newInstance();
                    Source xslDoc = new StreamSource("toJsonComplete.xsl");
                    Source xmlDoc = new StreamSource(XML_DOC);
                    String outputFileName = "FactoryFloorComplete.json";
                    OutputStream htmlFile = new FileOutputStream(outputFileName);
                    Transformer transform = tFactory.newTransformer(xslDoc);
                    transform.transform(xmlDoc, new StreamResult(htmlFile));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 8:
                try {
                    TransformerFactory tFactory = TransformerFactory.newInstance();
                    Source xslDoc = new StreamSource("toJsonMachines.xsl");
                    Source xmlDoc = new StreamSource(XML_DOC);
                    String outputFileName = "FactoryFloorMachines.json";
                    OutputStream htmlFile = new FileOutputStream(outputFileName);
                    Transformer transform = tFactory.newTransformer(xslDoc);
                    transform.transform(xmlDoc, new StreamResult(htmlFile));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 9:
                try {
                    TransformerFactory tFactory = TransformerFactory.newInstance();
                    Source xslDoc = new StreamSource("toJsonProducts.xsl");
                    Source xmlDoc = new StreamSource(XML_DOC);
                    String outputFileName = "FactoryFloorProducts.json";
                    OutputStream htmlFile = new FileOutputStream(outputFileName);
                    Transformer transform = tFactory.newTransformer(xslDoc);
                    transform.transform(xmlDoc, new StreamResult(htmlFile));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            case 4:
                try {
                    File stylesheet = new File("toTxtCompleteCSV.xsl");
                    File xmlSource = new File(XML_DOC);
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse(xmlSource);
                    StreamSource styleSource = new StreamSource(stylesheet);
                    Transformer transformer = TransformerFactory.newInstance()
                            .newTransformer(styleSource);
                    Source source = new DOMSource(document);
                    Result outputTarget = new StreamResult(new File("FactoryFloorCompleteCSV.txt"));
                    transformer.transform(source, outputTarget);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                    return false;
                }
            case 5:
                try {
                    File stylesheet = new File("toTxtUnityKGCSV.xsl");
                    File xmlSource = new File(XML_DOC);
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse(xmlSource);
                    StreamSource styleSource = new StreamSource(stylesheet);
                    Transformer transformer = TransformerFactory.newInstance()
                            .newTransformer(styleSource);
                    Source source = new DOMSource(document);
                    Result outputTarget = new StreamResult(new File("FactoryFloorUnityKGCSV.txt"));
                    transformer.transform(source, outputTarget);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                    return false;
                }
            case 6:
                try {
                    File stylesheet = new File("toTxtOnlyPLsWithMachines.xsl");
                    File xmlSource = new File(XML_DOC);
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse(xmlSource);
                    StreamSource styleSource = new StreamSource(stylesheet);
                    Transformer transformer = TransformerFactory.newInstance()
                            .newTransformer(styleSource);
                    Source source = new DOMSource(document);
                    Result outputTarget = new StreamResult(new File("FactoryFloorOnlyPLsWithMachines.txt"));
                    transformer.transform(source, outputTarget);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                    return false;
                }
            default:
                System.out.println("Option Unavailable");
                return false;
        }
    }
}
