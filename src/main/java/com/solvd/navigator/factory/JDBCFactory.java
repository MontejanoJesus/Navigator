package com.solvd.navigator.factory;

import com.solvd.navigator.dao.IDAO;
import com.solvd.navigator.dao.jdbc.RouteDAO;
import com.solvd.navigator.dao.jdbc.LocationDAO;
import com.solvd.navigator.dao.jdbc.DriverDAO;
public class JDBCFactory extends AbstractFactory{
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
            //Tae
       /* } else if (daoType.equalsIgnoreCase("Transportation")) {
            return (T) new TransportationDAO();*/
        }
        return null;
    }


    }
