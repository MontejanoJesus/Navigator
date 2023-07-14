package com.solvd.navigator;

import com.solvd.navigator.algo.Dijkstra;
import com.solvd.navigator.algo.Graph;
import com.solvd.navigator.factory.JDBCFactory;
import com.solvd.navigator.model.Location;
import com.solvd.navigator.model.Result;
import com.solvd.navigator.model.Route;
import com.solvd.navigator.parsers.DOMWriter;
import com.solvd.navigator.parsers.JsonParser;
import com.solvd.navigator.parsers.StaxWriter;
import com.solvd.navigator.service.imple.LocationService;
import com.solvd.navigator.service.imple.RouteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Get all necessary information from database
        // Need locations and routes

        Graph graph = new Graph(true, true);
        LocationService locationService = new LocationService();
        RouteService routeService = new RouteService();

        List<Location> locations = locationService.getAll();
        for(Location l: locations) {
            graph.addLocation(l);
        }

        List<Route> routes = routeService.getAll();
        for(Route r: routes) {
            graph.addRoute(r);
        }

        // Prompt user to choose Starting Location
        String startingLocationString;
        int startingChoice = 0;
        int endingChoice = 0;
        do{
            logger.info("Choose a valid starting location: " + "\n");

            for(int i = 0; i < locations.size(); i++) {
                logger.info((i + 1) + " " + locations.get(i).getName() + "\n");
            }
            startingLocationString = scanner.nextLine();

            try{
                startingChoice = Integer.parseInt(startingLocationString);
            }catch (Exception e){
                continue;
            }
        }while(!validateLocationChoice(startingChoice, locations.size()));

        // Prompt user to choose destination

        Integer endingLocationString;

        do{
            logger.info("Choose a valid ending location: " + "\n");

            for(int i = 0; i < locations.size(); i++) {
                logger.info((i + 1) + " " + locations.get(i).getName() + "\n");
            }
            startingLocationString = scanner.nextLine();

            try{
                endingChoice = Integer.parseInt(startingLocationString);
            }catch (Exception e){
                continue;
            }
        }while(!validateLocationChoice(endingChoice, locations.size()));
        startingChoice = startingChoice-1;
        endingChoice = endingChoice-1;

        // Set up algorithm
        Location startingLocation = locations.get(startingChoice);
        Location endingLocation = locations.get(endingChoice);

        Dictionary[] result = Dijkstra.findAllShortestPath(graph, startingLocation);
        Dictionary<String, Integer> duration = result[0];
        Dictionary<String, Location> AllLocations = result[1];
        Result finalResult = Dijkstra.result(AllLocations, endingLocation);
        // Print results
        Dijkstra.printPathWithTransportation(AllLocations, endingLocation);
        logger.info("\nTotal duration will be " + duration.get(endingLocation.getName()) + "hrs");


        // Stax Parser
        StaxWriter staxWriter = new StaxWriter();
        Path path = Paths.get("src\\main\\resources\\ResultStax.xml");
        staxWriter.writeToXml(path, finalResult);
        // Json Parser
        JsonParser jsonParser = new JsonParser();
        jsonParser.writeToJson(finalResult);

        //DOM Parser
        DOMWriter domWriter = new DOMWriter();
        domWriter.writeToXml(finalResult);

    }

    private static boolean validateLocationChoice(int choice, int size) {
        return choice > 0 && choice <= size;
    }
}
