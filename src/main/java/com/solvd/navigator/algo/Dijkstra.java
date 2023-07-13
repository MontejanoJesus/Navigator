package com.solvd.navigator.algo;

import com.solvd.navigator.App;
import com.solvd.navigator.model.Location;
import com.solvd.navigator.model.Result;
import com.solvd.navigator.model.Route;
import org.apache.logging.log4j.Logger;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Dijkstra {

    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(Dijkstra.class);

    public static Dictionary[] findAllShortestPath(Graph graph, Location startlocation){
        Dictionary<String, Integer> shortestWeights = new Hashtable<>();// stores the shortest weight for each location
        Dictionary<String, Location> locationList = new Hashtable<>();//stores a list of locations in the right order
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();



        shortestWeights.put(startlocation.getName(), 0);
        QueueObject qo = new QueueObject(startlocation, 0);
        queue.add(qo);

        for (Location loc: graph.getLocations()) {
            if(loc != startlocation){
                shortestWeights.put(loc.getName(), Integer.MAX_VALUE);

            }
            locationList.put(loc.getName(), new Location("Null"));
        }

        while(queue.size() != 0){
            Location currentLocation = queue.poll().getLocation();

            for (Route route: currentLocation.getRoutes()) {
                Integer alternate = shortestWeights.get(currentLocation.getName()) + route.getDuration();
                String neighborData = route.getLocationB().getName();

                if (alternate < shortestWeights.get(neighborData)){
                    shortestWeights.put(neighborData, alternate);
                    locationList.put(neighborData, currentLocation);

                    Location loca = null;
                    for(Location l: graph.getLocations()){
                        if(l.getName().equals(route.getLocationB().getName())){
                            loca = l;

                        }
                    }

                    //queue.add(new QueueObject(route.getLocationB(), shortestWeights.get(neighborData)));
                    queue.add(new QueueObject(loca, shortestWeights.get(neighborData)));

                }
            }
        }

        return new Dictionary[]{shortestWeights, locationList};
    }

    public static void printPathWithTransportation(Dictionary<String,Location> previous, Location destination) {

        if (!destination.getName().equals("Null")) {
            Location previousLocation = previous.get(destination.getName());
            printPathWithTransportation(previous, previousLocation);
            for(Route route : previousLocation.getRoutes()){
                if(route.getLocationB().getName().equals(destination.getName())) {
                    logger.info(" --| " + route.getTransportation().getTransportationType().getType()+" (" + route.getDuration()+") |--> "+ destination.getName());
                    return;
                }
            }
            System.out.print(" -> " + destination.getName());

        }
    }
    public static Result result(Dictionary<String,Location> previous, Location destination) {
        Result result = new Result();
        if (!destination.getName().equals("Null")) {
            Location previousLocation = previous.get(destination.getName());
            result = result(previous, previousLocation);
            for(Route r: previousLocation.getRoutes()){
                if(r.getLocationB().getName().equals(destination.getName())) {

                    result.getRouteList().add(r);
                }
            }
        }
        return result;
    }

    public static void printPath(Dictionary<String,Location> previous, Location destination) {
        if (!destination.getName().equals("Null")) {
            Location previousVertex = previous.get(destination.getName());
            printPath(previous, previousVertex);
            logger.info(" -> " + destination.getName());
        }
    }



}
