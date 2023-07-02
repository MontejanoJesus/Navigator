package com.solvd.navigator.dao;

public interface IRouteDAO extends IDAO<Route>{
    Route getRouteByLocationsId(long locationAId, long locationBId);

}
