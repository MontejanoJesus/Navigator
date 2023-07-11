package com.solvd.navigator.service.imple;

import com.solvd.navigator.dao.IDriverDAO;
import com.solvd.navigator.dao.ITransportationDAO;
import com.solvd.navigator.factory.AbstractFactory;
import com.solvd.navigator.factory.FactoryGenerator;
import com.solvd.navigator.model.Transportation;
import com.solvd.navigator.service.ITransportationService;

import java.util.List;

public class TransportationService implements ITransportationService {

    private AbstractFactory daoFactory = FactoryGenerator.getFactory("JDBC");
    private ITransportationDAO iTransportationDAO = daoFactory.getDao("Transportation");
    private IDriverDAO iDriverDAO = daoFactory.getDao("Driver");

    @Override
    public Transportation getById(long id) {
         //Tae comment
        //Transportation transportation = iTransportationDAO.getById(id);
        //transportation.setDriver(iDriverDAO.getById(transportation.getDriver().getId()));

        //return transportation;
        return null;
    }

    @Override
    public List<Transportation> getAll() {

        List<Transportation> transportationList = iTransportationDAO.getAll();

        for(Transportation transportation: transportationList){
            //Tae comment
           // transportation.setDriver(iDriverDAO.getById(transportation.getDriver().getId()));

        }
        return transportationList;
    }

    @Override
    public void insert(Transportation transportation) {
        iTransportationDAO.insert(transportation);
    }

    @Override
    public void update(Transportation transportation) {
        iTransportationDAO.update(transportation);
    }

    @Override
    public void delete(long id) {
        iTransportationDAO.delete(id);
    }
}
