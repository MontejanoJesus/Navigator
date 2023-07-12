package com.solvd.navigator.factory;

import com.solvd.navigator.dao.IDAO;
import com.solvd.navigator.dao.jdbc.*;

public class JDBCFactory extends AbstractFactory{
    public <T extends IDAO> T getDao(DaoType daoType) {

        if (daoType == null) {
            return null;
        }
        switch (daoType) {
            case DRIVER_LICENSE:
                return (T) new DriverLicenseDAO();
            case LOCATION:
                return (T) new LocationDAO();
            case PERSON:
                return (T) new PersonDAO();
            case REVIEW:
                return (T) new ReviewDAO();
            case ROUTE:
                return (T) new RouteDAO();
            case TRANSPORTATION:
                return (T) new TransportationDAO();
            case TRANSPORTATION_TYPE:
                return (T) new TransportationTypeDAO();
            default:
                throw new IllegalArgumentException("Invalid DAO type: " + daoType);
        }
    }


    }
