package com.solvd.navigator.dom;

import com.solvd.navigator.model.Driver;
import com.solvd.navigator.model.Location;
import com.solvd.navigator.model.Route;
import com.solvd.navigator.model.Transportation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DOMparser {

         public static void main(String[] args) {
                 try {
                     String xmlFile = "./src/main/resources/navigator.xml";
                     String xsdFile = "./src/main/resources/navigator.xsd";

                     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                     DocumentBuilder builder = factory.newDocumentBuilder();
                     Document document = builder.parse(xmlFile);

                     SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                     Schema schema = schemaFactory.newSchema(new File(xsdFile));
                     schema.newValidator().validate(new DOMSource(document));

                     Element rootElement = document.getDocumentElement();
                     Element routesElement = (Element) rootElement.getElementsByTagName("routes").item(0);

                     Element locationAElement = (Element) rootElement.getElementsByTagName("locationA").item(0);
                     Element locationBElement = (Element) rootElement.getElementsByTagName("locationB").item(0);

                     String locationAId = getTextContent(locationAElement, "id");
                     String locationAName = getTextContent(locationAElement, "name");
                     String locationBId = getTextContent(locationBElement, "id");
                     String locationBName = getTextContent(locationBElement, "name");

                     //Print follow xml/xsd

                     System.out.println("Location A ID: " + locationAId);
                     System.out.println("Location A Name: " + locationAName);
                     System.out.println("Location B ID: " + locationBId);
                     System.out.println("Location B Name: " + locationBName);
                     System.out.println("Routes ...... ");

                     NodeList routeList = routesElement.getElementsByTagName("route");
                     for (int i = 0; i < routeList.getLength(); i++) {
                         Element routeElement = (Element) routeList.item(i);
                         String routeId = getTextContent(routeElement, "id");
                         String duration = getTextContent(routeElement, "duration");
                         String cost = getTextContent(routeElement, "cost");
                         String distance = getTextContent(routeElement, "distance");

                         Element transportationElement = (Element) routeElement.getElementsByTagName("transportation").item(0);
                         String transportationId = getTextContent(transportationElement, "id");
                         String transportationName = getTextContent(transportationElement, "name");

                         Element driverElement = (Element) transportationElement.getElementsByTagName("driver").item(0);
                         String driverId = getTextContent(driverElement, "id");
                         String driverName = getTextContent(driverElement, "name");

                         System.out.println("Route ID: " + routeId);
                         System.out.println("Duration: " + duration);
                         System.out.println("Cost: " + cost);
                         System.out.println("Distance: " + distance);
                         System.out.println("Transportation ID: " + transportationId);
                         System.out.println("Transportation Name: " + transportationName);
                         System.out.println("Driver ID: " + driverId);
                         System.out.println("Driver Name: " + driverName);
                         System.out.println();
                     }


                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }

             private static String getTextContent(Element element, String tagName) {
                 NodeList nodeList = element.getElementsByTagName(tagName);
                 if (nodeList.getLength() > 0) {
                     Node node = nodeList.item(0);
                     return node.getTextContent();
                 }
                 return null;
             }
         }

