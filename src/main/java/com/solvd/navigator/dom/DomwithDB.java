package com.solvd.navigator.dom;

import com.solvd.navigator.model.Driver;
import com.solvd.navigator.model.Route;
import com.solvd.navigator.model.Transportation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomwithDB {
    private static final Logger logger = LogManager.getLogger(DomwithDB.class);
    public static void main(String[] args) {
        try {
            String xmlFile = "./src/main/resources/navigator.xml";
            String xsdFile = "./src/main/resources/navigator.xsd";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(xmlFile));
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

            // Retrieve data from Route the database
            //RouteDAO dao = new RouteDAO();
            //I need Service for this retrieveRoutesFromDatabase
            //1.  Route getAll retrieveRoutesFromDatabase
            //Transportation transportation = retrieveTransportationFromDatabase(transportationId);
            //2.Transportation ById
            //Driver driver = retrieveDriverFromDatabase(driverId);
            // and add all to List<Route> routes =  serviceNameXXXX
            List<Route> routes = retrieveRoutesFromDatabase();

            for (Route route : routes) {
                System.out.println("Route ID: " + route.getId());
                System.out.println("Duration: " + route.getDuration());
                System.out.println("Cost: " + route.getCost());
                System.out.println("Distance: " + route.getDistance());
                Transportation transportation = route.getTransportation();
                System.out.println("Transportation ID: " + transportation.getId());
                System.out.println("Transportation Name: " + transportation.getName());
                Driver driver = transportation.getDriver();
                System.out.println("Driver ID: " + driver.getId());
                System.out.println("Driver Name: " + driver.getName());
                System.out.println();
            }

            System.out.println("Location A ID: " + locationAId);
            System.out.println("Location A Name: " + locationAName);
            System.out.println("Location B ID: " + locationBId);
            System.out.println("Location B Name: " + locationBName);
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

    private static List<Route> retrieveRoutesFromDatabase() {
        List<Route> routes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://18.197.182.199:3306/Navigator", "root", "devintern")) {
            String query = "SELECT * FROM routes";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    long routeId = resultSet.getLong("id");
                    int duration = resultSet.getInt("duration");
                    int cost = resultSet.getInt("cost");
                    int distance = resultSet.getInt("distance");
                    long transportationId = resultSet.getLong("transportation_id");

                    //I need this
                    Transportation transportation = retrieveTransportationFromDatabase(transportationId);

                    Route route = new Route(routeId, duration, cost, distance, transportation);
                    routes.add(route);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return routes;
    }

    private static Transportation retrieveTransportationFromDatabase(long transportationId) {

        String query = "SELECT * FROM transportation WHERE id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://18.197.182.199:3306/Navigator", "root", "devintern");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, transportationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    long driverId = resultSet.getLong("driver_id");


                    //I need this
                    Driver driver = retrieveDriverFromDatabase(driverId);

                    return new Transportation(id, name, driver);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Driver retrieveDriverFromDatabase(long driverId) {
        String query = "SELECT id, name FROM drivere WHERE id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://18.197.182.199:3306/Navigator", "root", "devintern");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, driverId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    return new Driver(id, name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}