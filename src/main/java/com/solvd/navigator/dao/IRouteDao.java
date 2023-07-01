package com.solvd.navigator.dao;

public interface IRouteDao extends IDAO<Route>{
    Route getRouteByLocationsId(long locationAId, long locationBId);

}
