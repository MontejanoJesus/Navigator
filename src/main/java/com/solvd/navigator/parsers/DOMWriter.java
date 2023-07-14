package com.solvd.navigator.parsers;

import com.solvd.navigator.model.Location;
import com.solvd.navigator.model.Result;
import com.solvd.navigator.model.Route;
import com.solvd.navigator.model.Transportation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMWriter {

    private static final Logger logger = LogManager.getLogger("DOMWriter");
    public void writeToXml(Result result) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element resultElement = doc.createElement("Result");
            doc.appendChild(resultElement);

            for (Route route : result.getRouteList()) {
                Element routeElement = createRouteElement(doc, route);
                resultElement.appendChild(routeElement);
            }

            writeDocumentToFile(doc);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private Element createRouteElement(Document doc, Route route) {
        Element routeElement = doc.createElement("Route");

        Element locationAElement = createLocationElement(doc, route.getLocationA());
        routeElement.appendChild(locationAElement);

        Element locationBElement = createLocationElement(doc, route.getLocationB());
        routeElement.appendChild(locationBElement);

        Element transportationElement = createTransportationElement(doc, route.getTransportation());
        routeElement.appendChild(transportationElement);

        Element durationElement = doc.createElement("duration");
        durationElement.appendChild(doc.createTextNode(String.valueOf(route.getDuration())));
        routeElement.appendChild(durationElement);

        return routeElement;
    }

    private Element createLocationElement(Document doc, Location location) {
        Element locationElement = doc.createElement("Location");

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(location.getName()));
        locationElement.appendChild(nameElement);

        return locationElement;
    }

    private Element createTransportationElement(Document doc, Transportation transportation) {
        Element transportationElement = doc.createElement("Transportation");

        Element transportationTypeElement = doc.createElement("TransportationType");
        Element typeElement = doc.createElement("Type");
        typeElement.appendChild(doc.createTextNode(transportation.getTransportationType().getType()));
        transportationTypeElement.appendChild(typeElement);
        transportationElement.appendChild(transportationTypeElement);

        Element vehicleNumberElement = doc.createElement("vehicleNumber");
        vehicleNumberElement.appendChild(doc.createTextNode(transportation.getVehicleNumber().toString()));
        transportationElement.appendChild(vehicleNumberElement);

        return transportationElement;
    }

   private void writeDocumentToFile(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource domSource = new DOMSource(doc);
            File outputFile = new File("src\\main\\resources\\resultDOM.xml");
            StreamResult streamResult = new StreamResult(outputFile);
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}