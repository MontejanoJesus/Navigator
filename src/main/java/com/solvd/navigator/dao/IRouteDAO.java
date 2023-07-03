package com.solvd.navigator.dao;

import com.solvd.navigator.model.Route;

import java.util.List;

public interface IRouteDAO extends IDAO<Route>{
    Route getRouteByLocationsId(long locationAId, long locationBId);
    List<Route> getAllRoutesByLocationId(long locationId);
}
