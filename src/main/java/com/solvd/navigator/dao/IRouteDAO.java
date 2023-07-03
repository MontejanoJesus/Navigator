package com.solvd.navigator.dao;

import com.solvd.navigator.model.Route;

public interface IRouteDAO extends IDAO<Route>{
    Route getRouteByLocationsId(long locationAId, long locationBId);
}
