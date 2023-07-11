package com.solvd.navigator.xmlparsers;

import com.solvd.navigator.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Characters;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StaxWriter {
/*
    private static final Logger logger = LogManager.getLogger("StaxWriter");
    public void writeToXml(Path path, Result result){

        try (OutputStream os = Files.newOutputStream(path)) {
            XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = null;

            try {
                writer = outputFactory.createXMLStreamWriter(os, "utf-8");
                writeResultElem(writer, result);
                logger.info("in");
            } finally {
                if (writer != null)
                    writer.close();
            }
        } catch (IOException | XMLStreamException e) {
            logger.error(e.getMessage());
        }
    }

    public void writeResultElem(XMLStreamWriter writer, Result result){
        try {
            writer.writeStartDocument("utf-8", "1.0");
            // writer.writeComment("Describes routes");

            writer.writeCharacters("\n");
            writer.writeStartElement("Result");
            writer.writeCharacters("\n");
            for (Route route : result.getRouteList())
                writeRouteElem(writer, route);

            writer.writeCharacters("\n");
            writer.writeEndElement();
            writer.writeCharacters("\n");
            writer.writeEndDocument();
        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        }



    }
    public void writeRouteElem(XMLStreamWriter writer, Route route){
        try {
            writer.writeCharacters(" ");
            writer.writeStartElement("Route");
            writer.writeAttribute("id", route.getId().toString());
            writer.writeCharacters("\n");

            writeLocationElem(writer, route.getLocationA());
            writer.writeCharacters("\n");
            writeLocationElem(writer, route.getLocationB());
            writer.writeCharacters("\n");
            //Tae
            // writeTransportationElem(writer, route.getTransportation());
            writer.writeCharacters("\n");

            writer.writeCharacters("  ");
            writer.writeStartElement("duration");
            writer.writeCharacters(route.getDuration().toString());
            writer.writeEndElement();
            writer.writeCharacters("\n");

            writer.writeCharacters("  ");
            writer.writeStartElement("cost");
            //Tae
            //writer.writeCharacters(route.getCost().toString());
            writer.writeEndElement();

            writer.writeCharacters("\n");
            writer.writeCharacters("  ");
            writer.writeStartElement("distance");
            writer.writeCharacters(route.getDistance().toString());
            writer.writeEndElement();
            writer.writeCharacters("\n");

            writer.writeCharacters(" ");
            writer.writeEndElement();

        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        }

    }
    public void writeLocationElem(XMLStreamWriter writer, Location location){
        try {
            writer.writeCharacters("  ");
            writer.writeStartElement("Location");
            writer.writeAttribute("id", location.getId().toString());
            writer.writeCharacters("\n");
            writer.writeCharacters("   ");

            writer.writeStartElement("name");
            writer.writeCharacters(location.getName());
            writer.writeEndElement();

            writer.writeCharacters("\n");
            writer.writeCharacters("  ");
            writer.writeEndElement();

        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        }
    }
    public void writeTransportationElem(XMLStreamWriter writer, Transportation transportation){
        try {
            writer.writeCharacters("  ");
            writer.writeStartElement("Transportation");
            writer.writeAttribute("id", transportation.getId().toString());

            writer.writeCharacters("\n");
            writer.writeCharacters("   ");
            writer.writeStartElement("name");
            writer.writeCharacters(transportation.getName());
            writer.writeEndElement();

            writeDriverElem(writer, transportation.getDriver());

            writer.writeCharacters("\n");
            writer.writeCharacters("  ");
            writer.writeEndElement();

        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        }
    }
    public void writeDriverElem(XMLStreamWriter writer, Driver driver){
        try {
            writer.writeCharacters("\n");
            writer.writeCharacters("   ");
            writer.writeStartElement("Driver");
            writer.writeAttribute("id", driver.getId().toString());

            writer.writeCharacters("\n");
            writer.writeCharacters("    ");
            writer.writeStartElement("name");
            writer.writeCharacters(driver.getName());
            writer.writeEndElement();

            writer.writeCharacters("\n");
            writer.writeCharacters("   ");
            writer.writeEndElement();

        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        }

    }
    */
}
