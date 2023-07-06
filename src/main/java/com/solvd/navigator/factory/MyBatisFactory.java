package com.solvd.navigator.factory;

import com.solvd.navigator.dao.*;
import com.solvd.navigator.dao.impl.mybatis.DriverDAO;
import com.solvd.navigator.dao.impl.mybatis.LocationDAO;
import com.solvd.navigator.dao.impl.mybatis.RouteDAO;
import com.solvd.navigator.dao.impl.mybatis.TransportationDAO;

public class MyBatisFactory extends AbstractFactory{


    public <T extends IDAO> T getDao(String daoType) {
        if(daoType == null) {
            return null;
        }
        if(daoType.equalsIgnoreCase("Driver")) {
            return (T) new DriverDAO();
        } else if (daoType.equalsIgnoreCase("Location")) {
            return (T )new LocationDAO();
        } else if (daoType.equalsIgnoreCase("Route")) {
            return (T) new RouteDAO();
        } else if (daoType.equalsIgnoreCase("Transportation")) {
            return (T) new TransportationDAO();
        }
        return null;
    }

}
